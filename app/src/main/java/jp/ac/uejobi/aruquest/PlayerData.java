package jp.ac.uejobi.aruquest;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.util.Calendar;

/**
 * Created by uejobi on 2018/11/13.
 */

public class PlayerData extends Application{
    static final int CHARANUM = 3;
    static SaveData saveData = new SaveData();
    static Data data = new Data();
    static int rank = -1;
    static int stepPoint;
    static int[] stepWeek = new int[7];
    static int stepSum;
    static int[] HP = new int[CHARANUM];
    static int[] MP = new int[CHARANUM];
    static int[] ATK = new int[CHARANUM];
    static int[] DEF = new int[CHARANUM];
    static int[] SPD = new int[CHARANUM];
    static double[] critical = new double[CHARANUM];
    static int[] zokuseiID = new int[CHARANUM];
    static private int[] preWeapon = new int[110];
    static private int[] preArmor = new int[110];
    static private int[] preSkill = new int[99];
    static int[][] skill = new int[CHARANUM][99]; // [キャラクター][技ID]
    static int[][] item = new int[2][99];
    static int[][] weapon = new int[CHARANUM][99]; // [キャラクター][武器ID]
    static int[][] armor = new int[CHARANUM][99]; // [キャラクター][防具ID]
    static int[][] skillSetted = new int[CHARANUM][4]; // [キャラクター][技ID]
    static int[][] itemSetted = new int[CHARANUM][4]; // [キャラクター][道具ID]
    static int[] weaponSetted = new int[CHARANUM];
    static int[] armorSetted = new int[CHARANUM];
    static int BGMVolume = 1;
    static int SEVolume = 1;
    static int[] date = new int[3];

    public void getData(Context context) {
        int[] weaponIni = {0,2,4};
        int[] armorIni = {0,2,4};
        int[] skillIni = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67};
        int[][] itemIni = {{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
        int[] setwIni = {2,4,0};
        int[] setaIni = {2,4,0};
        int[][] setsIni = {{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        int[][] setiIni = {{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        int[] zokuseiIni = {0,0,0};
        int[] sevenIni = {0,0,0,0,0,0,0};
        Calendar calBefore = Calendar.getInstance();
        Calendar calCurrent = Calendar.getInstance();
        if(calCurrent.get(Calendar.HOUR) <= 3 && calCurrent.get(Calendar.AM_PM) == 0){
            calCurrent.add(Calendar.DATE,-1);
        }
        date[0] = calCurrent.get(Calendar.YEAR);
        date[1] = calCurrent.get(Calendar.MONTH);
        date[2] = calCurrent.get(Calendar.DATE);
        saveData.initialize(context, -1, weaponIni, armorIni, skillIni, itemIni, setwIni, setaIni, setsIni, setiIni, zokuseiIni, 546, sevenIni, 87892, 1, 2, date);

        rank = saveData.readRank(context);
        stepPoint = saveData.readWalkPoint(context);
        stepWeek = saveData.readSevenStep(context).clone();
        stepSum = saveData.readWalkSum(context);
        weaponSetted = saveData.readSetWeapon(context).clone();
        armorSetted = saveData.readSetArmor(context).clone();
        skillSetted = saveData.readSetSkill(context).clone();
        itemSetted = saveData.readSetItem(context).clone();
        zokuseiID = saveData.readZokuseiID(context).clone();
        BGMVolume = saveData.readBGM(context);
        SEVolume = saveData.readSE(context);
        date = saveData.readDate(context).clone();

        updateStatus();

        // 歩数を日付と結びつける
        calBefore.set(date[0], date[1], date[2]);
        long diffTime = calCurrent.getTimeInMillis() - calBefore.getTimeInMillis();
        int diffDayMillis = 1000 * 60 * 60 * 24;
        int diffDays = (int) (diffTime / diffDayMillis);
        for(int i = 0; i + diffDays < stepWeek.length; i++){
            stepWeek[i] = stepWeek[i + diffDays];
        }
        if(diffDays > 0) {
            if(diffDays > 7){
                diffDays = 7;
            }
            for (int i = stepWeek.length - diffDays; i < stepWeek.length; i++){
                stepWeek[i] = 0;
            }
        }
        date[0] = calCurrent.get(Calendar.YEAR);
        date[1] = calCurrent.get(Calendar.MONTH);
        date[2] = calCurrent.get(Calendar.DATE);

        // 所持武器防具アイテム取り出し
        int indexMemo = 0;
        for(int i = 0; i < saveData.readWeapon(context).length; i++){
            preWeapon[i] = saveData.readWeapon(context)[i];
            indexMemo++;
        }
        for(int i = 0; indexMemo + i < preWeapon.length; i++){
            preWeapon[indexMemo + i] = -1;
        }
        indexMemo = 0;

        for(int i = 0; i < saveData.readArmor(context).length; i++){
            preArmor[i] = saveData.readArmor(context)[i];
            indexMemo++;
        }
        for(int i = 0; indexMemo + i < preArmor.length; i++){
            preArmor[indexMemo + i] = -1;
        }
        indexMemo = 0;

        for(int i = 0; i < saveData.readSkill(context).length; i++){
            preSkill[i] = saveData.readSkill(context)[i];
            indexMemo++;
        }
        for(int i = 0; indexMemo + i < preSkill.length; i++){
            preSkill[indexMemo + i] = -1;
        }
        indexMemo = 0;

        for(int i = 0; i < saveData.readItem(context)[0].length; i++){
            item[0][i] = saveData.readItem(context)[0][i];
            item[1][i] = saveData.readItem(context)[1][i];
            indexMemo++;
        }
        for(int i = 0; indexMemo + i < item[0].length; i++){
            item[0][indexMemo + i] = -1;
            item[1][indexMemo + i] = -1;
        }

        int[] charaIndex = new int[CHARANUM];
        // 所持武器セット
        for(int i = 0; i < preWeapon.length && preWeapon[i] != -1; i++){
            if(data.bukiR(preWeapon[i])[1].equals("0")){
                weapon[0][charaIndex[0]] = preWeapon[i];
                charaIndex[0]++;
            }
            else if(data.bukiR(preWeapon[i])[1].equals("1")){
                weapon[1][charaIndex[1]] = preWeapon[i];
                charaIndex[1]++;
            }
            else if(data.bukiR(preWeapon[i])[1].equals("2")){
                weapon[2][charaIndex[2]] = preWeapon[i];
                charaIndex[2]++;
            }
        }
        for(int i = 0; i < CHARANUM; i++){
            for(int j = charaIndex[i]; j < weapon[i].length; j++){
                weapon[i][j] = -1;
            }
        }
        for(int i = 0; i < CHARANUM; i++){
            charaIndex[i] = 0;
        }
        // 所持防具セット
        for(int i = 0; i < preArmor.length && preArmor[i] != -1; i++){
            if(data.bouguR(preArmor[i])[1].equals("0")){
                armor[0][charaIndex[0]] = preArmor[i];
                charaIndex[0]++;
            }
            else if(data.bouguR(preArmor[i])[1].equals("1")){
                armor[1][charaIndex[1]] = preArmor[i];
                charaIndex[1]++;
            }
            else if(data.bouguR(preArmor[i])[1].equals("2")){
                armor[2][charaIndex[2]] = preArmor[i];
                charaIndex[2]++;
            }
        }
        for(int i = 0; i < CHARANUM; i++){
            for(int j = charaIndex[i]; j < armor[i].length; j++){
                armor[i][j] = -1;
            }
        }
        for(int i = 0; i < CHARANUM; i++){
            charaIndex[i] = 0;
        }
        // 所持技セット
        for(int i = 0; i < preSkill.length && preSkill[i] != -1; i++){
            if(data.wazaR(preSkill[i])[1].equals("0")){
                skill[0][charaIndex[0]] = preSkill[i];
                charaIndex[0]++;
            }
            else if(data.wazaR(preSkill[i])[1].equals("1")){
                skill[1][charaIndex[1]] = preSkill[i];
                charaIndex[1]++;
            }
            else if(data.wazaR(preSkill[i])[1].equals("2")){
                skill[2][charaIndex[2]] = preSkill[i];
                charaIndex[2]++;
            }
        }
        for(int i = 0; i < CHARANUM; i++){
            for(int j = charaIndex[i]; j < skill[i].length; j++){
                skill[i][j] = -1;
            }
        }
    }

    public void saveData(Context context){
        if(rank == -1){
            getData(context);
        }
        // 歩数を日付と結びつける
        Calendar calBefore = Calendar.getInstance();
        Calendar calCurrent = Calendar.getInstance();
        calBefore.set(date[0], date[1], date[2]);
        if(calCurrent.get(Calendar.HOUR) <= 3 && calCurrent.get(Calendar.AM_PM) == 0){
            calCurrent.add(Calendar.DATE,-1);
        }
        calBefore.set(Calendar.HOUR, 4);
        calCurrent.set(Calendar.HOUR, 4);
        long diffTime = calCurrent.getTimeInMillis() - calBefore.getTimeInMillis();
        int diffDayMillis = 1000 * 60 * 60 * 24;
        int diffDays = (int) (diffTime / diffDayMillis);
        for(int i = 0; i + diffDays < stepWeek.length; i++){
            stepWeek[i] = stepWeek[i + diffDays];
        }
        if(diffDays > 0) {
            for (int i = stepWeek.length - diffDays; i < stepWeek.length; i++){
                stepWeek[i] = 0;
            }
        }
        date[0] = calCurrent.get(Calendar.YEAR);
        date[1] = calCurrent.get(Calendar.MONTH);
        date[2] = calCurrent.get(Calendar.DATE);
        saveData.writing(context, rank, preWeapon, preArmor, preSkill, item, weaponSetted, armorSetted, skillSetted, itemSetted, zokuseiID, 99999, stepWeek, stepSum, BGMVolume, SEVolume, date);
    }

    public void resetData(Context context){
        int[] weaponIni = {0,2,4};
        int[] armorIni = {0,2,4};
        int[] skillIni = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67};
        int[][] itemIni = {{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
        int[] setwIni = {2,4,0};
        int[] setaIni = {2,4,0};
        int[][] setsIni = {{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        int[][] setiIni = {{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        int[] zokuseiIni = {0,0,0};
        int[] sevenIni = {0,0,0,0,0,0,0};
        Calendar calCurrent = Calendar.getInstance();
        if(calCurrent.get(Calendar.HOUR) <= 3 && calCurrent.get(Calendar.AM_PM) == 0){
            calCurrent.add(Calendar.DATE,-1);
        }
        date[0] = calCurrent.get(Calendar.YEAR);
        date[1] = calCurrent.get(Calendar.MONTH);
        date[2] = calCurrent.get(Calendar.DATE);
        saveData.writing(context, -1, weaponIni, armorIni, skillIni, itemIni, setwIni, setaIni, setsIni, setiIni, zokuseiIni, 546, sevenIni, 87892, 1, 2, date);
        getData(context);
    }

    public static void addStepPoint(int num){
        stepPoint += num;
    }

    public static void decStepPoint(int num){
        stepPoint -= num;
    }

    public static void addStepWeek(int num){
        stepWeek[6] += num;
    }

    public static void addStepSum(int num){
        stepSum += num;
    }

    public static void changeZokusei(){
        zokuseiID[0] = (int)(Math.random() * 5);
        zokuseiID[1] = (int)(Math.random() * 5);
        zokuseiID[2] = (int)(Math.random() * 5);
    }

    public static  void setWeaponSetted(int charaID, int weponId){
        weaponSetted[charaID] = weponId;
        updateStatus();
    }

    public static  void setArmorSetted(int charaID, int armorId){
        armorSetted[charaID] = armorId;
        updateStatus();
    }

    public static void setSkillSetted(int charaID, int index, int skillId){
        skillSetted[charaID][index] = skillId;
    }

    public static boolean setItemSetted(int charaID, int index, int itemId){
        for(int i = 0; i < item[0].length && item[0][i] != -1; i++){
            if(item[0][i] == itemId && item[1][i] > 0){
                if(itemSetted[charaID][index] != -1){
                    for(int j = 0; item[0][j] != -1 && i < item[0].length; j++){
                        if(item[0][j] == itemSetted[charaID][index]){
                            item[1][j]++;
                            break;
                        }
                    }
                }
                itemSetted[charaID][index] = itemId;
                item[1][i]--;
                if(item[1][i] <= 0){
                    for(int p = i + 1; p < item[0].length; p++){
                        item[0][p - 1] = item[0][p];
                        item[1][p - 1] = item[1][p];
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void releaseItemSetted(int charaID, int index){
        if(itemSetted[charaID][index] >= 0) {
            for (int i = 0; i < item[0].length && item[0][i] != -1; i++) {
                if (item[0][i] == itemSetted[charaID][index]) {
                    itemSetted[charaID][index] = -1;
                    item[1][i]++;
                    return;
                }
            }
            for(int i = 0; i < item[0].length; i++){
                if(item[0][i] > itemSetted[charaID][index]){
                    for(int j = item[0].length - 1; j > i; j--){
                        item[0][j] = item[0][j - 1];
                        item[1][j] = item[1][j - 1];
                    }
                    item[0][i] = itemSetted[charaID][index];
                    item[1][i] = 1;
                    itemSetted[charaID][index] = -1;
                    return;
                }
            }
        }
    }

    public static void useItemSetted(int charaID, int index){
        itemSetted[charaID][index] = -1;
    }

    public static void getItem(int itemID){
        for (int i = 0; i < item[0].length && item[0][i] != -1; i++) {
            if (item[0][i] == itemID) {
                item[1][i]++;
                return;
            }
        }
        for(int i = 0; i < item[0].length; i++){
            if(item[0][i] > itemID || item[0][i] == -1){
                for(int j = item[0].length - 1; j > i; j--){
                    item[0][j] = item[0][j - 1];
                    item[1][j] = item[1][j - 1];
                }
                item[0][i] = itemID;
                item[1][i] = 1;
                return;
            }
        }
    }

    public static boolean getSkill(int skillID){
        for (int i = 0; i < preSkill.length && preSkill[i] != -1; i++) {
            if (preSkill[i] == skillID) {
                return false;
            }
        }
        for (int i = 0; i < preSkill.length; i++) {
            if(preSkill[i] > skillID || preSkill[i] == -1){
                for(int j = preSkill.length - 1; j > i; j--){
                    preSkill[j] = preSkill[j - 1];
                }
                preSkill[i] = skillID;
                // 所持技セット
                int[] charaIndex = new int[CHARANUM];
                for(int p = 0; i < preSkill.length && preSkill[p] != -1; p++){
                    if(data.wazaR(preSkill[p])[1].equals("0")){
                        skill[0][charaIndex[0]] = preSkill[p];
                        charaIndex[0]++;
                    }
                    else if(data.wazaR(preSkill[p])[1].equals("1")){
                        skill[1][charaIndex[1]] = preSkill[p];
                        charaIndex[1]++;
                    }
                    else if(data.wazaR(preSkill[p])[1].equals("2")){
                        skill[2][charaIndex[2]] = preSkill[p];
                        charaIndex[2]++;
                    }
                }
                for(int p = 0; p < CHARANUM; p++){
                    for(int q = charaIndex[p]; q < skill[p].length; q++){
                        skill[p][q] = -1;
                    }
                }
                return true;
            }
        }
        return false;

    }

    public static void getWeapon(int weaponID){
        for (int i = 0; i < preWeapon.length && preWeapon[i] != -1; i++) {
            if (preWeapon[i] == weaponID) {
                return;
            }
        }
        for (int i = 0; i < preWeapon.length; i++) {
            if (preWeapon[i] > weaponID || preWeapon[i] == -1) {
                for (int j = preWeapon.length - 1; j > i; j--) {
                    preWeapon[j] = preWeapon[j - 1];
                }
                preWeapon[i] = weaponID;
                // 所持防具セット
                int[] charaIndex = new int[CHARANUM];
                for(int p = 0; p < preWeapon.length && preWeapon[p] != -1; p++){
                    if(data.bukiR(preWeapon[p])[1].equals("0")){
                        weapon[0][charaIndex[0]] = preWeapon[p];
                        charaIndex[0]++;
                    }
                    else if(data.bukiR(preWeapon[p])[1].equals("1")){
                        weapon[1][charaIndex[1]] = preWeapon[p];
                        charaIndex[1]++;
                    }
                    else if(data.bukiR(preWeapon[p])[1].equals("2")){
                        weapon[2][charaIndex[2]] = preWeapon[p];
                        charaIndex[2]++;
                    }
                }
                for(int p = 0; p < CHARANUM; p++){
                    for(int q = charaIndex[p]; q < weapon[p].length; q++){
                        weapon[p][q] = -1;
                    }
                }
                return;
            }
        }
    }

    public static void getArmor(int armorID){
        for (int i = 0; i < preArmor.length && preArmor[i] != -1; i++) {
            if (preArmor[i] == armorID) {
                return;
            }
        }
        for (int i = 0; i < preArmor.length; i++) {
            if (preArmor[i] > armorID || preArmor[i] == -1) {
                for (int j = preArmor.length - 1; j > i; j--) {
                    preArmor[j] = preArmor[j - 1];
                }
                preArmor[i] = armorID;
                // 所持防具セット
                int[] charaIndex = new int[CHARANUM];
                for(int p = 0; p < preArmor.length && preArmor[p] != -1; p++){
                    if(data.bouguR(preArmor[p])[1].equals("0")){
                        armor[0][charaIndex[0]] = preArmor[p];
                        charaIndex[0]++;
                    }
                    else if(data.bouguR(preArmor[p])[1].equals("1")){
                        armor[1][charaIndex[1]] = preArmor[p];
                        charaIndex[1]++;
                    }
                    else if(data.bouguR(preArmor[p])[1].equals("2")){
                        armor[2][charaIndex[2]] = preArmor[p];
                        charaIndex[2]++;
                    }
                }
                for(int p = 0; p < CHARANUM; p++){
                    for(int q = charaIndex[p]; q < armor[p].length; q++){
                        armor[p][q] = -1;
                    }
                }
                return;
            }
        }
    }

    public static void updateStatus(){
        for(int i = 0; i < CHARANUM; i++) {
            HP[i] = Integer.parseInt(data.mikataR(i)[1]) + Integer.parseInt(data.bukiR(weaponSetted[i])[3]) + Integer.parseInt(data.bouguR(armorSetted[i])[3]);
            MP[i] = Integer.parseInt(data.mikataR(i)[2]) + Integer.parseInt(data.bukiR(weaponSetted[i])[4]) + Integer.parseInt(data.bouguR(armorSetted[i])[4]);
            ATK[i] = Integer.parseInt(data.mikataR(i)[3]) + Integer.parseInt(data.bukiR(weaponSetted[i])[5]) + Integer.parseInt(data.bouguR(armorSetted[i])[5]);
            DEF[i] = Integer.parseInt(data.mikataR(i)[4]) + Integer.parseInt(data.bukiR(weaponSetted[i])[6]) + Integer.parseInt(data.bouguR(armorSetted[i])[6]);
            SPD[i] = Integer.parseInt(data.mikataR(i)[5]) + Integer.parseInt(data.bukiR(weaponSetted[i])[7]) + Integer.parseInt(data.bouguR(armorSetted[i])[7]);
            critical[i] = Double.parseDouble(data.mikataR(i)[6]) + Double.parseDouble(data.bukiR(weaponSetted[i])[8]) + Double.parseDouble(data.bouguR(weaponSetted[i])[8]);
        }
    }

    public void test(Context context){
        int[] weapon = {0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] armor = {0,1,2,3};
        int[] skill = {0,1,2};
        int[][] item = {{0,1,2,3},{2,2,2,2}};
        int[] setw = {0,1,2};
        int[] seta = {0,1,2};
        int[][] sets = {{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        int[][] seti = {{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        int[] zokusei = {0,0,0};
        int[] seven = {342,4324,52,2352,3242,12488,785};
        int[] date = new int[3];
        Calendar calCurrent = Calendar.getInstance();
        calCurrent.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);
        if(calCurrent.get(Calendar.HOUR) <= 3){
            calCurrent.add(Calendar.DATE,-1);
        }
        /*date[0] = calCurrent.get(Calendar.YEAR);
        date[1] = calCurrent.get(Calendar.MONTH);
        date[2] = calCurrent.get(Calendar.DATE);*/
        date[0] = 2018;
        date[1] = 11;
        date[2] = 14;
        saveData.writing(context, 148, weapon, armor, skill, item, setw, seta, sets, seti, zokusei, 546, seven, 87892, 1, 2, date);
        //Log.d("テストおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおおお", String.valueOf(saveData.readSetSkill(context)[2][3]));
    }

}
