package com.doubtnut.awesomeai.data.repository.service

import com.doubtnut.awesomeai.data.model.login.LoginRequest
import com.doubtnut.awesomeai.data.model.login.LoginResponse
import com.doubtnut.awesomeai.data.remote.CoreResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): CoreResponse<LoginResponse>
}