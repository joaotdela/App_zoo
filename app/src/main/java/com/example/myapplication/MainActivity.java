package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnmap;
    Button btnanimal;
    Button btnzoo;
    Button btnnews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnmap = findViewById(R.id.btnmap);
        btnzoo = findViewById(R.id.btnzoo);
        btnnews =findViewById(R.id.btnnews);
        btnanimal = findViewById(R.id.btnanimal);

        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        btnanimal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                RequestAnimal();
                Intent it = new Intent(MainActivity.this, AnimaisActivity.class);
                startActivity(it);
            }

            private void RequestAnimal() {
                String url = "https://192.168.15.16:6643/api/Animal";
                Apirequest apiRequest = new Apirequest();
                apiRequest.execute(url);
            }

        });

        btnzoo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                RequestZoo();
                Intent it = new Intent(MainActivity.this, AnimaisActivity.class);
                startActivity(it);
            }

            private void RequestZoo() {
                String url = "https://192.168.15.16:6643/api/Zoo";
                Apirequest apinRequest = new Apirequest();
                apinRequest.execute(url);
            }
        });

        btnnews.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                RequestNews();
                Intent it = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(it);
            }

            private void RequestNews() {
                String url = "https://192.168.15.16:6643/api/News";
                ApiNewsRequest apinRequest = new ApiNewsRequest();
                apinRequest.execute(url);
            }
        });


    }
}