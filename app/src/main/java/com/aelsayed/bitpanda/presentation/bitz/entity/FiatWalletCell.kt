package com.aelsayed.bitpanda.presentation.bitz.entity

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelsayed.bitpanda.domain.base.RecyclerItem
import com.aelsayed.bitpanda.R
import com.aelsayed.bitpanda.presentation.base.adapter.Cell

object FiatWalletCell : Cell<RecyclerItem>() {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is FiatWalletUI
    }

    override fun type(): Int {
        return R.layout.item_fiat_wallet
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return FiatWalletViewHolder(parent.viewOf(type()))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClick: ((RecyclerItem) -> Unit)?
    ) {
        if (holder is FiatWalletViewHolder && item is FiatWalletUI) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                onItemClick?.run { this(item) }
            }
        }
    }

}