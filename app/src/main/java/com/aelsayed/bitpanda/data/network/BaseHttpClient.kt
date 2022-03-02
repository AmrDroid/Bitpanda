package com.aelsayed.bitpanda.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named

private const val TIMEOUT = 5L

class BaseHttpClient @Inject constructor(
    @Named("MockInterceptor") mockInterceptor: Interceptor
) {

    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .addInterceptor(mockInterceptor)
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        .build()

}