package com.example.henucmapus;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class addActivity extends Activity implements OnClickListener{
	Button Btnsub;
	ImageView backtoNofi;
	EditText fruitText;
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	 setContentView(R.layout.add_activity);
	 findViewById();
 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.Btnsub:
			Fruit newFruit=new Fruit(fruitText.getText().toString(),  R.drawable.watermelon);
			//fruitList.add(newFruit);
			break;
         case R.id.backtoNofi:
			finish();
			break;
			
		default:
			break;
		}
	}
	private void findViewById() {
		// 实例化控件
		Btnsub = (Button) findViewById(R.id.Btnsub);
		backtoNofi = (ImageView) findViewById(R.id.backtoNofi);
		
	}
}
