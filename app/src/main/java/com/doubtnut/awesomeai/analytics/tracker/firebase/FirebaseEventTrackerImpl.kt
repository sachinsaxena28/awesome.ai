package com.doubtnut.awesomeai.analytics.tracker.firebase

import android.os.Bundle
import com.doubtnut.awesomeai.analytics.model.FirebaseEvent
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import java.io.Serializable
import javax.inject.Inject

class FirebaseEventTrackerImpl @Inject constructor() : FirebaseEventTracker {

    override fun logEvent(event: FirebaseEvent) {
        val firebaseAnalytics = Firebase.analytics
        val bundle = Bundle()
        event.properties.forEach { (key, value) ->
            bundle.putSerializable(key, value as Serializable)
        }
        if (event.isPredefined) {
            firebaseAnalytics.logEvent(event.name, bundle)
        } else {
            firebaseAnalytics.logEvent(event.name, bundle)
        }
    }

    override fun setUserProperties(userId: String?, properties: Map<String, String>) {
        val firebaseAnalytics = Firebase.analytics
        firebaseAnalytics.setUserId(userId)
        properties.forEach { (key, value) ->
            firebaseAnalytics.setUserProperty(key, value)
        }
    }
}