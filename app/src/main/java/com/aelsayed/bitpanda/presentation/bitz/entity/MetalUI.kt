package com.aelsayed.bitpanda.presentation.bitz.entity

import com.aelsayed.bitpanda.domain.base.RecyclerItem

data class MetalUI(
    override val id: String,
    val name: String,
    val symbol: String,
    val price: Double,
    val logo: String,
    val precision: Int
) : RecyclerItem