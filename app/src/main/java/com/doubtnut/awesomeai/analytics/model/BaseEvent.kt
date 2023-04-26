package com.doubtnut.awesomeai.analytics.model

import androidx.annotation.Keep

@Keep
abstract class BaseEvent(
    val name: String,
    val properties: Map<String, Any> = emptyMap()
)