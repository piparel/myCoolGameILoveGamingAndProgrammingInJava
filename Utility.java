public class Utility {
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
}
