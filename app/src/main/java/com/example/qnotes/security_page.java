package com.example.qnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class security_page extends AppCompatActivity {
    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_page);

        backBtn = findViewById(R.id.back_btn);

        backBtn.setOnClickListener((v -> startActivity(new Intent(security_page.this,locked_notes.class))));
    }
}