package com.chenzhe.templateservice.service;


import com.chenzhe.templateservice.ITemplateService;
import com.chenzhe.templateservice.TemplateServiceApplication;
import com.chenzhe.templateservice.entity.Template;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = TemplateServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTemplateService {

    @Autowired
    private ITemplateService templateService;

    @Autowired
    private TemplateCommonService templateCommonService;

    @Test
    public void testFindById() {
        Template u = new Template();
        u.setKey("test3");
        u.setText("test3@gmail.com");
        u = templateCommonService.save(u);
        Assert.assertNotNull(u.getId());
        Template template1 = templateService.findById(u.getId());
        Assert.assertNotNull(template1);
        Assert.assertEquals(u.getText(), template1.getText());
        Assert.assertEquals(u.getKey(), template1.getKey());
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void testUniqueKey() {
        Template u = new Template();
        u.setKey("test1");
        u.setText("test1@gmail.com");
        u = templateCommonService.save(u);
        Template u1 = new Template();
        u1.setKey("test1");
        u1.setText("test1@gmail.com");
        u1 = templateCommonService.save(u1);
    }

    @Test
    public void testFindByKey() {
        Template u = new Template();
        u.setKey("test4");
        u.setText("test4@gmail.com");
        u.setCreateTime(System.currentTimeMillis());
        u = templateCommonService.save(u);

        Template t1 = templateService.findByKey(u.getKey());
        Assert.assertEquals(u.getKey(), t1.getKey());
        Assert.assertEquals(u.getText(), t1.getText());
    }
}
