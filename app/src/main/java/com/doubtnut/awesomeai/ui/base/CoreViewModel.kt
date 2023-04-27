package com.doubtnut.awesomeai.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

open class CoreViewModel() : ViewModel() {

    @CallSuper
    override fun onCleared() {
        super.onCleared()
    }
}