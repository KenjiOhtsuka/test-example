package com.improve_future.test_example

open class Money(protected val amount: Int) {
    override fun equals(other: Any?): Boolean {
        val money: Money = other as Money
        return amount == money.amount &&
                this::class == money::class
    }
}