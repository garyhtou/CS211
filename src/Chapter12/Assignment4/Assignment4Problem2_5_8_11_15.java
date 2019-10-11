package Chapter12.Assignment4;

public class Assignment4Problem2_5_8_11_15 {

    /**
     * Gary Tou
     * 10/4/2019
     */

    public static void main(String[] args){

        //Problem #2
        System.out.println("Problem #2");
        writeNums(5); //Prints: "1, 2, 3, 4, 5"

        //Problem #5
        System.out.println("\n\nProblem #5");
        writeBinary(44); //Prints: "101100"

        //Problem #8
        System.out.println("\n\nProblem #8");
        System.out.println(multiplyEvens(4)); //Prints: "384"

        //Problem #11
        System.out.println("\n\nProblem #11");
        System.out.println(repeat("hello", 3)); //Prints: hellohellohello

        //Problem #15
        System.out.println("\n\nProblem #15");
        System.out.println(permut(7, 4)); //Prints: 840

    }

    /**
     * Problem #2
     * Prints numbers from 1 to n(inclusive).
     * @param n Number to print
     */
    public static void writeNums(int n){
        if(n < 1){
            throw new IllegalArgumentException("n must be greater than one"); //Throw argument is n is less than 1
        } else if(n == 1){
            System.out.print(n); //prints last number (1) and exits method.
            return;
        }
        writeNums(n-1); //recursion
        System.out.print(", " + n); //prints number with comma in front. This print statement will be placed in a stack until recursion is done.
    }

    /**
     * Problem #5
     * Prints n as it's binary representation.
     * @param n Number to be printed in binary.
     */
    public static void writeBinary(int n){
        if(n == 0){ //if reached end of number, exit recursion.
            return;
        }
        writeBinary(n/2); //next digit
        System.out.print(n%2); //prints number. This print statement will be placed in a stack until recursion is done.
    }

    /**
     * Problem #8
     * Multiples the first n even integers.
     * @param n Number of first even integers to multiple by.
     */
    public static int multiplyEvens(int n){
        if(n <= 0){ //if invalid input, throw exception.
            throw new IllegalArgumentException("n must be great than 0");
        } else if(n == 1){ //if there is one even number left, just return two and exit recursion
            return 2;
        }
        return n*2 * multiplyEvens(n-1); //multiple by the current event number and call the next.
    }

    /**
     * Problem #8
     * Repeats a String n numbers of times.
     * @param s Text to be repeated
     * @param n Number of timess to be repeated
     * @return The String of repeated text
     */
    public static String repeat(String s, int n){
        if(n == 1){ //If one repeat left, just return the string and exit recursion
            return s;
        }
        return(s + repeat(s, n-1)); //adds repeats to return string
    }

    /**
     * Problem #15
     * Calculates number of permutations.
     * @param n Group of items
     * @param r Number of Items
     * @return number of permutations
     */
    public static int permut(int n, int r){
        if (r == 1){ //if reach end of factorial, return n to end recursion.
            return n;
        }
        return n * permut(n-1, r-1); //multiple current n and call next number.
    }
}
