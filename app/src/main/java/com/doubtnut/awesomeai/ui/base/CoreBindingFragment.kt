package com.doubtnut.core.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.doubtnut.awesomeai.ui.base.CoreViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class CoreBindingFragment<VM : CoreViewModel, VB : ViewBinding> : Fragment(),
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

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
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

    protected open fun setupObservers() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        provideActivityViewModel()
        setupObservers()
        setupView(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected abstract fun provideViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    protected abstract fun providePageName(): String

    protected abstract fun provideViewModel(): VM

    protected open fun provideActivityViewModel() {}

    protected abstract fun setupView(view: View, savedInstanceState: Bundle?)

    val isViewModelInitialized get() = ::viewModel.isInitialized

}