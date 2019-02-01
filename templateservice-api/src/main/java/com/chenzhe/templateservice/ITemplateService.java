package com.chenzhe.templateservice;

import com.chenzhe.templateservice.entity.Template;

public interface ITemplateService {

    Template findById(Long id);

    Template findByKey(String key);
}