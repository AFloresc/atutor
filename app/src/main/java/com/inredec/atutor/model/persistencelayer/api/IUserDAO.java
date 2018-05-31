package com.inredec.atutor.model.persistencelayer.api;

import com.inredec.atutor.model.businesslayer.entities.User;

import java.util.ArrayList;
import java.util.List;


public interface IUserDAO {

    User getUserByMail(String email);

    void userSave(List<User> users);

    void userSave(User user);

    List<User> getAllUsers();

}
