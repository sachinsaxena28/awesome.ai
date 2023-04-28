package com.doubtnut.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.doubtnut.awesomeai.ui.base.CoreViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class CoreBindingDialogFragment<VM : CoreViewModel, VB : ViewBinding> : DialogFragment(),
    HasAndroidInjector {

    lateinit var viewModel: VM

    private var _binding: VB? = null

    val mBinding get() = _binding

    val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = provideViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        provideActivityViewModel()
        setupObservers()
        setupView(view, savedInstanceState)
    }

    protected open fun setupObservers() {

    }

    protected open fun provideActivityViewModel() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected abstract fun provideViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    protected abstract fun providePageName(): String

    protected abstract fun provideViewModel(): VM

    protected abstract fun setupView(view: View, savedInstanceState: Bundle?)

    val isViewModelInitialized get() = ::viewModel.isInitialized

}