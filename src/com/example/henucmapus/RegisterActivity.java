package com.example.henucmapus;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	private DBHelper dbHelper;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		//创建DBHelper实例
		dbHelper=new DBHelper(this, "info",2);
		Button BtnReOK=(Button)findViewById(R.id.BtnReOK);
		Button BtnCancel=(Button)findViewById(R.id.BtnCancel);
		
		final EditText NameETextr=(EditText)  findViewById(R.id.NameETextr);
		final EditText PswordETextr=(EditText)  findViewById(R.id.PswordETextr);
		final EditText PswordETextr1=(EditText)  findViewById(R.id.PswordETextr1);
		
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
                 
                 if(name.length()==0){
             		Toast.makeText(RegisterActivity.this,"用户名为空",Toast.LENGTH_SHORT).show();
            		 
             	}else if(password.length()==0){
             		Toast.makeText(RegisterActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
               		 	
             	}else if(password1.length()==0){
             		Toast.makeText(RegisterActivity.this,"请确认密码",Toast.LENGTH_SHORT).show();
              		 
             	}else if(password1.length()!=password.length()){
             		Toast.makeText(RegisterActivity.this,"输入密码不一致",Toast.LENGTH_SHORT).show();
             		 
             	}
             	else{
             		 values.put("name",NameETextr.getText().toString());
                 values.put("password",PswordETextr.getText().toString());
                 db.insert("info", null, values);
             	}
                
			}
		});
		BtnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent MainActivity=new Intent(RegisterActivity.this,MainActivity.class);
				startActivity(MainActivity);
				
			}
		});
	}
}
