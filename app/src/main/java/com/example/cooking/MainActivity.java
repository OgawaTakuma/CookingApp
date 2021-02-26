package com.example.cooking;

import android.app.Activity;
import android.content.Intent;
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
import static android.view.View.*;


public class MainActivity extends AppCompatActivity {


    private TextView textView;

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


        // ボタンの取得
        Button button1 = findViewById(R.id.button);

        // リスナーの登録
        button1.setOnClickListener(onClick_button);
    }

    private View.OnClickListener onClick_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // ボタン1が押された場合
            if (v.getId() == R.id.button) {
                textView = findViewById(R.id.editText1);
                RecipeCreate recipeCreate = new RecipeCreate();
                recipeCreate.execute();
                //Toast.makeText(this, "ボタン1が押されました！", Toast.LENGTH_LONG).show();

                // インテントへのインスタンス生成
                //Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                //　インテントに値をセット
                //intent.putExtra("DATA",textView.getText().toString());
                // サブ画面の呼び出し
                //startActivity(intent);
            }
        }
    };
}
