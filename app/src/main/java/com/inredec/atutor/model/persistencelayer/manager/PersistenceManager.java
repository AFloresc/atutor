package com.inredec.atutor.model.persistencelayer.manager;

import android.content.Context;

import com.inredec.atutor.model.persistencelayer.impl.flatfile.manager.FlatFilePersistenceManager;
import com.inredec.atutor.model.persistencelayer.impl.rest.manager.RestPersistenceManager;
import com.inredec.atutor.utilitieslayer.AppUtils;


public class PersistenceManager {

    public static PersistenceManager getPersistenceManager
            (AppUtils.PersistenceTechnologies persisistenceTechnologies, Context context){

        PersistenceManager persistenceManager=null;

        switch (persisistenceTechnologies){
            case FLAT_FILE:
                persistenceManager = new FlatFilePersistenceManager(context);
                break;
            case REST:
                persistenceManager = new RestPersistenceManager();
                break;
        }

        return  persistenceManager;
    }
}
