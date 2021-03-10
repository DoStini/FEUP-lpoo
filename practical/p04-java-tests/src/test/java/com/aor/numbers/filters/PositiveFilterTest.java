package com.aor.numbers.filters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveFilterTest {
    @Test
    public void positiveNumber() {
        Assertions.assertTrue((new PositiveFilter()).accept(5));
    }

    @Test
    public void zeroNumber() {
        Assertions.assertFalse((new PositiveFilter()).accept(0));
    }

    @Test
    public void negativeNumber() {
        Assertions.assertFalse((new PositiveFilter()).accept(-5));
    }
}