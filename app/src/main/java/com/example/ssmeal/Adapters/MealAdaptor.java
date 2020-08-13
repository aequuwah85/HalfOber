package com.example.ssmeal.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ssmeal.R;
import com.example.ssmeal.modelCalsses.Meal;

import java.util.List;

public class MealAdaptor extends RecyclerView.Adapter<MealAdaptor.ViewHolder> {
    private List<Meal> mealList;

    public MealAdaptor(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdaptor.ViewHolder holder, int position) {
         Meal meal=mealList.get(position);
         holder.mealName.setText(meal.getMealName());
        holder.mealPrice.setText(String.valueOf(meal.getMealPrice()));
         holder.mealDes.setText(meal.getMealDescription());
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mealName,mealDes,mealPrice,mealCalory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mealName=itemView.findViewById(R.id.mealName);
            mealDes=itemView.findViewById(R.id.mealDes);
            mealPrice=itemView.findViewById(R.id.mealPrice);
        }
    }
}
