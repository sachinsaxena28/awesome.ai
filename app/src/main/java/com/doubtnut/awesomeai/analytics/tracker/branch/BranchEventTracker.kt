package com.doubtnut.awesomeai.analytics.tracker.branch

import com.doubtnut.awesomeai.analytics.model.BranchEvent

interface BranchEventTracker {
    fun logEvent(event: BranchEvent)
}