package com.doubtnut.awesomeai.analytics.tracker

import com.doubtnut.awesomeai.analytics.tracker.branch.BranchEventTracker
import com.doubtnut.awesomeai.analytics.tracker.firebase.FirebaseEventTracker

interface EventTracker : FirebaseEventTracker, BranchEventTracker