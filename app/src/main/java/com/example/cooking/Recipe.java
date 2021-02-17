package com.example.cooking;

import java.util.ArrayList;

public class Recipe {
    private String recipeName;
    private String zairyo;
//    private double suuryou;
    private String recipeUrl;
    private String imageUrl;

    public String getRecipeName(){
        return recipeName;
    }
    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }

    public String getZairyo(){
        return zairyo;
    }
    public void setZairyo(String zairyo){
        this.zairyo = zairyo;
    }

//    public double getSuuryou(){
//        return suuryou;
//    }
//    public void setSuuryou(double suuryou){
//        this.suuryou = suuryou;
//    }

    public String getRecipeUrl(){
        return recipeUrl;
    }
    public void setRecipeUrl(String recipeUrl){
        this.recipeUrl = recipeUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

}
