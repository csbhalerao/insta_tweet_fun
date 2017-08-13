package com.example.chetan.insta_twit_fun

import android.app.Application
import android.util.Log
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.TwitterConfig




class InstaTwitApp : Application(){
    override fun onCreate() {
        super.onCreate()
        val config = TwitterConfig.Builder(this)
                .logger(DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(TwitterAuthConfig(getString(R.string.twitter_consumer_key),
                        getString(R.string.twitter_consumer_secret)))
                .debug(true)
                .build()
        Twitter.initialize(config)
    }
}