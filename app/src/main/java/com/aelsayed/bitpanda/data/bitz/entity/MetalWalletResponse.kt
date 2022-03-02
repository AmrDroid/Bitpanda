package com.aelsayed.bitpanda.data.bitz.entity


import com.aelsayed.bitpanda.data.base.ResponseObject
import com.aelsayed.bitpanda.domain.bitz.entity.MetalWallet
import com.google.gson.annotations.SerializedName

data class MetalWalletResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("balance") val balance: Double,
    @SerializedName("isDefault") val isDefault: Boolean,
    @SerializedName("metalId") val metalId: String,
    @SerializedName("deleted") val deleted: Boolean
) : ResponseObject<MetalWallet> {

    override fun toDomain(): MetalWallet =
        MetalWallet(
            id = id,
            name = name,
            balance = balance,
            isDefault = isDefault,
            metalId = metalId,
            deleted = deleted
        )

}