package com.example.Adapter;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import com.example.henucmapus.Fruit;
import com.example.henucmapus.R;
import com.example.henucmapus.R.id;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>{
  private int resourceId;
  private ImageView fruitImage;
  private TextView fruitName;
	public FruitAdapter(Context context, int resource, List<Fruit> objects) {
		super(context, resource, objects);
		//Listview子项布局id
		resourceId=resource;
	}
	
	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		
		Fruit fruit=getItem(position);
		View view ;
		//convertView将之前加载好的布局进行缓存
		if(convertView==null){
			view =LayoutInflater.from(getContext()).inflate(resourceId,null);
			fruitImage=(ImageView)view.findViewById(R.id.fruit_item);
			fruitName=(TextView)view.findViewById(R.id.fruit_name);
		}else{
			view=convertView;
		}

		fruitImage.setImageResource(fruit.getImageId());
	  fruitName.setText(fruit.getName());
			// TODO Auto-generated method stub
			return view;
		}

}
