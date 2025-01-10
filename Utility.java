import java.util.Random;

public class Utility {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static Random random = new Random();


    public static String colorText(String text, String color) {
        return color + text + ANSI_RESET;
    }

    public static void clearScreen(){
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }  

    public static void printInSimpleBox(String text) {
        // print text in box
        int textLength = text.length();

        // first row
        System.out.print("┌");
        for (int i = 0; i < textLength; i++) {
            System.out.print("─");
        }
        System.out.print("┐\n");

        // second row with text 
        System.out.println("│" + text + "│");

        // closing row
        System.out.print("└");
        for (int i = 0; i < textLength; i++) {
            System.out.print("─");
        }
        System.out.print("┘\n");
    }

    public static void printInDoubleBox(String text) {
        // print text in box
        int textLength = text.length();

        // first row
        System.out.print("╔");
        for (int i = 0; i < textLength; i++) {
            System.out.print("═");
        }
        System.out.print("╗\n");

        // second row with text 
        System.out.println("║" + text + "║");

        // closing row
        System.out.print("╚");
        for (int i = 0; i < textLength; i++) {
            System.out.print("═");
        }
        System.out.print("╝\n");
    }

    public static void printHealthbar(int health, int maxHealth, String name) {
        String healthbar = "";
        String healthColor = ANSI_GREEN;
        double ratio = (double) health/maxHealth;

        if (ratio > 0.66) {
            healthColor = ANSI_GREEN;
        }
        else if (ratio > 0.33) {
            healthColor = ANSI_YELLOW;
        }
        else {
            healthColor = ANSI_RED;
        }

        int lostHealth = maxHealth-health;

        System.out.println( name + " HEALTH: " + health + " / " + maxHealth);
        for (int i=0; i<health; i++) {
            healthbar += "█";
        }
        for (int i =0; i<lostHealth; i++) {
            healthbar += "_";
        }
        healthbar = colorText(healthbar, healthColor);
        healthbar = "|" + healthbar + "|";

        System.out.println(healthbar);


    }

    public static boolean rollNumber(int probability) {
        return random.nextInt(1, 101) <= probability;
    }
}
