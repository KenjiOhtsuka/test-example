package com.improve_future.test_example

interface Expression {
    fun reduce(bank: Bank, to: String): Money
    fun plus(addend: Expression): Expression
    fun times(multiplier: Int): Expression
}