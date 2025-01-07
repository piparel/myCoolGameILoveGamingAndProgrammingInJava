import java.util.Scanner;
import java.util.Random;

public class SimpleCombatTest {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random coinflip = new Random();
        boolean done = false;
        boolean invalidInput = true;

        int counter = 0;
        String winner;
        Character testCharacter = new Character(100, 5, 15, 0, 0, 1, 0);
        Enemy testEnemy = new Enemy(100, 10, 10, 2, 3);

        String first = "Player";

        if (testEnemy.getAgility() > testCharacter.getAgility()) { 
        } else if (testCharacter.getAgility() > testEnemy.getAgility()) {
            counter = 0;
        }

        else {
            int randomNumber = coinflip.nextInt(2);
            counter = randomNumber;
            
        }

        if (counter == 0) {
        first = "Player";
        }

        else {
            first = "Enemy";
        }

        Utility.printInDoubleBox("STARTING EPIC FIGHT!!!!");
        System.out.println(first + " Starts");

        while (!done) {

                if (testCharacter.getHealth() <= 0 || testEnemy.getHealth() <= 0) {
                    break;
                }
            if (counter ==0) {
                while (invalidInput) {
                    System.out.println("[f]ight or try to [r]un");
                    String playerInput = scanner.nextLine();
                    if (playerInput.equals("r")) {
                        if (coinflip.nextInt(2) == 1) {
                            done = true;
                        }

                        else {break;}
                    }
                        

                    else if (playerInput.equals("f")) {
                        testCharacter.attack(testEnemy);
                        System.out.println("The enemy has " + testEnemy.getHealth() + " health");
                        break;
                    }

                }
            }
        }

        System.out.println("The fight is done and you won :D");
    }
}
