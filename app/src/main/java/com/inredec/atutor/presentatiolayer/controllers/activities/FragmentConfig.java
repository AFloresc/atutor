package com.inredec.atutor.presentatiolayer.controllers.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inredec.atutor.R;

public class FragmentConfig extends Fragment {

    View v;

    public FragmentConfig() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.config_fragment, container, false);
        return v;
    }


}

