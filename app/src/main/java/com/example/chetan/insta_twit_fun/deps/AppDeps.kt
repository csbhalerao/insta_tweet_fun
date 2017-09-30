package com.example.chetan.insta_twit_fun.deps

import android.app.Application
import com.example.chetan.insta_twit_fun.InstaTwitApp
import com.example.chetan.insta_twit_fun.home.MainActivity
import com.example.chetan.insta_twit_fun.signin.SigninActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, StorageModule::class))
interface AppDeps {
    fun inject(application: InstaTwitApp)

    fun inject(mainActivity: MainActivity)

    fun inject(signinActivity: SigninActivity)
}