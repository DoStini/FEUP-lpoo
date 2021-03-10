package com.aor.numbers.filters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisibleByFilterTest {
    @Test
    public void sameNumber() {
        Assertions.assertTrue((new DivisibleByFilter(5)).accept(5));
    }

    @Test
    public void doubleNumber() {
        Assertions.assertTrue((new DivisibleByFilter(5)).accept(10));
    }

    @Test
    public void tripleNumber() {
        Assertions.assertTrue((new DivisibleByFilter(5)).accept(15));
    }

    @Test
    public void zeroNumber() {
        Assertions.assertTrue((new DivisibleByFilter(5)).accept(0));
    }

    @Test
    public void negativeBase() {
        Assertions.assertTrue((new DivisibleByFilter(-2)).accept(4));
    }

    @Test
    public void nonDivisible1() {
        Assertions.assertFalse((new DivisibleByFilter(5)).accept(7));
    }

    @Test
    public void nonDivisible2() {
        Assertions.assertFalse((new DivisibleByFilter(2)).accept(5));
    }
}