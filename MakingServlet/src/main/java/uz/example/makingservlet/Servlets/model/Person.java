package uz.example.makingservlet.Servlets.model;

import java.beans.JavaBean;
import java.io.Serializable;

public class Person implements Serializable {
    private String username;
    private String password;

    public Person(){
        this.username="Bob";
        this.password="admin";
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
