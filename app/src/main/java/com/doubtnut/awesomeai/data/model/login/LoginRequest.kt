package com.doubtnut.awesomeai.data.model.login

import com.google.errorprone.annotations.Keep

@Keep
data class LoginRequest(val email: String, val password: String)