package com.chenzhe.templateservice.service;

import com.chenzhe.templateservice.entity.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PrepareData implements InitializingBean {
    @Autowired
    private TemplateCommonService templateCommonService;

    @Override
    public void afterPropertiesSet() throws Exception {
        Template welcome = new Template();
        welcome.setKey("welcome");
        welcome.setText("Hello dear {{user.salutation}} {{user.name}},\n" +
                "\n" +
                "we are very happy to welcome you to our newsletter.\n" +
                "\n" +
                "In case you don't want to receive any further newsletters in the future please unsubscribe here:\n" +
                "https://domain-of-product.de/unsubscribe-newsletter/{{user.identifier}}\n" +
                "\n" +
                "Best Regards,\n" +
                "Your Customer Support Team");
        welcome = templateCommonService.save(welcome);
        log.info("template init welcome {} into local db", welcome);
        Template newsletterOne = new Template();
        newsletterOne.setKey("newsletterOne");
        newsletterOne.setText("Hello dear {{user.salutation}} {{user.name}},\n" +
                "\n" +
                "this are our latest news...\n" +
                "\n" +
                "In case you don't want to receive any further newsletters in the future please unsubscribe here:\n" +
                "https://domain-of-product.de/unsubscribe-newsletter/{{user.identifier}}\n" +
                "\n" +
                "Best Regards,\n" +
                "Your Customer Support Team");
        newsletterOne = templateCommonService.save(newsletterOne);
        log.info("template init newsletter {} into local db", newsletterOne);
    }
}
