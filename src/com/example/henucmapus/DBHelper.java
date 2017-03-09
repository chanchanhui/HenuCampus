package com.example.henucmapus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
public static final String CREATE_BOOK="create table info("+
"id integer primary key autoincrement,"+
		"name text,"+"password text)";
public static final String ALTER_TABLE1="alter table info add sex text";
private Context mContext;
	public DBHelper(Context context, String name,int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
		mContext=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
   db.execSQL(CREATE_BOOK);
   Toast.makeText(mContext, "数据库创建成功", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
      db.execSQL(ALTER_TABLE1);
	}

}
