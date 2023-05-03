package com.example.qnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class locked_notes extends AppCompatActivity {
    ImageButton backBtn, settingBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locked_notes);

        backBtn = findViewById(R.id.back_btn);
        settingBtn = findViewById(R.id.setting_btn);

        backBtn.setOnClickListener((v -> startActivity(new Intent(locked_notes.this,MainActivity.class))));
        settingBtn.setOnClickListener((v -> startActivity(new Intent(locked_notes.this,security_page.class))));
    }
}