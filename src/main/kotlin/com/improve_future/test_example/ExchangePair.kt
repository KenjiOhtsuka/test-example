package com.improve_future.test_example

class ExchangePair(val from: String, val to: String) {
    override fun equals(other: Any?): Boolean {
        val pair: ExchangePair = other as ExchangePair
        return from.equals(pair.from) && to.equals(pair.to)
    }

    override fun hashCode(): Int {
        return 0
    }
}