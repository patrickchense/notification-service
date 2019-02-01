package com.chenzhe.templateservice.service;

import com.chenzhe.templateservice.TemplateServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = TemplateServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTemplateCommonService {

    @Autowired
    private TemplateCommonService userCommonService;

    @Test
    public void testTemplateSave() {

    }

    @Test
    public void testTemplateUpdate() {

    }

    @Test
    public void testFindAllByQuery() {

    }

    @Test
    public void testDelete() {

    }
}
