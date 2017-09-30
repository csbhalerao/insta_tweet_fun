package com.example.chetan.insta_twit_fun.common

import android.content.SharedPreferences
import android.text.TextUtils
import com.example.chetan.insta_twit_fun.signin.TwitterUserDetails
import com.google.gson.Gson


class UserInfoManager(var gson: Gson, var sharedPreferences: SharedPreferences) {

    fun saveTwitterUserDetail(userDetails: TwitterUserDetails) {
        sharedPreferences.edit().putString(TWITTER_USER_DETAIL_KEY, userDetails.toString()).commit()
    }

    private val TWITTER_USER_DETAIL_KEY: String = "TWITTER_USER_DETAIL_KEY"

    fun getTwitterUserDetail(): TwitterUserDetails? {
        val jsonString = sharedPreferences.getString(TWITTER_USER_DETAIL_KEY, "")
        if (!TextUtils.isEmpty(jsonString)) {
            return Gson().fromJson(jsonString, TwitterUserDetails::class.java)
        } else {
            return TwitterUserDetails(0, "","")
        }
    }
}