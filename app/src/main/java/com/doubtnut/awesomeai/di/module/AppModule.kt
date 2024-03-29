package com.doubtnut.awesomeai.di.module

import ai.study.learning.virtual.test.tutor.BuildConfig
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.doubtnut.awesomeai.di.qualifier.ApplicationContext
import com.doubtnutapp.data.base.di.qualifier.AppVersion
import com.doubtnutapp.data.base.di.qualifier.AppVersionCode
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    @JvmStatic
    @ApplicationContext
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @JvmStatic
    @AppVersion
    fun provideAppVersion() = BuildConfig.VERSION_NAME

    @Provides
    @JvmStatic
    @AppVersionCode
    fun provideAppVersionCode() = BuildConfig.VERSION_CODE
}