package com.example.henucmapus;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AnotherFragment extends Fragment{
 public View onCreateView(LayoutInflater inflater,ViewGroup container,
		   Bundle savedInstanceState){
	 View view =inflater.inflate(R.layout.anotherfragment,container, false);
	 
	 return view;
 }
}
