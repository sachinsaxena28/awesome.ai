package com.doubtnut.awesomeai.ui.login.di

import com.doubtnut.awesomeai.data.repository.service.LoginService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class LoginServiceModule {
    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }
}