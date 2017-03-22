package com.example.henucmapus;

import java.util.ArrayList;
import java.util.List;

import com.example.Adapter.FruitAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class NotificationActivity extends Activity implements OnClickListener{
	private String[] fruit = { "Apple", "Banana", "Pineapple", "Orange", "Strawberry" };
	public List<Fruit> fruitList = new ArrayList<Fruit>();
	ImageView imageBack;
	ImageView iamgeAdd;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nofitication_activity);
		findViewById();
		// ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1,fruit);
		initFruits();

		FruitAdapter adapter = new FruitAdapter(this, R.layout.listview_item, fruitList);

		listView.setAdapter(adapter);
		// item点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Fruit fruit1 = fruitList.get(position);
				Toast.makeText(NotificationActivity.this, fruit1.getName(), Toast.LENGTH_SHORT).show();
			}

		});

	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.add:
			Intent addActivity=new Intent(this, addActivity.class);
			//addActivity.putStringArrayListExtra("com.example.henucmapus.Notification", fruitList);
			startActivity(addActivity);
		
			break;
       case R.id.back:
    		finish();
			
			break;
				
		}		
		
	}
	// item实例化
	private void initFruits() {
		Fruit apple = new Fruit("大苹果", R.drawable.apple);
		fruitList.add(apple);
		Fruit pear = new Fruit("大雪梨", R.drawable.pear);
		fruitList.add(pear);
		Fruit watermelon = new Fruit("西瓜", R.drawable.watermelon);
		fruitList.add(watermelon);
		Fruit pineapple = new Fruit("菠萝", R.drawable.pineapple);
		fruitList.add(pineapple);

	}

	private void findViewById() {
		
		// 实例化控件
		listView = (ListView) findViewById(R.id.listview_fruit);
		imageBack = (ImageView) findViewById(R.id.back);
		iamgeAdd = (ImageView) findViewById(R.id.add);
		imageBack.setOnClickListener(this);
		iamgeAdd.setOnClickListener(this);
	}
	
	
}
