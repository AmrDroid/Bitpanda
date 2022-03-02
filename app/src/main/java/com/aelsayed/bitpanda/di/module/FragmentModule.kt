package com.aelsayed.bitpanda.di.module

import com.aelsayed.bitpanda.di.scope.PerView
import com.aelsayed.bitpanda.presentation.bitz.ui.BitzFragment
import com.aelsayed.bitpanda.presentation.bitz.ui.WalletDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @PerView
    @ContributesAndroidInjector
    abstract fun bitz(): BitzFragment


    @PerView
    @ContributesAndroidInjector
    abstract fun detailBitz(): WalletDetailsFragment

}