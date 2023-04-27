package com.doubtnut.awesomeai.data.model

import com.google.errorprone.annotations.Keep

@Keep
data class LoginResponse(val token: String)