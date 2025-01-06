import java.util.Random;

public class World {
    private static final int SIZE = 24;
    private String[][] map = new String[SIZE + 1][SIZE + 1];
    Random random = new Random();

    private void initializeMap() {
        for (int x = 0; x <= SIZE; x++) {
            for (int y = 0; y <= SIZE; y++) {
                map[x][y] = "■";
            }
        }
    }

    private void generateMap(){
        initializeMap();
        boolean builderSpawned = false;
        boolean shopPlaced = false;
        boolean pondPlaced = false;
        boolean casinoPlaced = false;
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

        for (String[] row : map) {
            System.out.println(String.join("  ", row));
        }
    }

    public static void main(String[] args) {
        World map = new World();
        map.generateMap();
    }
}
