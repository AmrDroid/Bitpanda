package com.aelsayed.bitpanda.di.module

import androidx.lifecycle.ViewModelProvider
import com.aelsayed.bitpanda.di.viewmodel.ViewModelFactory
import com.aelsayed.bitpanda.di.viewmodel.ViewModelKey
import com.aelsayed.bitpanda.presentation.base.viewmodel.BaseViewModel
import com.aelsayed.bitpanda.presentation.bitz.ui.BitzViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun factory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BitzViewModel::class)
    abstract fun bitz(vm: BitzViewModel): BaseViewModel

}