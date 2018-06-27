package com.inredec.atutor.presentatiolayer.controllers.activities;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.Concept;
import com.inredec.atutor.model.businesslayer.entities.Content;
import com.inredec.atutor.model.businesslayer.entities.Lesson;
import com.inredec.atutor.presentatiolayer.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentLessons extends Fragment {

    private View v;
    private RecyclerView myRecycleView;
    private List<Lesson> lstLessons;
    private RecyclerViewAdapter recyclerViewAdapter;

    SearchView searchView;

    public FragmentLessons() {
    }
/*
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        changeSearchTextColor(searchView);
        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));

        // listeninng search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Lesson> filtermodelist = filter(lstLessons, newText);
                recyclerViewAdapter.setfilter(filtermodelist);
                return true;
            }
        });



    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.lessons_fragment, container, false);
        myRecycleView = (RecyclerView)v.findViewById(R.id.lesson_recycler);
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstLessons);
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

    private void changeSearchTextColor(View view){
        if (view != null){
            if (view instanceof TextView){
                ((TextView) view).setTextColor(Color.WHITE);
                return;
            }else if(view instanceof ViewGroup){
                ViewGroup viewGroup = (ViewGroup)view;
                for (int i = 0; 1 < viewGroup.getChildCount(); i++){
                    changeSearchTextColor(viewGroup.getChildAt(i));
                }
            }

        }
    }

    // Filter lessons method
    private List<Lesson> filter(List<Lesson> p1, String query){
        query = query.toLowerCase();
        final List<Lesson> filteredModeList = new ArrayList<>();
        for (Lesson model:p1){
            final String text = model.getName().toLowerCase();
            if (text.startsWith(query)){
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }

}
