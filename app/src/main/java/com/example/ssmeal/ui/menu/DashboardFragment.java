package com.example.ssmeal.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ssmeal.Adapters.CategoryAdapter;
import com.example.ssmeal.R;
import com.example.ssmeal.api.Api;
import com.example.ssmeal.api.ApiInterface;
import com.example.ssmeal.modelCalsses.Category;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {
    RecyclerView recyclerView;
    List<Category> categories = new ArrayList<>();
    ApiInterface apiInterface;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.categoryview);
        apiInterface = Api.getClient().create(ApiInterface.class);
        Call<List<Category>> call = apiInterface.getCategory();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categories = response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });

        return root;
    }

    private void setAdapter() {
        CategoryAdapter adapter = new CategoryAdapter(categories);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}


