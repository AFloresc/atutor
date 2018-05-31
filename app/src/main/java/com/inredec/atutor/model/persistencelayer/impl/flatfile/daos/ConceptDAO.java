package com.inredec.atutor.model.persistencelayer.impl.flatfile.daos;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inredec.atutor.model.businesslayer.entities.Concept;
import com.inredec.atutor.model.persistencelayer.api.IConceptDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConceptDAO implements IConceptDAO{

    private Context context;

    @Override
    public Concept getConceptByTitle(String title) {
        List<Concept>concepts = getConceptFromFlatFile();

        Concept concept = null;

        for(Concept conceptTemp:concepts){
            if(concept.getTitle().equals(title)){
                concept = conceptTemp;
                break;
            }
        }
        return concept;
    }

    private List<Concept> getConceptFromFlatFile() {
        Gson gson = new Gson();
        String usersFromFileJSON="";
        try{
            BufferedReader br=
                    new BufferedReader(
                            new InputStreamReader(
                                    context.openFileInput("concepts.json")
                            )
                    );
            usersFromFileJSON = br.readLine();
            br.close();
        }
        catch(Exception ex){}
        ArrayList<Concept> concepts =
                gson.fromJson(usersFromFileJSON, new TypeToken<List<Concept>>(){}.getType());
        return  concepts;
    }

    @Override
    public void conceptSave(List<Concept> concepts) {

    }
}
