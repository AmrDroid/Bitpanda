package com.aelsayed.bitpanda.presentation.bitz.entity

import com.aelsayed.bitpanda.domain.base.RecyclerItem

data class FiatWalletUI(
    override val id: String,
    val name: String,
    val fiatId: String,
    val balance: Double,
    val isDefault: Boolean,
    val deleted: Boolean
) : RecyclerItem