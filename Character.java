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

        String[] classes = {"Warrior", "Mage", "Archer"};

        boolean chosen = false;
        String chosenClass = "";

        while (chosen == false){

            System.out.println("Which class are you? :");
            System.out.println("[Warrior], [Mage], [Archer]");
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

    public void createCharacterFile(){
        try{
            FileWriter file = new FileWriter(name + ".csv");
            file.write(name + ","+ characterClass);
            file.close();
        }   
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}




