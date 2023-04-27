package com.doubtnut.awesomeai.di.module

import androidx.lifecycle.ViewModelProvider
import com.doubtnut.awesomeai.ui.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderModule {

    @Binds
    internal abstract fun bindViewFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
