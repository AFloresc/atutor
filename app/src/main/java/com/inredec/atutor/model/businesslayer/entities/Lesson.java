package com.inredec.atutor.model.businesslayer.entities;


import java.util.ArrayList;

public class Lesson {

    private int id;
    private String name;
    private String image;
    private String level;
    private int Photo;

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

    private ArrayList<Content> contents;
    private ArrayList<Concept> concepts;

    public Lesson(int id, String name,
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

    public int getId() {
        return id;
    }



    public void setId(int id) {
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
