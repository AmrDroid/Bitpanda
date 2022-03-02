package com.aelsayed.bitpanda.domain.base

sealed class Failure(var retryAction: () -> Unit) : Throwable() {

    class FailureWithMessage(val msg: String) : Failure({})

}