package com.doubtnut.awesomeai.ui.splash

import ai.study.learning.virtual.test.tutor.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.doubtnut.awesomeai.analytics.tracker.firebase.FirebaseEventTracker
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var eventTracker: FirebaseEventTracker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}