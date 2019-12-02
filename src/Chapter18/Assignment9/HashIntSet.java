package Chapter18.Assignment9;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
public class HashIntSet {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;

    // Constructs an empty set.
    public HashIntSet() {
        elementData = new HashEntry[10];
        size = 0;
    }

    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(int value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }

            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry(value, elementData[bucket]);
            size++;
        }
    }

    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
        int bucket = hashFunction(value);
        HashEntry current = elementData[bucket];
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }

    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(int value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data == value) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry current = elementData[bucket];
                while (current.next != null && current.next.data != value) {
                    current = current.next;
                }

                // if the element is found, remove it
                if (current.next != null && current.next.data == value) {
                    current.next = current.next.next;
                    size--;
                }
            }
        }
    }

    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }

    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }


    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(int value) {
        return Math.abs(value) % elementData.length;
    }

    private double loadFactor() {
        return (double) size / elementData.length;
    }

    // Resizes the hash table to twice its former size.
    private void rehash() {
        // replace element data array with a larger empty version
        HashEntry[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry current = oldElementData[i];
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }

    // Represents a single value in a chain stored in one hash bucket.
    private class HashEntry {
        public int data;
        public HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }


    /**
     * Assignment 9
     * EXERCISE 1
     * Adds all element in input to this HashIntSet
     * @param set another HashIntSet
     */
    public void addAll(HashIntSet set) {
        for (int i = 0; i < set.elementData.length; i++) {
            HashEntry current = set.elementData[i];
            while (current != null) {
                this.add(current.data);
                current = current.next;
            }
        }
    }

    /**
     * Assignment 9
     * EXERCISE 2
     * Checks if this HashIntSet contains all elemt in put
     * @param set another HashIntSet
     * @return true if it coantains all
     */
    public boolean containsAll(HashIntSet set) {
        for (int i = 0; i < set.elementData.length; i++) {
            HashEntry current = set.elementData[i];
            while (current != null) {
                if (!this.contains(current.data)) {
                    return false;
                }
                current = current.next;
            }
        }
        return true;
    }


    /**
     * Assignment 9
     * EXERCISE 3
     * Check is sets have exact same elements
     * @param set another HashIntSet
     * @return true if has the exact same elements
     */
    public boolean equals(HashIntSet set) {
        if (this.size() != set.size()) {
            return false;
        }

        for (int i = 0; i < this.elementData.length; i++) {
            HashEntry current = set.elementData[i];
            while (current != null) {
                if (!set.contains(current.data)) {
                    return false;
                }
                current = current.next;
            }
        }
        return true;
    }

    /**
     * Assignment 9
     * EXERCISE 9
     * returns the kth smallest element within the queue
     * @param queue target queue
     * @param k kth smallest element
     * @return the kth smallest element within the queue
     */
    public int kthSmallest(PriorityQueue<Integer> queue, int k){
        if(k < 1 || k > queue.size()){
            throw new IllegalArgumentException("k out of bounds");
        }
        Queue<Integer> aux = new LinkedList<Integer>();
        for(int i = 0; i < k-1; i++){
            aux.add(queue.remove());
        }
        int value = queue.remove();
        while(!aux.isEmpty()){
            queue.add(aux.remove());
        }
        return value;
    }

    //11
}
