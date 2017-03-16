package com.example.henucmapus;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

public class MyPagerAdapter extends FragmentPagerAdapter{
	private List<Fragment>fragList;
	private List<String>title;
	public MyPagerAdapter(FragmentManager fm,List<Fragment>fragList,List<String>title) {
		super(fm);
		this.fragList=fragList;
		this.title=title;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return  fragList.size();
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return title.get(position);
	}

	}


