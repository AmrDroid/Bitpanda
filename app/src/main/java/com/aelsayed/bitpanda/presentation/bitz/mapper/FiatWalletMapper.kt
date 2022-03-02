package com.aelsayed.bitpanda.presentation.bitz.mapper

import com.aelsayed.bitpanda.domain.bitz.entity.FiatWallet
import com.aelsayed.bitpanda.presentation.base.mapper.MapperUI
import com.aelsayed.bitpanda.presentation.bitz.entity.FiatWalletUI

class FiatWalletMapper : MapperUI<FiatWallet, FiatWalletUI> {

    override fun mapToUI(obj: FiatWallet): FiatWalletUI = with(obj) {
        FiatWalletUI(
            id = id,
            name = name,
            balance = balance,
            isDefault = isDefault,
            deleted = deleted,
            fiatId = fiatId
        )
    }

}