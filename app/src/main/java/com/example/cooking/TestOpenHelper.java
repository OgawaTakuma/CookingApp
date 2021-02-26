package com.example.cooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TestOpenHelper extends SQLiteOpenHelper{
    // データーベースのバージョン
    public static final int DATABASE_VERSION = 1;
    // データーベース名
    private static final String DATABASE_NAME = "RecipeDB.db";
    private static final String TABLE_NAME = "recipedb";
    private static final String _ID = "_id";
    private static final String COLUMN_NAME_TITLE = "recipeName";
    private static final String COLUMN_NAME_SUBTITLE1 = "recipeUrl";
    private static final String COLUMN_NAME_SUBTITLE2 = "imageUrl";
    private static final String COLUMN_NAME_SUBTITLE3 = "zairyo";
    private static final String COLUMN_NAME_SUBTITLE4 = "suuryou";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TITLE + " TEXT," +
                    COLUMN_NAME_SUBTITLE1 + " TEXT," +
                    COLUMN_NAME_SUBTITLE2 + " TEXT," +
                    COLUMN_NAME_SUBTITLE3 + " TEXT," +
                    COLUMN_NAME_SUBTITLE4 + " TEXT);";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    TestOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
// テーブル作成
        db.execSQL(
                SQL_CREATE_ENTRIES
        );

        //最初からデータ格納する場合、ここでDBにレシピを追加
//        saveData(db, "青葉城趾", "歴史", 4);

        Log.d("debug", "onCreate(SQLiteDatabase db)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // アップデートの判別、古いバージョンは削除して新規作成
        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void saveData(SQLiteDatabase db, String recipeName, String recipeUrl, String imageUrl, String zairyo, String suuryou){
        ContentValues values = new ContentValues();
        values.put("recipeName", recipeName);
        values.put("recipeUrl", recipeUrl);
        values.put("imageUrl", imageUrl);
        values.put("zairyo", zairyo);
        values.put("suuryou", suuryou);
        db.insert("recipedb", null, values);
    }
}
