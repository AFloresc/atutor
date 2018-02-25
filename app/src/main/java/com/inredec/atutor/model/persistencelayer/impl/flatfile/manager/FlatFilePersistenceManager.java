package com.inredec.atutor.model.persistencelayer.impl.flatfile.manager;

import android.content.Context;

import com.inredec.atutor.model.persistencelayer.manager.PersistenceManager;


public class FlatFilePersistenceManager extends PersistenceManager {
    private Context context;

    //private xxxx xxxxDAO;


    public FlatFilePersistenceManager(Context context){

        this.context=context;
    }
}
