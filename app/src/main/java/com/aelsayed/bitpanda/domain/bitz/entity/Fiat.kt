package com.aelsayed.bitpanda.domain.bitz.entity

import com.aelsayed.bitpanda.domain.base.RecyclerItem

data class Fiat(
    override val id: String,
    val name: String,
    val symbol: String,
    val logo: String,
    val precision: Int = 2
) : RecyclerItem