package com.doubtnut.awesomeai.data.repository

import com.doubtnut.awesomeai.data.source.local.LocalUserDataSource
import com.doubtnut.awesomeai.data.source.remote.RemoteUserDataSource
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val localUserDataSource: LocalUserDataSource
) : UserRepository {

    override fun checkLogin() {

    }

    override fun postLogin() {

    }

}