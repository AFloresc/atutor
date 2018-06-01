package com.inredec.atutor.presentatiolayer.controllers.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.Concept;
import com.inredec.atutor.model.businesslayer.entities.Content;
import com.inredec.atutor.model.businesslayer.entities.Lesson;
import com.inredec.atutor.presentatiolayer.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentLessons extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    private List<Lesson> lstLessons;

    public FragmentLessons() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.lessons_fragment, container, false);
        myRecycleView = (RecyclerView)v.findViewById(R.id.lesson_recycler);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstLessons);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstLessons = new ArrayList<>();
        lstLessons.add(new Lesson(1,
                "Instalar IDE",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Facil",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(2,
                "Arquitectura Android",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Facil",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(3,
                "SDK Manager",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Facil",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(4,
                "AVD Manager",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Facil",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(5,
                "Android Device Monitor",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(6,
                "Debug",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(7,
                "Adb",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));

        lstLessons.add(new Lesson(8,
                "Ciclo de vida de una Activity",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));

        lstLessons.add(new Lesson(8,
                "Estructura aplicacion Android",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));


    }
}
