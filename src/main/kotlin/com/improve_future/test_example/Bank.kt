package com.improve_future.test_example

class Bank {
    private val rateMap = mutableMapOf<ExchangePair, Int>()

    fun reduce(source: Expression, to: String): Money {
        return source.reduce(this, to)
    }

    fun rate(from: String, to: String): Int {
        if (from.equals(to)) return 1
        return rateMap[ExchangePair(from, to)] ?: 0
    }

    fun addRate(from: String, to: String, rate: Int) {
        rateMap.put(ExchangePair(from, to), rate)
    }
}