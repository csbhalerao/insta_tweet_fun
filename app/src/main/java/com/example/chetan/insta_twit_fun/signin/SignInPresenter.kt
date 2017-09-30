package com.example.chetan.insta_twit_fun.signin

import com.example.chetan.insta_twit_fun.common.UserInfoManager


class SignInPresenter(val userInfoManager: UserInfoManager, val view: SignInView) {

    fun init(): Unit {
        val twitterUserDetail = userInfoManager.getTwitterUserDetail()
        if(twitterUserDetail?.twitterToken.isNullOrBlank()){
            view.doLogin()
        } else {
            view.redirectToMainActivity()
        }
    }
}