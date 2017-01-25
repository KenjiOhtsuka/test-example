package com.improve_future.test_example

class Dollar(amount: Int) : Money(amount) {
    fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }
}