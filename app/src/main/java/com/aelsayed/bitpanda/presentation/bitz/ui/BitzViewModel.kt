package com.aelsayed.bitpanda.presentation.bitz.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aelsayed.bitpanda.domain.base.RecyclerItem
import com.aelsayed.bitpanda.domain.bitz.entity.Bitz
import com.aelsayed.bitpanda.domain.bitz.usecase.GetBitzUseCase
import com.aelsayed.bitpanda.presentation.base.viewmodel.BaseViewModel
import com.aelsayed.bitpanda.presentation.bitz.entity.BitzUI
import com.aelsayed.bitpanda.presentation.bitz.entity.CryptoWalletUI
import com.aelsayed.bitpanda.presentation.bitz.entity.FiatWalletUI
import com.aelsayed.bitpanda.presentation.bitz.entity.MetalWalletUI
import com.aelsayed.bitpanda.presentation.bitz.mapper.BitzMapper
import com.aelsayed.bitpanda.presentation.bitz.ui.BitzFragment.Companion.BALANCE
import com.aelsayed.bitpanda.presentation.bitz.ui.BitzFragment.Companion.CRYPTO
import com.aelsayed.bitpanda.presentation.bitz.ui.BitzFragment.Companion.FIAT
import com.aelsayed.bitpanda.presentation.bitz.ui.BitzFragment.Companion.METAL
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

 class BitzViewModel @Inject constructor(
    private val getBitzUseCase: GetBitzUseCase
) : BaseViewModel() {

    private val _ldBitz = MutableLiveData<List<RecyclerItem>>()
    val ldBitz: LiveData<List<RecyclerItem>> = _ldBitz

    private val metalWallet = mutableListOf<RecyclerItem>()
    private val cryptoWallet = mutableListOf<RecyclerItem>()
    private val fiatWallet = mutableListOf<RecyclerItem>()

    fun getBitz() {
        metalWallet.clear()
        cryptoWallet.clear()
        fiatWallet.clear()
        val finalList = mutableListOf<RecyclerItem>()
        getBitzUseCase(Unit)
            .map { bitz ->
                BitzMapper().mapToUI(bitz as Bitz)
            }
            .map { bitz ->
                bitz.metalWallet.forEach { metalWalletUI ->
                    finalList.add(metalWalletUI)
                    val list = metalWalletUI.returnCurrencyListOfThisWallet(bitz)
                    finalList.addAll(list)
                    metalWallet.add(metalWalletUI)
                    metalWallet.addAll(list)
                }
                bitz.cryptoWallet.forEach { cryptoWalletUI ->
                    finalList.add(cryptoWalletUI)
                    val list = cryptoWalletUI.returnCurrencyListOfThisWallet(bitz)
                    finalList.addAll(list)
                    cryptoWallet.add(cryptoWalletUI)
                    cryptoWallet.addAll(list)

                }
                bitz.fiatWallet.forEach { fiatWalletUI ->
                    finalList.add(fiatWalletUI)
                    val list = fiatWalletUI.returnCurrencyListOfThisWallet(bitz)
                    finalList.addAll(list)
                    fiatWallet.add(fiatWalletUI)
                    fiatWallet.addAll(list)
                }

                finalList.toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loading(true) }
            .doAfterTerminate { loading(false) }
            .subscribe({ resultList ->
                _ldBitz.value = resultList
            }, { throwable ->
                handleFailure(throwable) { getBitz() }
            }).addTo(compositeDisposable)
    }

    private inline fun <reified T : RecyclerItem> T.returnCurrencyListOfThisWallet(bitz: BitzUI): List<RecyclerItem> {
        val result = mutableListOf<RecyclerItem>()
        when (this) {
            is MetalWalletUI -> {
                bitz.metal.sortedBy { it.price }.firstOrNull { it.id == this.metalId }?.run {
                    result.add(this as RecyclerItem)
                }
            }
            is CryptoWalletUI -> {
                bitz.cryptocoin.sortedBy { it.price }.firstOrNull { it.id == this.cryptocoinId }
                    ?.run {
                        result.add(this as RecyclerItem)
                    }
            }
            is FiatWalletUI -> {
                bitz.fiat.firstOrNull { it.id == this.fiatId }?.run {
                    result.add(this as RecyclerItem)
                }
            }
        }

        return result
    }


    fun filterItems(type: String): List<RecyclerItem> {
        val result = mutableListOf<RecyclerItem>()
        when (type) {
            FIAT -> {
                return fiatWallet
            }
            CRYPTO -> {
                return cryptoWallet
            }
            METAL -> {
                return metalWallet
            }
            BALANCE -> {
                result.addAll(metalWallet)
                result.addAll(cryptoWallet)
                result.addAll(fiatWallet)
                return result
            }
        }
        return _ldBitz.value!!
    }


}