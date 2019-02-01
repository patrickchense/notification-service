package com.chenzhe.notificationservice.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chenzhe.templateservice.ITemplateService;
import com.chenzhe.userservice.IUserService;
import com.chenzhe.notificationservice.util.TemplateFormatter;
import com.chenzhe.templateservice.entity.Template;
import com.chenzhe.userservice.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class NotificationServiceImpl implements NotificationService{

    @Reference(url = "dubbo://127.0.0.1:20770")
    private IUserService userService;

    @Reference(url = "dubbo://127.0.0.1:20880")
    private ITemplateService templateService;

    @Value("${template.welcome.key}")
    private String templateWelcomeKey;

    @Value("${start.sendint.newsletters}")
    private boolean sendNewsSwitch;

    protected static final ConcurrentHashMap<String, String> CACHE_LETTERS = new ConcurrentHashMap<>();

    @Override
    public String sendWelcome(Long id) {
        User user = userService.findById(id);
        if (user != null) {
            Template welcomeTemplate = templateService.findByKey(templateWelcomeKey);
            if (welcomeTemplate == null) {
                log.warn("no welcome template, please add one first");
                return null;
            }
            // replace template
            String welcomeMail = translateTemplate(welcomeTemplate.getText(), user);
            log.info("got the welcome mail text: {}", welcomeMail);
            // send email
            // TODO

            return welcomeMail;
        }
        log.warn("user not find {}, can't send welcome letter", user);
        return null;
    }

    @Override
    public void sendNewsletters(String newsletterTemplateKey) {
        List<User> users = userService.findAllUsers();
        if (users == null || users.isEmpty()) {
            log.warn("no users, no need to send newsletters");
            return;
        }
        Template newsletterTemplate = templateService.findByKey(newsletterTemplateKey);
        if (newsletterTemplate == null) {
            log.warn("no newsletter template, please add one first");
            return;
        }
        for (User user : users) {
            String newsletterMail = translateTemplate(newsletterTemplate.getText(), user);
            String emailTs = user.getEmail() + ";" + System.currentTimeMillis();
            CACHE_LETTERS.put(emailTs, newsletterMail);
        }
    }

    /*
        run every 5 seconds
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void sendNewsletter() {
        if (sendNewsSwitch && CACHE_LETTERS.size() > 10) {
            CACHE_LETTERS.entrySet().forEach(e -> {
                String emailTs = e.getKey();
                String text = e.getValue();
                String email = emailTs.substring(0, emailTs.lastIndexOf(";"));
                // TODO send email;
                // SUCCESS delete from MAP
                // CACHE_LETTERS.remove(emailTs);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    log.error("send email err", e);
                }
            });
        }
    }

    private String translateTemplate(String text, User user) {
        try {
            return TemplateFormatter.format(text, user);
        } catch (Exception e) {
            log.error("compile template text {} failed ", text, e);
        }
        return null;
    }
}
