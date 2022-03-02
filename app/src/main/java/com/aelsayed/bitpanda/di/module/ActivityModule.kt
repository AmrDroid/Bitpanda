package com.aelsayed.bitpanda.di.module

import com.aelsayed.bitpanda.di.scope.PerView
import com.aelsayed.bitpanda.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerView
    @ContributesAndroidInjector
    abstract fun main(): MainActivity

}