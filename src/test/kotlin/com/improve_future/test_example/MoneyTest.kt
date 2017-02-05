package com.improve_future.test_example

import junit.framework.Assert.*
import org.junit.Test

class MoneyTest {
    @Test
    fun testMultiplication() {
        assertEquals(Money.dollar(10), Money.dollar(5).times(2))
        assertEquals(Money.dollar(15), Money.dollar(5).times(3))
    }

    @Test
    fun testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)))
        assertFalse(Money.dollar(5).equals(Money.dollar(6)))
        assertTrue(Money.franc(5).equals(Money.franc(5)))
        assertFalse(Money.franc(5).equals(Money.franc(6)))
        assertFalse(Money.dollar(5).equals(Money.franc(5)))
    }

    @Test
    fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }

    @Test
    fun testSimpleAddition() {
        val result: Expression = Money.dollar(5).plus(Money.dollar(5))
        val sum: Sum = result as Sum
        val bank: Bank = Bank()
        val reduced: Money = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }

    @Test
    fun testReduceSum() {
        val sum: Expression = Sum(Money.dollar(3), Money.dollar(4))
        val bank: Bank = Bank()
        val result: Money = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(7), result)
    }

    @Test
    fun testReduceMoney() {
        val bank: Bank = Bank()
        val result: Money = bank.reduce(Money.dollar(1), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank: Bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(Money.franc(2), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testMixedAddition() {
        val fiveBucks: Expression = Money.dollar(5)
        val tenFrancs: Expression = Money.franc(10)
        val bank: Bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(fiveBucks.plus(tenFrancs), "USD")
        assertEquals(Money.dollar(10), result)
    }

    @Test
    fun testSumPlusMoney() {
        val fiveBucks: Expression = Money.dollar(5)
        val tenFrancs: Expression = Money.franc(10)
        val bank: Bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val sum: Expression = Sum(fiveBucks, tenFrancs).plus(fiveBucks)
        val result: Money = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(15), result)
    }

    @Test
    fun testSumTimes() {
        val fiveBucks: Expression = Money.dollar(5)
        val tenFrancs: Expression = Money.franc(10)
        val bank: Bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val sum: Expression = Sum(fiveBucks, tenFrancs).times(2)
        val result: Money = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(20), result)
    }

    @Test
    fun testPlusSameCurrencyReturnsMoney() {
        val sum: Expression = Money.dollar(1).plus(Money.dollar(1))
        assertTrue(sum is Money)
    }
}