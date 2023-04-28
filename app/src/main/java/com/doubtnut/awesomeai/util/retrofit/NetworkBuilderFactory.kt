package com.doubtnut.awesomeai.util.retrofit

import okhttp3.OkHttpClient
import javax.inject.Singleton

@Singleton
class NetworkBuilderFactory {

    // this same instance of OkHttpClient should be used across the app
    // if we need to change builder configuration for certain requests, use
    // httpClientBuilderFactory.create()......build()
    private val okHttpClient by lazy { OkHttpClient() }

    fun okhttpBuilder(): OkHttpClient.Builder = okHttpClient.newBuilder()
}
