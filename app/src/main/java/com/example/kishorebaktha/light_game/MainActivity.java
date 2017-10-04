package com.example.kishorebaktha.light_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
    }
    public void Next(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Game.class);
        startActivity(intent);
    }
    public void NEXT2(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Game2.class);
        startActivity(intent);
    }
}