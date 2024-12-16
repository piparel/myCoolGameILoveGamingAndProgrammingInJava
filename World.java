import java.util.Random;

public class World {
    private static final int SIZE = 24;
    private String[][] map = new String[SIZE + 1][SIZE + 1];


    private void initializeMap() {
        for (int x = 0; x <= SIZE; x++) {
            for (int y = 0; y <= SIZE; y++) {
                map[x][y] = "■";
            }
        }
        for (String[] row : map) {
            System.out.println(String.join("  ", row));
        }
    }

    private void generateMap(){
        initializeMap();
        boolean builderSpawned = false;
        boolean orthogonalAllowed = false;
        int builderMoveDirection = 0;
        int allocatedBlocks = 0;
        int rootX = SIZE/2; int rootY = SIZE/2;
        int stepped = 0;

        while(allocatedBlocks<((SIZE * SIZE)/ 8)){
            if (builderSpawned == false){
                int cx = 2 + Math.floor(Math.random()* SIZE - 2);
                int cy = 2 + Math.floor(Math.random()* SIZE - 2);

                if (Math.abs(rootX - cx) <= 0 && Math.abs(rootY - cy) <= 0) {
                    if (map[cx][cy] != "■") {
                        map[cx][cy] = "·";
                        allocatedBlocks++;
                    } // end if
                } else {
                    builderSpawned = true;
                    Random random = new Random();
                    builderMoveDirection = random.nextInt(8);
                    stepped = 0;
                }
            }
        }
    }


    

    public static void main(String[] args) {
        World map = new World();
        map.initializeMap();
    }
}
