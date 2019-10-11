package Chapter11.Assignment3;

import java.util.LinkedList;

/**
 * Gary Tou
 * 9/25/2019
 */

public class Assignment3Problem3 {

    /**
     * Removes elements from a specified range.
     * @param list ListedList of Integers
     * @param elementValue Element to be removed
     * @param startingIndex Starting index of elements to be removed
     * @param endingIndex Ending index of of elements to be removed
     */
    public static void removeInRange(LinkedList<Integer> list, int elementValue, int startingIndex, int endingIndex){
        for(int i = endingIndex; i >= startingIndex; i--){ //loops through range backwards
            if(list.get(i) == elementValue){ //if current element equals elementValue, remove it
                list.remove(i); //removes element
            }
        }
    }

}
