package com.aelsayed.bitpanda.presentation.bitz.entity

import com.aelsayed.bitpanda.domain.base.RecyclerItem

data class BitzUI(
    override val id: String,
    val metalWallet: List<MetalWalletUI>,
    val cryptoWallet: List<CryptoWalletUI>,
    val fiatWallet: List<FiatWalletUI>,
    val cryptocoin: List<CryptocoinUI>,
    val fiat: List<FiatUI>,
    val metal: List<MetalUI>
) : RecyclerItem