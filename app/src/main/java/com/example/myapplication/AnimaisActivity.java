package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnimaisActivity extends AppCompatActivity {
    Button btnanimalback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais);
        btnanimalback = findViewById(R.id.btnback3);
        btnanimalback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimaisActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }


}