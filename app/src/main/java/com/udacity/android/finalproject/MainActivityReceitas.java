package com.udacity.android.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityReceitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_receitas);
    }

    public void openReceita01(View view){
        Intent intent = new Intent(this, MainActivityReceita01.class);

        startActivity(intent);
    }

    public void openReceita02(View view){
        Intent intent = new Intent(this, MainActivityReceita02.class);

        startActivity(intent);
    }

    public void openReceita03(View view){
        Intent intent = new Intent(this, MainActivityReceita03.class);

        startActivity(intent);
    }

    public void openReceita04(View view){
        Intent intent = new Intent(this, MainActivityReceita04.class);

        startActivity(intent);
    }

    public void openReceita05(View view){
        Intent intent = new Intent(this, MainActivityReceita05.class);

        startActivity(intent);
    }
}
