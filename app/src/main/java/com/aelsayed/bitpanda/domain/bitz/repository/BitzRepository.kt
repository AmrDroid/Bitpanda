package com.aelsayed.bitpanda.domain.bitz.repository

import com.aelsayed.bitpanda.domain.base.RecyclerItem
import io.reactivex.Single

interface BitzRepository {

    fun getBitz(): Single<RecyclerItem>

}