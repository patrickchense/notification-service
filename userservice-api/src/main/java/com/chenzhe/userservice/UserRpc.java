package com.chenzhe.userservice;

import java.io.Serializable;

public class UserRpc implements Serializable {

    private String identifier;

    private String name;

    private String salutation;

    private String email;

    public UserRpc(String identifier, String name, String salutation, String email) {
        this.identifier = identifier;
        this.name = name;
        this.email = email;
        this.salutation = salutation;
    }

    public UserRpc() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
