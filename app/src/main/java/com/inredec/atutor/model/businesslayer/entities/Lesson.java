package com.inredec.atutor.model.businesslayer.entities;


import java.util.ArrayList;

public class Lesson {

    private int id;
    private String name;
    private String image;
    private ArrayList<Content> contents;
    private ArrayList<Concept> concepts;

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
