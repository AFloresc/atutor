package com.inredec.atutor.presentatiolayer.controllers.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inredec.atutor.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainAppActivity extends AppCompatActivity {

    @BindView(R.id.tablayout_id)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_id)
    ViewPager viewPager;

    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        ButterKnife.bind(this);

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
