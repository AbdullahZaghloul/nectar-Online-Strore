package com.example.orange_android_course_final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class incategorymen extends AppCompatActivity {

    RecyclerView recyclerView7;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incategorymen);
        recyclerView7 = findViewById(R.id.recview7_id);
        dialog = progressDialog();
        dialog.show();
        getData();
    }
    private void getData()
    {
        Call<List<productModel>> call = productClient5.getInstance5().getMyAPI5().getproduct5();
        call.enqueue(new Callback<List<productModel>>() {
            @Override
            public void onResponse(Call<List<productModel>> call, Response<List<productModel>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(incategorymen.this, "Code is : "+String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    return;

                }
                List<productModel> list  = response.body();
                ProductAdapter productAdapter = new ProductAdapter(incategorymen.this,list);
                recyclerView7.setAdapter(productAdapter);
                recyclerView7.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<productModel>> call, Throwable t) {
                Toast.makeText(incategorymen.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
    }
    private ProgressDialog progressDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("API Fertching");
        dialog.setMessage("Loading Data.....");
        dialog.setCancelable(false);
        return dialog;
    }
}