package com.inredec.atutor.presentatiolayer.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.Lesson;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Lesson> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Lesson> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_lesson, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        // Dialog ini

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_lesson);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.item_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_name_tv = (TextView) myDialog.findViewById(R.id.dialog_name_lesson_id);
                TextView dialog_description_tv = (TextView) myDialog.findViewById(R.id.dialog_description_id);
                ImageView dialog_lesson_img = (ImageView) myDialog.findViewById(R.id.dialog_lesson_img);
                dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_description_tv.setText(mData.get(vHolder.getAdapterPosition()).getLevel());
                dialog_lesson_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());

                Toast.makeText(mContext, "Test Click" +
                        String.valueOf(vHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_level.setText(mData.get(position).getLevel());
        holder.img.setImageResource(mData.get(position).getPhoto());

        //"https://www.pdn.cam.ac.uk/teaching/teaching_images/iTunes-U-1.4-for-iOS-app-icon-small.png"

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

        public MyViewHolder(View itemView) {
            super(itemView);
            item_lesson = (LinearLayout)itemView.findViewById(R.id.lesson_item);
            tv_name = (TextView)itemView.findViewById(R.id.name_lesson);
            tv_level = (TextView)itemView.findViewById(R.id.level_lesson);
            img = (ImageView)itemView.findViewById(R.id.img_lesson);
        }
    }

    //To filter search bar
    public void  setfilter(List<Lesson> listlessons){
        mData = new ArrayList<>();
        mData.addAll(listlessons);
        notifyDataSetChanged();
    }

}
