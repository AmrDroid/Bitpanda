package com.aelsayed.bitpanda.presentation.bitz.mapper

import com.aelsayed.bitpanda.domain.bitz.entity.Metal
import com.aelsayed.bitpanda.presentation.base.mapper.MapperUI
import com.aelsayed.bitpanda.presentation.bitz.entity.MetalUI

class MetalMapper : MapperUI<Metal, MetalUI> {

    override fun mapToUI(obj: Metal): MetalUI = with(obj) {
        MetalUI(
            name = name,
            symbol = symbol,
            id = id,
            price = price,
            logo = logo,
            precision = precision
        )
    }

}