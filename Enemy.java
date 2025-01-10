import java.util.Random;

public class Enemy {
    private String name;
    private String characterClass; 

    private int health;
    private final int maxHealth;
    private int armor;
    private int strength;
    private int agility;
    private int critrate;
    private String enemyClass;
    private String weakness;
    private int minDmg;
    private int maxDmg;

    private static Random random = new Random();

    // TODO proper setters
    public Enemy(String enemyName, int health, int armor, int strength, int agility, int critrate, String enemyClass) {
        setName(enemyName);
        this.health = health;
        this.maxHealth = health;
        this.armor = armor;
        this.strength = strength;
        this.minDmg = (int) 0.8*this.strength;
        this.maxDmg = (int) 1.2*this.strength;
        this.agility = agility;
        this.critrate = critrate;
        // cant use "class" because of java
        this.enemyClass = enemyClass;
        if (this.enemyClass == "warrior") {
            this.weakness = "mage";
        } else if (this.enemyClass == "mage") {
            this.weakness = "archer";
        } else {
            this.weakness = "warrior";
        }
    }

    public Enemy() {
        this("testEnemy", 100, 0, 5, 0, 2, "warrior");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseHealth(int x){
        this.health += x;
    }

    public void decreaseHealth(int x){
        if (this.health - x <= 0){
            this.health = 0;
        }
        else{
            this.health -= x;
        }
    }

    public void increaseArmor(int x){
        this.armor += x;
    }

    public void decreaseArmor(int x){
        if (this.armor - x <= 0){
            this.armor = 0;
        }
        else{
            this.armor -= x;
        }
    }

    public void increaseStrength(int x){
        this.strength += x;
    }

    public void decreaseStrength(int x){
        if (this.strength - x <= 0){
            this.strength = 0;
        }
        else{
            this.strength -= x;
        }
    }

    public void increaseAgility(int x){
        this.agility += x;
    }

    public void decreaseAgility(int x){
        if (this.agility - x <= 0){
            this.agility = 0;
        }
        else{
            this.agility -= x;
        }
    }

    public void increaseCritrate(int x){
        this.critrate += x;
    }

    public void decreaseCritrate(int x){
        if (this.critrate - x <= 0){
            this.critrate = 0;
        }
        else{
            this.critrate -= x;
        }
    }

    public String getCharacterClass(){
        return characterClass;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getArmor(){
        return armor;
    }
    public int getStrength(){
        return strength;
    }
    public int getAgility(){
        return agility;
    }

    public double getCritrate(){
        return critrate;
    }

    public String getWeakness() {
        return this.weakness;
    }

    public void attack(Character player) {
        // check for random crit

        int finalHit = random.nextInt(minDmg, maxDmg);

        if (player.getWeakness() == this.characterClass) {
            finalHit *= 1.5;
            System.out.println("You are weak to this enemy");
        }

        if (Utility.rollNumber((int) critrate)) { 
            System.out.println("CRIT!");
            finalHit *= 2;
        }

        if (Utility.rollNumber(player.getAgility())) {
            System.out.println("The player dodged the attack!");
            finalHit = 0;
        }
        System.out.println("the enemy dealt " + finalHit + " damage!");
        player.decreaseHealth(finalHit);
    }

}
