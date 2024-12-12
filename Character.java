import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Character {

    private String name;
    private String cClass; 
    Scanner scanner = new Scanner(System.in);  


    public Character() {
        this.name = assignName();
        Utility.clearScreen();
        this.cClass = assigncClass();
        Utility.clearScreen();
    }

    public String assignName(){
        System.out.println("Whose legacy will be told? :");
        return scanner.nextLine();
    }

    public String assigncClass(){

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

    public String getcClass(){
        return cClass;
    }
    public String getName(){
        return name;
    }
}


