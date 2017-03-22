package com.example.henucmapus;

import java.util.ArrayList;
import java.util.List;

import com.example.Adapter.MyPagerAdapter;
import com.example.fragment.MyFragment1;
import com.example.fragment.MyFragment2;
import com.example.fragment.MyFragment3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	private ViewPager pager;
	private List<Fragment> FragList;
	private List<String> titlelist;
	private RadioGroup radiogroup;
	private RadioButton rb1,rb2,rb3;
	private Drawable drawable;
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

		radiogroup=(RadioGroup) findViewById(R.id.radiogroup);
		rb1=(RadioButton) findViewById(R.id.first);
		rb2=(RadioButton) findViewById(R.id.second);
		rb3=(RadioButton) findViewById(R.id.thrid);
		rb1.setBackgroundColor(android.graphics.Color.BLUE);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				switch(arg0){
				case 0:
					rb1.setBackgroundColor(android.graphics.Color.BLUE);
					rb2.setBackgroundColor(android.graphics.Color.WHITE);
					rb3.setBackgroundColor(android.graphics.Color.WHITE);
					break;

				case 1:
					rb1.setBackgroundColor(android.graphics.Color.WHITE);
					rb2.setBackgroundColor(android.graphics.Color.BLUE);
					rb3.setBackgroundColor(android.graphics.Color.WHITE);
					break;

				case 2:
					rb1.setBackgroundColor(android.graphics.Color.WHITE);
					rb2.setBackgroundColor(android.graphics.Color.WHITE);
					rb3.setBackgroundColor(android.graphics.Color.BLUE);
					break;

				default:
					break;
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		radiogroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch(checkedId){
				case R.id.first:
					pager.setCurrentItem(0);
					rb1.setBackgroundColor(android.graphics.Color.BLUE);
					rb2.setBackgroundColor(android.graphics.Color.WHITE);
					rb3.setBackgroundColor(android.graphics.Color.WHITE);
					break;
				case R.id.second:
					pager.setCurrentItem(1);
					rb1.setBackgroundColor(android.graphics.Color.WHITE);
					rb2.setBackgroundColor(android.graphics.Color.BLUE);
					rb3.setBackgroundColor(android.graphics.Color.WHITE);
					break;
				case R.id.thrid:
					pager.setCurrentItem(2);
					rb1.setBackgroundColor(android.graphics.Color.WHITE);
					rb2.setBackgroundColor(android.graphics.Color.WHITE);
					rb3.setBackgroundColor(android.graphics.Color.BLUE);
					break;
				default:
					break;
				}
			}
		});

	}

}
