package com.firuz.currencyconvertor.domain

interface DataMapper<Data, Domain> {
    fun map(from: Data): Domain
}
