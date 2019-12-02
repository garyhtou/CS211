package Chapter16.Assignment7;

import Chapter15.Assignment6.ArrayIntList;

public class ListTestClient {
    public static void main(String[] args) {
        ArrayIntList list1 = new ArrayIntList();
        list1.add(18);
        list1.add(27);
        list1.add(93);
        System.out.println("Original List: " + list1);
        list1.remove(1);
        System.out.println("Removed index 1: " + list1);

        LinkedIntList list2 = new LinkedIntList();
        list2.add(10);
        list2.add(25);
        list2.add(31);
        list2.add(47);
        list2.add(52);
        list2.add(68);
        list2.add(77);
        System.out.println("\nOriginal List: " + list2);
        list2.switchPairs();
        System.out.println("switchPairs() result: " + list2);

        LinkedIntList list3 = new LinkedIntList();
        list3.add(2);
        list3.add(-4);
        list3.add(-1);
        list3.add(0);
        list3.add(-52);
        list3.add(68);
        list3.add(-7);
        list3.add(12);
        System.out.println("\nOriginal List: " + list3);
        list3.split();
        System.out.println("split() result: " + list3);
    }
}
