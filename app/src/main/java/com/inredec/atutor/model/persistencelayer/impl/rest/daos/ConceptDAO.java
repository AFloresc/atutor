package com.inredec.atutor.model.persistencelayer.impl.rest.daos;

import com.inredec.atutor.model.businesslayer.entities.Concept;
import com.inredec.atutor.model.persistencelayer.api.IConceptDAO;

import java.util.List;

public class ConceptDAO implements IConceptDAO {
    @Override
    public Concept getConceptByTitle(String title) {
        return null;
    }

    @Override
    public void conceptSave(List<Concept> concepts) {

    }
}
