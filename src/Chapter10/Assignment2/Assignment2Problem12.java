package Chapter10.Assignment2;

import java.util.ArrayList;

/**
 * Gary Tou
 * 9/23/2019
 */

public class Assignment2Problem12 {

    final static String marker = "****";

    /**
     * Marks which element has a length of 4 by added a marker ("****") in front.
     * @param list ArrayList with string elements
     */
    public static void markLength4(ArrayList<String> list) {
        for (int i = list.size()-1; i >= 0; i--) { //iterates through entire ArrayList backwards
            if (list.get(i).length() == 4) { //checks the current element has a length of 4
                list.add(i, marker); //adds marker (4 asterisks) if length is four
            }
        }
    }
}