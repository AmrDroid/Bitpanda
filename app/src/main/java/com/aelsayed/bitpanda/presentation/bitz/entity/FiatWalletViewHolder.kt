package com.aelsayed.bitpanda.presentation.bitz.entity

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aelsayed.bitpanda.R

class FiatWalletViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(fiatWallet: FiatWalletUI) = with(itemView) {
        findViewById<TextView>(R.id.itemWalletNameTxv).text = fiatWallet.name
        findViewById<TextView>(R.id.itemWalletBalanceTxv).text = fiatWallet.balance.toString()

    }

}