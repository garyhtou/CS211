package MorseCode;

public class MorseCodeClient {

    public static void main(String args[]) {

        MorseCodeTree tree = new MorseCodeTree();

        System.out.println(tree.decode(".... . .-.. .-.. ---"));
        System.out.println(tree.encode("world"));

    }
}
