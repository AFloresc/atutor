package com.inredec.atutor.model.persistencelayer.api;

import com.inredec.atutor.model.businesslayer.entities.Content;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContentEndPoints {

    @GET("lessons/{id}/contents")
    Call<List<Content>> getContentsbyLesson(@Path("id") Long lesson);
}
