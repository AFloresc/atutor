package com.inredec.atutor.model.persistencelayer.api;


import com.inredec.atutor.model.businesslayer.entities.Concept;

import java.util.List;

public interface IConceptDAO {

    Concept getConceptByTitle(String title);

    void conceptSave(List<Concept> concepts);
}
