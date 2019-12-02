package MorseCode;

/**
 * Gary Tou
 * 12/1/2019
 * <p>
 * Encodes and decodes Morse Code using a binary tree.
 */
public class MorseCodeTree {
    private MorseCodeTreeNode overallRoot;

    private final String DOT = ".";
    private final String DASH = "-";

    /**
     * Create binary tree
     */
    public MorseCodeTree() {
        overallRoot = buildTree(1, 63); //Creates blank tree with 5 levels
        fillTree(); //fills tree with preset values
        //this.printSideways();
    }

    /**
     * Fill binary tree with values. A-Z and 0-9
     */
    private void fillTree() {
        this.add("a", ".-");
        this.add("b", "-...");
        this.add("c", "-.-");
        this.add("d", "-..");
        this.add("e", ".");
        this.add("f", "..-.");
        this.add("g", "--.");
        this.add("h", "....");
        this.add("i", "..");
        this.add("j", ".---");
        this.add("k", "-.");
        this.add("l", ".-..");
        this.add("m", "--");
        this.add("n", "-.");
        this.add("o", "---");
        this.add("p", ".--.");
        this.add("q", "--.-");
        this.add("r", ".-.");
        this.add("s", "...");
        this.add("t", "-");
        this.add("u", "..-");
        this.add("v", "...-");
        this.add("w", ".--");
        this.add("x", "-..-");
        this.add("y", "-.--");
        this.add("z", "--..");
        this.add("1", ".----");
        this.add("2", "..---");
        this.add("3", "...--");
        this.add("4", "....-");
        this.add("5", ".....");
        this.add("6", "-....");
        this.add("7", "--...");
        this.add("8", "---..");
        this.add("9", "----.");
        this.add("0", "-----");
    }

    /**
     * Decodes Morse Code into English
     *
     * @param code Morse Code text
     * @return English text
     */
    public String decode(String code) {
        String[] codeSections = code.split(" "); //splits up into letters
        String result = "";

        for (int k = 0; k < codeSections.length; k++) { //this loops processes each morse code letter at a time
            MorseCodeTreeNode current = overallRoot;

            for (int i = 0; i < codeSections[k].length(); i++) { //loops through letter's code. Goes to letter's location
                if (codeSections[k].substring(i, i + 1).equals(DOT)) {
                    current = current.left;
                } else if (codeSections[k].substring(i, i + 1).equals(DASH)) {
                    current = current.right;
                }

            }

            result += current.english; //adds the code's letter to variable which is returned
        }

        return result;
    }

    /**
     * Encodes English into Morse Code
     *
     * @param english English text
     * @return Morse Code text
     */
    public String encode(String english) {
        String result = "";
        for (int i = 0; i < english.length(); i++) { //for each letter
            String letter = english.substring(i, i + 1).toUpperCase(); //current letter
            result += encode(overallRoot.left, letter) + encode(overallRoot.right, letter); //goes to every node
            if (i != english.length() - 1) {
                result += " ";
            }
        }
        return result;
    }

    /**
     * Recursive Helper Method
     *
     * @param root    current root
     * @param english Letter which you're looking for
     * @return Morse Code equivalent of the letter
     */
    private String encode(MorseCodeTreeNode root, String english) {
        if (root.english != null && root.english.equals(english)) { //if english matches, return code. Else, keep traversing through all nodes
            return root.code;
        } else {
            String letter = "";
            if (root.left != null) {
                letter += encode(root.left, english); //traversing through all nodes
            }
            if (root.right != null) {
                letter += encode(root.right, english); //traversing through all nodes
            }
            return letter;
        }
    }

    /**
     * Adds new english/morse code to the binary tree
     *
     * @param english English text
     * @param code    Morse Code text
     */
    private void add(String english, String code) {
        int pos = 0;
        MorseCodeTreeNode current = overallRoot;

        while (pos < code.length()) { //goes to code's location within binary tree
            if (code.substring(pos, pos + 1).equals(DOT)) {
                current = current.left;
            } else if (code.substring(pos, pos + 1).equals(DASH)) {
                current = current.right;
            }

            pos++;
        }

        //once reached code's location, set english and code.
        current.english = english.toUpperCase();
        current.code = code;
        //System.out.println("added:\t" + english + "|" + code);
    }

    /**
     * Prints the morse code binary tree sideways
     */
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    /**
     * Recursive helper method
     *
     * @param root  current root
     * @param level current level
     */
    private void printSideways(MorseCodeTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1); //prints right side first (because it's on top)
            for (int i = 0; i < level; i++) {
                System.out.print("    "); //space between nodes
            }
            System.out.println(root.english + "|" + root.code); //prints english and code of each node
            printSideways(root.left, level + 1); //prints left side second
        }
    }

    /**
     * Morse Code binary tree builder
     *
     * @param n   current element
     * @param max max elements
     * @return
     */
    private MorseCodeTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null; //stop once reached desired number of nodes
        } else {
            return new MorseCodeTreeNode(null, null, buildTree(2 * n, max), buildTree(2 * n + 1, max)); //creates an empty binary tree
        }
    }


    /**
     * Morse Code binary tree Node
     */
    private class MorseCodeTreeNode {
        public String english; //english value
        public String code; //morse code value
        public MorseCodeTreeNode left;
        public MorseCodeTreeNode right;

        /**
         * Node constructor
         *
         * @param english English text
         * @param code    Morse Code text
         */
        public MorseCodeTreeNode(String english, String code) {
            this(english, code, null, null);
        }

        /**
         * Node Constructor
         *
         * @param english English text
         * @param code    Morse Code text
         * @param left    left node
         * @param right   right node
         */
        public MorseCodeTreeNode(String english, String code, MorseCodeTreeNode left, MorseCodeTreeNode right) {
            this.english = english;
            this.code = code;
            this.left = left;
            this.right = right;
        }
    }
}
