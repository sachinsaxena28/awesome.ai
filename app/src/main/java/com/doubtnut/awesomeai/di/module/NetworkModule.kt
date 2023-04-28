package com.doubtnut.awesomeai.di.module

import ai.study.learning.virtual.test.tutor.BuildConfig
import android.content.Context
import com.doubtnut.awesomeai.util.retrofit.NetworkBuilderFactory
import com.doubtnut.awesomeai.util.retrofit.interceptor.FakeInterceptor
import com.doubtnut.awesomeai.util.retrofit.interceptor.RefreshTokenInterceptor
import com.doubtnut.awesomeai.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://api.example.com/"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext appContext: Context,
        httpClientBuilderFactory: NetworkBuilderFactory
    ): OkHttpClient =
        httpClientBuilderFactory.okhttpBuilder()
            .connectTimeout(20000, TimeUnit.MILLISECONDS)
            .readTimeout(20000, TimeUnit.MILLISECONDS)
            .writeTimeout(20000, TimeUnit.MILLISECONDS)
            .addInterceptor(RefreshTokenInterceptor(appContext))
            .apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(FakeInterceptor(appContext))
                    addInterceptor(
                        HttpLoggingInterceptor()
                            .also { it.level = HttpLoggingInterceptor.Level.BODY }
                    )
                }
            }
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}