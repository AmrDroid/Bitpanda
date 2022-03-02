package com.aelsayed.bitpanda.presentation.bitz.mapper

import com.aelsayed.bitpanda.domain.bitz.entity.Fiat
import com.aelsayed.bitpanda.presentation.base.mapper.MapperUI
import com.aelsayed.bitpanda.presentation.bitz.entity.FiatUI

class FiatMapper : MapperUI<Fiat, FiatUI> {

    override fun mapToUI(obj: Fiat): FiatUI = with(obj) {
        FiatUI(
            name = name,
            symbol = symbol,
            id = id,
            logo = logo,
            precision = precision
        )
    }

}