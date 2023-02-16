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

import java.util.List;

public class productAdapter2 extends RecyclerView.Adapter<productAdapter2.ViewHolder> {
    Context context;
    List<productModel2>productModels2;

    public productAdapter2(Context context, List<productModel2> productModels2) {
        this.context = context;
        this.productModels2 = productModels2;
    }

    @NonNull
    @Override
    public productAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_itemcell2,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull productAdapter2.ViewHolder holder, int position) {
        Glide.with(context).load(productModels2.get(position).getImage()).placeholder(R.drawable.banana).into(holder.img);
        if(productModels2.get(position).getTitle().length()>10)
            holder.txt.setText(productModels2.get(position).getTitle().substring(0,9).concat("..."));
        else
            holder.txt.setText(productModels2.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return productModels2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.rec2_image_id);
            txt=itemView.findViewById(R.id.rec2_tv_id);
        }
    }
}
