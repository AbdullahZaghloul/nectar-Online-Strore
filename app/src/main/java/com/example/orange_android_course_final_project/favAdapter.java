package com.example.orange_android_course_final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class favAdapter extends RecyclerView.Adapter<favAdapter.ViewHolder> {

    Context context;
    public static ArrayList<favModel> favModels;

    public favAdapter(Context context, ArrayList<favModel> favModels) {
        this.context = context;
        this.favModels = favModels;
    }

    @NonNull
    @Override
    public favAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favouritemcell,parent ,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull favAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(favModels.get(position).getFav_image()).into(holder.fav_img);
        holder.fav_title.setText(favModels.get(position).getTitle());
        holder.fav_price.setText(favModels.get(position).getPrice()+" $");
    }

    @Override
    public int getItemCount() {
        return favModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fav_img;
        TextView fav_title;
        TextView fav_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fav_img=itemView.findViewById(R.id.fav_img);
            fav_title=itemView.findViewById(R.id.fav_title);
            fav_price=itemView.findViewById(R.id.fav_price);
        }
    }
}
