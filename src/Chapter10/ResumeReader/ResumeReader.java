package Chapter10.ResumeReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ResumeReader {

    public static ArrayList<String[]> score = new ArrayList<>();

    public static void main(String[] args) throws java.io.FileNotFoundException{

        File ignoreFile = new File("E:\\Programming\\IntelliJ Projects\\CS 211\\src\\Chapter10\\ResumeReader\\ignore.txt");
        File keywordsFile = new File("E:\\Programming\\IntelliJ Projects\\CS 211\\src\\Chapter10\\ResumeReader\\keywords.txt");
        File[] resume = new File("E:\\Programming\\IntelliJ Projects\\CS 211\\src\\Chapter10\\ResumeReader\\Resume").listFiles();


        ArrayList<String> ignoreList = new ArrayList<>();
        ArrayList<String> keywordsList = new ArrayList<>();

        addToArrayList(ignoreFile, ignoreList);
        addToArrayList(keywordsFile, keywordsList);

        for(File currentResume : resume) {

            int currentScore = 0;

            Scanner scan = new Scanner(currentResume);
            String name = scan.nextLine();
            while (scan.hasNext()) {
                String current = scan.next();
                if (keywordsList.contains(current)){
                    currentScore++;
                }
            }

            score.add(new String[]{name, Integer.toString(currentScore)});
        }

        print();
    }

    public static void addToArrayList(File file, ArrayList list) throws java.io.FileNotFoundException{
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            list.add(scan.nextLine());
        }
    }

    public static void print(){
        for(String[] person : score){
            System.out.println(person[0] + ": " + person[1]);
        }
    }
}
