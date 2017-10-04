package com.example.kishorebaktha.light_game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by KISHORE BAKTHA on 7/8/2017.
 */

public class Game2  extends AppCompatActivity {
    Button b1,b2,b3,b4;
    Random r;
    int score=0,temp;
    MediaPlayer play;
    TextView t1,t2;
    Context context=this;
    String color1,color2,color3,color4;
    final Handler mHandler = new Handler();
    // Create runnable for posting
    final Runnable mUpdateResults = new Runnable() {
        public void run() {
            temp = (r.nextInt(3) + 1);
            if (temp == 1)
                color1 = "red";
            else if (temp == 2)
                color1 = "green";
            else if (temp == 3)
                color1 = "blue";

            temp = (r.nextInt(3) + 1);
            if (temp == 1)
                color2 = "red";
            else if (temp == 2)
                color2 = "green";
            else if (temp == 3)
                color2 = "blue";

            temp = (r.nextInt(3) + 1);
            if (temp == 1)
                color3 = "red";
            else if (temp == 2)
                color3 = "green";
            else if (temp == 3)
                color3 = "blue";

            temp = (r.nextInt(3) + 1);
            if (temp == 1)
                color4 = "red";
            else if (temp == 2)
                color4 = "green";
            else if (temp == 3)
                color4 = "blue";
            applyColor(b1, color1);
            applyColor(b2, color2);
            applyColor(b3, color3);
            applyColor(b4, color4);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = (Button) findViewById(R.id.button6);
        b2 = (Button) findViewById(R.id.button7);
        b3 = (Button) findViewById(R.id.button8);
        b4 = (Button) findViewById(R.id.button9);
        t1=(TextView)findViewById(R.id.textView4);
        t1.setText("SCORE: "+score);
        t2=(TextView)findViewById(R.id.textView5);
        r = new Random();
        int temp;
        temp = (r.nextInt(3) + 1);
        if (temp == 1)
            color1 = "red";
        else if (temp == 2)
            color1 = "green";
        else if (temp == 3)
            color1 = "blue";

        temp = (r.nextInt(3) + 1);
        if (temp == 1)
            color2 = "red";
        else if (temp == 2)
            color2 = "green";
        else if (temp == 3)
            color2 = "blue";

        temp = (r.nextInt(3) + 1);
        if (temp == 1)
            color3 = "red";
        else if (temp == 2)
            color3 = "green";
        else if (temp == 3)
            color3 = "blue";

        temp = (r.nextInt(3) + 1);
        if (temp == 1)
            color4 = "red";
        else if (temp == 2)
            color4 = "green";
        else if (temp == 3)
            color4 = "blue";
        applyColor(b1, color1);
        applyColor(b2, color2);
        applyColor(b3, color3);
        applyColor(b4, color4);
        new CountDownTimer(120*1000,1000)
        {
            public void onTick(long milliuntilfinished)
            {
                t2.setText("TIME LEFT: "+milliuntilfinished/1000);
            }
            public void onFinish()
            {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Game2.this);
                a_builder.setMessage(" YOUR SCORE IS-"+score+"   do you want to exit the game?")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent intent=new Intent(getApplicationContext(),Game2.class);
                        startActivity(intent);
                        finish();
                    }
                });
                AlertDialog ab = a_builder.create();
                ab.setTitle("Alert");
                ab.show();
            }
        }.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color1=changeColor(color1);
                applyColor(b1,color1);
                color2=changeColor(color2);
                applyColor(b2,color2);
                check();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color1=changeColor(color1);
                applyColor(b1,color1);
                color2=changeColor(color2);
                applyColor(b2,color2);
                color3=changeColor(color3);
                applyColor(b3,color3);
                check();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color2=changeColor(color2);
                applyColor(b2,color2);
                color3=changeColor(color3);
                applyColor(b3,color3);
                color4=changeColor(color4);
                applyColor(b4,color4);
                check();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color3=changeColor(color3);
                applyColor(b3,color3);
                color4=changeColor(color4);
                applyColor(b4,color4);
                check();
            }
        });
    }
    public String changeColor(String color) {
        if (color.equals("red"))
            color = "green";
        else if (color.equals("green"))
            color = "blue";
        else if (color.equals("blue"))
            color = "red";
        return color;
    }
    public void applyColor(Button button,String color)
    {
        if(color.equals("red"))
            button.setBackgroundColor(Color.RED);
        if(color.equals("green"))
            button.setBackgroundColor(Color.GREEN);
        if(color.equals("blue"))
            button.setBackgroundColor(Color.BLUE);
    }
    public void check()
    {
        if(color1.equals("green")&&color2.equals("green")&&color3.equals("green")&&color4.equals("green")) {
            play=MediaPlayer.create(context,R.raw.success);
            play.start();
            LayoutInflater layoutInflater=getLayoutInflater();
            View view=layoutInflater.inflate(R.layout.green_toast,null);
            Toast toast=new Toast(this);
            toast.setView(view);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP,0,100);
            toast.show();
            score++;
            t1.setText("SCORE: "+score);
            startTestThread();
        }
    }
    public void NEW(View view)
    {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        Intent intent=new Intent(getApplicationContext(),Game.class);
        startActivity(intent);
        finish();
    }
    protected void startTestThread() {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.postDelayed(mUpdateResults,500);
            }
        };
        t.start();
    }

}
