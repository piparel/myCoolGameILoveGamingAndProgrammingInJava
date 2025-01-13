package Game;
import java.util.Random;

public class SlotMachine {
    private Random rand = new Random(); 
    int lossStreak = 0;

    public int roll(int inputMoney) {
        String[] symbolStrings = {"§", "█", "¤", "©"};
        int[] chosenSymbols = new int[3];
        int symbolStringsLength = symbolStrings.length;

        // totally fair Gambling
        for (int i = 0; i < 3; i++) {
            chosenSymbols[i] = rand.nextInt(symbolStringsLength);
        }

        // if you won fair and square set LossStreak to 0
        // if your lossStreak is 3, then win (pity system)
        if ((chosenSymbols[0] == chosenSymbols[1] && chosenSymbols[1] == chosenSymbols[2]) || lossStreak == 3) {
            System.out.println(symbolStrings[chosenSymbols[0]] + " " + symbolStrings[chosenSymbols[0]] +" "+ symbolStrings[chosenSymbols[0]]);
            lossStreak = 0;
            return 6*inputMoney;
        }

        else {
            // if you didn't win, 50% chance to add 1 to the loss streak
            lossStreak += rand.nextInt(1);
            System.out.println(symbolStrings[chosenSymbols[0]] + " " + symbolStrings[chosenSymbols[1]] +" "+ symbolStrings[chosenSymbols[2]]);
        }

        return 0;
   }
}

// slot machines
