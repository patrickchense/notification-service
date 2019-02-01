package com.chenzhe.templateservice.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.chenzhe.templateservice.ITemplateService;
import com.chenzhe.templateservice.dao.TemplateRepository;
import com.chenzhe.templateservice.entity.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(interfaceClass = ITemplateService.class)
@Component
@Slf4j
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    private TemplateRepository templateRepository;



    @Override
    public Template findById(Long id) {
        log.info("find template by id {}", id);
        return templateRepository.findById(id).orElse(null);
    }

    @Override
    public Template findByKey(String key) {
        log.info("find template by key {}", key);

        return templateRepository.findByKey(key);
    }
}
