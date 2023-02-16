package com.example.orange_android_course_final_project;

import java.util.ArrayList;

public class favList {
    public static ArrayList<favModel> favItems= new ArrayList<>();

    public static void additemtoList(favModel favModel)
    {
        favItems.add(favModel);
    }
}
