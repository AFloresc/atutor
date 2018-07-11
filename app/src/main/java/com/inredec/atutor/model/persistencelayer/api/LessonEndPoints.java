package com.inredec.atutor.model.persistencelayer.api;

import com.inredec.atutor.model.businesslayer.entities.Lesson;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LessonEndPoints {

    @GET("lessons")
    Call<List<Lesson>> getLessons();


}
