package Tests;
import java.util.Scanner;

import Game.Fish;
import Game.Inventory;
import Game.Utility;
import Game.World;

public class MovementTest {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Scanner scanner = new Scanner(System.in);
        World map = new World();

        map.generateMap();
        map.getMap();

        int pondx = map.getPondX();
        int pondy = map.getPondY();

        while (true){
            map.getMap();
            map.move();

            int playerx = map.getPlayerPosX();
            int playery = map.getPlayerPosY();



            System.out.println("Pond at: " + pondx + " " + pondy);
            System.out.println("player at: " + playerx + " " + playery);

            if (playerx == pondx && playery == pondy) {
                // may pack this into a function in future.. would look cleaner
                Utility.printInDoubleBox("funny water goes blubblub");
                String userInput = "";

                while (true) {
                    System.out.println("Would you like to [f]ish, [i]nventory or [r]eturn to map?");
                    userInput = scanner.nextLine();
                    if (userInput.equals("f")) {
                        Fish.catchFish(inv);
                    }

                    else if (userInput.equals("i")) {
                        inv.openInventory();
                    }

                    else if (userInput.equals("r")) {
                        break;
                    }

                } 
            }

        }
        
    }
}