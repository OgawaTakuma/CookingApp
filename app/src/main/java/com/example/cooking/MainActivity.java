package com.example.cooking;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.View;
import android.widget.Toast;

import static android.view.View.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private TestOpenHelper helper;
    private SQLiteDatabase db;
    private CsvReader csvReader;

    private String recipeNameText;
    private String recipeUrlText;
    private String imageUrlText;
    private String zairyoText;
    private String suuryouText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        //リスナーをボタンに登録
        findViewById(R.id.button).setOnClickListener(this);
        // ボタンの取得
        Button button1 = findViewById(R.id.button);

        // リスナーの登録
        //button1.setOnClickListener(onClick_button);

        helper = new TestOpenHelper(getApplicationContext());
        db =helper.getReadableDatabase();
        csvReader = new CsvReader();
        csvReader.reader(getApplicationContext());
        //recipeCreate.csvtotext(csvReader.objects);
        for(int i=0;i<csvReader.objects.size();i++) {
            //objectの中身をテキストに格納
            recipeNameText = csvReader.objects.get(i).getRecipeName();
            recipeUrlText = csvReader.objects.get(i).getRecipeUrl();
            imageUrlText = csvReader.objects.get(i).getImageUrl();
            zairyoText = csvReader.objects.get(i).getZairyo();
            suuryouText = csvReader.objects.get(i).getSuuryou();
            //DBに追加
            helper.saveData(db, recipeNameText, recipeUrlText, imageUrlText, zairyoText, suuryouText);


        }
        //DB読み込んで表示させたい

    }

    //private View.OnClickListener onClick_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // ボタン1が押された場合
            if (v.getId() == R.id.button) {
                textView = findViewById(R.id.editText1);
                RecipeCreate recipeCreate = new RecipeCreate();
                recipeCreate.execute();
                Context context = getApplicationContext();
                Toast.makeText(context, "ボタン1が押されました！", Toast.LENGTH_LONG).show();

                // インテントへのインスタンス生成
                Intent intent = new Intent(MainActivity.this, SearchResult.class);
                //　インテントに値をセット
                intent.putExtra("DATA",textView.getText().toString());
                // サブ画面の呼び出し
                startActivity(intent);



            }
        }
}
