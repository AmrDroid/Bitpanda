package com.aelsayed.bitpanda.domain.base

interface RecyclerItem {
    val id: String?
    override fun equals(other: Any?): Boolean
}