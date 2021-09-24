package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Apirequest extends AsyncTask<String, Integer, String> {

    String myURl;
    Context context;

    @Override
    protected String doInBackground(String... params) {
        myURl = params[0];
        try {
            URL url = new URL(myURl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept","application/json");


            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception data) {
            data.printStackTrace();
            return data.toString();
        }
        return null;
    }

@Override
protected void onPostExecute(String s){

    super.onPostExecute(s);

    try {
        JSONObject js = new JSONObject(s);
        JSONArray data = js.getJSONArray("data").getJSONArray(Integer.parseInt("result"));

        String name = data.getJSONObject(0).getString("name");
        String description = ((JSONArray) data).getJSONObject(0).getString("descri");
        System.out.println("name" + name + "descri"+description);
        Toast.makeText(context, "name" + name + "descri" + description, Toast.LENGTH_SHORT).show();

    }catch (JSONException data){
        data.printStackTrace();
    }
}
}

