package com.doubtnut.awesomeai.ui.base

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class CoreBindingActivity<VM : CoreViewModel, VB : ViewBinding>
    : AppCompatActivity(), HasAndroidInjector {

    lateinit var viewModel: VM

    lateinit var binding: VB

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
        if (addLayout()) {
            binding = provideViewBinding()
            setContentView(binding.root)
        }
        setupObservers()
        setupView(savedInstanceState)
    }

    protected open fun setupObservers() {

    }

    open fun addLayout() = true

    protected abstract fun provideViewBinding(): VB

    protected abstract fun providePageName(): String

    protected abstract fun provideViewModel(): VM

    protected abstract fun setupView(savedInstanceState: Bundle?)

    /**
     * Use this method before setContentView to enable full screen
     */
    protected fun requestFullScreen() {
        // Full Screen Activity
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}