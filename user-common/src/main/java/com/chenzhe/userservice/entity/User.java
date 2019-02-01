package com.chenzhe.userservice.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String sureName;

    private String firstName;

    private String gender;

    private String email;

    private String subscribedNewsletter;

    private Long createTime;

    private Long updateTime;

    private Long creator;

}
