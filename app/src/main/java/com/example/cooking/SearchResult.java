package com.example.cooking;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SearchResult extends AppCompatActivity {

    /*
    Recipe recipe;
    ConstraintLayout layout =findViewById(R.id.ConstraintLayout);
    TextView textView = findViewById(R.id.textViewD);
*/
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);


        TextView text = (TextView)findViewById(R.id.textView4);
        // インテントを取得
        Intent intent = getIntent();
        // インテントに保存されたデータを取得
        String data = intent.getStringExtra("DATA");
        text.setText(data);


        /*
        //とりあえず。
        int id = 1;

        //レシピが存在する場合～みたいなIF文かけてレシピを格納したい
        recipe = new Recipe();

        //1つ目のレシピ情報を表示
        //レシピ名
        TextView textRecipeName1 = new TextView(this);
            textRecipeName1.setText(recipe.getRecipeName());
            textRecipeName1.setId(id);
            textRecipeName1.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            ));
            //マージン設定
            ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) textRecipeName1.getLayoutParams();
            lp.leftMargin = 60;
            lp.topMargin = 50;
            lp.startToStart = layout.getId();
            lp.topToBottom = textView.getId();
            textRecipeName1.setLayoutParams(lp);

        //材料名
        TextView textZairyo1 = new TextView(this);
        textZairyo1.setText(recipe.getZairyo());
         */



    }


}
