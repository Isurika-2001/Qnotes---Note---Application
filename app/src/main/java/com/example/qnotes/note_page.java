package com.example.qnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;


public class note_page extends AppCompatActivity {

//    boolean darkModeVal;
//    SharedPreferences sharedPreferences;

    EditText title, content;
    ImageButton attachImage, save, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_page);

        title = findViewById(R.id.title_txt);
        content = findViewById(R.id.content_txt);

        attachImage = findViewById(R.id.attach_btn);
        save = findViewById(R.id.save_btn);

        backBtn = findViewById(R.id.back_btn);
//        sharedPreferences = getSharedPreferences("night",0);
//        darkModeVal = sharedPreferences.getBoolean("night_mode", false);
//
//        if(!darkModeVal){
//            backBtn.setImageResource(R.drawable.back);
//        } else {
//            backBtn.setImageResource(R.drawable.back2);
//        }

        backBtn.setOnClickListener((v -> startActivity(new Intent(note_page.this,MainActivity.class))));

        save.setOnClickListener( (v)-> save_note());
    }
    void save_note(){
        String titleTxt = title.getText().toString();
        String contentTxt =  content.getText().toString();

        if (titleTxt==null || titleTxt.isEmpty()){
            title.setError("Title is required");
        } else {
        }
    }
}