package com.aelsayed.bitpanda.presentation.bitz.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.aelsayed.bitpanda.domain.base.Failure
import com.aelsayed.bitpanda.domain.base.RecyclerItem
import com.aelsayed.bitpanda.R
import com.aelsayed.bitpanda.databinding.FragmentBitzBinding
import com.aelsayed.bitpanda.presentation.base.fragment.BaseFragment
import com.aelsayed.bitpanda.presentation.bitz.entity.CryptocoinUI
import com.aelsayed.bitpanda.presentation.bitz.entity.MetalUI
import com.aelsayed.bitpanda.presentation.extension.*

class BitzFragment : BaseFragment() {

    override var fragmentLayout: Int = R.layout.fragment_bitz

    private lateinit var bitzViewModel: BitzViewModel

    private lateinit var binding: FragmentBitzBinding

    private val bitzAdapter: BitzAdapter by lazy {
        BitzAdapter(::showDetails)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBitzBinding.inflate(inflater, container, false)

        setupRecycler()
        setupViewModel()
        setHasOptionsMenu(true)

        return binding.root
    }


    private fun setupRecycler() {
        binding.itemErrorContainer.gone()
        binding.bitzRecyclerView.adapter = bitzAdapter
    }

    private fun setupViewModel() {
        bitzViewModel = viewModel(viewModelFactory.get()) {

            getBitz()

            observe(ldBitz, ::addBitz)

            observe(ldLoading, ::loadingUI)

            observe(ldFailure, ::handleFailure)

        }
    }

    private fun addBitz(bitz: List<RecyclerItem>) {
        binding.itemErrorContainer.gone()
        binding.bitzRecyclerView.visible()
        bitzAdapter.submitList(bitz)
    }

    private fun loadingUI(isLoading: Boolean) {
        if (isLoading) {
            binding.itemErrorContainer.gone()
            binding.progressBar.visible()
        } else {
            binding.progressBar.gone()
        }
    }

    private fun handleFailure(failure: Failure) {
        when (failure) {
            is Failure.FailureWithMessage -> {
                binding.bitzRecyclerView.gone()
                binding.itemErrorContainer.visible()
                binding.itemErrorMessage.text = failure.msg
                binding.itemErrorRetryBtn.setOnClickListener { failure.retryAction() }
            }
        }
    }

    private fun showDetails(item: RecyclerItem) {
        var price = ""
        when (item) {
            is MetalUI -> {
                price = item.price.roundToXDecimal(item.precision)
                Toast.makeText(
                    context,
                    price,
                    Toast.LENGTH_LONG
                ).show()
            }
            is CryptocoinUI -> {
                price = item.price.roundToXDecimal(item.precision)
                Toast.makeText(
                    context,
                    price,
                    Toast.LENGTH_LONG
                ).show()


            }
        }
        this.findNavController().navigate(
            BitzFragmentDirections
                .actionListOfWalletsFragmentToDetailsViewFragment(
                    price
                )
        )
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var filter = ""

        when (item.itemId) {

            R.id.fiat_wallet -> filter = FIAT
            R.id.crypto_wallet -> filter = CRYPTO
            R.id.metal_wallet -> filter = METAL
            R.id.balance -> filter = BALANCE
            R.id.default_list -> filter = DEFAULT
        }
        bitzAdapter.submitList(bitzViewModel.filterItems(filter))
        return super.onOptionsItemSelected(item)
    }


    companion object {
        const val FIAT = "fiat"
        const val CRYPTO = "crypto"
        const val METAL = "metal"
        const val BALANCE = "balance"
        const val DEFAULT = "default"
    }


}