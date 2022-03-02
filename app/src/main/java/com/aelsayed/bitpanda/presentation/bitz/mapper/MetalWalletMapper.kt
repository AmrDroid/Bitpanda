package com.aelsayed.bitpanda.presentation.bitz.mapper

import com.aelsayed.bitpanda.domain.bitz.entity.MetalWallet
import com.aelsayed.bitpanda.presentation.base.mapper.MapperUI
import com.aelsayed.bitpanda.presentation.bitz.entity.MetalWalletUI

class MetalWalletMapper : MapperUI<MetalWallet, MetalWalletUI> {

    override fun mapToUI(obj: MetalWallet): MetalWalletUI = with(obj) {
        MetalWalletUI(
            id = id,
            name = name,
            balance = balance,
            isDefault = isDefault,
            metalId = metalId,
            deleted = deleted
        )
    }

}