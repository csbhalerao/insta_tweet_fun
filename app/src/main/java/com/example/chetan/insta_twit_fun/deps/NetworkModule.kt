package com.example.chetan.insta_twit_fun.deps

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class NetworkModule {
    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }
}