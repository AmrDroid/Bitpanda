package com.aelsayed.bitpanda.presentation.bitz.entity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.aelsayed.bitpanda.R
import com.aelsayed.bitpanda.presentation.extension.load

class MetalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(metal: MetalUI) = with(itemView) {
        val logo = itemView.findViewById<ImageView>(R.id.itemAssetLogoImv)
        ViewCompat.setTransitionName(logo, metal.id)
        logo.load(metal.logo)
        itemView.findViewById<TextView>(R.id.itemAssetNameTxv).text = metal.name
        itemView.findViewById<TextView>(R.id.itemAssetBalanceTxv).text =
            metal.price.toString()

    }

}