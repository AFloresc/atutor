package com.inredec.atutor.model.servicelayer.api;

import com.inredec.atutor.model.businesslayer.entities.User;
import com.inredec.atutor.utilitieslayer.AppUtils;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Agauser on 26/02/2018.
 */

public interface IUserService {

    User getUserByMail(String mail
            , AppUtils.PersistenceTechnologies persistenceTechnologies);

    void createInitialLocalUsers() throws ParseException;

    void saveUser(User user, AppUtils.PersistenceTechnologies persistenceTechnologies);

    void saveUser(User user);

   // void createInitialUsers() throws ParseException;

    List<User> getAllusers();
}
