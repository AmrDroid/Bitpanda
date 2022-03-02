package com.aelsayed.bitpanda.data.bitz.entity


import com.aelsayed.bitpanda.data.base.ResponseObject
import com.aelsayed.bitpanda.domain.bitz.entity.Fiat
import com.google.gson.annotations.SerializedName

data class FiatResponse(
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("id") val id: String,
    @SerializedName("logo") val logo: String
) : ResponseObject<Fiat> {

    override fun toDomain(): Fiat =
        Fiat(
            name = name,
            symbol = symbol,
            id = id,
            logo = logo
        )

}