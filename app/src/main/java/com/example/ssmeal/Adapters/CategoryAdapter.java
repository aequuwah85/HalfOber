package com.example.ssmeal.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;



import com.example.ssmeal.R;
import com.example.ssmeal.modelCalsses.Category;
import com.example.ssmeal.ui.menu.MealsFragment;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Category> categories;
    private Category selectedItem;

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.ViewHolder holder, int position) {
        final Category category=categories.get(position);

        holder.categoryName.setText(category.getCategoryName());
        holder.description.setText(category.getCategoryDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem= category;

                Bundle bundle=new Bundle();
                bundle.putInt("categoryId",selectedItem.getCategoryId());
                AppCompatActivity appCompatActivity=(AppCompatActivity) v.getContext();
                MealsFragment mealsFragment= new MealsFragment();
                mealsFragment.setArguments(bundle);
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.rec,mealsFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName, description;

        public ViewHolder(@NonNull View view) {
            super(view);
            categoryName=view.findViewById(R.id.categoryName);
            description=view.findViewById(R.id.description);


        }
    }
}
