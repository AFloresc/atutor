package com.inredec.atutor.model.persistencelayer.impl.rest.manager;

import com.inredec.atutor.model.persistencelayer.api.IUserDAO;
import com.inredec.atutor.model.persistencelayer.manager.PersistenceManager;

/**
 * Created by Agauser on 23/02/2018.
 */

public class RestPersistenceManager  extends PersistenceManager{
    @Override
    public IUserDAO getUserDAO() {
        return null;
    }
}
