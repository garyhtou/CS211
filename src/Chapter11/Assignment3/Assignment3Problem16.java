package Chapter11.Assignment3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Gary Tou
 * 10/3/2019
 */

public class Assignment3Problem16 {

    /**
     * Check if a Map is one to one; each key has a unique value.
     * @param map Map containing String for it's keys and values
     * @return TRUE is Map is one to one. FALSE if Map is not one to one.
     */
    public static boolean is1to1(Map<String, String> map){
        Set<String> keys = new HashSet<>(map.keySet()); //gets all keys
        Set<String> values = new HashSet<>(map.values()); //gets all values and remove duplicates
        return (keys.size() == values.size()? true : false); //if both Sets are the same size, the Map is one to one (each key has a unique value).
    }
}

