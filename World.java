import java.util.Random;
import java.util.Scanner;

public class World {
    private static final int SIZE = 24;
    private String[][] map = new String[SIZE + 1][SIZE + 1];
    private int[] pondTile = new int[2];
    Random random = new Random();

    String savedPlace = "·";

    private int playerPosX;
    private int playerPosY; 

    public int getPondx() {
        return pondTile[0];
    }

    public int getPondy() {
        return pondTile[1];
    }

    private void initializeMap() {
        for (int x = 0; x <= SIZE; x++) {
            for (int y = 0; y <= SIZE; y++) {
                map[x][y] = "■";
            }
        }
    }

    public void generateMap(){
        initializeMap();
        boolean builderSpawned = false;
        boolean shopPlaced = false;
        boolean pondPlaced = false;
        boolean casinoPlaced = false;
        boolean player = false;

        int builderMoveDirection = 0;
        int allocatedBlocks = 0;
        int rootX = SIZE/2; int rootY = SIZE/2;
        int stepped = 0;


        int cx = 0;
        int cy = 0;

        while(allocatedBlocks<((SIZE * SIZE)/ 4)){
            if (builderSpawned == false){
                cx = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
                cy = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));

                if (Math.abs(rootX - cx) <= 0 && Math.abs(rootY - cy) <= 0) {
                    if (map[cx][cy] != "·") {
                        map[cx][cy] = "·";
                        allocatedBlocks++;
                    }
                } else {
                    builderSpawned = true;
                    Random random = new Random();
                    builderMoveDirection = random.nextInt(8);
                    stepped = 0;
                }
            }
            else {
					if (builderMoveDirection==0 && cy>0){cy--;stepped++;}
					else if (builderMoveDirection==1 && cx<SIZE){cx++;stepped++;}
					else if (builderMoveDirection==2 && cy<SIZE){cy++;stepped++;}
					else if (builderMoveDirection==3 && cx>0){cx++;stepped++;}
					else if (builderMoveDirection==4 && cx<SIZE && cy>0){cy--;cx++;stepped++;}
					else if (builderMoveDirection==5 && cx<SIZE && cy<SIZE){cy++;cx++;stepped++;}
					else if (builderMoveDirection==6 && cx>0 && cy<SIZE){cy++;cx--;stepped++;}
					else if (builderMoveDirection==7 && cx>0 && cy>0){cy--;cx--;stepped++;}

					if (cx<SIZE && cy<SIZE && cx>1 && cy>1 && stepped<=7){
					if (map[cx+1][cy]=="·"){if (map[cx][cy]!="·"){map[cx][cy]="·";allocatedBlocks++;}
					} else if (map[cx-1][cy]=="·"){if (map[cx][cy]!="·"){map[cx][cy]="·";allocatedBlocks++;} 
					} else if (map[cx][cy+1]=="·"){if (map[cx][cy]!="·"){map[cx][cy]="·";allocatedBlocks++;}
					} else if (map[cx][cy-1]=="·"){if (map[cx][cy]!="·"){map[cx][cy]="·";allocatedBlocks++;}
					}} else { builderSpawned=false;}
            }
        }

        //---Special places that spawn after map creation, only places them in valid spots---
        while (shopPlaced == false){
            cx = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
            cy = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
            if (map[cx][cy] == "·"){
                map[cx][cy] = "s";
                shopPlaced = true;
            }
        }
        while (pondPlaced == false){
            cx = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
            cy = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
            if (map[cx][cy] == "·"){
                map[cx][cy] = "p";
                pondTile[1] = cx;
                pondTile[0] = cy;
                pondPlaced = true;
            }
        }
        while (casinoPlaced == false){
            cx = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
            cy = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
            if (map[cx][cy] == "·"){
                map[cx][cy] = "c";
                casinoPlaced = true;
            } 
        }
        while (player == false){
            cx = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
            cy = 2 + (int) Math.floor(random.nextDouble() * (SIZE - 2));
            if (map[cx][cy] == "·"){
                map[cx][cy] = "¤";
                playerPosY = cx;
                playerPosX = cy;

                player = true;
            }
        }
        //-------------------------------------------------------------------------------------
    }
    public void getMap(){
        for (String[] row : map) {
            System.out.println(String.join(" ", row));
        }
    }
    public int getPlayerPosX(){
        return playerPosX;
    }
    public int getPlayerPosY(){
        return playerPosY;
    }

    public void move(){
        boolean canMoveUp = false;
        boolean canMoveDown = false;
        boolean canMoveRight = false;
        boolean canMoveLeft = false;
        boolean hasOptions = false;
        StringBuilder movementOptions = new StringBuilder("Where would you like to go, you can move ");

        Scanner scanner = new Scanner(System.in);

        if (map[playerPosY+1][playerPosX] !="■"){canMoveDown = true;}
        if (map[playerPosY-1][playerPosX] !="■"){canMoveUp = true;}
        if (map[playerPosY][playerPosX+1] !="■"){canMoveRight = true;}
        if (map[playerPosY][playerPosX-1] !="■"){canMoveLeft = true;}

        if (canMoveUp) {
            movementOptions.append("[u]p");
            hasOptions = true;
        }
        if (canMoveDown) {
            if (hasOptions) {movementOptions.append(", ");}
            movementOptions.append("[d]own");
            hasOptions = true;
        }
        if (canMoveRight) {
            if (hasOptions) {movementOptions.append(", ");}
            movementOptions.append("[r]ight");
            hasOptions = true;
        }
        if (canMoveLeft) {
            if (hasOptions) {movementOptions.append(", ");}
            movementOptions.append("[l]eft");
        }
        System.out.println(movementOptions);
        String direction = scanner.nextLine();

        if (canMoveUp && direction.equals("u")){
            map[playerPosY][playerPosX] = savedPlace;
            savedPlace = map[playerPosY-1][playerPosX];
            map[playerPosY-1][playerPosX] = "¤";

            playerPosY -= 1;
        }
        else if (canMoveDown && direction.equals("d")){
            map[playerPosY][playerPosX] = savedPlace;
            savedPlace = map[playerPosY+1][playerPosX];
            map[playerPosY+1][playerPosX] = "¤";

            playerPosY += 1;
        }
        else if (canMoveRight && direction.equals("r")){
            map[playerPosY][playerPosX] = savedPlace;
            savedPlace = map[playerPosY][playerPosX+1];
            map[playerPosY][playerPosX+1] = "¤";

            playerPosX += 1;
        }
        else if (canMoveLeft && direction.equals("l")){
            map[playerPosY][playerPosX] = savedPlace;
            savedPlace = map[playerPosY][playerPosX-1];
            map[playerPosY][playerPosX-1] = "¤";

            playerPosX -= 1;
        }
        else{
            System.out.println("NOT VALID BRO WTF smh");
        }
    }
}

