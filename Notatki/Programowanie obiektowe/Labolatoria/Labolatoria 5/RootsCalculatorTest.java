package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RootsCalculatorTest {

    @Test
    void calculate_roots() {
        assertEquals(2, RootsCalculator.calculate_roots(1, -5, -6).size());
        assertEquals(1, RootsCalculator.calculate_roots(1, -4, 4).size());
        assertEquals(0, RootsCalculator.calculate_roots(1, 1, 6).size());
        assertEquals(1, RootsCalculator.calculate_roots(0, 1, 6).size());
        assertEquals(0, RootsCalculator.calculate_roots(0, 0, 7).size());
        assertEquals(Double.POSITIVE_INFINITY, RootsCalculator.calculate_roots(0, 0, 0).get(0));
    }
}