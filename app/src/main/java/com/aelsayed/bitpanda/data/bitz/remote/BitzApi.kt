package com.aelsayed.bitpanda.data.bitz.remote

import com.aelsayed.bitpanda.data.bitz.entity.BitzResponse
import io.reactivex.Single
import retrofit2.http.GET

interface BitzApi {

    @GET("bitz")
    fun getBitz(): Single<BitzResponse>

}