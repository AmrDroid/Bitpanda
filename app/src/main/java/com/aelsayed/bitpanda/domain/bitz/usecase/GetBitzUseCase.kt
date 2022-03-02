package com.aelsayed.bitpanda.domain.bitz.usecase

import com.aelsayed.bitpanda.domain.base.RecyclerItem
import com.aelsayed.bitpanda.domain.base.usecase.SingleUseCase
import com.aelsayed.bitpanda.domain.bitz.repository.BitzRepository
import io.reactivex.Single
import javax.inject.Inject

class GetBitzUseCase @Inject constructor(
    private val bitzRepository: BitzRepository
) : SingleUseCase<RecyclerItem, Unit> {

    override fun invoke(params: Unit): Single<RecyclerItem> =
        bitzRepository.getBitz()

}