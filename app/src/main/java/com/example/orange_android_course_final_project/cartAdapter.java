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
import java.util.List;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.viewHolde> {

    Context context;
    public static ArrayList<cartModel> cartModelList;

    public cartAdapter(Context context, ArrayList<cartModel> cartModelList) {
        this.context = context;
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public cartAdapter.viewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_itemcell,parent,false);
        return new viewHolde(v);
    }

    @Override
    public void onBindViewHolder(@NonNull cartAdapter.viewHolde holder, int position) {
        Glide.with(context).load(cartModelList.get(position).getImg()).into(holder.card_img);
        holder.card_title.setText(cartModelList.get(position).getTitle());
        holder.card_counter.setText(cartModelList.get(position).getCounter());
        holder.card_price.setText(cartModelList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    public class viewHolde extends RecyclerView.ViewHolder {
        ImageView card_img;
        TextView card_title;
        TextView card_counter;
        TextView card_price;
        public viewHolde(@NonNull View itemView) {
            super(itemView);
            card_img = itemView.findViewById(R.id.card_img_id);
            card_title = itemView.findViewById(R.id.card_title_id);
            card_counter=itemView.findViewById(R.id.card_counter_id);
            card_price=itemView.findViewById(R.id.card_price_id);
        }
    }
}
