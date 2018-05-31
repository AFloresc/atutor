package com.inredec.atutor.model.servicelayer.impl;

import com.inredec.atutor.model.businesslayer.entities.User;
import com.inredec.atutor.model.persistencelayer.impl.flatfile.manager.FlatFilePersistenceManager;
import com.inredec.atutor.model.persistencelayer.impl.rest.manager.RestPersistenceManager;
import com.inredec.atutor.model.servicelayer.api.IUserService;
import com.inredec.atutor.utilitieslayer.AppUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agauser on 26/02/2018.
 */

public class UserService implements IUserService {

    //Singletones
    private FlatFilePersistenceManager flatFilePersistenceManager;


    public UserService(FlatFilePersistenceManager flatFilePersistenceManager, RestPersistenceManager restPersistenceManager) {
    }

    @Override
    public User getUserByMail(String mail, AppUtils.PersistenceTechnologies persistenceTechnologies) {
        return null;
    }

    @Override
    public void createInitialLocalUsers() throws ParseException {
        List<User> users = new ArrayList<User>();

        //Creació users test
        User user1 = new User();
        user1.setName("alex@websays.com");
        user1.setPassword("12345");
        user1.setName("Alex Flores");
        users.add(user1);

        User user2 = new User();
        user2.setName("lidia@lidia.com");
        user2.setPassword("qwerty");
        user2.setName("Lidia Perez");
        users.add(user2);

        User user3 = new User();
        user3.setName("pol@gmail.com");
        user3.setPassword("zxcvb");
        user3.setName("Pol Rodriguez");
        users.add(user3);

        User user4 = new User();
        user4.setName("marc@gmail.com");
        user4.setPassword("11223344");
        user4.setName("Marc Rodriguez");
        users.add(user4);

        flatFilePersistenceManager.getUserDAO().userSave(users);
        
    }

    @Override
    public void saveUser(User user, AppUtils.PersistenceTechnologies persistenceTechnologies) {
        List<User> users = new ArrayList<User>();
        users.add(user);

        flatFilePersistenceManager.getUserDAO().userSave(users);

    }

    @Override
    public void saveUser(User user) {
        List<User> users = new ArrayList<User>();
        users.add(user);

        flatFilePersistenceManager.getUserDAO().userSave(users);

    }


    public void createInitialUsers() throws ParseException {
        List<User> users = new ArrayList<User>();

        //Creació users test
        User user1 = new User();
        user1.setName("alex@websays.com");
        user1.setPassword("12345");
        user1.setName("Alex Flores");
        users.add(user1);

        User user2 = new User();
        user2.setName("lidia@lidia.com");
        user2.setPassword("qwerty");
        user2.setName("Lidia Perez");
        users.add(user2);

        User user3 = new User();
        user3.setName("pol@gmail.com");
        user3.setPassword("zxcvb");
        user3.setName("Pol Rodriguez");
        users.add(user3);

        User user4 = new User();
        user4.setName("marc@gmail.com");
        user4.setPassword("11223344");
        user4.setName("Marc Rodriguez");
        users.add(user4);

        flatFilePersistenceManager.getUserDAO().userSave(users);
    }

    @Override
    public List<User> getAllusers() {
        return flatFilePersistenceManager.getUserDAO().getAllUsers();
    }
}
