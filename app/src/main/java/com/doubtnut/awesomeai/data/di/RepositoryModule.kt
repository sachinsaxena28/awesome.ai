package com.doubtnut.awesomeai.data.di

import com.doubtnut.awesomeai.data.repository.UserRepository
import com.doubtnut.awesomeai.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module


@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserRepository(repository: UserRepositoryImpl): UserRepository
}
