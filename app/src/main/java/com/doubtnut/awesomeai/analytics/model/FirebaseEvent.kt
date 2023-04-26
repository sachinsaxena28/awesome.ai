package com.doubtnut.awesomeai.analytics.model

import androidx.annotation.Keep

@Keep
class FirebaseEvent(
    name: String,
    properties: Map<String, Any> = emptyMap(),
    val isPredefined: Boolean = false
) : BaseEvent(name, properties)