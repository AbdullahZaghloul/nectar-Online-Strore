package com.example.orange_android_course_final_project;

import java.util.ArrayList;
import java.util.List;

public class cartList {
    public static ArrayList<cartModel> listitems= new ArrayList<>();

    public static void additemtoList(cartModel cartModel)
    {
        listitems.add(cartModel);
    }

}
