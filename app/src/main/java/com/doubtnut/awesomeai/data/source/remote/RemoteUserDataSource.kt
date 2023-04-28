package com.doubtnut.awesomeai.data.source.remote

import com.doubtnut.awesomeai.data.repository.service.LoginService
import javax.inject.Inject

class RemoteUserDataSource @Inject constructor(private val loginService: LoginService) {

}