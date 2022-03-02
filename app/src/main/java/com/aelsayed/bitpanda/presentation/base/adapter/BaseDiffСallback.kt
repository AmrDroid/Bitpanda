package com.aelsayed.bitpanda.presentation.base.adapter

import androidx.recyclerview.widget.DiffUtil
import com.aelsayed.bitpanda.domain.base.RecyclerItem

val BASE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<RecyclerItem>() {

    override fun areItemsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem == newItem
    }

}
