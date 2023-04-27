package com.doubtnut.awesomeai

import android.app.Application
import com.doubtnut.awesomeai.di.component.AppComponent
import com.doubtnut.awesomeai.di.component.DaggerAppComponent

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}