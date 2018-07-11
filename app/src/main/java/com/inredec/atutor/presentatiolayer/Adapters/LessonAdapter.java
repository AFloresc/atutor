package com.inredec.atutor.presentatiolayer.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.inredec.atutor.R;
import com.inredec.atutor.model.businesslayer.entities.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.MyViewHolder>
        implements Filterable {

    private Context context;
    private List<Lesson> lessonList;
    private List<Lesson> lessonListFiltered;

    private LessonAdapterListener listener;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_lesson;
        private TextView tv_name;
        private TextView tv_level;
        private ImageView img;

        public MyViewHolder(View view) {
            super(view);
            item_lesson = (LinearLayout)itemView.findViewById(R.id.lesson_item);
            tv_name = (TextView)itemView.findViewById(R.id.name_lesson);
            tv_level = (TextView)itemView.findViewById(R.id.level_lesson);
            img = (ImageView)itemView.findViewById(R.id.img_lesson);



            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onLessonSelected(lessonListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }

    public LessonAdapter(Context context, List<Lesson> lessonList, LessonAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.lessonList = lessonList;
        this.lessonListFiltered = lessonList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lesson, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Lesson lesson =lessonListFiltered.get(position);

        holder.tv_name.setText(lesson.getName());
        holder.tv_level.setText(lesson.getLevel());

        Glide.with(context)
                .load(lesson.getImage())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return lessonListFiltered.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    lessonListFiltered = lessonList;
                } else {
                    List<Lesson> filteredList = new ArrayList<>();
                    for (Lesson row : lessonList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getLevel().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    lessonListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = lessonListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                lessonListFiltered = (ArrayList<Lesson>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface LessonAdapterListener {
        void onLessonSelected(Lesson lesson);
    }
}
