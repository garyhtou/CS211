package Chapter11.Assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Assignment3Problem11 {

    public static Set<Integer> symmetricSetDifference(Set<Integer> one, Set<Integer> two){
        Set<Integer> symmetricSet = new HashSet<>();
        symmetricSet.addAll(one);
        symmetricSet.addAll(two);
        return symmetricSet;
    }
}
