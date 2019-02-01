package com.chenzhe.templateservice.pojo;

import lombok.Data;

@Data
public class QueryTemplate {

    private Long id;

    private String key;

    private Long createTimeStart;

    private Long createTimeEnd;

    private int page;

    private int pageSize;
}
