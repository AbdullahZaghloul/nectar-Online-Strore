package com.example.orange_android_course_final_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    Context context;
    List<productModel>productModels;

    public ProductAdapter(Context context, List<productModel> productModels) {
        this.context = context;
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_itemcell1 , parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(productModels.get(position).getImage()).placeholder(R.drawable.banana).into(holder.product_image);
        if(productModels.get(position).getTitle().length()>9)
            holder.product_name.setText(productModels.get(position).getTitle().substring(0,9).concat("..."));
        else
            holder.product_name.setText(productModels.get(position).getTitle());
        holder.product_price.setText(productModels.get(position).getPrice()+" ".concat("$"));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(context,productDetails.class);
                y.putExtra("product_img" , productModels.get(position).getImage());
                if (productModels.get(position).getTitle().length()>17)
                    y.putExtra("product_title",productModels.get(position).getTitle().substring(0,14).concat("....."));
                else
                    y.putExtra("product_title",productModels.get(position).getTitle());
                y.putExtra("product_price",productModels.get(position).getPrice()+"");
                if(productModels.get(position).getDescription().length()>100)
                    y.putExtra("product_des",productModels.get(position).getDescription().substring(0,100).concat("..."));
                else
                    y.putExtra("product_des",productModels.get(position).getDescription());
                context.startActivity(y);
            }
        });

    }

    @Override
    public int getItemCount() {return productModels.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        TextView product_name;
        TextView product_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.prod_image_id);
            product_name = itemView.findViewById(R.id.prod_name_id);
            product_price = itemView.findViewById(R.id.prod_price_id);
        }
    }
}
