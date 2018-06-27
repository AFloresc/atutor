package com.inredec.atutor.presentatiolayer.controllers.activities;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.Lesson;
import com.inredec.atutor.presentatiolayer.Adapters.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainAppActivity extends AppCompatActivity {

    @BindView(R.id.tablayout_id)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_id)
    ViewPager viewPager;
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;

    ViewPagerAdapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragments
        adapter.AddFragment(new FragmentConfig(), "Config");
        adapter.AddFragment(new FragmentLessons(), "Lecciones");
        adapter.AddFragment(new FragmentConcepts(), "Conceptos");
        adapter.AddFragment(new FragmentQuiz(), "Tests");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //Add icons to tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_build);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_lesson);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_concept);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_test);

        //Remove shadow
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setElevation(0);
        myToolbar.setElevation(0);

    }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchfile, menu);

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
                final List<Lesson> filtermodelist ;
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
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

    //Change color of searchview
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
}
