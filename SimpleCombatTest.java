import java.util.Scanner;
import java.util.Random;

public class SimpleCombatTest {
    public static void main(String[] args) {
        Character testCharacter = new Character(10, 5, 15, 0, 0, 1, 0);

        testCharacter.setName("AcetylCholin");
        testCharacter.fish();

        Enemy testEnemy = new Enemy(100, 10, 10, 2, 3, "warrior");
        testEnemy.setName("Zwombie");

        Combat.fight(testCharacter, testEnemy);
    }
}
