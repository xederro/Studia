package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RootsCalculatorTest {

    @Test
    void calculate_roots() {
        Double[][][] testCases = {
                {{-1.0, 6.0},{1.0,-5.0,-6.0}},
                {{2.0},{1.0,-4.0,4.0}},
                {{},{1.0,1.0,6.0}},
                {{-6.0},{0.0,1.0,6.0}},
                {{},{0.0,0.0,7.0}},
                {{Double.POSITIVE_INFINITY},{0.0,0.0,0.0}},
        };

        for (Double[][] test : testCases){
            List<Double> returned = RootsCalculator.calculate_roots(test[1][0], test[1][1], test[1][2]);
            Assertions.assertEquals(test[0].length, returned.size());
            Assertions.assertArrayEquals(returned.toArray(), test[0]);
        }
    }
}