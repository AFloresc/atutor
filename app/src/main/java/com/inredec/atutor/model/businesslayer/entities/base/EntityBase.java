package com.inredec.atutor.model.businesslayer.entities.base;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Agauser on 23/02/2018.
 */

public abstract class EntityBase {

    private static final int ENTITY_UNSAVED_VALUE=-1;

    private UUID uuid;
    private int _id;
    private Date insertedDBDate;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Date getInsertedDBDate() {
        return insertedDBDate;
    }

    public void setInsertedDBDate(Date insertedDBDate) {
        this.insertedDBDate = insertedDBDate;
    }

    public EntityBase(){
        uuid=UUID.randomUUID();
        _id=ENTITY_UNSAVED_VALUE;
        insertedDBDate=null;
    }
}

