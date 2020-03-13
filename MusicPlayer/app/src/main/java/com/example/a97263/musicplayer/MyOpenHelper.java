package com.example.a97263.musicplayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 97263 on 2019/3/7.
 */

public class MyOpenHelper extends SQLiteOpenHelper
{
    /**一个APP只对应一个数据库，所以后面的参数值保留一个context
     *  super(context, "my.db", null, 1);
     * @param context 上下文
     * "my.db"  数据库的名字
     *  null  默认值
     *  1 数据库的版本version
     */
    public MyOpenHelper(Context context)
    {
        super(context, "musicdb_1.db", null, 1);
    }



    /**
     * SQLiteDatabase  数据库对象的方类
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql="create table users(id integer primary key autoincrement,name varchar(20),pwd varchar(20))";
        db.execSQL(sql);
    }

    /**
     * SQLiteDatabase  数据库对象的方类
     * 当版本升级时，可以更改表的结构
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //数据库升级时调用
        //添加一个列
//        Toast.makeText(MyOpenHelper.this,"dasdas ",Toast.LENGTH_SHORT).show();
        String sql="alter table users add phone varchar(20)";
        db.execSQL(sql);

    }

}
