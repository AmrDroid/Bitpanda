package com.aelsayed.bitpanda.presentation.bitz.mapper

import com.aelsayed.bitpanda.domain.bitz.entity.CryptoWallet
import com.aelsayed.bitpanda.presentation.base.mapper.MapperUI
import com.aelsayed.bitpanda.presentation.bitz.entity.CryptoWalletUI

class CryptoWalletMapper : MapperUI<CryptoWallet, CryptoWalletUI> {

    override fun mapToUI(obj: CryptoWallet): CryptoWalletUI = with(obj) {
        CryptoWalletUI(
            id = id,
            name = name,
            balance = balance,
            isDefault = isDefault,
            cryptocoinId = cryptocoinId,
            deleted = deleted
        )
    }

}