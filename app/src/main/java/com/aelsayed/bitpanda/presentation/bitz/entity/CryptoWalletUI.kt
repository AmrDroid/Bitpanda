package com.aelsayed.bitpanda.presentation.bitz.entity

import com.aelsayed.bitpanda.domain.base.RecyclerItem

data class CryptoWalletUI(
    override val id: String,
    val name: String,
    val balance: Double,
    val isDefault: Boolean,
    val cryptocoinId: String,
    val deleted: Boolean
) : RecyclerItem