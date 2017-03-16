package com.example.henucmapus;

import android.R.anim;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MyFragment1 extends Fragment {
	private ImageView Notification;
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment1, container, false);
		// TODO Auto-generated method stub
		return view;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Notification = (ImageView) view.findViewById(R.id.notificationcenter);
		Notification.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("a", "点击");
				Intent NotificationAcvtivty = new Intent(getActivity(), NotificationActivity.class);
				startActivity(NotificationAcvtivty);
			}
		});
		Log.d("aa", "aaa");

	}
	// public void onClick(View v) {
	// Log.d("aa", "aaa");
	// // TODO Auto-generated method stub
	// switch (v.getId()) {
	// case R.id.notificationcenter:
	//
	// break;
	//
	// default:
	// break;
	// }
	// }
}