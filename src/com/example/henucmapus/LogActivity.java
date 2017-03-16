package com.example.henucmapus;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogActivity extends Activity implements OnClickListener {
	private DBHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_activity);
		dbHelper = new DBHelper(this, "info", 2);
		Button Btnregister = (Button) findViewById(R.id.Btnregister);
		Btnregister.setOnClickListener(this);
		Button Btnlogin = (Button) findViewById(R.id.Btnlogin);
		Btnlogin.setOnClickListener(this);

	}

	public void onClick(View v) {
		EditText NameETextl = (EditText) findViewById(R.id.NameETextr);
		EditText PswordETextrl = (EditText) findViewById(R.id.PswordETextrl);

		switch (v.getId()) {
		case R.id.Btnlogin:
			String name = null;
			name = NameETextl.getText().toString();
			String password = null;
			password = PswordETextrl.getText().toString();
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			Cursor cursor = db.query("info", null, null, null, null, null, null);
			while (cursor.moveToNext()) {

				String nameindb = cursor.getString(cursor.getColumnIndex("name"));
				String passwordindb = cursor.getString(cursor.getColumnIndex("password"));
				if (name.length() == 0) {
					Toast.makeText(LogActivity.this, "用户名为空", Toast.LENGTH_SHORT).show();

				} else if (password.length() == 0) {
					Toast.makeText(LogActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();

				} else if (nameindb.equals(name) && passwordindb.equals(password)) {
					Toast.makeText(LogActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
					Log.d("info", "the name is " + name);
					Log.d("info", "the passwrod is " + password);
					//Intent mainActivity =new Intent(this,acActivity)
					Intent mainActivity = new Intent(LogActivity.this, MainActivity.class);
					startActivity(mainActivity);
				} else {
					Toast.makeText(LogActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();

				}
			}
			break;
		case R.id.Btnregister:
			Intent RegisterActivity = new Intent(LogActivity.this, RegisterActivity.class);
			startActivity(RegisterActivity);

			break;
//		case R.id.button1:
//			Intent MainActivity = new Intent(LogActivity.this, MainActivity.class);
//			startActivity(MainActivity);
//			AnotherFragment fragment = new AnotherFragment();
//			FragmentManager fragmentManager = getFragmentManager();
//			FragmentTransaction transaction = fragmentManager.beginTransaction();
//			transaction.add(R.id.sample_content_fragment, fragment);
//			transaction.addToBackStack(null);
//			transaction.commit();

//			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
