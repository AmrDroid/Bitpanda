package com.aelsayed.bitpanda.presentation.bitz.entity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.aelsayed.bitpanda.R
import com.aelsayed.bitpanda.presentation.extension.load

class CryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(cryptoWallet: CryptocoinUI) = with(itemView) {
        val logo = itemView.findViewById<ImageView>(R.id.itemAssetLogoImv)
        ViewCompat.setTransitionName(logo, cryptoWallet.id)
        logo.load(cryptoWallet.logo)
        itemView.findViewById<TextView>(R.id.itemAssetSymbolTxv).text = cryptoWallet.symbol
        itemView.findViewById<TextView>(R.id.itemAssetBalanceTxv).text =
            cryptoWallet.price.toString()
    }

}