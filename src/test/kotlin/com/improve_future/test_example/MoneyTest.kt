package com.improve_future.test_example

import junit.framework.Assert.*
import org.junit.Test

class MoneyTest {
    @Test
    fun testMultiplication() {
        assertEquals(Dollar(10), Dollar(5).times(2))
        assertEquals(Dollar(15), Dollar(5).times(3))
    }

    @Test
    fun testEquality() {
        assertTrue(Dollar(5).equals(Dollar(5)))
        assertFalse(Dollar(5).equals(Dollar(6)))
        assertTrue(Franc(5).equals(Franc(5)))
        assertFalse(Franc(5).equals(Franc(6)))
        assertFalse(Dollar(5).equals(Franc(5)))
    }
}