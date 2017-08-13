package com.example.chetan.insta_twit_fun.home

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.chetan.insta_twit_fun.R
import android.databinding.DataBindingUtil
import com.example.chetan.insta_twit_fun.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var viewpagerTabItem : ViewPager? = null;
    var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewpagerTabItem = (binding as ActivityMainBinding?)!!.viewpagerTabItem;
    }
}