package com.chenzhe.templateservice.service;


import com.chenzhe.templateservice.entity.Template;
import com.chenzhe.templateservice.pojo.QueryTemplate;

import java.util.List;

public interface TemplateCommonService {

    List<Template> findAllTemplates(QueryTemplate queryTemplate);

    Template updateTemplate(Template old, Template template);

    void deleteTemplate(Long id);

    Template save(Template template);
}
