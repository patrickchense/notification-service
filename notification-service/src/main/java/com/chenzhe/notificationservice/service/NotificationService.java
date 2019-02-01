package com.chenzhe.notificationservice.service;

public interface NotificationService {

    String sendWelcome(Long id);

    void sendNewsletters(String newsletterTemplateKey);
}
