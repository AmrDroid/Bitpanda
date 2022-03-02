package com.aelsayed.bitpanda.domain.bitz.entity

import com.aelsayed.bitpanda.domain.base.RecyclerItem

data class MetalWallet(
    override val id: String,
    val name: String,
    val balance: Double,
    val isDefault: Boolean,
    val metalId: String,
    val deleted: Boolean
) : RecyclerItem {

    //todo implement me
    fun reduceBalance(amount: Double) {
    }

    //todo implement me
    fun addBalance(amount: Double) {
    }

}