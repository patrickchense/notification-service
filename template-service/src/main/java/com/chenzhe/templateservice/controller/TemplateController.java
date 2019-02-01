package com.chenzhe.templateservice.controller;

import com.chenzhe.templateservice.ITemplateService;
import com.chenzhe.templateservice.entity.Template;
import com.chenzhe.templateservice.exp.TemplateNotExistException;
import com.chenzhe.templateservice.pojo.QueryTemplate;
import com.chenzhe.templateservice.pojo.Response;
import com.chenzhe.templateservice.pojo.TemplateBean;
import com.chenzhe.templateservice.service.TemplateCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.chenzhe.templateservice.pojo.Response.*;

@RestController
@RequestMapping("/template")
@Slf4j
public class TemplateController {

    @Autowired
    private ITemplateService templateService;

    @Autowired
    private TemplateCommonService templateCommonService;

    @RequestMapping(value = "/id/{templateId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public TemplateBean getTemplate(@PathVariable("templateId") Long id) {
        Template template = templateService.findById(id);
        if (template != null) {
            TemplateBean response = new TemplateBean();
            response.setId(template.getId());
            response.setKey(template.getKey());
            response.setText(template.getText());
            return response;
        }
        return null;
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<TemplateBean> findTemplates(@RequestBody QueryTemplate queryTemplate) {
        List<Template> templates = templateCommonService.findAllTemplates(queryTemplate);
        if (templates.isEmpty()) {
            return Collections.emptyList();
        }
        return templates.stream().map(u -> new TemplateBean(u.getId(), u.getKey(), u.getText())).collect(Collectors.toList());
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Response createTemplate(@RequestBody TemplateBean newTemplate) {
        if (StringUtils.isEmpty(newTemplate.getText()) || StringUtils.isEmpty(newTemplate.getKey())) {
            return PARAM_INCORRECT;
        }
        Template nTemplate = new Template();
        nTemplate.setId(newTemplate.getId());
        nTemplate.setKey(newTemplate.getKey());
        nTemplate.setText(newTemplate.getText());
        nTemplate.setCreateTime(System.currentTimeMillis());
        templateCommonService.save(nTemplate);
        return SUCCESS;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Response updateTemplate(@RequestBody TemplateBean newTemplate) {
        if (newTemplate.getId() == null) {
            return PARAM_INCORRECT;
        }
        Template template = templateService.findById(newTemplate.getId());
        if (template == null) {
            return FAIL;
        }
        Template nTemplate = new Template();
        nTemplate.setId(newTemplate.getId());
        nTemplate.setKey(newTemplate.getKey());
        nTemplate.setText(newTemplate.getText());
        nTemplate.setCreateTime(template.getCreateTime());
        nTemplate.setUpdateTime(System.currentTimeMillis());
        templateCommonService.updateTemplate(template, nTemplate);
        return SUCCESS;
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Response deleteTemplate(@PathVariable("templateId") Long id) {
        try {
            templateCommonService.deleteTemplate(id);
        } catch (TemplateNotExistException e) {
            log.warn("delete template {} not exist", id);
            return FAIL;
        }
        return SUCCESS;
    }
}
