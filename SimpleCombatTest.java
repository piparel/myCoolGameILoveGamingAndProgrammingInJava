
public class SimpleCombatTest {
    public static void main(String[] args) {
        Character testCharacter = new Character(100, 5, 40, 0, 0, 10, 0);

        testCharacter.setName("AcetylCholin");
        testCharacter.setClass("archer");
        testCharacter.fish();

        Enemy testEnemy = new Enemy();
        testEnemy.setName("Zwombie");

        Combat.fight(testCharacter, testEnemy);

        Enemy[] stuffToFight = new Enemy[3];
        Enemy rat1 = EnemyTypes.rat("warrior");
        Enemy rangedRat = EnemyTypes.rat("archer");
        Enemy wiz = EnemyTypes.darkWizard();

        stuffToFight[0] = rat1;
        stuffToFight[1] = rangedRat;
        stuffToFight[2] = wiz;

        for (int i = 0; i<stuffToFight.length; i++) {
            Combat.fight(testCharacter, stuffToFight[i]);
        }

        
    }
}
