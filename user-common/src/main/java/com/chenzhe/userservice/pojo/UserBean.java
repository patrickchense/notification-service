package com.chenzhe.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {

    private Long id;

    private String name;

    private String email;

    private String salutation;

    private String identifier;

}
