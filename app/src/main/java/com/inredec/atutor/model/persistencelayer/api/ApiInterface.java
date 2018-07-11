package com.inredec.atutor.model.persistencelayer.api;

import com.inredec.atutor.model.businesslayer.entities.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("")
    Call<User> performRegistration();

    @GET("")
    Call<User> performUserLogin();


}
