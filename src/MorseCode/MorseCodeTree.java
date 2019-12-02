package MorseCode;


public class MorseCodeTree {

    private MorseCodeTreeNode overallRoot;

    public MorseCodeTree() {
        overallRoot = buildTree(1, 63);
        fillTree();
        this.printSideways();
    }

    private void fillTree(){
        this.add("a", ".-");
        this.add("b", "-...");
        this.add("c",  "-.-");
        this.add("d",  "-..");
        this.add("e",    ".");
        this.add("f", "..-.");
        this.add("g",  "--.");
        this.add("h", "....");
        this.add("i",   "..");
        this.add("j", ".---");
        this.add("k",   "-.");
        this.add("l", ".-..");
        this.add("m",   "--");
        this.add("n",   "-.");
        this.add("o",  "---");
        this.add("p", ".--.");
        this.add("q", "--.-");
        this.add("r", ".-.");
        this.add("s",  "...");
        this.add("t",   "-");
        this.add("u",  "..-");
        this.add("v", "...-");
        this.add("w",  ".--");
        this.add("x", "-..-");
        this.add("y", "-.--");
        this.add("z", "--..");
        this.add("1", ".----");
        this.add("2","..---");
        this.add("3", "...--");
        this.add("4", "....-");
        this.add("5", ".....");
        this.add("6", "-....");
        this.add("7", "--...");
        this.add("8", "---..");
        this.add("9", "----.");
        this.add("0", "-----");
    }

    public String decode(String code){
        String[] codeSections = code.split(" ");
        String result = "";

        for(int k = 0; k < codeSections.length; k++) {
            MorseCodeTreeNode current = overallRoot;

            for (int i = 0; i < codeSections[k].length(); i++) {
                if (codeSections[k].substring(i, i + 1).equals(".")) {
                    current = current.left;
                } else if (codeSections[k].substring(i, i + 1).equals("-")) {
                    current = current.right;
                }

            }

            result += current.english;
        }

        return result;
    }


    public String encode(String english){
        String result = "";
        for(int i = 0; i < english.length(); i++){
            String letter = english.substring(i, i+1).toUpperCase();
            result += encode(overallRoot.left, letter) + encode(overallRoot.right, letter);
            if(i != english.length()-1){
                result += " ";
            }
        }
        return result;
    }
    private String encode(MorseCodeTreeNode root, String english){
        if(root.english != null && root.english.equals(english)){
            return root.code;
        } else{
            String letter = "";
            if(root.left != null){
                letter += encode(root.left, english);
            }
            if(root.right != null){
                letter += encode(root.right, english);
            }
            return letter;
        }
    }


    private void add(String english, String code){
        int pos = 0;
        MorseCodeTreeNode current = overallRoot;

        while(pos < code.length()){
            if(code.substring(pos, pos+1).equals(".")){
                current = current.left;
            } else if(code.substring(pos, pos+1).equals("-")){
                current = current.right;
            }

            pos++;
        }

        current.english = english.toUpperCase();
        current.code = code;
        //System.out.println("added:\t" + english + "|" + code);
    }


    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(MorseCodeTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.english + "|" + root.code);
            printSideways(root.left, level + 1);
        }
    }



    private MorseCodeTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new MorseCodeTreeNode(null, null, buildTree(2 * n, max), buildTree(2 * n + 1, max));
        }
    }






    private class MorseCodeTreeNode {
        public String english;
        public String code;
        public MorseCodeTreeNode left;
        public MorseCodeTreeNode right;

        // constructs a leaf node with given data
        public MorseCodeTreeNode(String english, String code) {
            this(english, code, null, null);
        }

        // constructs a branch node with given data, left subtree,
        // right subtree
        public MorseCodeTreeNode(String english, String code, MorseCodeTreeNode left, MorseCodeTreeNode right) {
            this.english = english;
            this.code = code;
            this.left = left;
            this.right = right;
        }
    }
}
