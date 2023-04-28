package com.doubtnut.awesomeai.data.source.local

interface UserPreference {

    fun isUserLoggedIn(): Boolean

    fun saveUserDetails()
}