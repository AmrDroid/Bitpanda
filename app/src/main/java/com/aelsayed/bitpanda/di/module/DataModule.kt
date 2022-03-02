package com.aelsayed.bitpanda.di.module

import dagger.Module

@Module(
    includes = [
        NetModule::class,
        RepositoryModule::class,
        ApiModule::class
    ]
)
class DataModule