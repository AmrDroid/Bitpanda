package com.aelsayed.bitpanda.presentation.bitz.entity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.aelsayed.bitpanda.R
import com.aelsayed.bitpanda.presentation.extension.load

class FiatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(fiat: FiatUI) = with(itemView) {
        val logo = itemView.findViewById<ImageView>(R.id.itemAssetLogoImv)
        ViewCompat.setTransitionName(logo, fiat.id)
        logo.load(fiat.logo)
        itemView.findViewById<TextView>(R.id.itemAssetSymbolTxv).text = fiat.symbol
        itemView.findViewById<TextView>(R.id.itemAssetNameTxv).text =
            fiat.name
    }

}