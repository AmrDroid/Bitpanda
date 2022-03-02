package com.aelsayed.bitpanda.presentation.bitz.ui

import com.aelsayed.bitpanda.domain.base.RecyclerItem
import com.aelsayed.bitpanda.presentation.base.adapter.BaseListAdapter
import com.aelsayed.bitpanda.presentation.bitz.entity.*

class BitzAdapter(onItemClick: (RecyclerItem) -> Unit) : BaseListAdapter(
    CryptoCell, CryptoWalletCell, FiatCell, FiatWalletCell, MetalCell, MetalWalletCell,
    onItemClick = onItemClick
)