package com.example.chetan.insta_twit_fun.signin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.chetan.insta_twit_fun.InstaTwitApp
import com.example.chetan.insta_twit_fun.R
import com.example.chetan.insta_twit_fun.common.UserInfoManager
import com.example.chetan.insta_twit_fun.home.MainActivity
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import javax.inject.Inject


class SigninActivity : AppCompatActivity(), SignInView {

    val TAG = "Login"

    @Inject
    lateinit var userInfoManager: UserInfoManager

    lateinit var presenter: SignInPresenter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        InstaTwitApp.appDeps.inject(this)
        presenter = SignInPresenter(userInfoManager, this)
        presenter.init()
    }

    override fun redirectToMainActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun doLogin() {
        val twitterLoginButton = findViewById<TwitterLoginButton>(R.id.button_twitter_login)
        val rootView = findViewById<View>(android.R.id.content)
        twitterLoginButton.setCallback(object : Callback<TwitterSession>() {
            override fun failure(exception: TwitterException?) {
                Log.i(TAG, exception?.localizedMessage);
                Snackbar.make(rootView, "Failed to login", Snackbar.LENGTH_LONG).show()
            }

            override fun success(result: Result<TwitterSession>?) {
                if (result != null) {
                    var userDetail = TwitterUserDetails(result.data.userId, result.data.userName
                            , result.data.authToken.token)
                    userInfoManager.saveTwitterUserDetail(userDetail)
                    Snackbar.make(rootView, "Login successfully", Snackbar.LENGTH_LONG).show()
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Snackbar.make(rootView, "Failed to get result", Snackbar.LENGTH_LONG).show()
                }

            }

        })
    }

}