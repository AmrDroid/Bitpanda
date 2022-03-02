package com.aelsayed.bitpanda.presentation.base.mapper

interface MapperUI<DomainObject, UIObject> {

    fun mapToUI(obj: DomainObject): UIObject

}