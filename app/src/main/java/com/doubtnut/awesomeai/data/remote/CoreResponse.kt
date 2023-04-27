package com.doubtnut.awesomeai.data.remote

import androidx.annotation.Keep

@Keep
open class CoreResponse<T>(val meta: ResponseMeta, val data: T, val error: T? = null)

@Keep
data class ResponseMeta(
    val code: Int,
    val message: String,
    val success: String?
)