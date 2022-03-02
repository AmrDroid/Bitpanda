package com.aelsayed.bitpanda.presentation.bitz.entity

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aelsayed.bitpanda.R

class MetalWalletViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(metalWallet: MetalWalletUI) = with(itemView) {

        findViewById<TextView>(R.id.itemWalletNameTxv).text = metalWallet.name
        findViewById<TextView>(R.id.itemWalletBalanceTxv).text = metalWallet.balance.toString()

    }

}