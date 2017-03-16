package com.example.henucmapus;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NotificationActivity extends Activity {
	private String[] fruit = { "Apple", "Banana", "Pineapple", "Orange", "Strawberry" };
	private List<Fruit> fruitList = new ArrayList<Fruit>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nofitication_activity);
		// ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1,fruit);
		 initFruits();
		FruitAdapter adapter = new FruitAdapter(this, R.layout.listview_item, fruitList);
		ListView listView = (ListView) findViewById(R.id.listview_fruit);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Fruit fruit1=fruitList.get(position);
				Toast.makeText(NotificationActivity.this, fruit1.getName(), Toast.LENGTH_SHORT).show();
			}
			
		});

	}
	private void initFruits(){
		Fruit apple=new Fruit("大苹果", R.drawable.apple);
		fruitList.add(apple);
		Fruit pear=new Fruit("大雪梨", R.drawable.pear);
		fruitList.add(pear);
		Fruit watermelon=new Fruit("大雪梨", R.drawable.watermelon);
		fruitList.add(watermelon);
		Fruit pineapple=new Fruit("大雪梨", R.drawable.pineapple);
		fruitList.add(pineapple);
		
		
	}
}
