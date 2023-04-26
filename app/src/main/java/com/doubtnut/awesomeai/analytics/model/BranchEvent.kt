package com.doubtnut.awesomeai.analytics.model

import androidx.annotation.Keep

@Keep
class BranchEvent(
    name: String,
    properties: Map<String, Any> = emptyMap()
) : BaseEvent(name, properties)