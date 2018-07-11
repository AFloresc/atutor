package com.inredec.atutor.model.persistencelayer.impl.rest.manager;

import android.content.Context;

import com.inredec.atutor.model.persistencelayer.api.IUserDAO;
import com.inredec.atutor.model.persistencelayer.manager.PersistenceManager;

import retrofit2.Retrofit;

/**
 * Created by Agauser on 23/02/2018.
 */

public class RestPersistenceManager  extends PersistenceManager{

    private Context context;
    private IUserDAO userDAO;

    /*private static final String BASE_URL = "http://10.0.2.2:5000";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }*/

    @Override
    public IUserDAO getUserDAO() {
        return null;
    }


}
