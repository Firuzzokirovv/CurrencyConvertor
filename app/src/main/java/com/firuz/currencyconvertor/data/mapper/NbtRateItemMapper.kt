package com.firuz.currencyconvertor.data.mapper

import com.firuz.currencyconvertor.data.local.entity.NbtRateEntity
import com.firuz.currencyconvertor.data.remote.models.Currency
import com.firuz.currencyconvertor.domain.DataMapper

class NbtRateItemMapper: DataMapper<Currency,NbtRateEntity> {
    override fun map(from: Currency): NbtRateEntity {
        return NbtRateEntity(
            name = from.name,
            fullName = from.fullName,
            nominal = from.nominal,
            flag = from.flag,
            value = from.value
        )
    }
}