package com.aelsayed.bitpanda.di.module

import com.aelsayed.bitpanda.data.bitz.remote.BitzApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun bitz(retrofit: Retrofit): BitzApi =
        retrofit.create(BitzApi::class.java)

}