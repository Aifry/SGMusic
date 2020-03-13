package com.example.a97263.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

    }

    public void play_1(View view)
    {
        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
        try
        {
            Intent intentToPlay = new Intent();
            intentToPlay.setClass(ChooseActivity.this, PlayActivity.class);
            startActivity(intentToPlay);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
        }
    }

    public void btuToNet(View view)
    {
        Intent intentToChooseNet=new Intent();
        intentToChooseNet.setClass(ChooseActivity.this,ChooseActivity_Net.class);
        startActivity(intentToChooseNet);
        Toast.makeText(getApplicationContext(),"Switched to online music",Toast.LENGTH_SHORT).show();
    }




}
