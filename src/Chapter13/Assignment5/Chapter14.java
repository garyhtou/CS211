package Chapter13.Assignment5;

import java.util.*;

/**
 * Gary Tou
 * 10/25/2019
 */

public class Chapter14 {

    /**
     * Check is Queue is a palindrome
     * @param integers Queue of Integers
     * @return true it it is a palindrome
     */
    public static boolean isPalindrome(Queue<Integer> integers){
        if(integers.size() <= 1){ //if 0 or 1 element, it is a palindrome
            return true;
        }

        LinkedList<Integer> aux = new LinkedList<>(); //auxiliary list to store original queue
        aux.addAll(integers);

        Stack<Integer> left = new Stack<>(); //Stack for left side
        int size = integers.size(); //save size of queue

        for(int i = 0; i < size/2; i++){ //add elements to left side stack
            left.add(integers.remove());
        }
        if(size % 2 == 1){ //if queue has an odd size, copy next element into left side
            left.add(integers.peek());
        }

        while(!left.empty()){ //compare left and right sides
            if(left.pop() != integers.remove()){ //if not palindrome, reset original queue and return false
                integers.clear();
                integers.addAll(aux);
                return false;
            }
        }

        integers.addAll(aux); //when true,  reset original queue and return true
        return true;
    }

    /**
     * Interleaves elements of a Integer Queue
     * @param integers Queue of Integers
     * @return interleaved queue
     */
    public static Queue<Integer> interleave(Queue<Integer> integers){
        if(integers.size() % 2 == 1){ //exit if array size is not even
            throw new IllegalArgumentException("no Integers in Queue");
        }

        Queue<Integer> left = new LinkedList<>(); //queue to store left side

        int size = integers.size(); //store size of queue because it will change
        for(int i = 0; i < size/2; i++){ //move left side elements into new queue
            left.add(integers.remove());
        }

        while(!left.isEmpty()){ //while left side queue is not empty, add left and right (alternate) to the end.
            integers.add(left.remove());
            integers.add(integers.remove());
        }

        return integers; //return interleaved Queue
    }
}
