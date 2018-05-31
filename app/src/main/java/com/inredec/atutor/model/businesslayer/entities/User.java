package com.inredec.atutor.model.businesslayer.entities;

import com.inredec.atutor.model.businesslayer.entities.base.EntityBase;

import java.util.ArrayList;


public class User extends EntityBase{

    private String name;
    private String mail;
    private String password;
    private String url_image;
    private ArrayList<Mark> marks;

    public User(){
        this.name = "";
        this.mail = "";
        this.password = "";
        this.url_image=" ";
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.url_image = " ";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", url_image='" + url_image + '\'' +
                '}';
    }
}
