package com.doubtnut.awesomeai.data.source.local

import javax.inject.Inject

class LocalUserDataSource @Inject constructor(private val userPreference: UserPreference) {

    fun isUserLoggedIn(): Boolean = userPreference.isUserLoggedIn()

    fun saveUserDetails() = userPreference.saveUserDetails()
}