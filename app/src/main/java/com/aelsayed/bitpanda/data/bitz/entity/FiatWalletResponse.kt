package com.aelsayed.bitpanda.data.bitz.entity


import com.aelsayed.bitpanda.data.base.ResponseObject
import com.aelsayed.bitpanda.domain.bitz.entity.FiatWallet
import com.google.gson.annotations.SerializedName

data class FiatWalletResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("fiatId") val fiatId: String,
    @SerializedName("balance") val balance: Double,
    @SerializedName("isDefault") val isDefault: Boolean,
    @SerializedName("deleted") val deleted: Boolean
) : ResponseObject<FiatWallet> {

    override fun toDomain(): FiatWallet =
        FiatWallet(
            id = id,
            name = name,
            fiatId = fiatId,
            balance = balance,
            isDefault = isDefault,
            deleted = deleted
        )

}