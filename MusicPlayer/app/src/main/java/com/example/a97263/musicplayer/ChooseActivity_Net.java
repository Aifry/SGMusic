package com.example.a97263.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ChooseActivity_Net extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__net);
    }

    public void btuToLoc(View view)
    {
        Intent intentToChooseLoc=new Intent();
        intentToChooseLoc.setClass(ChooseActivity_Net.this,ChooseActivity.class);
        startActivity(intentToChooseLoc);
        Toast.makeText(getApplicationContext(),"Switched to local music",Toast.LENGTH_SHORT).show();
    }
}
