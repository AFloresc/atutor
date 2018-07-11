package com.inredec.atutor.model.businesslayer.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LessonsReceived {

    @SerializedName("lessons")
    private List<Lesson> lessons;

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
