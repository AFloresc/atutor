package com.inredec.atutor.model.businesslayer.entities;


import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    private String header;

    @SerializedName("text")
    private String content;

    @SerializedName("url_image")
    private String image;

    public Content (String title, String content){
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
