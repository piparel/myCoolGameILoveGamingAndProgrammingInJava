import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Character {

    Scanner scanner = new Scanner(System.in);  

    private String name;
    private String characterClass; 

    private int health;
    private int armor;
    private int strength;
    private int agility;
    private int luck;

    private double critrate;
    private static Random critRandom = new Random();

    private int coins;

    public Character() {
        this.name = assignName();
        Utility.clearScreen();
        this.characterClass = assignCharacterClass();
        Utility.clearScreen();

        assignHealth();
        assignArmor();
        assignStrength();
        assignAgility();
        assignLuck();
        assignCritrate();
        this.coins = 0;
    }

    // TODO Setters
    public Character( int health, int armor, int strength, int agility, int luck, double critrate, int coins) {
        this.health = health;
        this.armor = armor;
        this.strength = strength;
        this.agility = agility;
        this.luck = luck;
        this.critrate = critrate;
        this.coins = coins;

    }

    public String assignName(){
        System.out.println("Whose legacy will be told? :");
        return scanner.nextLine();
    }

    public String assignCharacterClass(){

        String[] classes = {"warrior", "mage", "archer"};

        boolean chosen = false;
        String chosenClass = "";

        while (chosen == false){

            System.out.println("Which class are you? :");
            System.out.println("[warrior], [mage], [archer]");
            chosenClass = scanner.nextLine();

            if(Arrays.asList(classes).contains(chosenClass)){
                chosen = true;
            }
            else{
                Utility.clearScreen();
                System.out.println("That is NOT a valid class!");
            }
        }
        return chosenClass;
    }

    public void assignHealth(){
        System.out.println(this.characterClass);
        switch(characterClass){
            case "warrior":
            this.health = 6;
            break;

            case "mage":
            this.health = 4;
            break;

            case "archer":
            this.health = 3;
            break;
        }
    }

    public void assignArmor(){
        switch(characterClass){
            case "warrior":
            this.armor = 3;
            break;

            case "mage":
            this.armor = 0;
            break;

            case "archer":
            this.armor = 1;
            break;
        }
    }

    public void assignStrength(){
        switch(characterClass){
            case "warrior":
            this.strength = 4;
            break;

            case "mage":
            this.strength = 5;
            break;

            case "archer":
            this.strength = 3;
            break;
        }
    }

    public void assignAgility(){
        switch(characterClass){
            case "warrior":
            this.agility = 0;
            break;

            case "mage":
            this.agility = 1;
            break;

            case "archer":
            this.agility = 3;
            break;
        }
    }

    public void assignLuck(){
        switch(characterClass){
            case "warrior":
            this.luck = 0;
            break;

            case "mage":
            this.luck = 2;
            break;

            case "archer":
            this.luck = 1;
            break;
        }
    }

    public void assignCritrate(){
        switch(characterClass){
            case "warrior":
            this.critrate = 2.0;
            break;

            case "mage":
            this.critrate = 0.0;
            break;

            case "archer":
            this.critrate = 5.0;
            break;
        }
    }

    public void createCharacterFile() {

        try{
            FileWriter file = new FileWriter("Characters/" + name + ".csv");
            file.write(name + ","+ characterClass + "," + health + "," + armor + "," + strength + "," + agility + "," + luck+ "," + critrate + "," + coins);
            file.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
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

    public void increaseLuck(int x){
        this.luck += x;
    }

    public void decreaseLuck(int x){
        this.luck -= x;
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
    public int getArmor(){
        return armor;
    }
    public int getStrength(){
        return strength;
    }
    public int getAgility(){
        return agility;
    }
    public int getLuck(){
        return luck;
    }
    public double getCritrate(){
        return critrate;
    }
    public int getCoins(){
        return coins;
    }

    public void attack(Enemy enemy) {
        boolean successfulCrit = false;

        // check for random crit
        double randomNumber = critRandom.nextInt(101);
        if (randomNumber < critrate) {
            successfulCrit = true;
        }

        int finalHit = strength - enemy.getArmor();
        if (successfulCrit) { 
            finalHit *= 2;
        }
        enemy.decreaseHealth(finalHit);
    }

}





