package com.doubtnut.awesomeai

import android.app.Application
import com.doubtnut.awesomeai.di.component.AppComponent
import com.doubtnut.awesomeai.di.component.DaggerAppComponent

class BaseApplication : Application() {

    companion object {
        lateinit var INSTANCE: BaseApplication
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}