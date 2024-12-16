import java.util.Random;

public class SlotMachine {
   private Random rand = new Random(); 

   public int roll() {
    String[] symbolStrings = {"§", "█", "¤", "©"};
    int[] chosenSymbols = new int[3];
    int symbolStringsLength = symbolStrings.length;

    for (int i = 0; i < 3; i++) {
        chosenSymbols[i] = rand.nextInt(symbolStringsLength);
    }

    System.out.println(symbolStrings[chosenSymbols[0]] + " " + symbolStrings[chosenSymbols[1]] +" "+ symbolStrings[chosenSymbols[2]]);
    if (chosenSymbols[0] == chosenSymbols[1] && chosenSymbols[1] == chosenSymbols[2]) {
        return 100;
    }
    return 0;
   }
}

// slot machines
