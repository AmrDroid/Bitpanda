package com.aelsayed.bitpanda.data.bitz.entity


import com.aelsayed.bitpanda.data.base.ResponseObject
import com.aelsayed.bitpanda.domain.bitz.entity.Metal
import com.google.gson.annotations.SerializedName

data class MetalResponse(
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("id") val id: String,
    @SerializedName("price") val price: Double,
    @SerializedName("logo") val logo: String
) : ResponseObject<Metal> {

    override fun toDomain(): Metal =
        Metal(
            name = name,
            symbol = symbol,
            id = id,
            price = price,
            logo = logo
        )

}