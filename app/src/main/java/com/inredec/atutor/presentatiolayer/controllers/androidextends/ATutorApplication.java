package com.inredec.atutor.presentatiolayer.controllers.androidextends;

import android.app.Application;

import com.inredec.atutor.model.businesslayer.entities.Topic;
import com.inredec.atutor.model.businesslayer.entities.User;

public class ATutorApplication extends Application{
    private User user;
    private Topic topic;

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


}

