package com.inredec.atutor.model.servicelayer.manager;

import android.content.Context;

import com.inredec.atutor.model.persistencelayer.impl.flatfile.manager.FlatFilePersistenceManager;
import com.inredec.atutor.model.persistencelayer.impl.rest.manager.RestPersistenceManager;
import com.inredec.atutor.model.persistencelayer.manager.PersistenceManager;
import com.inredec.atutor.utilitieslayer.AppUtils;

/**
 * Created by Agauser on 23/02/2018.
 */

public class ServiceManager {

    private Context context;

    //Singletones de gestores de persistencia
    private FlatFilePersistenceManager flatFilePersistenceManager;
    private RestPersistenceManager restPersistenceManager;

    //Servicios
    //todo Service

    //Constructor
    public ServiceManager(Context context){
        this.context=context;
        flatFilePersistenceManager=(FlatFilePersistenceManager)
                PersistenceManager.getPersistenceManager(
                        AppUtils.PersistenceTechnologies.FLAT_FILE,context);

        restPersistenceManager=(RestPersistenceManager)
                PersistenceManager.getPersistenceManager(
                        AppUtils.PersistenceTechnologies.REST,context);
    }

    //Inicialización del gestor de servicios
    //todo Init
}
