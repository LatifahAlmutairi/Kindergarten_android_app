package com.example.kindergarten;


import java.io.Serializable;

public class UsersSignUp implements Serializable {
    public String user_name;
    public String password ;
    public String email;
    public String key;
    public String user_key;

    public UsersSignUp(String user_name, String password, String email) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }
}
