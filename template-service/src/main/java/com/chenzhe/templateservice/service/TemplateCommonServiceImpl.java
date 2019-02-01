package com.chenzhe.templateservice.service;

import com.chenzhe.templateservice.dao.TemplateRepository;
import com.chenzhe.templateservice.entity.Template;
import com.chenzhe.templateservice.exp.TemplateNotExistException;
import com.chenzhe.templateservice.pojo.QueryTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TemplateCommonServiceImpl implements TemplateCommonService {
    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public List<Template> findAllTemplates(QueryTemplate queryTemplate) {
        return null;
    }

    @Override
    public Template updateTemplate(Template old, Template template) {
        if (!old.equals(template)) {
            log.info("update template from {} to {}", old, template);
            templateRepository.save(template);
        }
        return template;
    }

    @Override
    public void deleteTemplate(Long id) {
        if (templateRepository.existsById(id)) {
            templateRepository.deleteById(id);
        }
        throw new TemplateNotExistException("template not exists");
    }

    @Override
    public Template save(Template template) {
        log.info("create template: {}", template);
        return templateRepository.save(template);
    }
}
