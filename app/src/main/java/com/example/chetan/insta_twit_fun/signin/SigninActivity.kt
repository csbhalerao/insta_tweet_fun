package com.example.chetan.insta_twit_fun.signin

import android.content.Context
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.chetan.insta_twit_fun.R
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import android.support.design.widget.Snackbar
import android.view.View


class SigninActivity : AppCompatActivity() {
    val TAG = "Login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val twitterLoginButton = findViewById(R.id.button_twitter_login) as TwitterLoginButton;
        val rootView = findViewById(android.R.id.content) as View;
        twitterLoginButton.setCallback(object : Callback<TwitterSession>() {
            override fun failure(exception: TwitterException?) {
                Log.i(TAG, exception?.localizedMessage);
                Snackbar.make(rootView, "Failed to login", Snackbar.LENGTH_LONG).show()
            }

            override fun success(result: Result<TwitterSession>?) {
                Snackbar.make(rootView, "Login successfully", Snackbar.LENGTH_LONG).show()

            }

        })
    }

}