package com.inredec.atutor.model.businesslayer.entities;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Lesson {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("urlImage")
    private String image;

    @SerializedName("level")
    private String level;

    //@SerializedName("test")
    private Test test;

    private int Photo;

    private ArrayList<Content> contents;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getLevel() {
        return level;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    private ArrayList<Concept> concepts;

    public Lesson(Long id, String name,
                  String image,
                  String level,
                  ArrayList<Content> contents,
                  ArrayList<Concept> concepts, int photo) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.level = level;
        this.contents = contents;
        this.concepts = concepts;
        this.Photo = photo;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Content> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Content> contents) {
        this.contents = contents;
    }
}
