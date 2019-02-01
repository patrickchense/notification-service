package com.chenzhe.templateservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateBean {

    private Long id;

    private String key;

    private String text;

}
