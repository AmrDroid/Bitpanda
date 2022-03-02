package com.aelsayed.bitpanda.presentation.bitz.mapper

import com.aelsayed.bitpanda.domain.bitz.entity.Cryptocoin
import com.aelsayed.bitpanda.presentation.base.mapper.MapperUI
import com.aelsayed.bitpanda.presentation.bitz.entity.CryptocoinUI

class CryptocoinMapper : MapperUI<Cryptocoin, CryptocoinUI> {

    override fun mapToUI(obj: Cryptocoin): CryptocoinUI = with(obj) {
        CryptocoinUI(
            name = name,
            symbol = symbol,
            id = id,
            price = price,
            logo = logo,
            precision = precision
        )
    }

}