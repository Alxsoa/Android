package com.example.viewpager_02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentC extends Fragment 
{
 @Override
 public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
 {
  return inflater.inflate(R.layout.fragment_c, container, false);
 }
}