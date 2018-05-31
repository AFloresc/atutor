package com.inredec.atutor.presentatiolayer.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.inredec.atutor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddUserTestActivity extends AppCompatActivity {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.textView7)
    TextView textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_test);

        ButterKnife.bind(this);

        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
        textView2.setText(intent.getStringExtra("etUsernameValue"));
        textView4.setText(intent.getStringExtra("etValue"));
        textView6.setText(intent.getStringExtra("etPassword"));

    }
}
