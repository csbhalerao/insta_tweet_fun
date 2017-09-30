package com.example.chetan.insta_twit_fun.home

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.chetan.insta_twit_fun.R
import android.databinding.DataBindingUtil
import com.example.chetan.insta_twit_fun.InstaTwitApp
import com.example.chetan.insta_twit_fun.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var viewpagerTabItem : ViewPager
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InstaTwitApp.appDeps.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

}