package com.inredec.atutor.model.businesslayer.entities;

import com.inredec.atutor.model.businesslayer.entities.base.EntityBase;


public class User extends EntityBase{

    private String name;
    private String mail;
    private String url_image;

    public User(){
        this.name = "";
        this.mail = "";
        this.url_image="";
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
}