package com.doubtnut.awesomeai.analytics.tracker.firebase

import com.doubtnut.awesomeai.analytics.model.FirebaseEvent

interface FirebaseEventTracker {
    fun logEvent(event: FirebaseEvent)
    fun setUserProperties(userId: String?, properties: Map<String, String>)
}