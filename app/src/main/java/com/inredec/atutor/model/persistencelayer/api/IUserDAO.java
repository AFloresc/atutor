package com.inredec.atutor.model.persistencelayer.api;

import com.inredec.atutor.model.businesslayer.entities.User;

/**
 * Created by Agauser on 23/02/2018.
 */

public interface IUserDAO {

    User getUserByMail(String email);

    void userSave(User user);

}
