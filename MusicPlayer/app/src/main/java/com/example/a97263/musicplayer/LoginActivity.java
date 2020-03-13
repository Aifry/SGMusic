package com.example.a97263.musicplayer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    MyOpenHelper myOpenHelper_login=null;
    EditText editText_uname_login;
    EditText editText_pwd_login;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myOpenHelper_login=new MyOpenHelper(getApplicationContext());

        editText_uname_login=findViewById(R.id.text_uname_login);
        editText_pwd_login=findViewById(R.id.text_pwd_login);
    }
    public void loginBtu(View view)
    {
        String uname_login=editText_uname_login.getText().toString().trim();
        String pwd_login=editText_pwd_login.getText().toString().trim();

        try
        {
            SQLiteDatabase db_login = myOpenHelper_login.getWritableDatabase();
            Cursor cursor = db_login.query("users", new String[]{"pwd"}, "name=?", new String[]{uname_login}, null, null, null);
            if (cursor != null && cursor.getCount() > 0)
            {
                if (cursor.moveToNext())
                {
                    String pwd_return = cursor.getString(0);
                    if (pwd_return.equals(pwd_login))
                    {
                        Intent intentToChoose = new Intent();
                        intentToChoose.setClass(LoginActivity.this, RollActivity.class);
                        startActivity(intentToChoose);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Password error.Please re-enter", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            else
            {
                Toast.makeText(getApplicationContext(), "You are not registered", Toast.LENGTH_SHORT).show();
            }
            db_login.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (uname_login.equals(pwd_login))
            {
                Toast.makeText(getApplicationContext(),"Ngsdfadr",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void registerBtu_login(View view)
    {
        Intent intentToRegister=new Intent();
        intentToRegister.setClass(LoginActivity.this,RegisterActivity.class);
        startActivity(intentToRegister);
    }
}
