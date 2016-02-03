package com.umut.multiplechoicelistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        TextView textView = (TextView) findViewById(R.id.textView);
        Intent myIntent = getIntent();
        ArrayList<String> array = myIntent.getStringArrayListExtra("id");


        textView.setText("Selected item ID's " + "\n");
        for (String item :array ) {
            textView.setText(textView.getText().toString() + " \n"+ item + " " );
        }


    }

}
