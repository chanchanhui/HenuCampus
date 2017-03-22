package com.example.fragment;

import com.example.henucmapus.R;
import com.example.henucmapus.R.id;
import com.example.henucmapus.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
public class MyFragment2 extends Fragment implements OnClickListener{
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	Button button=(Button)inflater.inflate(R.layout.fragment2,container,false).findViewById(R.id.b1);
	button.setOnClickListener(this);
	return inflater.inflate(R.layout.fragment2,container,false);
}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch (v.getId()) {
	case R.id.b1:
		Log.d("a","button");
		break;

	default:
		break;
	}
}

}
