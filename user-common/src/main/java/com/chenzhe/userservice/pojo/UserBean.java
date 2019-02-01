package com.chenzhe.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {

    private Long id;

    private String sureName;

    private String firstName;

    private String gender;

    private String email;

}
