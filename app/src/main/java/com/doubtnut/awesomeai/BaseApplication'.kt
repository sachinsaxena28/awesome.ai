package com.doubtnut.awesomeai

import android.app.Application
import com.doubtnut.awesomeai.di.AppComponent
import com.doubtnut.awesomeai.di.DaggerAppComponent

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}