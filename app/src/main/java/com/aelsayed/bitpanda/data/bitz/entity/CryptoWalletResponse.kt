package com.aelsayed.bitpanda.data.bitz.entity


import com.aelsayed.bitpanda.data.base.ResponseObject
import com.aelsayed.bitpanda.domain.bitz.entity.CryptoWallet
import com.google.gson.annotations.SerializedName

data class CryptoWalletResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("balance") val balance: Double,
    @SerializedName("isDefault") val isDefault: Boolean,
    @SerializedName("cryptocoinId") val cryptocoinId: String,
    @SerializedName("deleted") val deleted: Boolean
) : ResponseObject<CryptoWallet> {

    override fun toDomain(): CryptoWallet =
        CryptoWallet(
            id = id,
            name = name,
            balance = balance,
            isDefault = isDefault,
            cryptocoinId = cryptocoinId,
            deleted = deleted
        )

}