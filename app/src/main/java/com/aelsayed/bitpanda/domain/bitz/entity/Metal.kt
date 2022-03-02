package com.aelsayed.bitpanda.domain.bitz.entity

import com.aelsayed.bitpanda.domain.base.RecyclerItem

data class
Metal(
    override val id: String,
    val name: String,
    val symbol: String,
    val price: Double,
    val logo: String,
    val precision: Int = 3
) : RecyclerItem