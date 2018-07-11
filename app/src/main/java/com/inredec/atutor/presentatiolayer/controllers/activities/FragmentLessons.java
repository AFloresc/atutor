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
import android.widget.Toast;

import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.Concept;
import com.inredec.atutor.model.businesslayer.entities.Content;
import com.inredec.atutor.model.businesslayer.entities.Lesson;
import com.inredec.atutor.model.businesslayer.entities.LessonsReceived;
import com.inredec.atutor.model.persistencelayer.api.LessonEndPoints;
import com.inredec.atutor.model.persistencelayer.impl.rest.ApiClient;
import com.inredec.atutor.presentatiolayer.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLessons extends Fragment {

    private View v;
    private RecyclerView myRecycleView;
    private List<Lesson> lstLessons;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Content> lstContents;

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
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstLessons);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Content content = new Content("Content 1" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean enim ante, dictum eu tristique vel, convallis ac justo. Fusce blandit fringilla metus a venenatis. Aenean magna elit, tincidunt nec semper ac, dignissim vitae justo. Fusce eu leo vitae sem semper accumsan. Integer interdum volutpat mattis. Vestibulum mattis id lacus at efficitur. Curabitur convallis odio ac neque malesuada porta. Sed vehicula, erat vel accumsan blandit, velit leo faucibus erat, aliquet interdum nibh magna eget velit. In dapibus accumsan congue. Quisque sit amet augue ligula. Donec ultricies quis ligula ut aliquet. Aliquam erat volutpat. ");

        lstContents = new ArrayList<>();
        lstContents.add(content);


        lstLessons = new ArrayList<>();

        loadlessons();

        System.out.println("Size: "+ lstLessons.size());

        lstLessons.add(new Lesson(1L,
                "Instalar IDE",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Facil",
                (ArrayList<Content>) lstContents, new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(2L,
                "Arquitectura Android",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Facil",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(3L,
                "SDK Manager",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Facil",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(4L,
                "AVD Manager",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Facil",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(5L,
                "Android Device Monitor",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(6L,
                "Debug",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));
        lstLessons.add(new Lesson(7L,
                "Adb",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));

        lstLessons.add(new Lesson(8L,
                "Ciclo de vida de una Activity",
                "http://pngimg.com/uploads/number1/number1_PNG14871.png",
                "Media",
                new ArrayList<Content>(), new ArrayList<Concept>(),
                R.drawable.lesson));

        lstLessons.add(new Lesson(9L,
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

    private void loadlessons(){
        LessonEndPoints apiService =
                ApiClient.getApiClient().create(LessonEndPoints.class);

        Call<List<Lesson>> call = apiService.getLessons();
        call.enqueue(new Callback<List<Lesson>>() {
            @Override
            public void onResponse(Call<List<Lesson>> call, Response<List<Lesson>> response) {
                lstLessons.clear();
                lstLessons.addAll(response.body());
                recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstLessons);
                myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
                myRecycleView.setAdapter(recyclerViewAdapter);
                System.out.println("Tamaño encontrado: "+ response.body().size());

            }

            @Override
            public void onFailure(Call<List<Lesson>> call, Throwable t) {
                Toast.makeText(getContext(),
                        "error :(",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

}
