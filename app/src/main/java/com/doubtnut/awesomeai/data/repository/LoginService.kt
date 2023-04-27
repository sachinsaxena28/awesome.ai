package com.doubtnut.awesomeai.data.repository

import com.doubtnut.awesomeai.data.model.LoginRequest
import com.doubtnut.awesomeai.data.model.LoginResponse
import com.doubtnut.awesomeai.data.remote.CoreResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): CoreResponse<LoginResponse>
}