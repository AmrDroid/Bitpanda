package com.aelsayed.bitpanda.data.bitz.datasource

import com.aelsayed.bitpanda.data.bitz.remote.BitzApi
import com.aelsayed.bitpanda.domain.base.RecyclerItem
import io.reactivex.Single
import javax.inject.Inject

class BitzRemoteDataSource @Inject constructor(
    private val bitzApi: BitzApi
) {

    fun getBitz(): Single<RecyclerItem> =
        bitzApi.getBitz().map { it.toDomain() }

}