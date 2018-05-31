package com.inredec.atutor.model.servicelayer.manager;

import android.content.Context;

import com.inredec.atutor.model.persistencelayer.impl.flatfile.manager.FlatFilePersistenceManager;
import com.inredec.atutor.model.persistencelayer.impl.rest.manager.RestPersistenceManager;
import com.inredec.atutor.model.persistencelayer.manager.PersistenceManager;
import com.inredec.atutor.model.servicelayer.api.IUserService;
import com.inredec.atutor.model.servicelayer.impl.UserService;
import com.inredec.atutor.utilitieslayer.AppUtils;



public class ServiceManager {

    private Context context;

    //Servicios
    private IUserService userServices;

    //Singletones de gestores de persistencia
    private FlatFilePersistenceManager flatFilePersistenceManager;
    private RestPersistenceManager restPersistenceManager;

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
    public IUserService getUserServices(){
        if(userServices == null){
            userServices = new UserService(
                            flatFilePersistenceManager,
                            restPersistenceManager
                            );
        }
        return userServices;
    }
}
