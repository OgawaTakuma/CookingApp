package com.example.cooking;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.AsyncTask;


public class RecipeCreate extends AsyncTask<Void,Void,String> {

    //コンストラクタ
    public RecipeCreate(){
        super();
    }
     // APIに飛ばすデータを作成
    String name ="a";
    String contact = "b";
//    // AyncTaskLoader(匿名クラス)からアクセスするためにfinalを付与
//    final String sendData = String.format(
//                "{ \"contact\": { \"name\":\"%s\", \"contact\":\"%s\" } }",
//                name, contact);
    protected void onPreExecute() {
        super.onPreExecute();
        // doInBackground前処理
    }
     @Override
     protected String doInBackground(Void... param) {
         try {
//             // データを送信するためにはbyte配列に変換する必要がある
//             byte[] sendJSON = JSON.getBytes("UTF-8");

             // 接続先のURLの設定およびコネクションの取得
             URL url = new URL("https://app.rakuten.co.jp/services/api/Recipe/CategoryRanking/20170426?format=json&categoryId=10&applicationId=1081580053232703144");
             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
             connection.setConnectTimeout(1000);
             connection.setReadTimeout(1000);
             final int status = connection.getResponseCode();

             // 接続するための設定
             connection.setRequestMethod("GET");
//             connection.setRequestProperty("Content-Type", "application/x-www-form-urlcoded");
//             connection.setRequestProperty("Accept", "application/json");

             // APIからの戻り値と送信するデータの設定を許可する
             connection.setDoInput(false);
             connection.setDoInput(true);

             // 送信するデータの設定

//             connection.getOutputStream().write(sendJSON);
//             connection.getOutputStream().flush();
//             connection.getOutputStream().close();

             // 接続！
             connection.connect();
             int statusCode = connection.getResponseCode();

             if(statusCode == HttpURLConnection.HTTP_OK){
                 StringBuilder result = null;
                 //responseの読み込み
                 final InputStream in = connection.getInputStream();
                 final String encoding = connection.getContentEncoding();
                 final InputStreamReader inReader = new InputStreamReader(in, "utf-8");
                 final BufferedReader bufferedReader = new BufferedReader(inReader);
                 String line = null;
                 while((line = bufferedReader.readLine()) != null) {
                     result.append(line);
                 }
                 bufferedReader.close();
                 inReader.close();
                 in.close();

                 return result.toString();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // doInBackground後処理
    }


 }
