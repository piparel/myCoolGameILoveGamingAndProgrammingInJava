import java.util.Random;

public class Enemy {
    private String name;
    private String characterClass; 

    private int health;
    private final int maxHealth;
    private int armor;
    private int strength;
    private int agility;
    private double critrate;
    private String enemyClass;

    private static Random critRandom = new Random();

    // TODO proper setters
    public Enemy(int health, int armor, int strength, int agility, double critrate, String enemyClass) {
        this.health = health;
        this.maxHealth = health;
        this.armor = armor;
        this.strength = strength;
        this.agility = agility;
        this.critrate = critrate;
        // cant use "class" because of java
        this.enemyClass = enemyClass;
    }

    public Enemy() {
        this(100, 0, 5, 0, 2, "warrior");
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

    public void attack(Character player) {
        boolean successfulCrit = false;

        // check for random crit
        double randomNumber = critRandom.nextInt(1, 101);
        if (randomNumber < critrate) {
            successfulCrit = true;
        }

        int finalHit = this.strength - player.getArmor();
        if (successfulCrit) { 
            finalHit *= 2;
        }
        player.decreaseHealth(finalHit);
    }

}
