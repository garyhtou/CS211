package Chapter11.Assignment3;

import java.util.LinkedList;

public class Assignment3Problem3 {

    public static void removeInRange(LinkedList<Integer> list, int elementValue, int startingIndex, int endingIndex){
        for(int i = endingIndex; i >= startingIndex; i--){ //loops through range backwards
            if(list.get(i) == elementValue){ //if current element equals elementValue, remove it
                list.remove(i);
            }
        }
    }

}
