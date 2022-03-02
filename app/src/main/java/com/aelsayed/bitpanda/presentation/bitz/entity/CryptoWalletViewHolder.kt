package com.aelsayed.bitpanda.presentation.bitz.entity

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aelsayed.bitpanda.R

class CryptoWalletViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(cryptoWallet: CryptoWalletUI) = with(itemView) {

        findViewById<TextView>(R.id.itemWalletNameTxv).text = cryptoWallet.name
        findViewById<TextView>(R.id.itemWalletBalanceTxv).text = cryptoWallet.balance.toString()

    }

}