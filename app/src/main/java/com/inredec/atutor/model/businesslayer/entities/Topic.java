package com.inredec.atutor.model.businesslayer.entities;

import com.inredec.atutor.model.businesslayer.entities.base.EntityBase;

import java.util.ArrayList;


public class Topic extends EntityBase {

    private int id;
    private String title;
    private String image;
    private ArrayList<Subheader> subheaders;


}
