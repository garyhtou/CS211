package Chapter15.Assignment6;

import java.util.Arrays;

public class ArrayIntListTestClass {

    public static void main(String[] args){
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
        ArrayIntList intList = new ArrayIntList();

        for(int i = 0; i < list.length; i++){
            intList.add(list[i]);
        }
        System.out.println("Original ArrayIntList:\t" + intList);

        //Exercise 1
        System.out.println("\nExercise 1");
        System.out.println("Last Index Of 4:\t" + intList.lastIndexOf(4));

        //Exercise 2
        System.out.println("\nExercise 2");
        int[] indexOfList = new int[]{5, 6, 7};
        System.out.println("Index Of SubList [5, 6, 7]: \t" + intList.indexOfSubList(indexOfList));

        //Exercise 5
        System.out.println("\nExercise 5");
        System.out.println("Running Total:\t" + intList.runningTotal());

        //Exercise 8
        System.out.println("\nExercise 8");
        System.out.println("Counting value 4:\t" + intList.count(4));

        //Exercise 11
        System.out.println("\nExercise 11");
        int returned = intList.removeLast();
        System.out.println("IntArray after removing last element:\t" + intList);
        System.out.println("Returned:\t" + returned);

    }
}
