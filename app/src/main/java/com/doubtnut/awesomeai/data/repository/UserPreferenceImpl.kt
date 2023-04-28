package com.doubtnut.awesomeai.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.doubtnut.awesomeai.data.source.local.UserPreference
import javax.inject.Inject

class UserPreferenceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : UserPreference {

    override fun isUserLoggedIn(): Boolean {
        return true
    }

    override fun saveUserDetails() {
        sharedPreferences.edit {

        }
    }
}