package com.example.orange_android_course_final_project;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class cartfragment extends Fragment {
    RecyclerView recyclerView;
    Button btn_show_dialog,btn_dialog;
    ImageButton cancleOrder;
    Button btn_tryagian;
    TextView backtohome;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_cartfragment, container, false);
        recyclerView=v.findViewById(R.id.card_recview_id);
        ArrayList<cartModel> arr = cartList.listitems;
        cartAdapter cartAdapter = new cartAdapter(getContext(),arr);
        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        btn_show_dialog=v.findViewById(R.id.btn_show_Dialog);
        btn_show_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext()).create();
                View view1 = getLayoutInflater().inflate(R.layout.checkout_dialog,null);
                btn_dialog=view1.findViewById(R.id.dialog_btn);
                cancleOrder=view1.findViewById(R.id.cancle_order);
                btn_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getContext(),orderAccepted.class));
                        dialog.dismiss();
                    }
                });
                cancleOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog dialog2 = new AlertDialog.Builder(getContext()).create();
                        View view2 = getLayoutInflater().inflate(R.layout.failedialog,null);
                        btn_tryagian=view2.findViewById(R.id.btn_tryagian);
                        backtohome=view2.findViewById(R.id.btn_backtohome);
                        btn_tryagian.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();
                            }
                        });
                        backtohome.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getContext(),home.class));
                                dialog2.dismiss();
                            }
                        });
                        dialog2.setView(view2);
                        dialog2.show();
                        dialog.dismiss();
                    }
                });

                dialog.setView(view1);
                dialog.show();
            }
        });
        return v;
    }

}