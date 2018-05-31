package com.inredec.atutor.model.persistencelayer.impl.flatfile.manager;

import android.content.Context;

import com.inredec.atutor.model.persistencelayer.api.IUserDAO;
import com.inredec.atutor.model.persistencelayer.impl.flatfile.daos.UserDAO;
import com.inredec.atutor.model.persistencelayer.manager.PersistenceManager;


public class FlatFilePersistenceManager extends PersistenceManager {

    private Context context;
    private IUserDAO userDAO;

    public FlatFilePersistenceManager(Context context){

        this.context=context;
    }

    @Override
    public IUserDAO getUserDAO(){
        if (userDAO == null){
            userDAO = new UserDAO(context);
        }
        return userDAO;
    }
}
