import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Character {

    private String name;
    private String characterClass; 
    Scanner scanner = new Scanner(System.in);  

    public Character() {
        this.name = assignName();
        Utility.clearScreen();
        this.characterClass = assignCharacterClass();
        Utility.clearScreen();
        
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

    public String getCharacterClass(){
        return characterClass;
    }
    public String getName(){
        return name;
    }

    public void createCharacterFile() {

        int health;
        int armor;
        int strength;
        int agility;
        int luck;
        double critrate;

        int coins = 0;

        if (characterClass == "Warrior"){
            health = 6;
            armor = 2;
            strength = 4;
            agility = 0;
            luck = 0;
            critrate = 3;
        }
        else if (characterClass == "Mage"){
            health = 4;
            armor = 0;
            strength = 5;
            agility = 1;
            luck = 2;
            critrate = 0;
        }
        else{
            health = 4;
            armor = 1;
            strength = 3;
            agility = 3;
            luck = 1;
            critrate = 5;
        }
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
}




