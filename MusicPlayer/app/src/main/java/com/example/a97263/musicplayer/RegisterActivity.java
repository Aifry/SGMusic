package com.example.a97263.musicplayer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    MyOpenHelper myOpenHelper=null;
    EditText editText_uname;
    EditText editText_pwd;
    EditText editText_cpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myOpenHelper=new MyOpenHelper(getApplicationContext());
        editText_uname=findViewById(R.id.text_uname);
        editText_pwd=findViewById(R.id.text_pwd);
        editText_cpwd=findViewById(R.id.text_cpwd);
    }

    public void registerBtu(View v)
    {
        String uname=editText_uname.getText().toString().trim();
        String pwd=editText_pwd.getText().toString().trim();
        String cpwd=editText_cpwd.getText().toString().trim();
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        if(pwd.equals(cpwd))
        {
            ContentValues values = new ContentValues();
            values.put("name", uname);
            values.put("pwd", pwd);
            long count = db.insert("users", null, values);
            db.close();
            if (count > 0)
            {
                Toast.makeText(getApplicationContext(), "Successful registration", Toast.LENGTH_SHORT).show();
                Intent intentToLogin=new Intent();
                intentToLogin.setClass(RegisterActivity.this,LoginActivity.class);
                startActivity(intentToLogin);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Registration failed.Network error.Please try again later", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Password mismatch",Toast.LENGTH_SHORT).show();
        }
        db.close();

    }



}
