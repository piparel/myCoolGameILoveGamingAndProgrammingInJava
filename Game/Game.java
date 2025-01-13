package Game;
public class Game {

    public static void main(String[] args){
        Character player = new Character(); 
            
        System.out.println("The brave " + player.getCharacterClass()+ " " + player.getName() + " ventures to write his own legacy");
        player.createCharacterFile();
    }
}
