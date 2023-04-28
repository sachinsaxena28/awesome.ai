package com.doubtnut.awesomeai.util.extension.common

import ai.study.learning.virtual.test.tutor.BuildConfig
import android.os.Build

object AppUtil {

    fun getVersionCode(): String = BuildConfig.VERSION_CODE.toString()

    fun getVersionName(): String = BuildConfig.VERSION_NAME

    fun getDeviceModel(): String = Build.MODEL
}