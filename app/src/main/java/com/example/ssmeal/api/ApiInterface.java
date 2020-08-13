package com.example.ssmeal.api;


import com.example.ssmeal.modelCalsses.Category;
import com.example.ssmeal.modelCalsses.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("categorys/GetCategoriesByRestaurantId/1")
    Call<List<Category>> getCategory();

    @GET("meals/GetMealsByCategoryId/{id}")
    Call<List<Meal>> getMeals(@Path("id") Integer id);
}
