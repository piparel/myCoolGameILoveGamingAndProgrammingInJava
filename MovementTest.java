public class MovementTest {
    public static void main(String[] args) {
        World map = new World();
        map.generateMap();
        map.getMap();

        while (true){
            map.move();
            map.getMap();

            System.out.println(map.getPlayerPosX());
            System.out.println(map.getPlayerPosY());
        }
        
    }
}