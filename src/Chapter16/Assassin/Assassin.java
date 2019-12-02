package Chapter16.Assassin;

import java.io.*;
import java.util.Iterator;

public class Assassin {

    private LinkedList<String> killRing = new LinkedList<>();
    private LinkedList<String> graveyard = new LinkedList<>();

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Joe");
        names.add("Sally");
        names.add("Jim");
        names.add("Carol");
        names.add("Chris");

        Assassin game = new Assassin(null);
        game.setPlayers(names);

        System.out.println(game.killRing);
        game.kill("Jim");
        System.out.println(game.killRing);

    }

    public Assassin(File file){
        this.importPlayers(file);
    }

    private void importPlayers(File file){
        if(file == null){
            return;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String name;
            while((name = reader.readLine()) != null){
                killRing.add((int)Math.random()*killRing.size(), name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setPlayers(LinkedList<String> names){
        Iterator<String> it = names.iterator();
        while(it.hasNext()){
            killRing.add((int)Math.random()*killRing.size(), it.next());
        }
    }
    public void kill(String name){
        int index = killRing.indexOf(name);
        killRing.remove(index);
        graveyard.add(name);
    }
    public void printGraveyard(){
        System.out.println(this.graveyard);
    }
}
