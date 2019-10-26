package Chapter13.Assignment5;

import java.util.Arrays;

/**
 * Gary Tou
 * 10/24/2019
 */
public class Assignment5Problem9 {

    /**
     * Merge Sort but prints steps
     * @param arr int array
     */
    public static void mergeSortProcess(int[] arr){

        if(arr.length < 2){ //if array is shorted than two elements, exit
            return;
        }

        System.out.println(Arrays.toString(arr)); //prints array

        int[] lArr = Arrays.copyOfRange(arr, 0, arr.length/2); //splits array. Left side
        int[] rArr = Arrays.copyOfRange(arr, (arr.length/2), arr.length); //splits array. Right side

        mergeSortProcess(lArr); //sorts left side
        mergeSortProcess(rArr); //sorts right side

        //index holders
        int lIndex = 0;
        int rIndex = 0;
        int arrIndex = 0;

        while(lIndex < lArr.length && rIndex < rArr.length){ //compare and sort left and right arrays

            if(lArr[lIndex] < rArr[rIndex]) { //if left is smaller
                arr[arrIndex] = lArr[lIndex]; //copy into array
                lIndex++;
                arrIndex++;
            } else{ //if right is smaller
                arr[arrIndex] = rArr[rIndex]; //copy into array
                rIndex++;
                arrIndex++;
            }
        }

        while(lIndex < lArr.length){ //add extra numbers
            arr[arrIndex] = lArr[lIndex];
            lIndex++;
            arrIndex++;
        }
        while(rIndex < rArr.length){ //add extra numbers
            arr[arrIndex] = rArr[rIndex];
            rIndex++;
            arrIndex++;
        }

        System.out.println(Arrays.toString(arr)); //prints sorted array
    }
}
