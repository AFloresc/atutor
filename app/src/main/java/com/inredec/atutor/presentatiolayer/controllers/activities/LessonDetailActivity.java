package com.inredec.atutor.presentatiolayer.controllers.activities;

import android.graphics.Point;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.Content;
import com.inredec.atutor.model.businesslayer.entities.Lesson;
import com.inredec.atutor.model.persistencelayer.api.ContentEndPoints;
import com.inredec.atutor.model.persistencelayer.api.LessonEndPoints;
import com.inredec.atutor.model.persistencelayer.impl.rest.ApiClient;
import com.inredec.atutor.presentatiolayer.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LessonDetailActivity extends AppCompatActivity {

    private static final String TAG = "LessonDetailActivity";

    @BindView(R.id.aa_name_lesson)
    TextView tv_name_lesson;
    @BindView(R.id.aa_img_lesson)
    ImageView iv_image_url;
    @BindView(R.id.aa_rating)
    TextView tv_lvl;
    @BindView(R.id.collapsingtb_less_dtl)
    CollapsingToolbarLayout tv_title;

    List<Content> contents = new ArrayList<>();
    String lesson_name = new String();
    String lesson_id = new String();
    String lesson_lvl = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_detail);
        Log.d(TAG, "onCreate: started.");

        ButterKnife.bind(this);

        // Hide default action bar
        //getSupportActionBar().hide();
        getIncomingIntent();
        loadContents();
        setLessonData(lesson_name,
                "https://cdn-images-1.medium.com/max/400/1*chPchgwNN4y1Slr_bwc01A.jpeg",
                "lesson_id",
                "http://10.0.2.2:5000/images/start_actvity.png");
    }



    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if (getIntent().hasExtra("lesson_name")
                && getIntent().hasExtra("lesson_id")) {

            lesson_name = getIntent().getStringExtra("lesson_name");
            System.out.println("Lesson name: " + lesson_name);

            lesson_id = getIntent().getStringExtra("lesson_id");

            System.out.println("Lesson id extra: " + lesson_id);

            lesson_lvl = getIntent().getStringExtra("lesson_lvl");

            System.out.println("Lesson level: " + lesson_lvl);


        }
    }

    private void loadContents(){
        ContentEndPoints apiService =
                ApiClient.getApiClient().create(ContentEndPoints.class);

        Call<List<Content>> call = apiService.getContentsbyLesson(Long.parseLong(lesson_id, 10) );
        call.enqueue(new Callback<List<Content>>() {
            @Override
            public void onResponse(Call<List<Content>> call, Response<List<Content>> response) {
                contents.clear();
                contents.addAll(response.body());

                System.out.println("Tamaño encontrado contents: "+ response.body().size());
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;

                tv_name_lesson.setText(lesson_name);
                tv_lvl.setText(lesson_lvl+".0");
                tv_title.setTitle(lesson_name);

                Glide.with(LessonDetailActivity.this)
                        .load("https://cdn-images-1.medium.com/max/400/1*chPchgwNN4y1Slr_bwc01A.jpeg")
                        .into(iv_image_url);

                LinearLayout linearLayout = (LinearLayout)findViewById(R.id.aa_contents);
                for(Content c: contents){
                    System.out.println(c);
                    TextView textViewHeader = new TextView(LessonDetailActivity.this);
                    textViewHeader.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    textViewHeader.setTypeface(null, Typeface.BOLD);
                    textViewHeader.setText(c.getTitle());
                    textViewHeader.setTextSize(20);
                    textViewHeader.setPadding(0, 25, 0, 0);
                    linearLayout.addView(textViewHeader);

                    TextView textView1 = new TextView(LessonDetailActivity.this);
                    textView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    textView1.setText(c.getContent());
                    textView1.setPadding(0, 10, 0, 0);
                    linearLayout.addView(textView1);

                    ImageView imgView = new ImageView(LessonDetailActivity.this);
                    //imgView.setLayoutParams(linearLayout.getLayoutParams());
                    imgView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT));

                    System.out.println("IMAGE URL: "+ c.getImage());
                    Glide.with(LessonDetailActivity.this)
                            .load(c.getImage())
                            .override(width, height)
                            .into(imgView);

                    linearLayout.addView(imgView);
                }
            }

            @Override
            public void onFailure(Call<List<Content>> call, Throwable t) {
                Toast.makeText(LessonDetailActivity.this,
                        "error :(",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setLessonData(String ls_name, String ls_img_url, String ls_id, String content_img){
        Log.d(TAG, "setLessonData: setting the lesson data.");
        // Deprecated


    }
}
