package com.example.qnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    SwitchCompat darkMode;
    boolean darkModeVal;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageView searchIcon, addIcon;

    FloatingActionButton addNoteBtn;
    ImageButton menuBtn, backBtn, attachBtn, SaveBtn, settingBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNoteBtn = findViewById(R.id.add_btn);
        addNoteBtn.setOnClickListener((v -> startActivity(new Intent(MainActivity.this,note_page.class))));

        menuBtn = findViewById(R.id.menu_btn);
        searchIcon = findViewById(R.id.imageView4);
        addIcon = findViewById(R.id.add_btn);
        backBtn = findViewById(R.id.back_btn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

        darkMode = findViewById(R.id.dark_mode);
        sharedPreferences = getSharedPreferences("night",0);
        darkModeVal = sharedPreferences.getBoolean("night_mode", false);

        if(!darkModeVal){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            darkMode.setChecked(false);
            searchIcon.setImageResource(R.drawable.search);
            menuBtn.setImageResource(R.drawable.menu);
            addIcon.setImageResource(R.drawable.add);
        }

        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    darkMode.setChecked(true);
                    searchIcon.setImageResource(R.drawable.search2);
                    menuBtn.setImageResource(R.drawable.menu2);
                    addIcon.setImageResource(R.drawable.add2);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night_mode",true);
                    editor.commit();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    darkMode.setChecked(false);
                    searchIcon.setImageResource(R.drawable.search2);
                    menuBtn.setImageResource(R.drawable.menu2);
                    addIcon.setImageResource(R.drawable.add2);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night_mode",false);
                    editor.commit();
                }
            }
        });
    }
    public void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.locked_notes){
                    Intent intent = new Intent(MainActivity.this, locked_notes.class);
                    startActivity(intent);
                }
                return true;
            }
        });
        popupMenu.show();
    }
}