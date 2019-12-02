package MorseCode;

public class MorseCodeClient {

    public static void main(String args[]) {
        MorseCodeTree tree = new MorseCodeTree(); //creates Morse Code Binary Tree

        //test cases
        System.out.println(tree.decode(".... . .-.. .-.. ---")); //HELLO
        System.out.println(tree.encode("world")); //.-- --- .-. .-.. -..
        System.out.println(tree.decode(".--- .- ...- .- .. ... -.- --- --- .-..")); //JAVAISCOOL
        System.out.println(tree.encode("testing")); //- . ... - .. -. --.
        System.out.println(tree.decode("-.- --- -- .--. ..- - . .-. ... -.- .. . -. -.- .")); //COMPUTER SCIENCE
        System.out.println(tree.encode("project2")); //.--. .-. --- .--- . -.- - ..---
        System.out.println(tree.encode("1234567890")); //.---- ..--- ...-- ....- ..... -.... --... ---.. ----. -----
    }
}
