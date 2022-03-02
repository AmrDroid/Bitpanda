package com.aelsayed.bitpanda.data.bitz.repository

import com.aelsayed.bitpanda.data.bitz.datasource.BitzRemoteDataSource
import com.aelsayed.bitpanda.domain.base.RecyclerItem
import com.aelsayed.bitpanda.domain.bitz.repository.BitzRepository
import io.reactivex.Single
import javax.inject.Inject

class BitzRepositoryImpl @Inject constructor(
    private val bitzRemoteDataSource: BitzRemoteDataSource
) : BitzRepository {

    override fun getBitz(): Single<RecyclerItem> =
        bitzRemoteDataSource.getBitz()

}