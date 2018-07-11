package com.inredec.atutor.presentatiolayer.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.Content;
import com.inredec.atutor.model.businesslayer.entities.Lesson;
import com.inredec.atutor.presentatiolayer.controllers.activities.LessonDetailActivity;
import com.inredec.atutor.presentatiolayer.controllers.activities.LoginActivity;
import com.inredec.atutor.presentatiolayer.controllers.activities.MainAppActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    final private String TAG = "RecyclerViewAdapter";


    Context mContext;
    List<Lesson> mData;
    List<Content> mContent;
    Dialog myDialog;
    Bundle bundle;
    Intent myintent;

    public RecyclerViewAdapter(Context mContext, List<Lesson> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_lesson, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_level.setText(mData.get(position).getLevel());
        //holder.img.setImageResource(mData.get(position).getPhoto());

        Glide.with(mContext)
                .load("http://localhost:5000/images/lesson.png")
                .into(holder.img);

//        if (mData.get(position).getContents().size() != 0)
  //          holder.tv_content_lesson.setText(mData.get(position).getContents().get(0).getContent());

        //"https://www.pdn.cam.ac.uk/teaching/teaching_images/iTunes-U-1.4-for-iOS-app-icon-small.png"

        holder.item_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mData.get(position).getName());
                Toast.makeText(mContext, "Test Click Lesson: " + mData.get(position).getId()+ "name: "+mData.get(position).getName(),
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, LessonDetailActivity.class);
                // all extras here
                intent.putExtra("lesson_name", mData.get(position).getName());
                intent.putExtra("lesson_id",  mData.get(position).getId().toString());
                intent.putExtra("lesson_lvl", mData.get(position).getLevel());

                //mContent = mData.get(position).getContents();
              //  if (mContent.size() != 0)
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_lesson;
        private TextView tv_name;
        private TextView tv_level;
        private ImageView img;
        public TextView tv_content_lesson;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_lesson = (LinearLayout)itemView.findViewById(R.id.lesson_item);
            tv_name = (TextView)itemView.findViewById(R.id.name_lesson);
            tv_level = (TextView)itemView.findViewById(R.id.level_lesson);
            img = (ImageView)itemView.findViewById(R.id.img_lesson);
            tv_content_lesson = (TextView)itemView.findViewById(R.id.content_lesson);

        }
    }

    //To filter search bar
    public void  setfilter(List<Lesson> listlessons){
        mData = new ArrayList<>();
        mData.addAll(listlessons);
        notifyDataSetChanged();
    }

}
