package pl.edu.pwr.student.lab02.data;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * The type Constants.
 */
abstract public class Constants {
    static private int SKI_COST = 100;
    static private int SKI_LEN_DIFF_PENALTY = 5;
    static private int SKI_TYPE_DIFF_PENALTY = 30;
    static private int NO_SKI_PENALTY = 100;
    static private List<Person> PEOPLE;
    static private Map<Ski, Integer> ASSORTMENT;
    static private EnumMap<PersonKind, Integer> DISCOUNTS;

    /**
     * Init constants.
     *
     * @param lPerson     the list of person
     * @param mAssortment the map of assortment
     * @param mDiscounts  the map discounts
     */
    public static void initConstants(List<Person> lPerson, Map<Ski, Integer> mAssortment, Map<PersonKind, Integer> mDiscounts) {
        initCollections(lPerson, mAssortment, mDiscounts);
    }

    /**
     * Init constants.
     *
     * @param lPerson            the list of person
     * @param mAssortment        the map of assortment
     * @param mDiscounts         the map discounts
     * @param skiCost            the ski cost
     * @param skiLenDiffPenalty  the ski len diff penalty
     * @param skiTypeDiffPenalty the ski type diff penalty
     * @param noSkiPenalty       the no ski penalty
     */
    public static void initConstants(List<Person> lPerson, Map<Ski, Integer> mAssortment, Map<PersonKind, Integer> mDiscounts, int skiCost, int skiLenDiffPenalty, int skiTypeDiffPenalty, int noSkiPenalty) {
        initCollections(lPerson, mAssortment, mDiscounts);
        SKI_COST = skiCost;
        SKI_LEN_DIFF_PENALTY = skiLenDiffPenalty;
        SKI_TYPE_DIFF_PENALTY = skiTypeDiffPenalty;
        NO_SKI_PENALTY = noSkiPenalty;
    }

    /**
     * Init collections.
     *
     * @param lPerson            the list of person
     * @param mAssortment        the map of assortment
     * @param mDiscounts         the map discounts
     */
    private static void initCollections(List<Person> lPerson, Map<Ski, Integer> mAssortment, Map<PersonKind, Integer> mDiscounts) {
        DISCOUNTS = new EnumMap<>(PersonKind.class);
        DISCOUNTS.put(PersonKind.C,0);
        DISCOUNTS.put(PersonKind.A,0);
        DISCOUNTS.put(PersonKind.J,0);

        DISCOUNTS.putAll(mDiscounts);
        PEOPLE = lPerson;
        ASSORTMENT = mAssortment;
    }

    /**
     * Gets ski cost.
     *
     * @return the ski cost
     */
    public static int getSkiCost() {
        return SKI_COST;
    }

    /**
     * Gets ski len diff penalty.
     *
     * @return the ski len diff penalty
     */
    public static int getSkiLenDiffPenalty() {
        return SKI_LEN_DIFF_PENALTY;
    }

    /**
     * Gets ski type diff penalty.
     *
     * @return the ski type diff penalty
     */
    public static int getSkiTypeDiffPenalty() {
        return SKI_TYPE_DIFF_PENALTY;
    }

    /**
     * Gets no ski penalty.
     *
     * @return the no ski penalty
     */
    public static int getNoSkiPenalty() {
        return NO_SKI_PENALTY;
    }

    /**
     * Gets people.
     *
     * @return the people
     */
    public static List<Person> getPeople() {
        return PEOPLE;
    }

    /**
     * Gets assortment.
     *
     * @return the assortment
     */
    public static Map<Ski, Integer> getAssortment() {
        return ASSORTMENT;
    }

    /**
     * Gets discounts.
     *
     * @return the discounts
     */
    public static Map<PersonKind, Integer> getDiscounts() {
        return DISCOUNTS;
    }
}
