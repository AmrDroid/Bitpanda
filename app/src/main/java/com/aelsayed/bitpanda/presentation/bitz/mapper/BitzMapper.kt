package com.aelsayed.bitpanda.presentation.bitz.mapper

import com.aelsayed.bitpanda.domain.bitz.entity.Bitz
import com.aelsayed.bitpanda.presentation.base.mapper.MapperUI
import com.aelsayed.bitpanda.presentation.bitz.entity.BitzUI

class BitzMapper : MapperUI<Bitz, BitzUI> {

    override fun mapToUI(obj: Bitz): BitzUI = with(obj) {
        BitzUI(
            id = id,
            metalWallet = metalWallet.map { MetalWalletMapper().mapToUI(it) },
            cryptoWallet = cryptoWallet.map { CryptoWalletMapper().mapToUI(it) },
            fiatWallet = fiatWallet.map { FiatWalletMapper().mapToUI(it) },
            cryptocoin = cryptocoin.map { CryptocoinMapper().mapToUI(it) },
            fiat = fiat.map { FiatMapper().mapToUI(it) },
            metal = metal.map { MetalMapper().mapToUI(it) }
        )
    }

}