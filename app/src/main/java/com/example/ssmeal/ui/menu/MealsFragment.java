package com.example.ssmeal.ui.menu;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ssmeal.Adapters.MealAdaptor;
import com.example.ssmeal.R;
import com.example.ssmeal.api.Api;
import com.example.ssmeal.api.ApiInterface;
import com.example.ssmeal.modelCalsses.Category;
import com.example.ssmeal.modelCalsses.Meal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MealsFragment extends Fragment {
    RecyclerView recyclerView;
    List<Meal> mealList=new ArrayList<>();
    ApiInterface apiInterface;
    int intentCategory;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle=this.getArguments();
        intentCategory=bundle.getInt("categoryId");
        View root = inflater.inflate(R.layout.fragment_meals, container, false);
        // Inflate the layout for this fragment
        recyclerView=(RecyclerView) root.findViewById(R.id.mealss);
        apiInterface = Api.getClient().create(ApiInterface.class);
        Call<List<Meal>> call=apiInterface.getMeals(intentCategory);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.line_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
       call.enqueue(new Callback<List<Meal>>() {
           @Override
           public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
               mealList=response.body();
               setAdapter();
           }

           @Override
           public void onFailure(Call<List<Meal>> call, Throwable t) {

           }
       });
        return (root);

    }
    private void setAdapter(){
        MealAdaptor adapter=new MealAdaptor(mealList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }
}
