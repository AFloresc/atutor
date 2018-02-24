package com.inredec.atutor.model.persistencelayer.impl.flatfile.daos;

import android.content.Context;

import com.inredec.atutor.model.businesslayer.entities.User;
import com.inredec.atutor.model.persistencelayer.api.IUserDAO;


public class UserDAO implements IUserDAO {

    private Context context;

    public UserDAO(Context context) {
        this.context = context;
    }

    @Override
    public User getUserByMail(String email) {
        return null;
    }

    @Override
    public void userSave(User user) {

    }
}
