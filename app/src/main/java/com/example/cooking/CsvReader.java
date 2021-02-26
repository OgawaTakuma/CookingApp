package com.example.cooking;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    List<Recipe> objects = new ArrayList<Recipe>();
    public void reader(Context context) {
        AssetManager assetManager = context.getResources().getAssets();
        try {
            // CSVファイルの読み込み
            InputStream inputStream = assetManager.open("recipe.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {

                //カンマ区切りで１つづつ配列に入れる
                Recipe recipe = new Recipe();
                String[] RowData = line.split(",");

                //CSVの左([0]番目)から順番にセット
                recipe.setRecipeName(RowData[0]);
                recipe.setRecipeUrl(RowData[1]);
                recipe.setImageUrl(RowData[2]);
                recipe.setZairyo(RowData[3]);
                recipe.setSuuryou(RowData[4]);

                objects.add(recipe);
            }
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
