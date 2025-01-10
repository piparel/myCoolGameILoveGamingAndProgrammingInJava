public class EnemyTypes extends Enemy{
   public static Enemy rat(String enemyClass) {
    return new Enemy("rat",
        10,
        0,
        2,
        10,
        5,
        enemyClass
    );
   }




   public static Enemy skeleton(String enemyClass) {
    return new Enemy("skeleton",
        50, 
    2, 
    5, 
    10, 
    7, 
    enemyClass
    );
   }

   public static Enemy slime(String enemyClass) {
    return new Enemy("slime",
        30, 
    0, 
    6, 
    5, 
    10, 
enemyClass
    );
   }

   public static Enemy darkWizard() {
    return new Enemy("Dark wizard", 30, 
    0, 
    15, 
    10, 
    2, 
    "mage"
    );
   }
}
