package com.chenzhe.userservice.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String salutation;

    private String identifier;

    private Long createTime;

    private Long updateTime;

    private Long creator;
}
