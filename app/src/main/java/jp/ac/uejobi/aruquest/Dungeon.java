package jp.ac.uejobi.aruquest;

/**
 * Created by uejobi on 2018/10/25.
 */

public class Dungeon {
    static boolean buttonFlg = false;
    static int key = 0;
    static boolean glove = false;
    static int pendant = 0;
    static boolean lantern = false;
    static int candle = 0;
    static boolean record = false;
    static int button = 0;
    static int floor = 0;
    static int enemyID;
    static int[][] mapArray;
    //int[][] mapArraySample = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,0,3,1,1,0,0,0,0,0,0,1,0,1},{1,1,0,1,0,3,0,1,1,1,1,0,1,0,1},{1,1,0,1,0,1,1,0,0,0,0,0,1,0,1},{1,1,2,0,0,1,1,1,1,0,1,1,0,0,1},{1,1,0,0,1,1,1,0,1,0,1,0,0,0,1},{1,0,1,0,0,1,1,0,0,0,0,1,1,0,1},{1,0,1,1,0,0,1,0,1,1,0,0,0,0,1},{1,0,0,0,1,0,1,1,0,0,1,1,1,0,1},{1,1,1,0,1,0,0,0,1,0,0,0,0,0,1},{1,0,1,1,0,0,1,0,0,0,0,0,0,0,1},{1,0,1,0,1,1,0,0,0,0,0,1,1,0,1},{1,0,1,0,0,0,0,1,1,1,0,0,1,2,1},{1,0,1,0,1,0,0,0,0,1,0,0,0,1,1},{1,2,1,0,1,0,1,0,0,0,1,1,1,0,1},{1,0,0,0,1,0,1,1,1,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    //int[] charPosSample = {4,4};

    static Data data = new Data();
    static DataBlock1 dataBlock1 = new DataBlock1();
    static DataBlock2 dataBlock2 = new DataBlock2();
    static DataBlock3 dataBlock3 = new DataBlock3();
    static DataBlock4 dataBlock4 = new DataBlock4();
    static DataBlock5 dataBlock5 = new DataBlock5();
    static DataBlock6 dataBlock6 = new DataBlock6();

    public static void incrementFloor(){
        floor++;
        key = 0;
        if(DungeonActivity.dungeonID < 5) {
            mapArray = dataBlock1.blockidR(DungeonActivity.dungeonID, floor);
        }else if(DungeonActivity.dungeonID < 8){
            mapArray = dataBlock2.blockidR(DungeonActivity.dungeonID, floor);
        }else if(DungeonActivity.dungeonID < 11){
            mapArray = dataBlock3.blockidR(DungeonActivity.dungeonID, floor);
        }else if(DungeonActivity.dungeonID < 13){
            mapArray = dataBlock4.blockidR(DungeonActivity.dungeonID, floor);
        }else if(DungeonActivity.dungeonID < 15){
            mapArray = dataBlock5.blockidR(DungeonActivity.dungeonID, floor);
        }else if(DungeonActivity.dungeonID < 16){
            mapArray = dataBlock6.blockidR(DungeonActivity.dungeonID, floor);
        }
        DrawMap.charPos[0] = Integer.parseInt(data.danjonJouhouR(DungeonActivity.dungeonID)[floor * 2 + 3]);
        DrawMap.charPos[1] = Integer.parseInt(data.danjonJouhouR(DungeonActivity.dungeonID)[floor * 2 + 4]);
    }

    public static void incrementKey() {
        key ++;
    }

    public static  boolean decrementKey(){
        if(key > 0) {
            key--;
            return true;
        }
        return false;
    }

    public static void chooseEnemy(){
        int ID = (int)(Math.random() * data.danjonTekiR(DungeonActivity.dungeonID).length);
        if(ID == 0){
            ID = (int)(Math.random() * data.danjonTekiR(DungeonActivity.dungeonID).length);
        }
        enemyID = Integer.parseInt(data.danjonTekiR(DungeonActivity.dungeonID)[ID]);
    }

    public static void setEmnemy(int enemyID){
        Dungeon.enemyID = enemyID;
    }

    public static int getKey() {
        return key;
    }
}
