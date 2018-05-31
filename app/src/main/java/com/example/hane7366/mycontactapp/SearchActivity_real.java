package com.example.hane7366.mycontactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchActivity_real extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_real);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MenuScreen.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView3);
        textView.setText(message);
    }
}
