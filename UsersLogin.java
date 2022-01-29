package com.example.kindergarten;

import java.io.Serializable;

public class UsersLogin implements Serializable {
    private String user_name;
    private String password ;
    private String key ;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
