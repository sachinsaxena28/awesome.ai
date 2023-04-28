package com.doubtnut.awesomeai.di.component

import android.app.Application
import com.doubtnut.awesomeai.BaseApplication
import com.doubtnut.awesomeai.analytics.di.EventTrackingModule
import com.doubtnut.awesomeai.data.di.RepositoryModule
import com.doubtnut.awesomeai.data.di.ServiceModule
import com.doubtnut.awesomeai.di.module.BindingActivityModule
import com.doubtnut.awesomeai.di.module.NetworkModule
import com.doubtnut.awesomeai.di.module.ViewModelProviderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        EventTrackingModule::class,
        BindingActivityModule::class,
        ViewModelProviderModule::class,
        NetworkModule::class,
        ServiceModule::class,
        RepositoryModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(app: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}