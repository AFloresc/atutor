package com.inredec.atutor.presentatiolayer.controllers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.inredec.atutor.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;
    private ProgressBar pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_welcome);
        iv = (ImageView)findViewById(R.id.iv_logo);
        pg = (ProgressBar)findViewById((R.id.pb_loadtime));

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        pg.startAnimation(myanim);

        /*try {
            wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        pg.setProgress(100);
        //startActivity(new Intent(MainActivity.this, LoginActivity.class));
        new Timer().schedule(new TimerTask(){

                                 @Override
                                 public void run() {
                                     Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                     startActivity(intent);
                                 }
                             }, 3000);

    }
}
