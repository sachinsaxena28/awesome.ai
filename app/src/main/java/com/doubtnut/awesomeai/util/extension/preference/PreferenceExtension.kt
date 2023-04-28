package com.doubtnut.awesomeai.util.extension

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.doubtnut.awesomeai.BaseApplication

fun defaultPrefs(context: Context = BaseApplication.INSTANCE.applicationContext): SharedPreferences =
    PreferenceManager.getDefaultSharedPreferences(context)