package com.example.cooking;

import java.util.ArrayList;

public class Recipe {
    private String recipeName;
    private String zairyo;
    private String recipeUrl;
    private String imageUrl;
    private String suuryou;

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

    public String getSuuryou() { return suuryou; }
    public void setSuuryou(String suuryou){ this.suuryou = suuryou; }

}
