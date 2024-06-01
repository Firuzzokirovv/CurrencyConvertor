package com.firuz.currencyconvertor.data.mapper

import com.firuz.currencyconvertor.data.local.entity.NbtRateEntity
import com.firuz.currencyconvertor.domain.DataMapper
import com.firuz.currencyconvertor.domain.models.NbtRate


class NbtRateMapper : DataMapper<NbtRateEntity, NbtRate> {
    override fun map(from: NbtRateEntity): NbtRate {
        return NbtRate(
            name = from.name,
            fullName = from.fullName,
            nominal = from.nominal,
            flag = from.flag,
            value = from.value
        )
    }

}