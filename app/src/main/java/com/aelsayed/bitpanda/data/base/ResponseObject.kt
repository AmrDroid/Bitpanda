package com.aelsayed.bitpanda.data.base

interface ResponseObject<out DomainObject : Any?> {

    fun toDomain(): DomainObject

}