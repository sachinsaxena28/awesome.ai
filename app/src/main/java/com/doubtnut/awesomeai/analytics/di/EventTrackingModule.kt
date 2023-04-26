package com.doubtnut.awesomeai.analytics.di

import com.doubtnut.awesomeai.analytics.model.BranchEvent
import com.doubtnut.awesomeai.analytics.model.FirebaseEvent
import com.doubtnut.awesomeai.analytics.tracker.EventTracker
import com.doubtnut.awesomeai.analytics.tracker.branch.BranchEventTracker
import com.doubtnut.awesomeai.analytics.tracker.branch.BranchEventTrackerImpl
import com.doubtnut.awesomeai.analytics.tracker.firebase.FirebaseEventTracker
import com.doubtnut.awesomeai.analytics.tracker.firebase.FirebaseEventTrackerImpl
import dagger.Module
import dagger.Provides

@Module
class EventTrackingModule {

    @Provides
    fun provideFirebaseEventTracker(): FirebaseEventTracker {
        return FirebaseEventTrackerImpl()
    }

    @Provides
    fun provideBranchEventTracker(): BranchEventTracker {
        return BranchEventTrackerImpl()
    }

    @Provides
    fun provideEventTracker(
        firebaseEventTracker: FirebaseEventTracker,
        branchEventTracker: BranchEventTracker
    ): EventTracker {
        return object : EventTracker {
            override fun logEvent(event: FirebaseEvent) {
                firebaseEventTracker.logEvent(event)
            }

            override fun logEvent(event: BranchEvent) {
                branchEventTracker.logEvent(event)
            }

            override fun setUserProperties(userId: String?, properties: Map<String, String>) {
                firebaseEventTracker.setUserProperties(userId, properties)
            }
        }
    }
}