//package MorseCode;
//
//import Chapter17.Assignment8.IntTreeNode;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class OLDMorseCodeTree {
//
//    private MorseCodeTreeNode root;
//
//    public OLDMorseCodeTree(){
//        root = buildTree(1, 63);
//
//        this.add("root", "");
//
//        this.add("a", ".-");
//        this.add("b", "-...");
//        this.add("c",  "-.-");
//        this.add("d",  "-..");
//        this.add("e",    ".");
//        this.add("f", "..-.");
//        this.add("g",  "--.");
//        this.add("h", "....");
//        this.add("i",   "..");
//        this.add("j", ".---");
//        this.add("k",   "-.");
//        this.add("l", ".-..");
//        this.add("m",   "--");
//        this.add("n",   "-.");
//        this.add("o",  "---");
//        this.add("p", ".--.");
//        this.add("q", "--.-");
//        this.add("r", ".-.");
//        this.add("s",  "...");
//        this.add("t",   "-");
//        this.add("u",  "..-");
//        this.add("v", "...-");
//        this.add("w",  ".--");
//        this.add("x", "-..-");
//        this.add("y", "-.--");
//        this.add("z", "--..");
//        this.add("1", ".----");
//        this.add("2","..---");
//        this.add("3", "...--");
//        this.add("4", "....-");
//        this.add("5", ".....");
//        this.add("6", "-....");
//        this.add("7", "--...");
//        this.add("8", "---..");
//        this.add("9", "----.");
//        this.add("0", "-----");
//
//
//    }
//
//
//
//    private MorseCodeTreeNode buildTree(int n, int max) {
//        if (n > max) {
//            return null;
//        } else {
//            return new MorseCodeTreeNode(null, null, buildTree(2 * n, max), buildTree(2 * n + 1, max), null);
//        }
//    }
//
//    public void add(String english, String code){
//        if(root == null){
//            root = new MorseCodeTreeNode(english, code, null);
//        } else{
//            MorseCodeTreeNode current = root;
//            int pos = 0;
//            while(current != null){
//                if(code.substring(pos, pos+1).equals(".")){
//                    if (current.left == null) {
//                        current.setLeft(new MorseCodeTreeNode(english, code, current.previous));
//                        break;
//                    } else{
//                        current = current.left;
//                    }
//                } else if(code.substring(pos, pos+1).equals("-")){
//                    if (current.right == null) {
//                        current.setRight(new MorseCodeTreeNode(english, code, current.previous));
//                    } else{
//                        current = current.right;
//                        break;
//                    }
//                }
//                pos++;
//            }
//        }
//    }
//
//
//    private class MorseCodeTreeNode{
//        private String code;
//        private String english;
//        private MorseCodeTreeNode previous;
//        private MorseCodeTreeNode left;
//        private MorseCodeTreeNode right;
//
//        public MorseCodeTreeNode(String english, String code, MorseCodeTreeNode previous, MorseCodeTreeNode left, MorseCodeTreeNode right){
//            this.code = code;
//            this.english = english;
//            this.previous = previous;
//            this.left = left;
//            this.right = right;
//        }
//
//        public void setLeft(MorseCodeTreeNode node){
//            this.left = node;
//        }
//        public void setRight(MorseCodeTreeNode node){
//            this.right = node;
//        }
//
//        public String getCode(){
//            return code;
//        }
//        public String getEnglish(){
//            return english;
//        }
//    }
//}
