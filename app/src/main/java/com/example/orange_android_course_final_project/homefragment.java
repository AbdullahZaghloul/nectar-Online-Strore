package com.example.orange_android_course_final_project;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homefragment extends Fragment {
    RecyclerView recyclerView1 , recyclerView2,recyclerView3,recyclerView4;
    ProgressDialog dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recView1_id);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recView2_id);
        recyclerView3 = (RecyclerView) view.findViewById(R.id.recView3_id);
        recyclerView4 = (RecyclerView) view.findViewById(R.id.recView4_id);
        dialog = progressDialog();
        dialog.show();
        getData1();
        getData2();
        return view;
    }
    private void getData1()
    {
        Call<List<productModel>> call = ProductClient.getInstance().getMyAPI().getproduct();
        call.enqueue(new Callback<List<productModel>>() {
            @Override
            public void onResponse(Call<List<productModel>> call, Response<List<productModel>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(), "Code is : "+String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    return;

                }
                List<productModel> productModels = response.body();
                ProductAdapter adapter = new ProductAdapter(getContext() , productModels);
                recyclerView1.setAdapter(adapter);
                recyclerView1.setLayoutManager(new LinearLayoutManager(getContext() ,LinearLayoutManager.HORIZONTAL , false ));
                recyclerView2.setAdapter(adapter);
                recyclerView2.setLayoutManager(new LinearLayoutManager(getContext() ,LinearLayoutManager.HORIZONTAL , false ));
                recyclerView4.setAdapter(adapter);
                recyclerView4.setLayoutManager(new LinearLayoutManager(getContext() ,LinearLayoutManager.HORIZONTAL , false ));
                dialog.cancel();
            }

            @Override
            public void onFailure(Call<List<productModel>> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }
        });
    }
    private void getData2()
    {
        Call<List<productModel2>> call = productClient2.getInstance().getMyAPI2().getproduct2();
        call.enqueue(new Callback<List<productModel2>>() {
            @Override
            public void onResponse(Call<List<productModel2>> call, Response<List<productModel2>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(), "Code is : "+String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    return;

                }
                List<productModel2> productModels2  = response.body();
                productAdapter2 productAdapter2 = new productAdapter2(getContext(),productModels2);
                recyclerView3.setAdapter(productAdapter2);
                recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                dialog.cancel();
            }

            @Override
            public void onFailure(Call<List<productModel2>> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

    }


    private ProgressDialog progressDialog() {
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setTitle("API Fertching");
        dialog.setMessage("Loading Data.....");
        dialog.setCancelable(false);
        return dialog;
    }
}