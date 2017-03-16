package com.example.henucmapus;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {
	private ViewPager pager;
	private List<Fragment> FragList;
	private List<String> titlelist;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainactivity);

		/**
		 * 初始化FragList并添加Fragment
		 */
		FragList = new ArrayList<Fragment>();
		FragList.add(new MyFragment1());
		FragList.add(new MyFragment2());
		FragList.add(new MyFragment3());
		pager = (ViewPager) findViewById(R.id.pager);

		titlelist = new ArrayList<String>();
		titlelist.add("校园导航");
		titlelist.add("校园信息");
		titlelist.add("个人设置");

		MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), FragList, titlelist);
		// 设置适配器
		pager.setAdapter(myPagerAdapter);

		// Notification=(ImageView)findViewById(R.id.notificationcenter);
		// Notification.setOnClickListener(this);

	}

}
