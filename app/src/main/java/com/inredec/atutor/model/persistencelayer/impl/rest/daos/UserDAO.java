package com.inredec.atutor.model.persistencelayer.impl.rest.daos;

import com.inredec.atutor.model.businesslayer.entities.User;
import com.inredec.atutor.model.persistencelayer.api.IUserDAO;

import java.util.List;

public class UserDAO implements IUserDAO {
    @Override
    public User getUserByMail(String email) {
        return null;
    }

    @Override
    public void userSave(List<User> users) {

    }

    @Override
    public void userSave(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
