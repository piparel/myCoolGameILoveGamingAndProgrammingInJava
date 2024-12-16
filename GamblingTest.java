import java.util.Scanner;

public class GamblingTest {
    public static void main(String[] args) {
    SlotMachine slots = new SlotMachine();
    Scanner scanner = new Scanner(System.in);
    int myCoins = 10000;

    for (; ;) {
        System.out.println("Your balance: " + myCoins);
        System.out.println("Would you like to gamble? [y]es/[y]es");
        String answer = scanner.nextLine();

        if (answer.equals("y")) {
            myCoins -= 10;
            myCoins = myCoins + slots.roll();
        }

        else {
            System.out.println("Wrong answer >:(");
        }

    }

    }
}