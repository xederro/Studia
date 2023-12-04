package pl.edu.pwr.student.lab02.tactics;


import pl.edu.pwr.student.lab02.data.Constants;
import pl.edu.pwr.student.lab02.data.Person;
import pl.edu.pwr.student.lab02.data.Ski;
import pl.edu.pwr.student.lab02.data.Variation;

import java.util.*;

/**
 * The type Brute force method.
 */
public class BruteForceMethod extends AbstractMethod{
    /**
     * Instantiates a new Brute force method.
     */
    public BruteForceMethod() {}

    /**
     * Runs Method
     */
    @Override
    public void find() {
        //Initializes lists of possible skis and people
        List<Ski> possibleSkis = new LinkedList<>();
        List<Person> possiblePeople = new LinkedList<>(Constants.getPeople());
        for (Map.Entry<Ski, Integer> entry : Constants.getAssortment().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                possibleSkis.add(entry.getKey());
            }
        }

        //Check all permutations
        if (possibleSkis.size() >= possiblePeople.size()) {
            checkPermutations(possibleSkis, possiblePeople);
        } else {
            checkPermutations(possiblePeople, possibleSkis);
        }
    }


    /**
     * Checks all permutations.
     * Creates permutations of bigger list of size of smaller list
     * Then checks all permutations of smaller list on permutation of bigger list
     *
     * @param bigger - bigger list of type Ski or Person
     * @param smaller - smaller list of type Ski or Person
     */
    private <T, G> void checkPermutations(List<T> bigger, List<G> smaller) {
        int biggerSize = bigger.size();
        int smallerSize = smaller.size();

        //i is binary representation of permutations of bigger list
        //for example list: a,b,c,d,e,f,g
        //can be represented as: 1011010 = 90
        //then the permutation is: a,c,d,f
        int counter = 0;
        for (long i = 1L << biggerSize; i >= 0; i--){
            List<T> permutation = new ArrayList<>();
            long temp = i;
            for (int j = biggerSize-1; j >= 0; j--){
                if (temp%2==1){
                    counter++;
                    permutation.add(bigger.get(j));
                }
                if (counter > smallerSize) break;
                temp=temp>>1;
            }

            if (counter == smallerSize) {
                //QuickPerm algorithm to assign every permutation of one list to the permutation of second one
                int[] p = new int[smallerSize+1];
                int n = 1;
                for (int k = 0; k <= smallerSize; k++) {
                    p[k] = k;
                }

                while (n < smallerSize) {
                    Map<Person, Ski> peopleWithSkis = new HashMap<>();

                    int j = 0;
                    p[n]--;
                    if(n%2!=0){
                        j=p[n];
                    }

                    //swap elements
                    T swap = permutation.get(n);
                    permutation.set(n, permutation.get(j));
                    permutation.set(j, swap);

                    n=1;
                    while(p[n]==0){
                        p[n]=n;
                        n++;
                    }

                    //add skis to people
                    if (bigger.get(0) instanceof Ski) {
                        for (int k = 0; k < smallerSize; k++) {
                            peopleWithSkis.put((Person) smaller.get(k), (Ski) permutation.get(k));
                        }
                    } else {
                        for (int k = 0; k < smallerSize; k++) {
                            peopleWithSkis.put((Person) permutation.get(k), (Ski) smaller.get(k));
                        }
                        for (int k = 0; k < biggerSize; k++) {
                            if (!peopleWithSkis.containsKey((Person) bigger.get(k))){
                                peopleWithSkis.put((Person) bigger.get(k), null);
                            }
                        }
                    }

                    //Check if variation is better than saved one
                    Variation variation = new Variation(peopleWithSkis);
                    Integer current = variation.evaluate();
                    if (current > best) {
                        best = current;
                        bestV = variation;
                    }
                }
            }
            permutation.clear();
            counter = 0;
        }
    }
}

