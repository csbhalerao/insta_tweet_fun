package com.example.chetan.insta_twit_fun.signin

import com.google.gson.Gson


class TwitterUserDetails(var userId: Long, var twitterUserName: String, var twitterToken: String){
    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this).toString()
    }
}
