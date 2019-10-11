package Chapter11.Assignment3;

import java.util.HashSet;
import java.util.Set;

/**
 * Gary Tou
 * 9/27/2019
 */

public class Assignment3Problem11 {

    /**
     * Returns a combined set (contains only unique values)
     * @param one Set of Integers
     * @param two Set of Integers
     * @return Combined set (contains only unique values)
     */
    public static Set<Integer> symmetricSetDifference(Set<Integer> one, Set<Integer> two){
        Set<Integer> symmetricSet = new HashSet<>(); //create a set
        symmetricSet.addAll(one); //add set one
        symmetricSet.addAll(two); //add set two and will remove duplicates
        return symmetricSet; //return combined set
    }
}
