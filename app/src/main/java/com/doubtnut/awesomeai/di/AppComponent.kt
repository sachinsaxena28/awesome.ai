package com.doubtnut.awesomeai.di

import android.app.Application
import com.doubtnut.awesomeai.BaseApplication
import com.doubtnut.awesomeai.analytics.di.EventTrackingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        EventTrackingModule::class,
        BindingActivityModule::class
    ]
)
interface AppComponent {

    fun inject(app: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}