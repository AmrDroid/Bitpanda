package com.aelsayed.bitpanda.presentation.bitz.entity

import com.aelsayed.bitpanda.domain.base.RecyclerItem

data class MetalWalletUI(
    override val id: String,
    val name: String,
    val balance: Double,
    val isDefault: Boolean,
    val metalId: String,
    val deleted: Boolean
) : RecyclerItem