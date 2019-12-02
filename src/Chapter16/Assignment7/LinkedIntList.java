package Chapter16.Assignment7;

// Class LinkedIntList can be used to store a list of integers.

/**
 * Gary Tou
 * 10/4/2019
 */
public class LinkedIntList implements IntList{
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Assignment 7
     * EXERCISE 8
     * Switches every two pair
     */
    public void switchPairs(){
        for(int i = 0; i < this.size(); i+=2){
            if (this.size() - i < 3){
                return;
            }
            ListNode loseHead = null;
            if(this.nodeAt(i+2) != null) {
                loseHead = this.nodeAt(i + 2);
            }
            ListNode itemOne = this.nodeAt(i);
            ListNode itemTwo = this.nodeAt(i+1);
            this.nodeAt(i-1).next = itemTwo;
            itemTwo.next = itemOne;
            itemOne.next = loseHead;
            if(i == 0){
                this.front = itemTwo;
            }
        }
    }

    /**
     * Assignment 7
     * EXERCISE 12
     * Rearranges negatives before positives.
     */
    public void split(){
        for(int i = 0; i < this.size(); i++){
            if(this.nodeAt(i).data < 0){
                ListNode current = this.nodeAt(i);
                this.nodeAt(i-1).next = this.nodeAt(i+1);
                current.next = this.nodeAt(0);
                this.front = current;
                i--;
            }
        }
    }
}
