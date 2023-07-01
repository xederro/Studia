package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RootsCalculator {
    public static List<Double> calculate_roots(double a, double b, double c){
        ArrayList<Double> temp = new ArrayList<Double>();

        if (a == 0) {
            if (b == 0) {
                if (c == 0){
                    temp.add(Double.POSITIVE_INFINITY);
                }
            } else {
                temp.add(-c/b);
            }
        } else {
            double delta = b*b-4*a*c;
            if (delta == 0) {
                temp.add(-b/(2*a));
            } else if (delta > 0){
                temp.add((-b+Math.sqrt(delta))/(2*a));
                temp.add((-b-Math.sqrt(delta))/(2*a));
            }
        }
        temp.sort(Comparator.naturalOrder());
        return temp;
    }
}
