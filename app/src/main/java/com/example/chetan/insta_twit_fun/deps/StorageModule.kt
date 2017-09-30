package com.example.chetan.insta_twit_fun.deps

import android.content.Context
import android.content.SharedPreferences
import com.example.chetan.insta_twit_fun.common.UserInfoManager
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    val PREFERENCE_NAME = "com.example.chetan.insta_twit_fun"

    @Provides
    @Singleton
    fun providesPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesUserInfoManager(sharedPreferences: SharedPreferences, gson: Gson): UserInfoManager {
        return UserInfoManager(gson, sharedPreferences)
    }
}