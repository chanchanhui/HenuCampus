package com.example.henucmapus;

import com.example.DB.DBHelper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	private DBHelper dbHelper;
	Button BtnReOK;
	Button BtnCancel;
	
	EditText NameETextr;
	EditText PswordETextr;
	EditText PswordETextr1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);
		//创建DBHelper实例
		dbHelper=new DBHelper(this, "info",2);
		findViewById();
		
		BtnReOK.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				String name=NameETextr.getText().toString();
				String password=PswordETextr.getText().toString();
				String password1=PswordETextr.getText().toString();
				
				// TODO Auto-generated method stub
				//打开数据库
				SQLiteDatabase db=dbHelper.getReadableDatabase();
                 ContentValues values =new ContentValues();
                 Cursor cursor = db.query("info", null, null, null, null, null, null);
                
                 if(name.length()==0){
             		Toast.makeText(RegisterActivity.this,"用户名为空",Toast.LENGTH_SHORT).show();
            		 
             	}else if(password.length()==0){
             		Toast.makeText(RegisterActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
               		 	
             	}else if(password1.length()==0){
             		Toast.makeText(RegisterActivity.this,"请确认密码",Toast.LENGTH_SHORT).show();
              		 
             	}else if(password1.length()!=password.length()){
             		Toast.makeText(RegisterActivity.this,"输入密码不一致",Toast.LENGTH_SHORT).show();
             		 
             	}
//             	else if(password.length()!=0){
//             		Log.d("aaa", "11111");
//             		while (cursor.moveToNext()) {
//                   	 String nameindb = cursor.getString(cursor.getColumnIndex("name"));
//                  	Log.d("aaa", "asdfasdf");
//                   	 if(name==nameindb){
//                   		 Toast.makeText(RegisterActivity.this,"用戶名已存在",Toast.LENGTH_SHORT).show();
//                   		 break;
//                   	 }
//                  	Log.d("aaa", "2222222");
//                    }
//             	}
                 else  	{
             		Log.d("aaa", "33333333");
             	values.put("name",NameETextr.getText().toString());
                 values.put("password",PswordETextr.getText().toString());
                 db.insert("info", null, values);
                 Toast.makeText(RegisterActivity.this,"注冊成功",Toast.LENGTH_SHORT).show();
             	}
                
			}
		});
		BtnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();
				
			}
		});
		
	}
	private void findViewById(){
		BtnReOK=(Button)findViewById(R.id.BtnReOK);
		BtnCancel=(Button)findViewById(R.id.BtnCancel);
		
		NameETextr=(EditText)  findViewById(R.id.NameETextr);
		PswordETextr=(EditText)  findViewById(R.id.PswordETextr);
		PswordETextr1=(EditText)  findViewById(R.id.PswordETextr1);
	}
}
