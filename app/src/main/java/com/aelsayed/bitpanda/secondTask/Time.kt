package com.aelsayed.bitpanda.secondTask

class Time {
    val date_iso8601: String = ""
    val unix: Long = getTime()

    private fun getTime(): Long = System.currentTimeMillis()

}