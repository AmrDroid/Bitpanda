package com.aelsayed.bitpanda.presentation.bitz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aelsayed.bitpanda.R
import com.aelsayed.bitpanda.databinding.FragmentWalletDetailsBinding
import dagger.android.support.DaggerFragment

class WalletDetailsFragment : DaggerFragment() {

    private lateinit var binding: FragmentWalletDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWalletDetailsBinding.inflate(inflater, container, false)


        val args = WalletDetailsFragmentArgs.fromBundle(requireArguments())

        binding.textViewPriceDetailsViewFragment.text = resources
            .getString(
                R.string.price_details_view, args.price.toString()
            )

        return binding.root
        return null

    }

}