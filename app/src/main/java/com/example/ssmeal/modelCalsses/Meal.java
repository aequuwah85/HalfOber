package com.example.ssmeal.modelCalsses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal {
    @SerializedName("mealId")
    @Expose
    private Integer mealId;
    @SerializedName("mealName")
    @Expose
    private String mealName;
    @SerializedName("mealDescription")
    @Expose
    private String mealDescription;
    @SerializedName("mealCalory")
    @Expose
    private Integer mealCalory;
    @SerializedName("mealPrice")
    @Expose
    private float mealPrice;

    public Meal(Integer mealId, String mealName, String mealDescription, Integer mealCalory, Float mealPrice) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealCalory = mealCalory;
        this.mealPrice = mealPrice;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public void setMealCalory(Integer mealCalory) {
        this.mealCalory = mealCalory;
    }

    public void setMealPrice(Float mealPrice) {
        this.mealPrice = mealPrice;
    }

    public Integer getMealId() {
        return mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public Integer getMealCalory() {
        return mealCalory;
    }

    public Float getMealPrice() {
        return mealPrice;
    }
}
