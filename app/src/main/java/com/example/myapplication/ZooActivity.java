package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ZooActivity extends AppCompatActivity {
    Button btnzooback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo);

        btnzooback = findViewById(R.id.btnback3);
        btnzooback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZooActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}