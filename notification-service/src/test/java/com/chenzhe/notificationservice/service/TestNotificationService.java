package com.chenzhe.notificationservice.service;

import com.chenzhe.notificationservice.NotificationServiceApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@SpringBootTest(classes = NotificationServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestNotificationService {

    @Autowired
    private NotificationService notificationService;

    @Test
    public void testSendWelcome() {
        String mailInfo = notificationService.sendWelcome(1L);
        Assert.assertEquals("Hello dear Mr test,\n" +
                "\n" +
                "we are very happy to welcome you to our newsletter.\n" +
                "\n" +
                "In case you don't want to receive any further newsletters in the future please unsubscribe here:\n" +
                "https://domain-of-product.de/unsubscribe-newsletter/test001\n" +
                "\n" +
                "Best Regards,\n" +
                "Your Customer Support Team", mailInfo);
    }


    @Test
    public void testSendNewsletters() {
        notificationService.sendNewsletters("newsletterOne");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2, NotificationServiceImpl.CACHE_LETTERS.size());
        for (Map.Entry<String, String> entry : NotificationServiceImpl.CACHE_LETTERS.entrySet()) {
            if (entry.getKey().startsWith("test@")) {
                //user id 1:
                Assert.assertEquals(entry.getValue(), "Hello dear Mr test,\n" +
                        "\n" +
                        "this are our latest news...\n" +
                        "\n" +
                        "In case you don't want to receive any further newsletters in the future please unsubscribe here:\n" +
                        "https://domain-of-product.de/unsubscribe-newsletter/test001\n" +
                        "\n" +
                        "Best Regards,\n" +
                        "Your Customer Support Team");
            } else {
                //user id 2
                Assert.assertEquals(entry.getValue(), "Hello dear Mrs. test1,\n" +
                        "\n" +
                        "this are our latest news...\n" +
                        "\n" +
                        "In case you don't want to receive any further newsletters in the future please unsubscribe here:\n" +
                        "https://domain-of-product.de/unsubscribe-newsletter/test002\n" +
                        "\n" +
                        "Best Regards,\n" +
                        "Your Customer Support Team");
            }
        }
    }
}
