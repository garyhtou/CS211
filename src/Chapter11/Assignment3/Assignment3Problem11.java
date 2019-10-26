package Chapter11.Assignment3;

import java.util.HashSet;
import java.util.Iterator;
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

        symmetricSet.addAll(one); //add Set one

        Iterator<Integer> iterator = two.iterator(); //create iterator for set two
        while(iterator.hasNext()){
            Integer currentNum = iterator.next();
            if(symmetricSet.contains(currentNum)){ //if item already exists, delete it.
                symmetricSet.remove(currentNum);
            } else{
                symmetricSet.add(currentNum); //if it does not exist, add it
            }
        }

        return symmetricSet; //return combined set
    }
}
