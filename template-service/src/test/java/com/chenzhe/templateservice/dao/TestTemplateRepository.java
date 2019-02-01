package com.chenzhe.templateservice.dao;

import com.chenzhe.templateservice.entity.Template;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ComponentScan("com.chenzhe.templateservice")
@DataJpaTest
public class TestTemplateRepository {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TemplateRepository templateRepository;

    @Test
    public void testSave() {
        Template template = new Template();
        template.setKey("test1");
        template.setText("test1@gmail.com");
        template.setCreateTime(System.currentTimeMillis());
        Template template1 = templateRepository.save(template);
        Assert.assertNotNull(template1.getId());
        Template template2 = templateRepository.findById(template1.getId()).get();
        Assert.assertEquals(template1.getText(), template2.getText());
        Assert.assertEquals(template1.getKey(), template2.getKey());
    }


    @Test
    public void testUpdate() {
        Template template = new Template();
        template.setKey("test1");
        template.setText("test1@gmail.com");
        template.setCreateTime(System.currentTimeMillis());
        Template template1 = templateRepository.save(template);
        Assert.assertNotNull(template1.getId());
        template1.setText("test2@gmail.com");
        Template template2 = templateRepository.save(template1);
        Assert.assertEquals(template2.getText(), "test2@gmail.com");
    }

    @Test
    public void testDelete() {
        Template template = new Template();
        template.setKey("test1");
        template.setText("test1@gmail.com");
        template.setCreateTime(System.currentTimeMillis());
        Template template1 = templateRepository.save(template);
        Assert.assertNotNull(template1.getId());
        templateRepository.deleteById(template1.getId());
        Assert.assertFalse(templateRepository.existsById(template1.getId()));
    }

    @Test
    public void testFindByKey() {
        Template template = new Template();
        template.setKey("test1");
        template.setText("test1@gmail.com");
        template.setCreateTime(System.currentTimeMillis());
        Template template1 = templateRepository.save(template);
        Assert.assertNotNull(template1.getId());
        Template t1 = templateRepository.findByKey(template.getKey());
        Assert.assertEquals(t1.getText(), template.getText());
        Assert.assertEquals(t1.getId(), template.getId());
    }
}
