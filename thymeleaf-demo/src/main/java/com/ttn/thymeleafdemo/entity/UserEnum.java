package com.ttn.thymeleafdemo.entity;

public enum  UserEnum {
    USER("USER ROLE"),
    ADMIN("ADMIN ROLE"),
    SUPER_ADMIN("SUPER_ADMIN ROLE");


    String message;

    UserEnum(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}


