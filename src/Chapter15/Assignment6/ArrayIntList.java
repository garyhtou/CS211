package Chapter15.Assignment6;

import java.util.NoSuchElementException;

/**
 * Gary Tou
 * 10/30/2019
 * Assignment 6
 *
 * Chapter 15, exercises 1, 2, 5, 8, and 11
 *
 * Class ArrayIntList can be used to store a list of integers.
 */
public class ArrayIntList {
    private int[] elementData; // list of integers
    private int size;          // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 100;

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        elementData = new int[capacity];
        size = 0;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // pre : size() < capacity
    // post: appends the given value to the end of the list
    public void add(int value) {
        elementData[size] = value;
        size++;
    }

    // pre: size() < capacity && 0 <= index <= size()
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, int value) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    /**
     * CHAPTER 15, EXERCISE 1
     * Returns index of last element with such value.
     * @param value Value of seeking element
     * @return index of last element with such value.
     */
    public int lastIndexOf(int value){
        for(int i = this.size() - 1; i >= 0; i--){
            if(this.get(i) == value){
                return i;
            }
        }
        return -1;
    }

    /**
     * CHAPTER 15, EXERCISE 2
     * Returns the first index of the sublist L.
     * @param L int[] sublist
     * @return index of the first occurrence of the sublist.
     */
    public int indexOfSubList(int[] L){
        for(int i = 0; i < this.size() - L.length; i++){
            for(int k = 0; k < L.length; k++){
                if(!(this.get(k+i) == L[k])){
                    break;
                } else if(k == L.length - 1){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * CHAPTER 15, EXERCISE 5
     * Creates an int[] with a running total of the element before it
     * @return returns the int[]
     */
    public ArrayIntList runningTotal(){
        ArrayIntList totals = new ArrayIntList(this.size());
        int currentSum = 0;

        for(int i = 0; i < this.size(); i++){
            currentSum += this.get(i);
            totals.add(currentSum);
        }

        return totals;
    }


    /**
     * CHAPTER 15, EXERCISE 8
     * Counts the occurrence of a value.
     * @param value value to be counted
     * @return number of occurrences of a value.
     */
    public int count(int value){
        int counter = 0;
        for(int i = 0; i < this.size; i++){
            if(this.get(i) == value){
                counter++;
            }
        }
        return counter;
    }

    /**
     * CHAPTER 15, EXERCISE 11
     * Removes last element in the intList.
     * @return the removed element.
     */
    public int removeLast(){
        if(this.size() == 0){
            throw new NoSuchElementException("IntList is empty");
        }

        int removed = this.get(this.size()-1);
        elementData[this.size() - 1] = 0;
        size--;

        return removed;
    }
}
