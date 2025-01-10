import java.util.Scanner;
import java.util.Random;

public class Combat {
   public static void fight(Character player, Enemy enemy) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean done = false;
        boolean invalidInput = true;

        int counter = 0;
        String winner;

        String first = "player";

        if (enemy.getAgility() > player.getAgility()) { 
            counter = 1;
        } else if (player.getAgility() > enemy.getAgility()) {
            counter = 0;
        }

        else {
            //random start
            int randomNumber = random.nextInt(2);
            counter = randomNumber;
            
        }

        if (counter == 1) {
            first = "enemy";
        }


        Utility.printInDoubleBox("STARTING EPIC FIGHT!!!!");
        System.out.println(first + " Starts");

        while (!done) {

                if (player.getHealth() <= 0 || enemy.getHealth() <= 0) {
                    if (enemy.getHealth() <= 0) {
                        return;
                    }
                    else {
                        Utility.printInDoubleBox("YOU DIED in a text game :skull:");
                    }
                    break;
                }
            if (counter ==0) {
                Utility.printHealthbar(player.getHealth(), player.getMaxHealth(), player.getName());
                counter = 1;
                while (invalidInput) {
                    System.out.println("[f]ight or try to [r]un");
                    System.out.println("[e] open Inventory");
                    String playerInput = scanner.nextLine();
                    if (playerInput.equals("r")) {
                        Utility.clearScreen();
                        done = player.run();
                        break;
                    }
                        

                    else if (playerInput.equals("f")) {
                        player.attack(enemy);
                        System.out.println();
                        scanner.nextLine();
                        Utility.clearScreen();
                        
                        break;
                    }

                    else if (playerInput.equals("e")) {
                        player.openInventory();
                        counter = 3;
                        break;
                    }

                }
            }

            else if (counter == 1) {
                counter = 0;
                enemy.attack(player);
                Utility.printHealthbar(enemy.getHealth(), enemy.getMaxHealth(), enemy.getName());
                System.out.println();
            }
            else if (counter == 3) {
                counter =1;
            }
        }

        System.out.println("The fight is done :D");
    }
}
