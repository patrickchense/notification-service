package com.chenzhe.templateservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "template")
@NoArgsConstructor
@Data
public class Template implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String key;

    @Column(length=2000)
    private String text;

    private Long createTime;

    private Long updateTime;
}
