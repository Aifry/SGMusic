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

public class PlayActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button play,pause,end;
    private TextView hint;
    private boolean isPause=false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        DisplayMetrics dm = getResources().getDisplayMetrics();

        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        end=findViewById(R.id.end);
        hint=findViewById(R.id.hint);



    }



    public void playMusic(View v)
    {
        try
        {
            mediaPlayer = MediaPlayer.create(PlayActivity.this, R.raw.yellow);
            mediaPlayer.start();
            Toast.makeText(getApplicationContext(),"Playing Music",Toast.LENGTH_SHORT).show();
            hint.setText(getString(R.string.splay));
            play.setEnabled(false);
            end.setEnabled(true);
            pause.setEnabled(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_SHORT).show();
        }

    }


    public void pauseMusic(View v)
    {
        try
        {
            mediaPlayer.pause();
            isPause = true;
            pause.setEnabled(false);
            hint.setText(getString(R.string.pp));
            play.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Music pauses playback", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Please play first",Toast.LENGTH_SHORT).show();
        }
    }

    public void endMusic(View v)
    {
        try
        {
            mediaPlayer.stop();
            hint.setText(getString(R.string.send));
            Toast.makeText(getApplicationContext(), "Stop playing audio", Toast.LENGTH_SHORT).show();
            play.setEnabled(true);
            pause.setEnabled(true);
            mediaPlayer.release();
            Intent intentToChoose=new Intent();
            intentToChoose.setClass(PlayActivity.this,RollActivity.class);
            startActivity(intentToChoose);
        }
        catch (Exception e)
        {
//            Toast.makeText(getApplicationContext(),"Network error",Toast.LENGTH_SHORT).show();
            Intent intentToChoose=new Intent();
            intentToChoose.setClass(PlayActivity.this,ChooseActivity.class);
            startActivity(intentToChoose);
        }

    }

}
