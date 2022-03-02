package com.aelsayed.bitpanda.di.module

import com.aelsayed.bitpanda.data.bitz.repository.BitzRepositoryImpl
import com.aelsayed.bitpanda.domain.bitz.repository.BitzRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bitz(bitzRepositoryImpl: BitzRepositoryImpl): BitzRepository

}