package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by uejobi on 2018/10/25.
 */

public class Object {
    MapFragment mapFragment = new MapFragment();
    Data data = new Data();
    Handler handler = new Handler();
    // オブジェクトIDによってオブジェクトクラスのメソッドを呼び出す
    public int objectTypeJudge(int objectID, int direction, View view){ // direction:0上,1下,2右,3左
        switch (objectID) {
            case 143:
                return key();
            case 141:
                return chest1();
            case 142:
                return emptyChest();
            case 302:
                return door();
            case 154:
                return floorWarp();
            case 155:
                return gate();
            case 158:
                return glove();
            case 161:
                return goddess();
            case 162:
                return goddess();
            case 163:
                return goddess();
            case 164:
                return goddess();
            case 165:
                return pendant();
            case 166:
                return pendant();
            case 167:
                return pendant();
            case 168:
                return lantern();
            case 169:
                return candle();
            case 182:
                return record();
            case 183:
                return gramophone();
            case 185:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 144){
                            Dungeon.mapArray[i][j] = 22;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
                return -1;
            case 186:
                return button();
            case 188:
                return chess(objectID, direction);
            case 189:
                return chess(objectID, direction);
            case 191:
                return chess(objectID, direction);
            case 192:
                return chess(objectID, direction);
            case 193:
                return chess(objectID, direction);
            case 194:
                return chess(objectID, direction);
            case 195:
                return chess(objectID, direction);
            case 196:
                return chess(objectID, direction);
            case 197:
                return chess(objectID, direction);
            case 198:
                return chess(objectID, direction);
            case 199:
                return chess(objectID, direction);
            case 211:
                return chess(objectID, direction);
            case 397:
                return chest2();
            case 396:
                return chest3();
            case 310:
                return chest4();
            case 398:
                return backHome(view);
            case 399:
                return gate2();
            case 400:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 351){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
                return -1;
            case 401:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 352){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
                return -1;
            case 402:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 353){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
                return -1;
            case 403:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 354){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
                return -1;
            case 404:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 355){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
                return -1;
            case 405:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 181){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
                return -1;
            case 548:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 34){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 528:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 529){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 529:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 528){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 531:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 532){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 532:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 531){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 533:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 534){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 535:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 536){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 536:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 535){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 537:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 538){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 538:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 537){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 539:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 541){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 541:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 539){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 542:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 543){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 543:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 542){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 544:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 545){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 545:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 544){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 546:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 547){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 547:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 546){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            case 549:
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 34){
                            DrawMap.charPos[0] = i;
                            DrawMap.charPos[1] = j;
                            return -1;
                        }
                    }
                }
                break;
            // ここからボス
            case 60:
                return -18;
            case 600:
                return -5;
            case 601:
                return -8;
            case 602:
                return -13;
            case 603:
                return -16;
            case 604:
                return -21;
            case 605:
                return -25;
            case 606:
                return -30;
            case 607:
                return -33;
            case 608:
                return -37;
            case 609:
                return -40;
            case 610:
                return -46;
            case 611:
                return -48;
            case 612:
                return -50;
            case 613:
                return -56;
            case 614:
                return -58;
            case 615:
                flower();
                return -59;
            case 616:
                flower();
                return -60;
            case 617:
                flower();
                return -61;
            case 618:
                flower();
                return -62;
            case 152:
                return -63;
            case 704:
                return -65;
            case 711:
                return -66;
            case 717:
                return -76;
            case 723:
                return -68;
            case 729:
                return -67;
            case 735:
                return -64;
            case 741:
                return -69;
            case 349:
                return transformBoss(view);
            case 756:
                return -70;
        }
        return -1;
    }

    public int onObjectTypeJudege(int objectID){
        switch (objectID){
            case 36:
                return chessButton();
            case 37:
                return chessButton();
        }
        return -1;
    }

    public int key(){
        Dungeon.incrementKey();
        String[][] msg = {{"カギ　を　てにいれた","これで　たからばこが　あけられるわね。"},{null,data.mikataR(0)[0]}};
        mapFragment.callMessageFragment(msg);
        return 0;
    }

    public int chest1(){
        if(Dungeon.decrementKey()) {
            int[] item = {0,1,4,5,10,20,21};
            int index = (int)(Math.random() * item.length);
            PlayerData.getItem(item[index]);
            String[][] msg = {{"たからばこを　あけた " + data.douguR(item[index])[0] +"　をてにいれた"},{null}};
            mapFragment.callMessageFragment(msg);
            return 142;
        }else{
            String[][] msg = {{"しかし　カギが　かかっている"},{null}};
            mapFragment.callMessageFragment(msg);
            return -1;
        }
    }

    public int chest2(){
        if(Dungeon.decrementKey()) {
            int[] item = {0,1,2,5,6,7,10,11,16,18,20,21,23,24};
            int index = (int)(Math.random() * item.length);
            PlayerData.getItem(item[index]);
            String[][] msg = {{"たからばこを　あけた " + data.douguR(item[index])[0] +"　をてにいれた"},{null}};
            mapFragment.callMessageFragment(msg);
            return 142;
        }else{
            String[][] msg = {{"しかし　カギが　かかっている"},{null}};
            mapFragment.callMessageFragment(msg);
            return -1;
        }
    }

    public int chest3(){
        if(Dungeon.decrementKey()) {
            int[] item = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
            int index = (int)(Math.random() * item.length);
            PlayerData.getItem(item[index]);
            String[][] msg = {{"たからばこを　あけた " + data.douguR(item[index])[0] +"　をてにいれた"},{null}};
            mapFragment.callMessageFragment(msg);
            return 142;
        }else{
            String[][] msg = {{"しかし　カギが　かかっている"},{null}};
            mapFragment.callMessageFragment(msg);
            return -1;
        }
    }

    public int chest4(){
        if(Dungeon.decrementKey()) {
            int[] item = {10,11,12,13};
            int index = (int)(Math.random() * item.length);
            PlayerData.getItem(item[index]);
            String[][] msg = {{"たからばこを　あけた " + data.douguR(item[index])[0] +"　をてにいれた"},{null}};
            mapFragment.callMessageFragment(msg);
            return 142;
        }else{
            String[][] msg = {{"しかし　カギが　かかっている"},{null}};
            mapFragment.callMessageFragment(msg);
            return -1;
        }
    }

    public int emptyChest(){
        String[][] msg = {{"しかし　からっぽだった","もうなにも　ないみたい。"},{null,data.mikataR(0)[0]}};
        mapFragment.callMessageFragment(msg);
        return 142;
    }

    public int gate(){
        for(int i = 0; i < Dungeon.mapArray.length; i++){
            for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                switch (Dungeon.mapArray[i][j]){
                    case 146:
                        Dungeon.mapArray[i][j] = 22;
                        break;
                    case 22:
                        Dungeon.mapArray[i][j] = 146;
                        break;
                    case 179:
                        Dungeon.mapArray[i][j] = 23;
                        break;
                    case 23:
                        Dungeon.mapArray[i][j] = 179;
                        break;
                    case 147:
                        Dungeon.mapArray[i][j] = 146;
                        break;
                    case 180:
                        Dungeon.mapArray[i][j] = 179;
                        break;
                }
            }
        }
        String[][] msg = {{"どこかで　もんのうごくおとがした"},{null}};
        mapFragment.callMessageFragment(msg);
        return -1;
    }

    public int glove(){
        Dungeon.glove = true;
        String[][] msg = {{"これであついものも　さわれそうね"},{null,data.mikataR(0)[0]}};
        mapFragment.callMessageFragment(msg);
        return 0;
    }

    public int pendant(){
        Dungeon.pendant++;
        String[][] msg = {{"ペンダントをてにいれた"},{null}};
        mapFragment.callMessageFragment(msg);
        return 0;
    }

    public int goddess(){
        if(Dungeon.pendant >= 3) {
            for (int i = 0; i < Dungeon.mapArray.length; i++) {
                for (int j = 0; j < Dungeon.mapArray[i].length; j++) {
                    switch (Dungeon.mapArray[i][j]) {
                        case 181:
                            Dungeon.mapArray[i][j] = 23;
                            break;
                    }
                }
            }
            Dungeon.pendant = 0;
        }
        else {
            String[][] msg = {{"だいざに３つのあながあいている"},{null}};
            mapFragment.callMessageFragment(msg);
        }
        return -1;
    }

    public int door(){
        if(Dungeon.glove){
            String[][] msg = {{"てぶくろは　こわれてしまった"},{null}};
            mapFragment.callMessageFragment(msg);
            Dungeon.glove = false;
            return 22;
        }
        String[][] msg = {{"あつっっ。　これじゃあけられないわ。"},{null,data.mikataR(0)[0]}};
        mapFragment.callMessageFragment(msg);
        return -1;
    }

    public int lantern(){
        Dungeon.lantern = true;
        String[][] msg = {{"ランタンをてにいれた"},{null}};
        mapFragment.callMessageFragment(msg);
        return 0;
    }

    public int candle(){
        if(Dungeon.lantern) {
            Dungeon.candle ++;
            if(Dungeon.candle >= 5){
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 144){
                            Dungeon.mapArray[i][j] = 22;
                        }
                    }
                }
                Dungeon.candle = 0;
                return 171;
            }
            return 171;
        }
        String[][] msg = {{"ろうそくね　ひだねがあれば；；；"},{null,data.mikataR(0)[0]}};
        mapFragment.callMessageFragment(msg);
        return -1;
    }

    public int record(){
        Dungeon.record = true;
        String[][] msg = {{"レコードを　てにいれた"},{null}};
        mapFragment.callMessageFragment(msg);
        return 0;
    }

    public int gramophone(){
        if(Dungeon.record) {
            String[][] msg = {{"おんがくが　ながれた", "アルクは　でんせつのつるぎを　てにいれた"}, {null, null}};
            mapFragment.callMessageFragment(msg);
        }
        return 0;
    }

    public int button(){
        Dungeon.button ++;
        if(Dungeon.button >= 4){
            for(int i = 0; i < Dungeon.mapArray.length; i++){
                for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                    if(Dungeon.mapArray[i][j] == 144){
                        Dungeon.mapArray[i][j] = 22;
                    }
                }
            }
            Dungeon.button = 0;
            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
            mapFragment.callMessageFragment(msg);
            return -1;
        }
        String[][] msg = {{"ボタンを　おした"},{null}};
        mapFragment.callMessageFragment(msg);
        return -1;
    }

    public int gate2(){
        for(int i = 0; i < Dungeon.mapArray.length; i++){
            for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                switch (Dungeon.mapArray[i][j]){
                    case 301:
                        Dungeon.mapArray[i][j] = 22;
                        break;
                    case 22:
                        Dungeon.mapArray[i][j] = 301;
                        break;
                    case 357:
                        Dungeon.mapArray[i][j] = 23;
                        break;
                    case 23:
                        Dungeon.mapArray[i][j] = 357;
                        break;
                    case 33:
                        Dungeon.mapArray[i][j] = 357;
                        break;
                }
            }
        }
        String[][] msg = {{"どこかで　なにかうごくおとがした"},{null}};
        mapFragment.callMessageFragment(msg);
        return -1;
    }

    public int chess (int objID, int direction){ // direction:0上,1下,2右,3左
        // 上
        if(direction == 0 && DrawMap.charPos[0] - 2 >= 0 && Dungeon.mapArray[DrawMap.charPos[0] - 2][DrawMap.charPos[1]] < 81){
            if(Dungeon.mapArray[DrawMap.charPos[0] - 2][DrawMap.charPos[1]] == 36){
                Dungeon.mapArray[DrawMap.charPos[0] - 2][DrawMap.charPos[1]] = 800;
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 181){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
            }
            else if(Dungeon.mapArray[DrawMap.charPos[0] - 2][DrawMap.charPos[1]] == 37){
                Dungeon.mapArray[DrawMap.charPos[0] - 2][DrawMap.charPos[1]] = 800;
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 144){
                            Dungeon.mapArray[i][j] = 22;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
            }else {
                Dungeon.mapArray[DrawMap.charPos[0] - 2][DrawMap.charPos[1]] = objID;
            }
            Dungeon.mapArray[DrawMap.charPos[0] - 1][DrawMap.charPos[1]] = 0;
        }
        // 下
        else if(direction == 1 && DrawMap.charPos[0] + 2 < Dungeon.mapArray.length && Dungeon.mapArray[DrawMap.charPos[0] + 2][DrawMap.charPos[1]] < 81){
            if(Dungeon.mapArray[DrawMap.charPos[0] + 2][DrawMap.charPos[1]] == 36){
                Dungeon.mapArray[DrawMap.charPos[0] + 2][DrawMap.charPos[1]] = 800;
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 181){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
            }
            else if(Dungeon.mapArray[DrawMap.charPos[0] + 2][DrawMap.charPos[1]] == 37){
                Dungeon.mapArray[DrawMap.charPos[0] + 2][DrawMap.charPos[1]] = 800;
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 144){
                            Dungeon.mapArray[i][j] = 22;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
            }else {
                Dungeon.mapArray[DrawMap.charPos[0] + 2][DrawMap.charPos[1]] = objID;
            }
            Dungeon.mapArray[DrawMap.charPos[0] + 1][DrawMap.charPos[1]] = 0;
        }
        // 右
        else if(direction == 2 && DrawMap.charPos[1] + 2 < Dungeon.mapArray[0].length && Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] + 2] < 81){
            if(Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] + 2] == 36){
                Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] + 2] = 800;
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 181){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
            }
            else if(Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] + 2] == 37){
                Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] + 2] = 800;
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 144){
                            Dungeon.mapArray[i][j] = 22;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
            }else {
                Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] + 2] = objID;
            }
            Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] + 1] = 0;
        }
        // 左
        else if(direction == 3 && DrawMap.charPos[1] - 2 >= 0 && Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] - 2] < 81){
            if(Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] - 2] == 36){
                Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] - 2] = 800;
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 181){
                            Dungeon.mapArray[i][j] = 23;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
            }
            else if(Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] - 2] == 37){
                Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] - 2] = 800;
                for(int i = 0; i < Dungeon.mapArray.length; i++){
                    for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                        if(Dungeon.mapArray[i][j] == 144){
                            Dungeon.mapArray[i][j] = 22;
                            String[][] msg = {{"なにかが　うごくおとがした"},{null}};
                            mapFragment.callMessageFragment(msg);
                        }
                    }
                }
            }else {
                Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] - 2] = objID;
            }
            Dungeon.mapArray[DrawMap.charPos[0]][DrawMap.charPos[1] - 1] = 0;
        }
        return -1;
    }

    public int chessButton(){
        String[][] msg = {{"ここになにか　はまりそうね"},{data.mikataR(0)[0]}};
        mapFragment.callMessageFragment(msg);
        return -1;
    }

    public int flower(){
        for(int i = 0; i < Dungeon.mapArray.length; i++){
            for(int j = 0; j < Dungeon.mapArray[i].length; j++){
                switch (Dungeon.mapArray[i][j]){
                    case 212:
                        Dungeon.mapArray[i][j] = 213;
                        break;
                    case 213:
                        Dungeon.mapArray[i][j] = 214;
                        break;
                    case 214:
                        Dungeon.mapArray[i][j] = 215;
                        break;
                    case 215:
                        Dungeon.mapArray[i][j] = 216;
                        for(int p = 0; p < Dungeon.mapArray.length; p++){
                            for(int q = 0; q < Dungeon.mapArray[p].length; q++){
                                if(Dungeon.mapArray[p][q] == 144){
                                    Dungeon.mapArray[p][q] = 22;
                                }
                            }
                        }
                        break;
                }
            }
        }
        return 0;
    }

    public int transformBoss(View view){
        String[][] msg = {{"これが　ほんとのわしじゃよ"},{"もりい"}};
        mapFragment.callMessageFragment(msg);
        AlphaAnimation alpha = new AlphaAnimation(1.0f, -0.5f);
        alpha.setDuration(3000);
        alpha.setRepeatCount(0);
        AnimationSet anim = new AnimationSet(false);
        anim.addAnimation(alpha);
        view.startAnimation(anim);
        try {
            Sound.dungeon.stop();
            Sound.dungeon.prepare();
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Dungeon.mapArray.length; i++) {
                    for (int j = 0; j < Dungeon.mapArray[i].length; j++) {
                        switch (Dungeon.mapArray[i][j]) {
                            case 45:
                                Dungeon.mapArray[i][j] = 743;
                                break;
                            case 46:
                                Dungeon.mapArray[i][j] = 744;
                                break;
                            case 47:
                                Dungeon.mapArray[i][j] = 745;
                                break;
                            case 48:
                                Dungeon.mapArray[i][j] = 746;
                                break;
                            case 49:
                                Dungeon.mapArray[i][j] = 747;
                                break;
                            case 50:
                                Dungeon.mapArray[i][j] = 748;
                                break;
                            case 51:
                                Dungeon.mapArray[i][j] = 749;
                                break;
                            case 52:
                                Dungeon.mapArray[i][j] = 750;
                                break;
                            case 53:
                                Dungeon.mapArray[i][j] = 751;
                                break;
                            case 40:
                                Dungeon.mapArray[i][j] = 752;
                                break;
                            case 41:
                                Dungeon.mapArray[i][j] = 753;
                                break;
                            case 42:
                                Dungeon.mapArray[i][j] = 754;
                                break;
                            case 43:
                                Dungeon.mapArray[i][j] = 755;
                                break;
                            case 349:
                                Dungeon.mapArray[i][j] = 756;
                                break;
                            case 44:
                                Dungeon.mapArray[i][j] = 757;
                                break;
                        }
                    }
                }
            }
        }, 2000);
        return -1;
    }

    public int floorWarp(){
        Dungeon.incrementFloor();
        return -1;
    }

    public int backHome(View view){
        if(PlayerData.rank == DungeonActivity.dungeonID){
            PlayerData.rank ++;
        }
        switch (DungeonActivity.dungeonID){
            case 0:
                String[][] msg0 = {{"えのなかにはいれるなんてふしぎ","まるで、ほんとうにもりにいるみたいだわ"}, {"マウ","エレナ"}};
                mapFragment.callMessageMapEndFragment(msg0);
                break;
            case 1:
                String[][] msg1 = {{"がさがさ！ごそごそ！","またモンスター？もういいかげんにして！","くるわよ！アルク！","；；；；","ちょっとまって！あたしはてきじゃないわ！","あたいはゆってぃ！よろしくでやんす","あたしたちは　はやくふういんのかぎををあつめなきゃいけないの、あなたにかまってるひまはないわ","わたしもつれていって、おねがい","かってにしなさい","よろしく！ゆってぃ","；；；；"}, {"？？","エレナ","マウ","アルク","？？","ゆってぃ","エレナ","ゆってぃ","エレナ","マウ","アルク"}};
                mapFragment.callMessageMapEndFragment(msg1);
                break;
            case 2:
                String[][] msg2 = {{"ゆってぃってどこからきたの？","ちぇるちぇるらんんど","へーソウナンダ","さんにんはふういんのかぎをげっとした"}, {"マウ","ゆってぃ","エレナ"}};
                mapFragment.callMessageMapEndFragment(msg2);
                break;
            case 3:
                String[][] msg3 = {{"ゆってぃってなにものなの？","ちぇるちぇるじんだよ","へーソウナンダ"}, {"マウ","ゆってぃ","エレナ"}};
                mapFragment.callMessageMapEndFragment(msg3);
                break;
            case 4:
                String[][] msg4 = {{"ゆってぃのすきなたべものってなに？","ちぇるちぇるラーメンだよ","ぼくもちぇるちぇるラーメンすきだよ"}, {"マウ","ゆってぃ","アルク"}};
                mapFragment.callMessageMapEndFragment(msg4);
                break;
            case 5:
                String[][] msg5 = {{"エレナってラインティアこくのおひめさまなの？","そうよ！なにかもんくある？","そうか、じゃあエレナがオーブをたくされたいちぞくなんだね","そうそう、ってなにいってるの？あたしはゆうしゃのまつえいよ！","え？ゆうしゃがオーブをたくしたいちぞくがいまのおうぞくだよ。しらないの？","じゃあわたしがゆうしゃのまつえいじゃないってことはホンモノのゆうしゃはどこにいるのよ","それはボクもわからないけど、ゆうしゃはあしきものによってすがたをかえられてしまったらしいよ"}, {"ゆってぃ","エレナ","ゆってぃ","エレナ","ゆってぃ","エレナ","ゆってぃ"}};
                mapFragment.callMessageMapEndFragment(msg5);
                break;
            case 6:
                String[][] msg6 = {{"ピラミッドのなかってれいぼうきいてるんだー","ちょっとさむいくらいだわ"}, {"マウ","エレナ"}};
                mapFragment.callMessageMapEndFragment(msg6);
                break;
            case 7:
                String[][] msg7 = {{"もうイヤよ！あたしはゆうしゃのまつえいでもないし、もうモンスターとなんてたたかいたくない！","ひめさま、そんなこといわないで","がんばってここからだっしゅつしましょう！","あなたにずっとじぶんがゆうしゃのまつえいだとおもいこんでいたわたしのきもちがわかるわけないわ","わからないわよ！わがままおひめさまのきもちなんてね！","もうあなたたちとなんていっしょにいれないわ"}, {"エレナ","マウ","マウ","エレナ","マウ","エレナ","エレナ"}};
                mapFragment.callMessageMapEndFragment(msg7);
                break;
            case 8:
                String[][] msg8 = {{"もうあたしにはふういんなんてむりね","ひめさま、いやになるのはわかるけどボクたちはなかまなんです。ここからいっしょにでましょう","ひめさまごめんね、いいすぎちゃった","みんなでだっしゅつしようよ！","ありがとう；みんな"}, {"エレナ","アルク","マウ","ゆってぃ","エレナ",}};
                mapFragment.callMessageMapEndFragment(msg8);
                break;
            case 9:
                String[][] msg9 = {{"すこしくらいところだったなー","おはかとかあってぶきみだったわ","ゆうれいにあわなくてよかった"}, {"マウ","エレナ","ゆってぃ"}};
                mapFragment.callMessageMapEndFragment(msg9);
                break;
            case 10:
                String[][] msg10 = {{"はぐるまのおとがうるさいわ","とけいとうのしくみみたいだね","なにをうごかしているんだろう？"}, {"エレナ","ゆってぃ","マウ",}};
                mapFragment.callMessageMapEndFragment(msg10);
                break;
            case 11:
                String[][] msg11 = {{"ここのまものってきかいでできているけどほんとうにまものなの？","きんぞくでできているからけんじゃきれなくててごわいな"}, {"マウ","アルク"}};
                mapFragment.callMessageMapEndFragment(msg11);
                break;
            case 12:
                String[][] msg12 = {{"ひめさますごーい","このつるぎ、アルクしかつかえないみたいだね","さわろうとしたらてがはじかれたよ","ふしぎだねー"}, {"マウ","ゆってぃ","ゆってぃ","マウ"}};
                mapFragment.callMessageMapEndFragment(msg12);
                break;
            case 13:
                String[][] msg13 = {{"このつるぎ、ちょーつよい","だってゆうしゃのつるぎだもの","なんでそんなことしってるの？","そこのかべにかいてあった","なんでそんなところにかいてあるのよ"}, {"アルク","ゆってぃ","マウ","ゆってぃ","エレナ",}};
                mapFragment.callMessageMapEndFragment(msg13);
                break;
            case 14:
                String[][] msg14 = {{"みんなみて～、こんな本をみつけたんだ","これってもしかして；","アルク、あなた；","アルクはゆうしゃの末裔だったでやんすね！","；；"}, {"ゆってぃ","マウ","エレナ","ゆってぃ","アルク"}};
                mapFragment.callMessageMapEndFragment(msg14);
                break;
            case 15:
                String[][] msg15 = {{"これでかぎが７つすべてあつまったね","なんか、７つってきくとねがいでもかないそうだね","それならいいのにね"}, {"ゆってぃ","マウ","エレナ"}};
                mapFragment.callMessageMapEndFragment(msg15);
                break;
            case 16:
                String[][] msg16 = {{"いままでのてきよりつよかったー","つぎでさいごかなー"}, {"マウ","アルク"}};
                mapFragment.callMessageMapEndFragment(msg16);
                break;
            case 17:
                Intent i = new Intent(view.getContext(), jp.ac.uejobi.aruquest.EndingActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                view.getContext().startActivity(i);
                break;
        }
        return -1;
    }


}
