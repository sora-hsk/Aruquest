package jp.ac.uejobi.aruquest;

import android.widget.Switch;
import android.widget.Toast;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by uejobi on 2018/10/24.
 */

public class CombatManagement {

    static boolean returnMapFlg = false;
    static boolean returnHomeFlg = false;
    static int[] hp = new int[4];
    static int[][] viewhp = new int[4][4];
    static int[][] viewmp = new int[3][4];
    static int[] poisonhp = new int[3];
    static int[] maxhp = new int[4];
    static int[] mp = new int[4];
    static int[] maxmp = new int[4];
    static int[] spd = new int[4];
    static int[] maxspd = new int[4];
    static int[] def = new int[4];
    static int[] maxdef = new int[4];
    static int[] atk = new int[4];
    static int[] maxatk = new int[4];
    static double[] critical = new double[3];
    static double[][] zokusei = new double[3][5];
    static double[] jakuten = new double[5];
    static int color1;
    static int color2;
    static int color3;
    static String[][] itemname = new String[3][4];
    //キャラの技名
    static String[][] skillname = new String[3][4];
    static String[] skillnameE = new String[8];
    //技の能力値
    static int[][] charskill1 = new int[4][9];
    static int[][] charskill2 = new int[4][9];
    static int[][] charskill3 = new int[4][9];
    static int[][] enemyskill = new int[8][8];
    //アイテム
    static int[][] charitem1 = new int[4][8];
    static int[][] charitem2 = new int[4][8];
    static int[][] charitem3 = new int[4][8];
    // 攻撃時のatk最終値
    static int atk1;
    static int atk2;
    static int atk3;
    // キャラ名
    static String[] charname = new String[4];
    // ログ
    static StringBuilder log;
    static String change;
    static String[] result;
    // ログ用データ
    static int data1;
    static int data2;
    static int data3;
    // ターン数管理
    // atk
    static int[] atkData = new int[6];
    // def
    static int[] defData = new int[6];
    // spd
    static int[] spdData = new int[6];
    // ターン指数
    static int[] turnCnt1 = new int[8];
    static int[] turnCnt2 = new int[8];
    static int[] turnCnt3 = new int[8];
    static int[] enemyCnt = new int[5];
    // 生死判定フラグ
    static int flg1;
    static int flg2;
    static int flg3;
    // こうげきぼうぎょ判定フラグ
    static int[] kougeki = new int[3];
    static int[] bougyo = new int[3];
    // 道具使用判定フラグ
    static int[] item = new int[3];
    // コマンド判定変数
    static int[] charmove = new int[3];
    // 技コマンド変数
    static int[] selectskill = new int[3];
    // 技の対象
    static int[] selecter = new int[3];
    // 勝ち負けフラグ
    static int resultFlg = 0;
    // 落とす道具
    static int dropItemID = -1;
    // 落とす技
    static int dropSkillID = -1;
    // 落とす確率
    static int dropRate = 0;
    // 落とすものの名前
    static String dropName = null;
    //クリティカル文字
    static String[] cr = new String[3];
    // ボスのときに逃げられない用
    static boolean escapeEnable = true;

    Data data = new Data();

    public void redyBattle() {
        // 初期化
        returnMapFlg = false;
        returnHomeFlg = false;
        atk1 = 0;
        atk2 = 0;
        atk3 = 0;
        log = null;
        change = null;
        data1 = 0;
        data2 = 0;
        data3 = 0;
        for(int i = 0; i < atkData.length; i++) {
            atkData[i] = 0;
            defData[i] = 0;
            spdData[i] = 0;
        }
        for(int i = 0; i < turnCnt1.length; i++) {
            turnCnt1[i] = 0;
            turnCnt2[i] = 0;
            turnCnt3[i] = 0;
        }
        for(int i = 0; i < enemyCnt.length; i++) {
            enemyCnt[i] = 0;
        }
        flg1 = 0;
        flg2 = 0;
        flg3 = 0;
        for(int i = 0; i < kougeki.length; i++) {
            kougeki[i] = 0;
            bougyo[i] = 0;
            item[i] = 0;
            charmove[i] = 0;
            selectskill[i] = 0;
            selecter[i] = 0;
        }
        resultFlg = 0;
        // ComandCtrlの初期化
        for(int i = 0; i < ComandCtrl.move.length; i++) {
            ComandCtrl.move[i] = 0;
            ComandCtrl.selecter[i] = 0;
            ComandCtrl.skill[i] = 0;
            ComandCtrl.item[i] = 0;
        }
        setStatus();
        setZokusei();
        haveSkill();
        setItem();
        dropItemID = Integer.parseInt(data.tekiR(Dungeon.enemyID)[6]);
        dropSkillID = Integer.parseInt(data.tekiR(Dungeon.enemyID)[7]);
        dropRate = Integer.parseInt(data.tekiR(Dungeon.enemyID)[8]);
        if(dropItemID >= 0){
            dropName = data.douguR(dropItemID)[0];
        }
        else if(dropSkillID >= 0){
            dropName = data.wazaR(dropSkillID)[0];
        }
    }

    public static int getResultFlg() {
        return resultFlg;
    }


    public void setStatus(){
        // dbからキャラ名取得　4番目は敵キャラ
        String[] name = {data.mikataR(0)[0],data.mikataR(1)[0],data.mikataR(2)[0],data.tekiR(Dungeon.enemyID)[0]};
        setCharname(name);
        // dbからhp取得 4番目は敵キャラ
        int [] hitpoint = {PlayerData.HP[0],PlayerData.HP[1],PlayerData.HP[2],Integer.parseInt(data.tekiR(Dungeon.enemyID)[1])};
        setHp(hitpoint);
        // dbからmp取得
        int [] magicpoint = {PlayerData.MP[0],PlayerData.MP[1],PlayerData.MP[2]};
        setMp(magicpoint);
        // dbからatk取得 4番目は敵キャラ
        int[] atack = {PlayerData.ATK[0],PlayerData.ATK[1],PlayerData.ATK[2],Integer.parseInt(data.tekiR(Dungeon.enemyID)[2])};
        setAtk(atack);
        // dbからdef取得 4番目は敵キャラ
        int[] defense = {PlayerData.DEF[0],PlayerData.DEF[1],PlayerData.DEF[2],Integer.parseInt(data.tekiR(Dungeon.enemyID)[3])};
        setDef(defense);
        // dbからspd取得 4番目は敵キャラ
        int[] speed = {PlayerData.SPD[0],PlayerData.SPD[1],PlayerData.SPD[2],Integer.parseInt(data.tekiR(Dungeon.enemyID)[4])};
        setSpd(speed);
        // dbからcritical取得
        double[] critical = {PlayerData.critical[0],PlayerData.critical[1],PlayerData.critical[2]};
        setCritical(critical);
        // dbからjakuten取得 赤　青　緑　白　黒　の順
        for(int i = 0; i < data.zokuseiR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[9])).length; i++){
            jakuten[i] = Double.parseDouble(data.zokuseiR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[9]))[i]);
        }
        // ターンカウンター

    }

    //属性倍率を歩数クラスから受け取るクラス
    public void  setZokusei(){
        //　1人目 赤　青　緑　白　黒　の順
        double[] one = {Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[0])[0]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[0])[1]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[0])[2]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[0])[3]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[0])[4])};
        //  2人目
        double[] two = {Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[1])[0]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[1])[1]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[1])[2]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[1])[3]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[1])[4])};
        //  3人目
        double[] three = {Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[2])[0]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[2])[1]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[2])[2]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[2])[3]),Double.parseDouble(data.zokuseiR(PlayerData.zokuseiID[2])[4])};
        // 2次元配列に格納
        int x = 0;
        int y = 0;
            while(y<5){
                zokusei[x][y] =one[y];
                y++;
            }
            y = 0;
            x++;
            while (y<5){
                zokusei[x][y] = two[y];
                y++;
            }
            y = 0;
            x++;
            while(y<5){
                zokusei[x][y] = three[y];
                y++;
            }

            color1 = Integer.parseInt(data.bukiR(PlayerData.weaponSetted[0])[9]);
            color2 = Integer.parseInt(data.bukiR(PlayerData.weaponSetted[1])[9]);
            color3 = Integer.parseInt(data.bukiR(PlayerData.weaponSetted[2])[9]);
    }


    // キャラ名
    public void setCharname (String[] a){
        int i = 0;
        while(a.length>i){
            charname[i] = a[i];
            i++;
        }
    }

    //HP
    public void setHp (int[] a){
        int i = 0;
        while(a.length>i){
            hp[i] = a[i];
            maxhp[i] = a[i];
            i++;
        }
        for(int j = 0; j < ComandCtrl.Hp.length; j++){
            ComandCtrl.Hp[j] = a[j];
        }
    }
    //MP
    public void setMp (int[] a){
        int i = 0;
        while (a.length>i){
            mp[i] = a[i];
            maxmp[i] = a[i];
            i++;
        }
        for(int j = 0; j < ComandCtrl.Mp.length; j++){
            ComandCtrl.Mp[j] = a[j];
        }
    }
    //SPEED
    public void setSpd(int[] a){
        int i = 0;
        while(a.length>i){
            spd[i] = a[i];
            i++;
        }
    }
    //ATACK
    public void setAtk(int[] a){
        int i = 0;
        while(a.length>i){
            atk[i] = a[i];
            i++;
        }
    }
    //DEFENSE
    public void setDef(int[] a){
        int i = 0;
        while (a.length>i){
            def[i] = a[i];
            i++;
        }
    }

    public void setCritical(double[] a){
        int i = 0;
        while (a.length>i){
            critical[i] = a[i];
            i++;
        }
    }

    // キャラの持つ技を格納
    public void haveSkill() {
        //キャラ1，２，３が装備している技をJSON,DBから抽出

        // 技名格納
        for(int i = 0; i < PlayerData.skillSetted.length; i++) {
            for(int j = 0; j < PlayerData.skillSetted[i].length; j++) {
                if(PlayerData.skillSetted[i][j] != -1) {
                    skillname[i][j] = data.wazaR(PlayerData.skillSetted[i][j])[0];
                }
            }
        }
        //技能力値格納 0HP  1MP  2ATK  3DEF  4SPD  5属性 6対象 7アタック値up 8ターン数 の順
        for(int i = 0; i < PlayerData.skillSetted[0].length; i++) {
            if(PlayerData.skillSetted[0][i] != -1) {
                charskill1[i][0] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[2]);
                charskill1[i][1] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[3]);
                charskill1[i][2] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[4]);
                charskill1[i][3] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[5]);
                charskill1[i][4] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[6]);
                charskill1[i][5] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[8]);
                charskill1[i][6] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[9]);
                charskill1[i][7] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[10]);
                charskill1[i][8] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[0][i])[11]);
            }
        }

        //技能力値格納 0HP  1MP  2ATK  3DEF  4SPD  5属性 6対象 7アタック値up 8ターン数 の順
        for(int i = 0; i < PlayerData.skillSetted[1].length; i++) {
            if(PlayerData.skillSetted[1][i] != -1) {
                charskill2[i][0] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[2]);
                charskill2[i][1] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[3]);
                charskill2[i][2] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[4]);
                charskill2[i][3] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[5]);
                charskill2[i][4] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[6]);
                charskill2[i][5] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[8]);
                charskill2[i][6] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[9]);
                charskill2[i][7] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[10]);
                charskill2[i][8] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[1][i])[11]);
            }
        }

        //技能力値格納 0HP  1MP  2ATK  3DEF  4SPD  5属性 6対象 7アタック値up 8ターン数 の順
        for(int i = 0; i < PlayerData.skillSetted[1].length; i++) {
            if(PlayerData.skillSetted[2][i] != -1) {
                charskill3[i][0] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[2]);
                charskill3[i][1] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[3]);
                charskill3[i][2] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[4]);
                charskill3[i][3] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[5]);
                charskill3[i][4] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[6]);
                charskill3[i][5] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[8]);
                charskill3[i][6] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[9]);
                charskill3[i][7] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[10]);
                charskill3[i][8] = Integer.parseInt(data.wazaR(PlayerData.skillSetted[2][i])[11]);
            }
        }

        //敵キャラの技
        // 技名格納
        for(int i = 0; i < skillnameE.length; i++){
            skillnameE[i] = null;
        }
        if(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]) >= 0) {
            for (int i = 0; i < data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5])).length; i++) {
                skillnameE[i] = data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[0];
            }
            //技能力値格納 0HP 1ATK 2 DEF 3SPD 4属性 5パターン 6アタックアップ 7ターン数
            for (int i = 0; i < data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5])).length; i++) {
                enemyskill[i][0] = Integer.parseInt(data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[1]);
                enemyskill[i][1] = Integer.parseInt(data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[2]);
                enemyskill[i][2] = Integer.parseInt(data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[3]);
                enemyskill[i][3] = Integer.parseInt(data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[4]);
                enemyskill[i][4] = Integer.parseInt(data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[5]);
                enemyskill[i][5] = Integer.parseInt(data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[6]);
                enemyskill[i][6] = Integer.parseInt(data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[7]);
                enemyskill[i][7] = Integer.parseInt(data.tekiwazaR(data.tekiwazaIDR(Integer.parseInt(data.tekiR(Dungeon.enemyID)[5]))[i])[8]);
            }
        }
    }
    public void setItem(){
        for(int i = 0; i < PlayerData.itemSetted.length; i++){
            for(int j = 0; j < PlayerData.itemSetted[i].length; j++){
                if(PlayerData.itemSetted[i][j] != -1) {
                    itemname[i][j] = data.douguR(PlayerData.itemSetted[i][j])[0];
                }else {
                    itemname[i][j] = null;
                }
            }
        }

        //キャラ１のアイテム
        for(int i = 0; i < PlayerData.itemSetted[0].length; i++) {
            if(PlayerData.itemSetted[0][i] != -1) {
                charitem1[i][0] = Integer.parseInt(data.douguR(PlayerData.itemSetted[0][i])[1]);
                charitem1[i][1] = Integer.parseInt(data.douguR(PlayerData.itemSetted[0][i])[2]);
                charitem1[i][2] = Integer.parseInt(data.douguR(PlayerData.itemSetted[0][i])[3]);
                charitem1[i][3] = Integer.parseInt(data.douguR(PlayerData.itemSetted[0][i])[4]);
                charitem1[i][4] = Integer.parseInt(data.douguR(PlayerData.itemSetted[0][i])[5]);
                charitem1[i][5] = Integer.parseInt(data.douguR(PlayerData.itemSetted[0][i])[6]);
                charitem1[i][6] = Integer.parseInt(data.douguR(PlayerData.itemSetted[0][i])[7]);
                charitem1[i][7] = Integer.parseInt(data.douguR(PlayerData.itemSetted[0][i])[8]);
            }
        }
        //キャラ２のアイテム
        for(int i = 0; i < PlayerData.itemSetted[1].length; i++) {
            if(PlayerData.itemSetted[1][i] != -1) {
                charitem2[i][0] = Integer.parseInt(data.douguR(PlayerData.itemSetted[1][i])[1]);
                charitem2[i][1] = Integer.parseInt(data.douguR(PlayerData.itemSetted[1][i])[2]);
                charitem2[i][2] = Integer.parseInt(data.douguR(PlayerData.itemSetted[1][i])[3]);
                charitem2[i][3] = Integer.parseInt(data.douguR(PlayerData.itemSetted[1][i])[4]);
                charitem2[i][4] = Integer.parseInt(data.douguR(PlayerData.itemSetted[1][i])[5]);
                charitem2[i][5] = Integer.parseInt(data.douguR(PlayerData.itemSetted[1][i])[6]);
                charitem2[i][6] = Integer.parseInt(data.douguR(PlayerData.itemSetted[1][i])[7]);
                charitem2[i][7] = Integer.parseInt(data.douguR(PlayerData.itemSetted[1][i])[8]);
            }
        }
        //キャラ３のアイテム
        for(int i = 0; i < PlayerData.itemSetted[0].length; i++) {
            if(PlayerData.itemSetted[2][i] != -1) {
                charitem3[i][0] = Integer.parseInt(data.douguR(PlayerData.itemSetted[2][i])[1]);
                charitem3[i][1] = Integer.parseInt(data.douguR(PlayerData.itemSetted[2][i])[2]);
                charitem3[i][2] = Integer.parseInt(data.douguR(PlayerData.itemSetted[2][i])[3]);
                charitem3[i][3] = Integer.parseInt(data.douguR(PlayerData.itemSetted[2][i])[4]);
                charitem3[i][4] = Integer.parseInt(data.douguR(PlayerData.itemSetted[2][i])[5]);
                charitem3[i][5] = Integer.parseInt(data.douguR(PlayerData.itemSetted[2][i])[6]);
                charitem3[i][6] = Integer.parseInt(data.douguR(PlayerData.itemSetted[2][i])[7]);
                charitem3[i][7] = Integer.parseInt(data.douguR(PlayerData.itemSetted[2][i])[8]);
            }
        }
    }


    public static void Comandresult(int a,int b,int c, int d, int e, int f,int g,int h, int i,int j,int k,int l){
        charmove[0] = a;
        charmove[1] = b;
        charmove[2] = c;
        selectskill[0] = d;
        selectskill[1] = e;
        selectskill[2] = f;
        selecter[0] = g;
        selecter[1] = h;
        selecter[2] = i;
        item[0] = j;
        item[1] = k;
        item[2] = l;
    }


    // ダメージ計算
    public static void damageCalc () {
        log = new StringBuilder();
        // 技判別
        int skill1 = selectskill[0];
        int skill2 = selectskill[1];
        int skill3 = selectskill[2];

        // 攻撃　回復　補助　判断
        // 行動判別変数
        int[] ptn = new int[3];

        //ぼうぎょフラグ
        int[] bougyo = {0,0,0};

        // にげる
        if(charmove[0] == 5){
            log.append(charname[0]+"たちは　にげだした\n");
            if(escapeEnable && (int)(Math.random() * 2) == 0){
                returnMapFlg = true;
                setResult();
                return;
            }
            log.append("しかし　まわりこまれてしまった\n");
            ptn[0] = 14;
            ptn[1] = 14;
            ptn[2] = 14;
        }


        //こうげき ぼうぎょ
        if (charmove[0] != 5) {
            for (int n = 0; n < 3; n++) {
                if (charmove[n] == 1) {
                    switch (n){
                        case 0:
                            atk1 = atk[0];
                            break;
                        case 1:
                            atk2 = atk[1];
                            break;
                        case 2:
                            atk3 = atk[2];
                            break;
                    }
                    ptn[n] = 6;
                }
                if (charmove[n] == 2) {
                    ptn[n] = 7;
                }
                if (charmove[n] == 4) {
                    ptn[n] = 8;
                }
            }
        }
        // 道具使用

        //行動可否
        for (int h = 0; h < 3; h++) {
            if (hp[h] <= 0) {
                ptn[h] = 5;
            }
        }
        // まひ判断
        if (turnCnt1[3] != 0)ptn[0] = 14;
        if (turnCnt2[3] != 0)ptn[1] = 14;
        if (turnCnt3[3] != 0)ptn[2] = 14;
        // キャラ1
        if (ptn[0] != 5 && ptn[0] != 6 && ptn[0] != 7 && ptn[0] != 8 && ptn[0] != 14) {
            if (charskill1[skill1][0] != 0) {
                //回復処理
                ptn[0] = 0;
            }
            if (charskill1[skill1][2] != 0) {
                // 攻撃処理
                atk1 = atk[0] + charskill1[skill1][2];
                ptn[0] = 1;
            } else {
                atk1 = 0;
            }
            if (charskill1[skill1][3] != 0) {
                // DFE上げ ターン処理
                ptn[0] = 2;
            }
            if (charskill1[skill1][4] != 0) {
                // SPD上げ ターン処理
                ptn[0] = 3;
            }
            if (charskill1[skill1][7] != 0) {
                // ATK値上げ ターン処理
                ptn[0] = 4;
            }
            if (charskill1[skill1][6] == 2){
                ptn[0] = 9;
            }
            if(charskill1[skill1][6] == 3){
                ptn[0] = 10;
            }
            if (charskill1[skill1][6] == 4){
                ptn[0] = 11;
            }
            if (charskill1[skill1][6] == 5){
                ptn[0] = 12;
            }
            if (charskill1[skill1][6] == 6){
                ptn[0] = 13;
            }
            if (charskill1[skill1][6] == 7){
                ptn[0] = 15;
            }

        }
        // キャラ2
        if (ptn[1] != 5 && ptn[1] != 6 && ptn[1] != 7 && ptn[1] != 8 && ptn[1] != 14) {
            if (charskill2[skill2][0] != 0) {
                //回復処理
                ptn[1] = 0;
            }
            if (charskill2[skill2][2] != 0) {
                atk2 = atk[1] + charskill2[skill2][2];
                ptn[1] = 1;
            } else {
                atk2 = 0;
            }
            if (charskill2[skill2][3] != 0) {
                // DFE上げ ターン処理
                ptn[1] = 2;
            }
            if (charskill2[skill2][4] != 0) {
                // SPD上げ ターン処理
                ptn[1] = 3;
            }
            if (charskill2[skill2][7] != 0) {
                // ATK値上げ ターン処理
                ptn[1] = 4;
            }
            if (charskill2[skill2][6] == 2){
                ptn[1] = 9;
            }
            if (charskill2[skill2][6] == 3){
                ptn[1] = 10;
            }
            if (charskill2[skill2][6] == 4){
                ptn[1] = 11;
            }
            if (charskill2[skill2][6] == 5){
                ptn[1] = 12;
            }
            if (charskill2[skill2][6] == 6){
                ptn[1] = 13;
            }
            if (charskill2[skill2][6] == 7){
                ptn[1] = 15;
            }

        }

        // キャラ3
        if (ptn[2] != 5 && ptn[2] != 6 && ptn[2] != 7 && ptn[2] != 8 && ptn[2] != 14) {
            if (charskill3[skill3][0] != 0) {
                //回復処理
                ptn[2] = 0;
            }
            if (charskill3[skill3][2] != 0) {
                atk3 = atk[2] + charskill3[skill3][2];
                ptn[2] = 1;
            } else {
                atk3 = 0;
            }
            if (charskill3[skill3][3] != 0) {
                // DFE上げ ターン処理
                ptn[2] = 2;
            }
            if (charskill3[skill3][4] != 0) {
                // SPD上げ ターン処理
                ptn[2] = 3;
            }
            if (charskill3[skill3][7] != 0) {
                // ATK値上げ ターン処理
                ptn[2] = 4;
            }
            if (charskill3[skill3][6] == 2){
                ptn[2] = 9;
            }
            if (charskill3[skill3][6] == 3){
                ptn[2] = 10;
            }
            if (charskill3[skill3][6] == 4){
                ptn[2] = 11;
            }
            if (charskill3[skill3][6] == 5){
                ptn[2] = 12;
            }
            if (charskill3[skill3][6] == 6){
                ptn[2] = 13;
            }
            if (charskill3[skill3][6] == 7){
                ptn[2] = 15;
            }
        }

        // 技が属性をもっている場合、属性を上書きする
        int zokusei1;
        int zokusei2;
        int zokusei3;
        // 1番目のキャラ
        if (charmove[0] == 3) {
            if (charskill1[skill1][5] != -1) {
                zokusei1 = charskill1[skill1][5];
            } else {
                zokusei1 = color1;
            }
        }else{
            zokusei1 = color1;
        }
        // 2番目のキャラ
        if (charmove[1] == 3) {
            if (charskill2[skill2][5] != -1) {
                zokusei2 = charskill2[skill2][5];
            } else {
                zokusei2 = color2;
            }
        }else {
            zokusei2 = color2;
        }
        // 3番目のキャラ
        if (charmove[2] == 3) {
            if (charskill3[skill3][5] != -1) {
                zokusei3 = charskill3[skill3][5];
            } else {
                zokusei3 = color3;
            }
        }else {
            zokusei3 = color3;
        }

        // 技が攻撃以外の場合キャラのステータスに反映(戦闘時の間)

        // 倍率付与
        if(zokusei1 != -1){
            atk1 = (int)(atk1 * zokusei[0][zokusei1]);
        }
        if(zokusei2 != -1){
            atk2 = (int)(atk2 * zokusei[1][zokusei2]);
        }
        if(zokusei3 != -1){
            atk3 = (int)(atk3 * zokusei[2][zokusei3]);
        }


        //クリティカル計算
        Random random = new Random();
        int num1 = random.nextInt(10000);
        int num2 = random.nextInt(10000);
        int num3 = random.nextInt(10000);
        //1番目のキャラ
        if(num1 <= (critical[0]*10000)-1){
            atk1 = atk1*2;
            cr[0] = "きゅうしょにあたった！";
        }else {
            cr[0] = "";
        }
        //2番目のキャラ
        if(num2 <= (critical[1]*10000)-1){
            atk2 = atk2*2;
            cr[1] = "きゅうしょにあたった！";
        }else {
            cr[1] = "";
        }
        //3番目のキャラ
        if(num3 <= (critical[2]*10000)-1){
            atk3 = atk3*2;
            cr[2] = "きゅうしょにあたった！";
        }else {
            cr[2] = "";
        }

        // spdの速い順にダメージ計算、hp[]変更、0の場合次の関数へ
        // 順番決定
        int c;
        // 計算用配列にspd[]の値を入れる
        int[] calcspd = new int[4];
        for(int x = 0; x<spd.length; x++){
            calcspd[x] = spd[x];
        }
        //順番認識用
        int order[] = {0,1,2,3};
        for(int i = 3; i > 0 ; i--){
            for (int y = 0; y < i; y++){
                if(calcspd[y]<calcspd[y+1]){
                    c = order[y];
                    order[y] = order[y+1];
                    order[y+1] = c;
                    c = calcspd[y];
                    calcspd[y] = calcspd[y+1];
                    calcspd[y+1] = c;
                }
            }
        }
        // 敵の弱点による倍率付与
        // キャラ1
        if(zokusei1 != -1){
            atk1 = (int)(atk1 * jakuten[zokusei1]);
        }
        // キャラ2
        if (zokusei2 != -1){
            atk2 = (int)(atk2 * jakuten[zokusei2]);
        }
        // キャラ3
        if(zokusei3 != -1){
            atk3 = (int)(atk3 * jakuten[zokusei3]);
        }

        //

        // ターン処理用データ取得
        for(int a = 0; a<3; a++){
            maxatk[a] = atk[a];
            maxdef[a] = def[a];
            maxspd[a] = spd[a];
        }

        // ログ初期化
        // ぼうぎょの場合戦闘前にあげる
        if (ptn[0] == 7){
            def[0] = maxdef[0]*2;
            bougyo[0] = 1;
            log.append(charname[0]+"はぼうぎょをした\n");
            ptn[0] = 14;
        }
        if (ptn[1] == 7){
            def[1] = maxdef[1]*2;
            bougyo[1] = 1;
            log.append(charname[1]+"はぼうぎょをした\n");
            ptn[1] = 14;
        }
        if (ptn[2] == 7){
            def[2] = maxdef[2]*2;
            bougyo[2] = 1;
            log.append(charname[2]+"はぼうぎょをした\n");
            ptn[2] = 14;
        }
        // 戦闘処理
        for (int i = 0; i < 4; i++){
            if (order[i] == 0){
                switch (ptn[0]){
                    case 0:
                        //
                        if(mp[0] < charskill1[skill1][1]){
                            log.append (charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            setHeal(selecter[0], skill1,0);
                            // mp
                        }
                        break;
                    case 1:
                        if(mp[0] < charskill1[skill1][1]){
                            log.append (charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            if (atk1 / 2 - def[3] / 4 <= 0) {
                                atk1 = (int)(Math.random() * 10);
                                if(!cr[0].equals("")){
                                    atk1 = atk[0];
                                }
                            } else {
                                atk1 = atk1 / 2 - def[3] / 4 + (int)(Math.random() * 20) - 10;
                                atk1 = Math.abs(atk1);
                                if(!cr[0].equals("") && atk1 < atk[0] + charskill1[skill1][2]){
                                    atk1 = atk[0] + charskill1[skill1][2];
                                }
                            }
                            hp[3] = hp[3] - atk1;
                            log.append (charname[0] + "の" + skillname[0][skill1] + "！" +cr[0]+ charname[3] + "に" + atk1 + "のダメージ\n");
                            hpZero(3);
                            if(resultFlg == 2 || resultFlg == 1) {
                                setResult();
                                return;
                            }
                        }
                        break;
                    case 2:
                        // DEF up
                        if(mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            setDFEup(selecter[0], charskill1[skill1][6], charskill1[skill1][3]);
                            if (charskill1[skill1][6] == 1){
                                log.append(charname[0] + "の" + skillname[0][skill1] + "!エレナたちはディフェンスがあがった\n");
                                char1Turn(1,1,2,charskill1[skill1][8]);
                                char1Turn(2,1,2,charskill1[skill1][8]);
                                char1Turn(3,1,2,charskill1[skill1][8]);
                            }else {
                                log.append(charname[0] + "の" + skillname[0][skill1] + "！"+charname[selecter[0]]+"はディフェンスがあがった\n");
                                char1Turn(selecter[0]+1,1,2,charskill1[skill1][8]);
                            }
                        }
                        break;
                    case 3:
                        // SPD up
                        if(mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            setSPDup(selecter[0], charskill1[skill1][6], charskill1[skill1][4]);
                            if (charskill1[skill1][6] == 1){
                                log.append(charname[0] + "の" + skillname[0][skill1] + "!エレナたちはスピードがあがった\n");
                                char1Turn(1,1,3,charskill1[skill1][8]);
                                char1Turn(2,1,3,charskill1[skill1][8]);
                                char1Turn(3,1,3,charskill1[skill1][8]);
                            }else {
                                log.append(charname[0] + "の" + skillname[0][skill1] + "！"+charname[selecter[0]]+"はスピードがあがった\n");
                                char1Turn(selecter[1]+1,1,3,charskill1[skill1][8]);
                            }
                        }
                        break;
                    case 4:
                        // ATK up
                        if (mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            setATKup(selecter[0], charskill1[skill1][6], charskill1[skill1][7]);
                            log.append(charname[0] + "の" + skillname[0][skill1] + "！"+charname[selecter[0]]+"はアタックがあがった\n");
                            char1Turn(selecter[0]+1,1,1,charskill1[skill1][8]);
                        }
                        break;
                    case 5:
                        log.append(charname[0]+"はうごけない\n");
                        break;
                    case 6:
                        if (atk1 / 2 - def[3] / 4 <= 0) {
                            atk1 = (int)(Math.random() * 10);
                            if(!cr[0].equals("")){
                                atk1 = atk[0];
                            }
                        } else {
                            atk1 = atk1 / 2 - def[3] / 4 + (int)(Math.random() * 20) - 10;
                            atk1 = Math.abs(atk1);
                            if(!cr[0].equals("") && atk1 < atk[0]){
                                atk1 = atk[0];
                            }
                        }
                        hp[3] = hp[3] - atk1;
                        log.append(charname[0] + "の こうげき！" +cr[0]+ charname[3] + "に" + atk1 + "のダメージ\n");
                        hpZero(3);
                        if(resultFlg == 2 || resultFlg == 1) {
                            setResult();
                            return;
                        }
                        break;
                    case 7:
                        def[0] = def[0]*2;
                        bougyo[0] = 1;
                        log.append(charname[0]+"はぼうぎょをした\n");
                        break;
                    case 8:
                        // 道具関数へ飛ぶ
                        Useitem(0);
                        break;
                    case 9:
                        //まひさせる
                        if (mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            enemyCnt[3] = charskill1[skill1][8];
                            log.append(charname[0] +"は"+skillname[0][skill1]+"をした！"+charname[3]+"はまひした\n");
                        }
                        break;
                    case 10:
                        //まひなおす
                        if(mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            log.append(charname[0]+"は"+skillname[0][skill1]+"をした");
                            char1Turn(selecter[0]+1,1,4,0);
                        }
                        break;
                    case 11:
                        //どくにさせる
                        if (mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");

                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            enemyCnt[4] = charskill1[skill1][8];
                            log.append(charname[0] +"は"+skillname[0][skill1]+"をした！"+charname[3]+"はどくをうけた\n");
                        }
                        break;
                    case 12:
                        //どくなおす
                        if (mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            int flag = 0;
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            switch (selecter[0]){
                                case 0:
                                    if (turnCnt1[4] != 0 && hp[0] > 0){
                                        turnCnt1[4] = 0;
                                        flag = 1;
                                    }
                                    break;
                                case 1:
                                    if (turnCnt2[4] != 0 && hp[1] > 0){
                                        turnCnt2[4] = 0;
                                        flag = 1;
                                    }
                                    break;
                                case 2:
                                    if (turnCnt3[4] != 0 && hp[2] > 0){
                                        turnCnt3[4] = 0;
                                        flag = 1;
                                    }
                                    break;
                            }
                            if (flag == 1){
                                log.append(charname[0]+"は"+skillname[0][skill1]+"をした！"+charname[selecter[0]]+"はどくがなおった\n");
                            }else{
                                log.append(charname[0]+"は"+skillname[0][skill1]+"にしっぱいした\n");
                            }
                        }
                        break;
                    case 13:
                        //そせい
                        if (mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            if(hp[selecter[0]] <= 0){
                                hp[selecter[0]] = charskill1[skill1][0];
                                viewhp[0][selecter[0]] = hp[selecter[0]];
                                log.append(charname[0]+"は"+skillname[0][skill1]+"をした！"+charname[selecter[0]]+"はふっかつした\n");
                            }else{
                                log.append(charname[0]+"は"+skillname[0][skill1]+"にしっぱいした\n");
                            }
                        }
                        break;
                    case 14:
                        break;
                    case 15:
                        if (mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[0] -= charskill1[skill1][1];
                            viewmp[0][0] = mp[0];
                            if(zokusei1 != -1){
                                atk1 = (int)(charskill1[skill1][2] * jakuten[zokusei1] * zokusei[0][zokusei1]) + (int)(Math.random() * 20) - 10;
                            }
                            else {
                                atk1 -= charskill1[skill1][2] + (int)(Math.random() * 20) - 10;
                            }
                            hp[3] -= atk1;
                            log.append(charname[0] + "の"+skillname[0][skill1]+"！" + charname[3] + "に" + atk1 + "のダメージ\n");
                            hpZero(3);
                            if(resultFlg == 2 || resultFlg == 1) {
                                setResult();
                                return;
                            }
                            break;

                        }
                        }
            }else if (order[i] == 1){
                switch (ptn[1]){
                    case 0:
                        if(mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            setHeal(selecter[1], skill2,1);
                        }
                        break;
                    case 1:
                        if(mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            if (atk2 / 2 - def[3] / 4 <= 0) {
                                atk2 = (int)(Math.random() * 10);
                                if(!cr[1].equals("")){
                                    atk2 = atk[1];
                                }
                            } else {
                                atk2 = atk2 / 2 - def[3] / 4 + (int)(Math.random() * 20) - 10;
                                atk2 = Math.abs(atk2);
                                if(!cr[1].equals("") && atk2 < atk[1] + charskill2[skill1][2]){
                                    atk2 = atk[1] + charskill2[skill1][2];
                                }
                            }
                            hp[3] = hp[3] - atk2;
                            log.append(charname[1] + "の" + skillname[1][skill2] + "！" +cr[1]+ charname[3] + "に" + atk2 + "のダメージ\n");
                            hpZero(3);
                            if(resultFlg == 2 || resultFlg == 1) {
                                setResult();
                                return;
                            }
                        }
                        break;
                    case 2:
                        // DFE up
                        if(mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            setDFEup(selecter[1], charskill2[skill2][6], charskill2[skill2][3]);
                            if (charskill2[skill2][6] == 1){
                                log.append(charname[1] + "の" + skillname[1][skill2] + "!エレナたちはディフェンスがあがった\n");
                                char1Turn(1,1,2,charskill2[skill2][8]);
                                char1Turn(2,1,2,charskill2[skill2][8]);
                                char1Turn(3,1,2,charskill2[skill2][8]);
                            }else {
                                log.append(charname[1] + "の" + skillname[1][skill2] + "！"+charname[selecter[1]]+"はディフェンスがあがった\n");
                                char1Turn(selecter[1]+1,1,2,charskill2[skill2][8]);
                            }
                        }
                        break;
                    case 3:
                        // SPD up
                        if(mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰが足りない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            setSPDup(selecter[1], charskill2[skill2][6], charskill2[skill2][4]);
                            if (charskill2[skill2][6] == 1){
                                log.append(charname[1] + "の" + skillname[1][skill2] + "!エレナたちはスピードがあがった\n");
                                char1Turn(1,1,3,charskill2[skill2][8]);
                                char1Turn(2,1,3,charskill2[skill2][8]);
                                char1Turn(3,1,3,charskill2[skill2][8]);
                            }else {
                                log.append(charname[1] + "の" + skillname[1][skill2] + "！"+charname[selecter[1]]+"はスピードがあがった\n");
                                char1Turn(selecter[1]+1,1,3,charskill2[skill2][8]);
                            }
                        }
                        break;
                    case 4:
                        // ATK up
                        if(mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            setATKup(selecter[1], charskill2[skill2][6], charskill2[skill2][7]);
                            log.append(charname[1] + "の" + skillname[1][skill2] + "！"+charname[selecter[1]]+"はアタックがあがった\n");
                            char1Turn(selecter[0]+1,1,1,charskill2[skill2][8]);
                        }
                        break;
                    case 5:
                        log.append(charname[1]+"はうごけない\n");
                        break;
                    case 6:
                        if (atk2 / 2 - def[3] / 4 <= 0) {
                            atk2 = (int)(Math.random() * 10);
                            if(!cr[1].equals("")){
                                atk2 = atk[1];
                            }
                        } else {
                            atk2 = atk2 / 2 - def[3] / 4 + (int)(Math.random() * 20) - 10;
                            atk2 = Math.abs(atk2);
                            if(!cr[1].equals("") && atk2 < atk[1]){
                                atk2 = atk[1];
                            }
                        }
                        hp[3] = hp[3] - atk2;
                        log.append(charname[1] + "の こうげき！" +cr[1]+ charname[3] + "に" + atk2 + "のダメージ\n");
                        hpZero(3);
                        if(resultFlg == 2 || resultFlg == 1) {
                            setResult();
                            return;
                        }
                        break;
                    case 7:
                        def[1] = def[1]*2;
                        bougyo[1] = 1;
                        log.append(charname[1]+"はぼうぎょをした\n");
                        break;
                    case 8:
                        Useitem(1);
                        break;
                    case 9:
                        //まひさせる
                        if (mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            enemyCnt[3] = charskill2[skill2][8];
                            log.append(charname[1] +"は"+skillname[1][skill2]+"をした！"+charname[3]+"はまひした\n");
                        }
                        break;
                    case 10:
                        //まひなおす
                        if(mp[0] < charskill1[skill1][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            log.append(charname[1]+"は"+skillname[1][skill2]+"をした");
                            char1Turn(selecter[1]+1,1,4,0);
                        }
                        break;
                    case 11:
                        //どくにさせる
                        if (mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            enemyCnt[4] = charskill2[skill2][8];
                            log.append(charname[1] +"は"+skillname[1][skill2]+"をした！"+charname[3]+"はどくをうけた\n");
                        }
                        break;
                    case 12:
                        //どくなおす
                        if (mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰがたりない\n");
                        }else {
                            int flag = 0;
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            switch (selecter[1]){
                                case 0:
                                    if (turnCnt1[4] != 0 && hp[0] > 0){
                                        turnCnt1[4] = 0;
                                        flag = 1;                                        }
                                    break;
                                case 1:
                                    if (turnCnt2[4] != 0 && hp[1] > 0){
                                        turnCnt2[4] = 0;
                                        flag = 1;
                                    }
                                    break;
                                case 2:
                                    if (turnCnt3[4] != 0 && hp[2] > 0){
                                        turnCnt3[4] = 0;
                                        flag = 1;
                                    }
                            }
                            if (flag == 1){
                                log.append(charname[1]+"は"+skillname[1][skill2]+"をした！"+charname[selecter[1]]+"はどくがなおった\n");
                            }else {
                                log.append(charname[1]+"は"+skillname[1][skill2]+"にしっぱいした\n");
                            }
                        }
                        break;
                    case 13:
                        //そせい
                        if (mp[1] < charskill2[skill2][1]){
                            log.append(charname[0]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            if(hp[selecter[0]] <= 0){
                                hp[selecter[0]] = charskill2[skill2][0];
                                log.append(charname[1]+"は"+skillname[1][skill2]+"をした！"+charname[selecter[0]]+"はふっかつした\n");
                            }else{
                                log.append(charname[1]+"は"+skillname[1][skill2]+"にしっぱいした\n");
                            }
                        }
                        break;
                    case 14:
                        break;
                    case 15:
                        if (mp[1] < charskill2[skill2][1]){
                            log.append(charname[1]+"はＭＰがたりない\n");
                        }else {
                            mp[1] -= charskill2[skill2][1];
                            viewmp[1][1] = mp[1];
                            if(zokusei2 != -1){
                                atk2 = (int)(charskill2[skill2][2] * jakuten[zokusei2] * zokusei[1][zokusei2]) + (int)(Math.random() * 20) - 10;
                            }
                            else {
                                atk2 -= charskill2[skill2][2] + (int)(Math.random() * 20) - 10;
                            }
                            hp[3] -= atk2;
                            log.append(charname[1] + "の" + skillname[1][skill2] + "！" + charname[3] + "に" + atk2 + "のダメージ\n");
                            hpZero(3);
                            if (resultFlg == 2 || resultFlg == 1) {
                                setResult();
                                return;
                            }
                        }
                            break;
                        }
            }else if (order[i] == 2){
                switch (ptn[2]){
                    case 0:
                        // 回復
                        if (mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            setHeal(selecter[2], skill3,2);
                        }
                        break;
                    case 1:
                        if(mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            if (atk3 / 2 - def[3] / 4 <= 0) {
                                atk3 = (int)(Math.random() * 10);
                                if(!cr[2].equals("")){
                                    atk3 = atk[2];
                                }
                            } else {
                                atk3 = atk3 / 2 - def[3] / 4 + (int)(Math.random() * 20) - 10;
                                atk3 = Math.abs(atk3);
                                if(!cr[2].equals("") && atk3 < atk[2] + charskill3[skill1][2]){
                                    atk3 = atk[2] + charskill3[skill1][2];
                                }
                            }
                            hp[3] = hp[3] - atk3;
                            log.append(charname[2] + "の" + skillname[2][skill3] + "！" +cr[2]+ charname[3] + "に" + atk3 + "のダメージ\n");
                            hpZero(3);
                            if(resultFlg == 2 || resultFlg == 1) {
                                setResult();
                                return;
                            }
                        }
                        break;
                    case 2:
                        // DFE up
                        if(mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            setDFEup(selecter[2], charskill3[skill3][6], charskill3[skill3][3]);
                            if (charskill3[skill3][6] == 1){
                                log.append(charname[2] + "の" + skillname[2][skill3] + "!エレナたちはディフェンスがあがった\n");
                                char1Turn(1,1,2,charskill3[skill3][8]);
                                char1Turn(2,1,2,charskill3[skill3][8]);
                                char1Turn(3,1,2,charskill3[skill3][8]);
                            }else {
                                log.append(charname[2] + "の" + skillname[2][skill3] + "！"+charname[selecter[2]]+"はディフェンスがあがった\n");
                                char1Turn(selecter[2]+1,1,2,charskill3[skill3][8]);
                            }
                        }
                        break;
                    case 3:
                        // SPD up
                        if (mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            setSPDup(selecter[2], charskill3[skill3][6], charskill3[skill3][4]);
                            if (charskill3[skill3][6] == 1) {
                                log.append(charname[2] + "の" + skillname[2][skill3] + "!エレナたちはスピードがあがった\n");
                                char1Turn(1, 1, 3, charskill3[skill3][8]);
                                char1Turn(2, 1, 3, charskill3[skill3][8]);
                                char1Turn(3, 1, 3, charskill3[skill3][8]);
                            }else {
                                log.append(charname[2] + "の" + skillname[2][skill3] + "！"+charname[selecter[2]]+"はスピードがあがった\n");
                                char1Turn(selecter[2]+1, 1, 3, charskill3[skill3][8]);
                            }
                        }
                        break;
                    case 4:
                        // ATK up
                        if (mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            setATKup(selecter[2], charskill3[skill3][6], charskill3[skill3][7]);
                            log.append(charname[2] + "の" + skillname[2][skill3] + "！"+charname[selecter[2]]+"はアタックがあがった\n");
                            char1Turn(selecter[2]+1,1,1,charskill3[skill3][8]);
                        }
                        break;
                    case 5:
                        log.append(charname[2]+"はうごけない\n");
                        break;
                    case 6:
                        if (atk3 / 2 - def[3] / 4 <= 0) {
                            atk3 = (int)(Math.random() * 10);
                            if(!cr[2].equals("")){
                                atk3 = atk[2];
                            }
                        } else {
                            atk3 = atk3 / 2 - def[3] / 4 + (int)(Math.random() * 20) - 10;
                            atk3 = Math.abs(atk3);
                            if(!cr[2].equals("") && atk3 < atk[2]){
                                atk3 = atk[2];
                            }
                        }
                        hp[3] = hp[3] - atk3;
                        log.append(charname[2] + "の こうげき！" +cr[2]+ charname[3] + "に" + atk3 + "のダメージ\n");
                        hpZero(3);
                        if(resultFlg == 2 || resultFlg == 1) {
                            setResult();
                            return;
                        }
                    break;
                    case 7:
                        def[2] = def[2]*2;
                        bougyo[2] = 1;
                        log.append(charname[2]+"はぼうぎょをした\n");
                        break;
                    case 8:
                        Useitem(2);
                        break;
                    case 9:
                        //まひさせる
                        if (mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            enemyCnt[3] = charskill3[skill3][8];
                            log.append(charname[2] +"は"+skillname[2][skill3]+"をした！"+charname[3]+"はまひした\n");
                        }
                        break;
                    case 10:
                        //まひなおす
                        if(mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill1][1];
                            viewmp[2][2] = mp[2];
                            log.append(charname[2]+"は"+skillname[2][skill3]+"をした");
                            char1Turn(selecter[2]+1,1,4,0);
                        }
                        break;
                    case 11:
                        //どくにさせる
                        if (mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            enemyCnt[4] = charskill3[skill3][8];
                            log.append(charname[2] +"は"+skillname[2][skill3]+"をした！"+charname[3]+"はどくをうけた\n");
                        }
                        break;
                    case 12:
                        //どくなおす
                        if (mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            int flag = 0;
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            switch (selecter[2]){
                                case 0:
                                    if (turnCnt1[4] != 0 && hp[0] > 0){
                                        turnCnt1[4] = 0;
                                        flag = 1;
                                    }
                                    break;
                                case 1:
                                    if (turnCnt2[4] != 0 && hp[1] > 0){
                                        turnCnt2[4] = 0;
                                        flag = 1;
                                    }
                                    break;
                                case 2:
                                    if (turnCnt3[4] != 0 && hp[2] > 0){
                                        turnCnt3[4] = 0;
                                        flag = 1;
                                    }
                            }
                            if (flag == 1){
                                log.append(charname[2]+"は"+skillname[2][skill3]+"をした！"+charname[selecter[2]]+"はどくがなおった\n");
                            }else {
                                log.append(charname[2]+"は"+skillname[2][skill3]+"にしっぱいした\n");
                            }
                        }
                        break;
                    case 13:
                        //そせい
                        if (mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            if(hp[selecter[0]] <= 0){
                                hp[selecter[0]] = charskill3[skill3][0];
                                log.append(charname[2]+"は"+skillname[2][skill3]+"をした！"+charname[selecter[0]]+"はふっかつした\n");
                            }else{
                                log.append(charname[2]+"は"+skillname[2][skill3]+"にしっぱいした\n");
                            }
                        }
                        break;
                    case 14:
                        break;
                    case 15:
                        if (mp[2] < charskill3[skill3][1]){
                            log.append(charname[2]+"はＭＰがたりない\n");
                        }else {
                            mp[2] -= charskill3[skill3][1];
                            viewmp[2][2] = mp[2];
                            if(zokusei3 != -1){
                                atk3 = (int)(charskill3[skill3][2] * jakuten[zokusei3] * zokusei[2][zokusei3]) + (int)(Math.random() * 20) - 10;
                            }
                            else {
                                atk3 -= charskill3[skill3][2] + (int)(Math.random() * 20) - 10;
                            }
                            hp[3] -= atk3;
                            log.append(charname[2] + "の" + skillname[2][skill3] + "！" + charname[3] + "に" + atk3 + "のダメージ\n");
                            hpZero(3);
                            if (resultFlg == 2 || resultFlg == 1) {
                                setResult();
                                return;
                            }
                        }
                            break;
                        }
            }else{
                // 敵攻撃関数へ
                enemyAttack();
                if(resultFlg == 2 || resultFlg == 1) {
                    setResult();
                    return;
                }
                // HPが0の場合行動不能へ
                if (flg1 == 1){
                    ptn[0] = 5;
                }
                if (flg2 == 1){
                    ptn[1] = 5;
                }
                if(flg3 == 1){
                    ptn[2] = 5;
                }
            }

        }
        //ターン数減
        char1Turn(1,0,0,0);
        hpZero(0);
        if(resultFlg == 2 || resultFlg == 1) {
            setResult();
            return;
        }
        char1Turn(2,0,0,0);
        hpZero(1);
        if(resultFlg == 2 || resultFlg == 1) {
            setResult();
            return;
        }
        char1Turn(3,0,0,0);
        hpZero(2);
        if(resultFlg == 2 || resultFlg == 1) {
            setResult();
            return;
        }
        char1Turn(6,0,0,0);
        char1Turn(6,0,1,0);
        char1Turn(6,0,2,0);

        char1Turn(5,0,0,0);
        hpZero(5);
        if(resultFlg == 2 || resultFlg == 1) {
            setResult();
            return;
        }
        // ぼうぎょ終了
        for (int s = 0;s < 3; s++){
            if(bougyo[s] == 1){
                def[s] = def[s]/2;
            }
        }
        // 結果
        setResult();
    }

   public static void setResult(){
       change = log.toString();

       int num = 0;
       StringTokenizer stringTokenizer = new StringTokenizer(change,"\n");
       while (stringTokenizer.hasMoreTokens()){
           stringTokenizer.nextToken();
           num++;
       }
       StringTokenizer stringTokenizer2 = new StringTokenizer(change,"\n");
       result = new String[num];
       num = 0;
       while (stringTokenizer2.hasMoreTokens()){
           result[num] = stringTokenizer2.nextToken();
           num++;
       }
       ComandCtrl.resultview(result);
       log = new StringBuilder();
   }

    // 回復処理
    public static void setHeal(int a, int b,int c){
        switch (c){
            case 0:
                if (charskill1[b][6] == 1){
                    // 全キャラを回復
                    if(hp[0] > 0) {
                        if (hp[0] + charskill1[b][0] < maxhp[0]) {
                            hp[0] += charskill1[b][0];
                            viewhp[0][0] = hp[0];
                        } else {
                            hp[0] = maxhp[0];
                            viewhp[0][0] = hp[0];
                        }
                    }
                    if (hp[1] > 0) {
                        if (hp[1] + charskill1[b][0] < maxhp[1]) {
                            hp[1] += charskill1[b][0];
                            viewhp[0][1] = hp[1];
                        } else {
                            hp[1] = maxhp[1];
                            viewhp[0][1] = hp[1];
                        }
                    }
                    if (hp[2] > 0) {
                        if (hp[2] + charskill1[b][0] < maxhp[2]) {
                            hp[2] += charskill1[b][0];
                            viewhp[0][2] = hp[2];
                        } else {
                            hp[2] = maxhp[2];
                            viewhp[0][2] = hp[2];
                        }
                    }
                    log.append(charname[c] + "の" + skillname[0][b] + "！エレナたちはＨＰをかいふくした\n");


                }else {
                    if (hp[a] > 0) {
                        if (hp[a] + charskill1[b][0] < maxhp[a]) {
                            hp[a] += charskill1[b][0];
                            viewhp[0][selecter[0]] = hp[a];
                            data1 = charskill1[b][0];
                            log.append(charname[c] + "の" + skillname[0][b] + "！" + charname[selecter[0]] + "はＨＰを" + data1 + "かいふくした\n");
                        } else {
                            data1 = maxhp[a] - hp[a];
                            hp[a] = maxhp[a];
                            viewhp[0][selecter[0]] = hp[a];
                            log.append(charname[c] + "の" + skillname[0][b] + "！" + charname[selecter[0]] + "はＨＰを" + data1 + "かいふくした\n");
                        }
                    }else {
                        log.append(charname[c] + "の" + skillname[0][b] + "！" + charname[selecter[0]] + "はたおれている\n");
                    }
                }
                break;
            case 1:
                if(charskill2[b][6] == 1){
                    // 全キャラを回復
                    if (hp[0] + charskill2[b][0] < maxhp[0]) {
                        hp[0] += charskill2[b][0];
                        viewhp[1][0] = hp[0];
                    } else {
                        hp[0] = maxhp[0];
                        viewhp[1][0] = hp[0];
                    }
                    if (hp[1] + charskill2[b][0] < maxhp[1]) {
                        hp[1] += charskill2[b][0];
                        viewhp[1][1] = hp[1];
                    } else {
                        hp[1] = maxhp[1];
                        viewhp[1][1] = hp[1];
                    }
                    if (hp[2] + charskill2[b][0] < maxhp[2]) {
                        hp[2] += charskill2[b][0];
                        viewhp[1][2] = hp[2];
                    } else {
                        hp[2] = maxhp[2];
                        viewhp[1][2] = hp[2];
                    }
                    log.append(charname[c] + "の" + skillname[0][b] + "！エレナたちはＨＰをかいふくした\n");

                }else {
                    if (hp[a] > 0) {
                        if (hp[a] + charskill2[b][0] < maxhp[a]) {
                            hp[a] += charskill2[b][0];
                            viewhp[1][selecter[1]] = hp[a];
                            data2 = charskill2[b][0];
                            log.append(charname[c] + "の" + skillname[1][b] + "！" + charname[selecter[1]] + "はＨＰを" + data2 + "かいふくした\n");
                        } else {
                            data2 = maxhp[a] - hp[a];
                            hp[a] = maxhp[a];
                            viewhp[1][selecter[1]] = hp[a];
                            log.append(charname[c] + "の" + skillname[1][b] + "！" + charname[selecter[1]] + "はＨＰを" + data2 + "かいふくした\n");
                        }
                    }else {
                        log.append(charname[c] + "の" + skillname[1][b] + "！" + charname[selecter[1]] + "はたおれている\n");
                    }
                }
                break;
            case 2:
                if (charskill3[b][6] == 1){
                    // 全キャラを回復
                    if (hp[0] + charskill3[b][0] < maxhp[0]) {
                        hp[0] += charskill3[b][0];
                        viewhp[2][0] = hp[0];
                    } else {
                        hp[0] = maxhp[0];
                        viewhp[2][0] = hp[0];
                    }
                    if (hp[1] + charskill3[b][0] < maxhp[1]) {
                        hp[1] += charskill3[b][0];
                        viewhp[2][1] = hp[1];
                    } else {
                        hp[1] = maxhp[1];
                        viewhp[2][1] = hp[1];
                    }
                    if (hp[2] + charskill3[b][0] < maxhp[2]) {
                        hp[2] += charskill3[b][0];
                        viewhp[2][2] = hp[2];
                    } else {
                        hp[2] = maxhp[2];
                        viewhp[2][2] = hp[2];
                    }
                    log.append(charname[c] + "の" + skillname[0][b] + "！エレナたちはＨＰをかいふくした\n");
                }else {
                    if (hp[a] > 0) {
                        if (hp[a] + charskill3[b][0] < maxhp[a]) {
                            hp[a] += charskill3[b][0];
                            viewhp[2][selecter[2]] = hp[a];
                            data3 = charskill3[b][0];
                            log.append(charname[c] + "の" + skillname[2][b] + "！" + charname[selecter[2]] + "はＨＰを" + data3 + "かいふくした\n");
                        } else {
                            data3 = maxhp[a] - hp[a];
                            hp[a] = maxhp[a];
                            viewhp[2][selecter[2]] = hp[a];
                            log.append(charname[c] + "の" + skillname[2][b] + "！" + charname[selecter[2]] + "はＨＰを" + data3 + "かいふくした\n");
                        }
                    }else {
                        log.append(charname[c] + "の" + skillname[2][b] + "！" + charname[selecter[2]] + "はたおれている\n");
                    }
                }
                break;
        }
    }

    // ATKup処理
    public static void setATKup(int a, int b, int c){
        switch (a){
            case 0:
                if(b == 1){
                    // 全体のatkアップ
                    if(turnCnt1[0] == 0){
                        atk[0] += (int)(maxatk[0]*0.5);
                    }
                    if(turnCnt2[0] == 0){
                        atk[1] += (int)(maxatk[1]*0.5);
                    }
                    if (turnCnt3[0] == 0){
                        atk[2] += (int)(maxatk[2]*0.5);
                    }
                }else {
                    if(turnCnt1[0] == 0){
                        atk[0] += (int)(maxatk[0]*0.5);
                    }
                }
                break;
            case 1:
                if(b == 1){
                    // 全体のatkアップ
                    if(turnCnt1[0] == 0){
                        atk[0] += (int)(maxatk[0]*0.5);
                    }
                    if(turnCnt2[0] == 0){
                        atk[1] += (int)(maxatk[1]*0.5);
                    }
                    if (turnCnt3[0] == 0){
                        atk[2] += (int)(maxatk[2]*0.5);
                    }
                }else{
                    if(turnCnt2[0] == 0){
                        atk[1] += (int)(maxatk[1]*0.5);
                    }
                }
                break;
            case 2:
                if (b == 1){
                    // 全体のatkアップ
                    if(turnCnt1[0] == 0){
                        atk[0] += (int)(maxatk[0]*0.5);
                    }
                    if(turnCnt2[0] == 0){
                        atk[1] += (int)(maxatk[1]*0.5);
                    }
                    if (turnCnt3[0] == 0){
                        atk[2] += (int)(maxatk[2]*0.5);
                    }
                }else{
                    if (atkData[2] == 0){
                        atk[2] += (int)(maxatk[2]*0.5);
                    }
                }
                break;
        }
    }

    // DFEup処理
    public static void setDFEup(int a, int b ,int c){
        switch (a){
            case 0:
                if(b == 1){
                    // ディフェンスアップ
                    if(turnCnt1[1] == 0){
                        def[0] += (int)(maxdef[0]*0.5);
                    }
                    if(turnCnt2[1] == 0){
                        def[1] += (int)(maxdef[1]*0.5);
                    }
                    if (turnCnt3[1] == 0){
                        def[2] += (int)(maxdef[2]*0.5);
                    }


                }else {
                    if(turnCnt1[1] == 0) {
                        def[0] += (int) (maxdef[0] * 0.5);
                    }
                }
                break;
            case 1:
                if(b == 1){
                    // 全体のdefアップ
                    if(turnCnt1[1] == 0){
                        def[0] += (int)(maxdef[0]*0.5);
                    }
                    if(turnCnt2[1] == 0){
                        def[1] += (int)(maxdef[1]*0.5);
                    }
                    if (turnCnt3[1] == 0){
                        def[2] += (int)(maxdef[2]*0.5);
                    }
                }else{
                    if(turnCnt2[1] == 0){
                        def[1] += (int)(maxdef[0]*0.5);
                    }
                }
                break;
            case 2:
                if (b == 1){
                    // 全体のdefアップ
                    if(turnCnt1[1] == 0){
                        def[0] += (int)(maxdef[0]*0.5);
                    }
                    if(turnCnt2[1] == 0){
                        def[1] += (int)(maxdef[1]*0.5);
                    }
                    if (turnCnt3[1] == 0){
                        def[2] += (int)(maxdef[2]*0.5);
                    }


                }else{
                    if (turnCnt3[1] == 0){
                        def[2] += (int)(maxdef[2]*0.5);
                    }
                }
                break;
        }

    }

    public static void setSPDup(int a, int b, int c){
        switch (a){
            case 0:
                if(b == 1){
                    // 全体のスピードアップ
                    if(turnCnt1[2] == 0){
                        spd[0] += (int)(maxspd[0]*0.5);
                    }
                    if(turnCnt2[2] == 0){
                        spd[1] += (int)(maxspd[1]*0.5);
                    }
                    if (turnCnt3[2] == 0){
                        spd[2] += (int)(maxspd[2]*0.5);
                    }
                }else {
                    if(turnCnt1[2] == 0){
                        spd[0] += (int)(maxspd[0]*0.5);
                    }
                }
                break;
            case 1:
                if(b == 1){
                    // 全体のスピードアップ
                    if(turnCnt1[2] == 0){
                        spd[0] += (int)(maxspd[0]*0.5);
                    }
                    if(turnCnt2[2] == 0){
                        spd[1] += (int)(maxspd[1]*0.5);
                    }
                    if (turnCnt3[2] == 0){
                        spd[2] += (int)(maxspd[2]*0.5);
                    }
                }else {
                    if(turnCnt2[2] == 0) {
                        spd[1] += (int) (maxspd[1] * 0.5);
                    }
                }
                break;
            case 2:
                if(b == 1){
                    // 全体のスピードアップ
                    if(turnCnt1[2] == 0){
                        spd[0] += (int)(maxspd[0]*0.5);
                    }
                    if(turnCnt2[2] == 0){
                        spd[1] += (int)(maxspd[1]*0.5);
                    }
                    if (turnCnt3[2] == 0){
                        spd[2] += (int)(maxspd[2]*0.5);
                    }
                }else {
                    if (turnCnt3[2] == 0){
                        spd[2] += (int)(maxspd[2]*0.5);
                    }
                }
                break;
        }
    }


    // ターン管理
    public static void char1Turn(int i, int x, int y, int z){  // キャラ　技を使用したか //項目 //値
        switch (i){
            case 1: // 適用キャラ判断
                if(x == 1){ // 技を使用した場合
                    switch (y) { //atk 1 def 2 spd 3
                        case 1:
                            if (turnCnt1[0] < z) turnCnt1[0] = z;
                            break;
                        case 2:
                            if (turnCnt1[1] < z) turnCnt1[1] = z;
                            break;
                        case 3:
                            if (turnCnt1[2] < z) turnCnt1[2] = z;
                            break;
                        case 4:
                            if (turnCnt1[3] > 0){
                                turnCnt1[3] = 0;
                                log.append(charname[i-1]+"はまひがなおった\n");
                            }else{
                                log.append("　がこうかはないようだ\n");
                            }
                            break;
                        case 5:
                            if (turnCnt1[4] > 0 && hp[0] > 0){
                                turnCnt1[4] = 0;
                                log.append(charname[i-1]+"はどくがなおった\n");
                            }else{
                                log.append("　がこうかはないようだ\n");
                            }
                            break;

                    }
                }else{ // 技を使用していなかった場合
                    if(turnCnt1[0] != 0){ // atk
                        turnCnt1[0] = turnCnt1[0]-1;
                        if(turnCnt1[0] == 0){
                            atk[0] -= (int)(maxatk[0]*0.5);
                            log.append(charname[0]+"のアタックがもとにもどった\n");
                        }
                    }
                    if(turnCnt1[1] != 0){
                        turnCnt1[1] = turnCnt1[1]-1;
                        if(turnCnt1[1] == 0){
                            def[0] -= (int)(maxdef[0]*0.5);
                            log.append(charname[0]+"のディフェンスがもとにもどった\n");
                        }
                    }
                    if(turnCnt1[2] != 0){
                        turnCnt1[2] = turnCnt1[2]-1;
                        if(turnCnt1[2] == 0){
                            spd[0] -= (int)(maxspd[0]*0.5);
                            log.append(charname[0]+"のスピードがもとにもどった\n");
                        }
                    }
                    if(turnCnt1[3] != 0){
                        turnCnt1[3] = turnCnt1[3]-1;
                        if(turnCnt1[3] == 0){
                            log.append(charname[0]+"のまひがなおった\n");
                            viewmp[0][0] = mp[0];
                        }
                    }
                    if(turnCnt1[4] != 0){
                        turnCnt1[4] = turnCnt1[4]-1;
                        if(turnCnt1[4] == 0  && hp[0] > 0){
                            log.append(charname[0]+"のどくがなおった\n");
                            viewmp[0][0] = mp[0];
                        }
                        else if(hp[0] > maxhp[0]*0.1){
                            hp[0] -= maxhp[0]*0.1;
                            poisonhp[0] = hp[0];
                            log.append(charname[0]+"はどくのダメージを"+(int)(maxhp[0]*0.1)+"をうけた\n");
                        }else {
                            log.append(charname[0]+"はどくのダメージを"+hp[0]+"をうけた\n");
                            hp[0] =0;
                            poisonhp[0] = 0;
                        }
                    }
                    if(turnCnt1[5] != 0){
                        turnCnt1[5] = turnCnt1[5]-1;
                        if (turnCnt1[5] == 0){
                            log.append(charname[0]+"のアタックがもとにもどった\n");
                        }
                    }
                    if(turnCnt1[6] != 0){
                        turnCnt1[6] = turnCnt1[6]-1;
                        if (turnCnt1[6] == 0){
                            log.append(charname[0]+"のディフェンスがもとにもどった\n");
                        }
                    }
                    if(turnCnt1[7] != 0){
                        turnCnt1[7] = turnCnt1[7]-1;
                        if (turnCnt1[7] == 0){
                            log.append(charname[0]+"のスピードがもとにもどった\n");
                        }
                    }
                }
                break;
            case 2:
                if(x == 1){ // 技を使用した場合
                    switch (y) { //atk 1 def 2 spd 3
                        case 1:
                            if (turnCnt2[0] < z) turnCnt2[0] = z;
                            break;
                        case 2:
                            if (turnCnt2[1] < z) turnCnt2[1] = z;
                            break;
                        case 3:
                            if (turnCnt2[2] < z) turnCnt2[2] = z;
                            break;
                        case 4:
                            if (turnCnt2[3] > 0){
                                turnCnt2[3] = 0;
                                log.append(charname[i-1]+"はまひがなおった\n");
                            }else{
                                log.append("　がこうかはないようだ\n");
                            }
                            break;
                        case 5:
                            if (turnCnt2[4] > 0 && hp[1] > 0){
                                turnCnt2[4] = 0;
                                log.append(charname[i-1]+"はどくがなおった\n");
                            }else{
                                log.append("　がこうかはないようだ\n");
                            }
                            break;
                    }
                }else { // 技を使用していなかった場合
                    if(turnCnt2[0] != 0){ // atk
                        turnCnt2[0] = turnCnt2[0]-1;
                        if(turnCnt2[0] == 0){
                            atk[1] -= (int)(maxatk[1]*0.5);
                            log.append(charname[1]+"のアタックがもとにもどった\n");
                        }
                    }
                    if(turnCnt2[1] != 0){
                        turnCnt2[1] = turnCnt2[1]-1;
                        if(turnCnt2[1] == 0){
                            def[1] -= (int)(maxdef[1]*0.5);
                            log.append(charname[1]+"のディフェンスがもとにもどった\n");
                        }
                    }
                    if(turnCnt2[2] != 0){
                        turnCnt2[2] = turnCnt2[2]-1;
                        if(turnCnt2[2] == 0){
                            spd[1] -= (int)(maxspd[1]*0.5);
                            log.append(charname[1]+"のスピードがもとにもどった\n");
                        }
                    }
                    if(turnCnt2[3] != 0){
                        turnCnt2[3] = turnCnt2[3]-1;
                        if(turnCnt2[3] == 0){
                            log.append(charname[1]+"のまひがなおった\n");
                            viewmp[1][1] = mp[1];
                        }

                    }
                    if(turnCnt2[4] != 0 && hp[2] > 0){
                        turnCnt2[4] = turnCnt2[4]-1;
                        if(turnCnt2[4] == 0){
                            log.append(charname[1]+"のどくがなおった\n");
                            viewmp[1][1] = mp[1];
                        }else if(hp[1] > maxhp[1]*0.1){
                            hp[1] -= maxhp[1]*0.1;
                            poisonhp[1] = hp[1];
                            log.append(charname[1]+"はどくのダメージを"+(int)(maxhp[1]*0.1)+"をうけた\n");
                        }else {
                            log.append(charname[1]+"はどくのダメージを"+hp[1]+"をうけた\n");
                            hp[1] = 0;
                            poisonhp[1] = hp[1];
                        }

                    }
                    if(turnCnt2[5] != 0){
                        turnCnt2[5] = turnCnt2[5]-1;
                        if (turnCnt2[5] == 0){
                            log.append(charname[1]+"のアタックがもとにもどった\n");
                        }
                    }
                    if(turnCnt2[6] != 0){
                        turnCnt2[6] = turnCnt2[6]-1;
                        if (turnCnt2[6] == 0){
                            log.append(charname[1]+"のディフェンスがもとにもどった\n");
                        }
                    }
                    if(turnCnt2[7] != 0){
                        turnCnt2[7] = turnCnt2[7]-1;
                        if (turnCnt2[7] == 0){
                            log.append(charname[1]+"のスピードがもとにもどった\n");
                        }
                    }
                }
                break;
            case 3:
                if(x == 1){ // 技を使用した場合
                    switch (y) { //atk 1 def 2 spd 3
                        case 1:
                            if (turnCnt3[0] < z) turnCnt3[0] = z;
                            break;
                        case 2:
                            if (turnCnt3[1] < z) turnCnt3[1] = z;
                            break;
                        case 3:
                            if (turnCnt3[2] < z) turnCnt3[2] = z;
                            break;
                        case 4:
                            if (turnCnt3[3] > 0){
                                turnCnt3[3] = 0;
                                log.append(charname[i-1]+"はまひがなおった\n");
                            }else{
                                log.append("　がこうかはないようだ\n");
                            }
                            break;
                        case 5:
                            if (turnCnt3[4] > 0){
                                turnCnt3[4] = 0;
                                log.append(charname[i-1]+"はどくがなおった\n");
                            }else{
                                log.append("　がこうかはないようだ\n");
                            }
                            break;

                    }
                }else { // 技を使用していなかった場合
                    if(turnCnt3[0] != 0){ // atk
                        turnCnt3[0] = turnCnt3[0]-1;
                        if(turnCnt3[0] == 0){
                            atk[2] -= (int)(maxatk[2]*0.5);
                            log.append(charname[2]+"のアタックがもとにもどった\n");
                        }
                    }
                    if(turnCnt3[1] != 0){
                        turnCnt3[1] = turnCnt3[1]-1;
                        if(turnCnt3[1] == 0){
                            def[2] -= (int)(maxdef[2]*0.5);
                            log.append(charname[2]+"のディフェンスがもとにもどった\n");
                        }
                    }
                    if(turnCnt3[2] != 0){
                        turnCnt3[2] = turnCnt3[2]-1;
                        if(turnCnt3[2] == 0){
                            spd[2] -= (int)(maxspd[2]*0.5);
                            log.append(charname[2]+"のスピードがもとにもどった\n");
                        }
                    }
                    if(turnCnt3[3] != 0){
                        turnCnt3[3] = turnCnt3[3]-1;
                        if(turnCnt3[3] == 0){
                            log.append(charname[2]+"のまひがなおった\n");
                            viewmp[2][2] = mp[2];
                        }
                    }
                    if(turnCnt3[4] != 0){
                        turnCnt3[4] = turnCnt3[4]-1;
                        if(turnCnt3[4] == 0){
                            log.append(charname[2]+"のどくがなおった\n");
                            viewmp[2][2] = mp[2];
                        } else if(hp[2] > maxhp[2]*0.1){
                            hp[2] -= maxhp[2]*0.1;
                            poisonhp[2] = hp[2];
                            log.append(charname[2]+"はどくのダメージを"+(int)(maxhp[2]*0.1)+"をうけた\n");
                        }else {
                            log.append(charname[2]+"はどくのダメージを"+hp[2]+"をうけた\n");
                            hp[2] = 0;
                            poisonhp[2] = 0;
                        }
                    }
                    if(turnCnt3[5] != 0){
                        turnCnt3[5] = turnCnt3[5]-1;
                        if (turnCnt3[5] == 0){
                            log.append(charname[2]+"のアタックがもとにもどった\n");
                        }
                    }
                    if(turnCnt3[6] != 0){
                        turnCnt3[6] = turnCnt3[6]-1;
                        if (turnCnt3[6] == 0){
                            log.append(charname[2]+"のディフェンスがもとにもどった\n");
                        }
                    }
                    if(turnCnt3[7] != 0){
                        turnCnt3[7] = turnCnt3[7]-1;
                        if (turnCnt3[7] == 0){
                            log.append(charname[2]+"のスピードがもとにもどった\n");
                        }
                    }
                }
                break;
            case 4:
                switch (y) { //atk 1 def 2 spd 3
                    case 1:
                        turnCnt1[0] = z;
                        turnCnt2[0] = z;
                        turnCnt3[0] = z;
                        break;
                    case 2:
                        turnCnt1[1] = z;
                        turnCnt2[1] = z;
                        turnCnt3[1] = z;
                        break;
                    case 3:
                        turnCnt1[2] = z;
                        turnCnt2[2] = z;
                        turnCnt3[2] = z;
                }
            case 5:
                if(enemyCnt[4] != 0){
                    enemyCnt[4]--;
                    if(enemyCnt[4] == 0){
                        log.append(charname[3]+"はどくがなおった\n");
                    }else{
                        hp[3] -= 50;
                        log.append(charname[3]+"はどくのダメージ50をうけた\n");
                    }
                }
                break;
            case 6:
                switch (y) { // atk 0 def 1 spd 2
                    case 0:
                        if (enemyCnt[0] != 0){
                            enemyCnt[0]--;
                            if (enemyCnt[0] == 0){
                                log.append(charname[3]+"のアタックがもとにもどった\n");
                            }
                        }
                        break;
                    case 1:
                        if (enemyCnt[1] != 0){
                            enemyCnt[1]--;
                            if (enemyCnt[1] == 0){
                                log.append(charname[3]+"のぼうぎょがもとにもどった\n");
                            }
                        }
                        break;
                    case 2:
                        if (enemyCnt[2] != 0){
                            enemyCnt[2]--;
                            if (enemyCnt[2] == 0){
                                log.append(charname[3]+"のスピードがもとにもどった\n");
                            }
                        }
                        break;
                }
        }
    }

    // h
    public static void hpZero(int a){
        switch (a){
            case 0:
                if(hp[0] <= 0 && flg1 != 1 && resultFlg == 0){
                    flg1 = 1;
                    log.append(charname[0]+"はたおれた\n");
                    if(hp[1] <= 0 && hp[2] <= 0){
                        log.append("ぜんめつしてしまった");
                        resultFlg = 1;
                    }
                }
                break;
            case 1:
                if (hp[1] <= 0 && flg2 != 1 && resultFlg == 0){
                    flg2 = 1;
                    log.append(charname[1]+"はたおれた\n");
                    if(hp[0] <= 0 && hp[2] <= 0){
                        log.append("ぜんめつしてしまった");
                        resultFlg = 1;
                    }
                }
                break;
            case 2:
                if (hp[2] <= 0 && flg3 != 1 && resultFlg == 0){
                    flg3 = 1;
                    log.append(charname[2]+"はたおれた\n");
                    if(hp[1] <= 0 && hp[0] <= 0){
                        log.append("ぜんめつしてしまった");
                        resultFlg = 1;
                    }
                }
                break;
            case 3:
                if (hp[3] <= 0){
                    log.append(charname[3] + "　をたおした\n");
                    if(dropItemID >= 0){
                        int random = (int)(Math.random() * 100);
                        if(random > 0 && random <= dropRate - 1){
                            PlayerData.getItem(dropItemID);
                            log.append(charname[3] + "は　" + dropName + "　をおとしていった\n");
                            log.append(charname[0] + "たちは　" + dropName + "　をてにいれた");
                        }
                    }
                    else if(dropSkillID >= 0){
                        int random = (int)(Math.random() * 100);
                        if(random > 0 && random <= dropRate - 1){
                            log.append(charname[3] + "は　" + dropName + "のひでんしょ　をおとしていった\n");
                            if(PlayerData.getSkill(dropSkillID)) {
                                log.append(charname[0] + "たちは　" + dropName + "　をおぼえた");
                            }else{
                                log.append( "しかし　すでにおぼえていた");
                            }
                        }
                    }
                    resultFlg = 2;
                }
                break;
        }
    }


    // 敵の攻撃関数
    public static void enemyAttack(){
        //atk値格納
        if(enemyCnt[3] != 0) {
            log.append(charname[3]+"はまひしている\n");
        }else{
            int a = atk[3];
            //技選択 技数判別
            int es = 0;
            for (int i = 0; i < skillnameE.length; i++) {
                if (skillnameE[i] != null) {
                    es ++;
                }
            }
            es ++;
            Random random = new Random();
            int num = random.nextInt(es);

            if(num == es - 1){
                // 攻撃相手決定
                int f = 0;
                int you = 0;
                while (f == 0) {
                    you = random.nextInt(3);
                    if (hp[you] > 0) {
                        f = 1;
                    }
                }
                if (a / 2 <= def[you] / 4) {
                    a = (int)(Math.random() * 5);
                } else {
                    a = a / 2 - def[you] / 4 + (int)(Math.random() * 10) - 5;
                }
                hp[you] = hp[you] - a;
                viewhp[3][you] = hp[you];

                log.append(charname[3] + "のこうげき！" + charname[you] + "に" + a + "のダメージ\n");
                for (int b = 0; b < 3; b++) {
                    hpZero(b);
                }
            }else {
                if (enemyskill[num][1] != 0 && enemyskill[num][5] != 1) {
                    // 技のatk値をaに上乗せ
                    a += enemyskill[num][1];
                    // 攻撃相手決定
                    int f = 0;
                    int you = 0;
                    while (f == 0) {
                        you = random.nextInt(3);
                        if (hp[you] > 0) {
                            f = 1;
                        }
                    }
                    if (a / 2 <= def[you] / 4) {
                        a = (int)(Math.random() * 5);
                    } else {
                        a = a / 2 - def[you] / 4 + (int)(Math.random() * 10) - 5;
                    }
                    hp[you] = hp[you] - a;
                    viewhp[3][you] = hp[you];

                    log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "に" + a + "のダメージ\n");
                    for (int b = 0; b < 3; b++) {
                        hpZero(b);
                    }
                }
                // ATKが-ならアタック下げ
                if (enemyskill[num][1] < 0) {
                    int f = 0;
                    int you = 0;
                    while (f == 0) {
                        you = random.nextInt(3);
                        if (hp[you] > 0) {
                            f = 1;
                        }
                        switch (you) {
                            case 0:
                                turnCnt1[5] = enemyskill[num][7];
                                if (turnCnt1[5] == 0) {
                                    atk[you] -= (int) (maxatk[you] * 0.5);
                                }
                                log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のアタックがさがった\n");
                                break;
                            case 1:
                                turnCnt2[5] = enemyskill[num][7];
                                if (turnCnt2[5] == 0) {
                                    atk[you] -= (int) (maxatk[you] * 0.5);
                                }
                                log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のアタックがさがった\n");
                                break;
                            case 2:
                                turnCnt3[5] = enemyskill[num][7];
                                if (turnCnt3[5] == 0) {
                                    atk[you] -= (int) (maxatk[you] * 0.5);
                                }
                                log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のアタックがさがった\n");
                                break;
                        }
                    }
                }
                if (enemyskill[num][2] < 0) {
                    int f = 0;
                    int you = 0;
                    while (f == 0) {
                        you = random.nextInt(3);
                        if (hp[you] > 0) {
                            f = 1;
                        }
                        switch (you) {
                            case 0:
                                turnCnt1[6] = enemyskill[num][7];
                                if (turnCnt1[6] == 0) {
                                    def[you] -= (int) (maxdef[you] * 0.5);
                                }
                                log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のディフェンスがさがった\n");
                                break;
                            case 1:
                                turnCnt2[6] = enemyskill[num][7];
                                if (turnCnt2[6] == 0) {
                                    def[you] -= (int) (maxdef[you] * 0.5);
                                }
                                log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のディフェンスがさがった\n");
                                break;
                            case 2:
                                turnCnt3[6] = enemyskill[num][7];
                                if (turnCnt3[6] == 0) {
                                    def[you] -= (int) (maxdef[you] * 0.5);
                                }
                                log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のディフェンスがさがった\n");
                                break;
                        }
                    }

                }
                if (enemyskill[num][2] > 0){
                    if (enemyCnt[1] == 0){
                        def[3] += (int)(maxdef[3]*0.5);
                    }
                    enemyCnt[1] = enemyskill[num][7];
                    log.append(charname[3] + "の" + skillnameE[num] + "！"+charname[3]+"のぼうぎょがあがった\n");
                }
                if (enemyskill[num][3] > 0){
                    if (enemyCnt[2] == 0){
                        spd[3] += (int)(maxspd[3]*0.5);
                    }
                    enemyCnt[2] = enemyskill[num][7];
                    log.append(charname[3] + "の" + skillnameE[num] + "！"+charname[3]+"のスピードがあがった\n");
                }
                if (enemyskill[num][6] != 0){
                    if (enemyCnt[0] == 0){
                        atk[3] += (int)(maxatk[3]*0.5);
                    }
                    enemyCnt[0] = enemyskill[num][7];
                    log.append(charname[3] + "の" + skillnameE[num] + "！"+charname[3]+"のアタックがあがった\n");
                }
                if (enemyskill[num][3] < 0) {
                    int f = 0;
                    int you = 0;
                    while (f == 0) {
                        you = random.nextInt(3);
                        if (hp[you] > 0) {
                            f = 1;
                        }
                    }
                    switch (you) {
                        case 0:
                            turnCnt1[7] = enemyskill[num][7];
                            if (turnCnt1[7] == 0) {
                                spd[you] -= (int) (maxspd[you] * 0.5);
                            }
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のスピードがさがった\n");
                            break;
                        case 1:
                            turnCnt2[7] = enemyskill[num][7];
                            if (turnCnt2[7] == 0) {
                                spd[you] -= (int) (maxspd[you] * 0.5);
                            }
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のスピードがさがった\n");
                            break;
                        case 2:
                            turnCnt3[7] = enemyskill[num][7];
                            if (turnCnt3[7] == 0) {
                                spd[you] -= (int) (maxspd[you] * 0.5);
                            }
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "のスピードがさがった\n");
                            break;
                    }
                }
                if (enemyskill[num][5] == 4) {
                    int f = 0;
                    int you = 0;
                    while (f == 0) {
                        you = random.nextInt(3);
                        if (hp[you] > 0) {
                            f = 1;
                        }
                    }
                    switch (you) {
                        case 0:
                            turnCnt1[4] = enemyskill[num][7];
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "はどくをうけた\n");
                            break;
                        case 1:
                            turnCnt2[4] = enemyskill[num][7];
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "はどくをうけた\n");
                            break;
                        case 2:
                            turnCnt3[4] = enemyskill[num][7];
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "はどくをうけた\n");
                            break;
                    }
                }
                if (enemyskill[num][5] == 2) {
                    int f = 0;
                    int you = 0;
                    while (f == 0) {
                        you = random.nextInt(3);
                        if (hp[you] > 0) {
                            f = 1;
                        }
                    }
                    switch (you) {
                        case 0:
                            turnCnt1[3] = enemyskill[num][7];
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "はまひをした\n");
                            break;
                        case 1:
                            turnCnt2[3] = enemyskill[num][7];
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "はまひをした\n");
                            break;
                        case 2:
                            turnCnt3[3] = enemyskill[num][7];
                            log.append(charname[3] + "の" + skillnameE[num] + "！" + charname[you] + "はまひをした\n");
                            break;
                    }

                }
                if (enemyskill[num][5] == 1){
                    a = atk[3];
                    a += enemyskill[num][1];
                    if (hp[0] > 0) {
                        if (a / 2 <= def[0] / 4) {
                            a = (int)(Math.random() * 5);
                        } else {
                            a = a / 2 - def[0] / 4 + (int)(Math.random() * 10) - 5;
                        }
                    hp[0] = hp[0] - a;
                    viewhp[3][0] = hp[0];
                     }
                    a = atk[3];
                    a += enemyskill[num][1];
                    if (hp[1] > 0) {
                        if (a / 2 <= def[1] / 4) {
                            a = (int)(Math.random() * 5);
                        } else {
                            a = a / 2 - def[1] / 4 + (int)(Math.random() * 10) - 5;
                        }
                        hp[1] = hp[1] - a;
                        viewhp[3][1] = hp[1];
                    }
                    a = atk[3];
                    a += enemyskill[num][1];
                    if (hp[2] > 0) {
                        if (a / 2 <= def[2] / 4) {
                            a = (int)(Math.random() * 5);
                        } else {
                            a = a / 2 - def[2] / 4 + (int)(Math.random() * 10) - 5;
                        }
                        hp[2] = hp[2] - a;
                        viewhp[3][2] = hp[2];
                    }

                    log.append(charname[3] + "の" + skillnameE[num] + "！エレナたちはダメージをうけた\n");
                for (int b = 0; b < 3; b++) {
                    hpZero(b);
                }
            }
            }
        }
        if(enemyCnt[3] > 0){
            enemyCnt[3]--;
            if(enemyCnt[3] == 0){
                log.append(charname[3]+"の まひ がなおった\n");
            }
        }
    }

    public static String[] getResult() {
        return result;
    }
    // 全体か個人か判断
    //能力上げ系の技のターン数カウント
    //味方キャラ、敵キャラのステータスを格納 (データベース抽出クラスからもらう)

    //道具関数
    public static void Useitem(int a){
        PlayerData.useItemSetted(a, item[a]);
        switch (a){
            case 0:
                if(charitem1[item[0]][0] != 0){
                    setHealitem(a,selecter[a]);
                }
                if(charitem1[item[0]][1] != 0){
                    setMpitem(a,selecter[a]);
                }
                if (charitem1[item[0]][2] != 0){
                        hp[3] -= charitem1[item[0]][2];
                        log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　" +charname[3]+"に"+(charitem1[item[0]][2])+"のダメージ\n");
                }
                if (charitem1[item[0]][3] != 0){
                    switch (selecter[0]){
                        case 0:
                            if (turnCnt1[1] == 0) def[selecter[0]] += (int)(maxdef[selecter[0]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[1] == 0) def[selecter[0]] += (int)(maxdef[selecter[0]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[1] == 0) def[selecter[0]] += (int)(maxdef[selecter[0]]*0.5);
                            break;
                    }
                    char1Turn(selecter[0]+1,1,2,charitem1[item[0]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　"+charname[selecter[0]]+"のディフェンスがあがった\n");
                }
                if (charitem1[item[0]][4] != 0){
                    switch (selecter[0]){
                        case 0:
                            if (turnCnt1[2] == 0) spd[selecter[0]] += (int)(maxspd[selecter[0]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[2] == 0) spd[selecter[0]] += (int)(maxspd[selecter[0]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[2] == 0) spd[selecter[0]] += (int)(maxspd[selecter[0]]*0.5);
                            break;
                    }
                    char1Turn(selecter[0]+1,1,3,charitem1[item[0]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　"+charname[selecter[0]]+"のスピードがあがった\n");
                }
                if (charitem1[item[0]][6] != 0){
                    switch (selecter[0]){
                        case 0:
                            if (turnCnt1[0] == 0) atk[selecter[0]] += (int)(maxatk[selecter[0]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[0] == 0) atk[selecter[0]] += (int)(maxatk[selecter[0]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[0] == 0) atk[selecter[0]] += (int)(maxatk[selecter[0]]*0.5);
                            break;
                    }
                    char1Turn(selecter[0]+1,1,1,charitem1[item[0]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　"+charname[selecter[0]]+"のアタックがあがった\n");
                }
                if (charitem1[item[0]][5] == 2){
                    if (enemyCnt[3] < charitem1[item[0]][7]) enemyCnt[3] = charitem1[item[0]][7];
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　"+charname[3]+"はまひした\n");
                }
                if (charitem1[item[0]][5] == 4){
                    if (enemyCnt[4] < charitem1[item[0]][7]) enemyCnt[4] = charitem1[item[0]][7];
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　"+charname[3]+"はどくをうけた\n");
                }
                if (charitem1[item[0]][5] == 3){
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　");
                    char1Turn(selecter[0],1,4,0);
                }
                if (charitem1[item[0]][5] == 5){
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　");
                    char1Turn(selecter[0]+1,1,5,0);
                }
                if (charitem1[item[0]][5] == 6){
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　");
                    if(hp[selecter[0]] <= 0){
                        if (charitem1[item[0]][7] >= maxhp[selecter[0]]){
                            hp[selecter[0]] = maxhp[selecter[0]];
                            viewhp[0][selecter[0]] = hp[selecter[0]];
                        }else {
                            hp[selecter[0]] = charitem1[item[0]][7];
                            viewhp[0][selecter[0]] = hp[selecter[0]];
                        }
                        log.append(charname[selecter[0]]+"はふっかつした\n");
                    }else{
                        log.append("がこうかはないようだ\n");
                    }
                }
                break;
            case 1:
                if(charitem2[item[1]][0] != 0){
                    setHealitem(a,selecter[a]);
                }
                if(charitem2[item[1]][1] != 0){
                    setMpitem(a,selecter[a]);
                }
                if (charitem2[item[1]][2] != 0){
                        hp[3] -= charitem2[item[1]][2];
                        log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　" +charname[3]+"に"+(charitem2[item[1]][2])+"のダメージ\n");
                }
                if (charitem2[item[1]][3] != 0){
                    switch (selecter[1]){
                        case 0:
                            if (turnCnt1[1] == 0) def[selecter[1]] += (int)(maxdef[selecter[1]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[1] == 0) def[selecter[1]] += (int)(maxdef[selecter[1]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[1] == 0) def[selecter[1]] += (int)(maxdef[selecter[1]]*0.5);
                            break;
                    }
                    char1Turn(selecter[1]+1,1,2,charitem2[item[1]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　"+charname[selecter[1]]+"のディフェンスがあがった\n");
                }
                if (charitem2[item[1]][4] != 0){
                    switch (selecter[1]){
                        case 0:
                            if (turnCnt1[2] == 0) spd[selecter[1]] += (int)(maxspd[selecter[1]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[2] == 0) spd[selecter[1]] += (int)(maxspd[selecter[1]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[2] == 0) spd[selecter[1]] += (int)(maxspd[selecter[1]]*0.5);
                            break;
                    }
                    char1Turn(selecter[1]+1,1,3,charitem2[item[1]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　"+charname[selecter[1]]+"のスピードがあがった\n");
                }
                if (charitem2[item[1]][6] != 0){
                    switch (selecter[1]){
                        case 0:
                            if (turnCnt1[0] == 0) atk[selecter[1]] += (int)(maxatk[selecter[1]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[0] == 0) atk[selecter[1]] += (int)(maxatk[selecter[1]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[0] == 0) atk[selecter[1]] += (int)(maxatk[selecter[1]]*0.5);
                            break;
                    }
                    char1Turn(selecter[1]+1,1,1,charitem2[item[1]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　"+charname[selecter[1]]+"のアタックがあがった\n");
                }
                if (charitem2[item[1]][5] == 2){
                    if (enemyCnt[3] < charitem2[item[1]][8]) enemyCnt[3] = charitem2[item[1]][7];
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　"+charname[3]+"はまひした\n");
                }
                if (charitem2[item[1]][5] == 4){
                    if (enemyCnt[4] < charitem2[item[1]][7]) enemyCnt[4] = charitem2[item[1]][7];
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　"+charname[3]+"はどくをうけた\n");
                }
                if (charitem2[item[1]][5] == 3){
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　");
                    char1Turn(selecter[1],1,4,0);
                }
                if (charitem2[item[1]][5] == 5){
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　");
                    char1Turn(selecter[1]+1,1,5,0);
                }
                if (charitem2[item[1]][5] == 6){
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　");
                    if(hp[selecter[1]] <= 0){
                        if (charitem2[item[1]][7] >= maxhp[1]){
                            hp[selecter[1]] = maxhp[selecter[1]];
                            viewhp[1][selecter[1]] = hp[selecter[1]];
                        }else {
                            hp[selecter[1]] = charitem2[item[1]][7];
                            viewhp[1][selecter[1]] = hp[selecter[1]];
                        }
                        log.append(charname[selecter[1]]+"はふっかつした\n");
                    }else{
                        log.append("がこうかはないようだ\n");
                    }
                }
                break;
            case 2:
                if(charitem3[item[2]][0] != 0){
                    setHealitem(a,selecter[a]);
                }
                if(charitem3[item[2]][1] != 0){
                    setMpitem(a,selecter[a]);
                }
                if (charitem3[item[2]][2] != 0){
                        hp[3] -= charitem3[item[2]][2];
                        log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　" +charname[3]+"に"+(charitem3[item[2]][2])+"のダメージ\n");
                }
                if (charitem3[item[2]][3] != 0){
                    switch (selecter[2]){
                        case 0:
                            if (turnCnt1[1] == 0) def[selecter[2]] += (int)(maxdef[selecter[2]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[1] == 0) def[selecter[2]] += (int)(maxdef[selecter[2]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[1] == 0) def[selecter[2]] += (int)(maxdef[selecter[2]]*0.5);
                            break;
                    }
                    char1Turn(selecter[2]+1,1,2,charitem3[item[2]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　"+charname[selecter[2]]+"のディフェンスがあがった\n");
                }
                if (charitem3[item[2]][4] != 0){
                    switch (selecter[2]){
                        case 0:
                            if (turnCnt1[2] == 0) spd[selecter[2]] += (int)(maxspd[selecter[2]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[2] == 0) spd[selecter[2]] += (int)(maxspd[selecter[2]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[2] == 0) spd[selecter[2]] += (int)(maxspd[selecter[2]]*0.5);
                            break;
                    }
                    char1Turn(selecter[2]+1,1,3,charitem3[item[2]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　"+charname[selecter[2]]+"のスピードがあがった\n");
                }
                if (charitem3[item[2]][6] != 0){
                    switch (selecter[2]){
                        case 0:
                            if (turnCnt1[0] == 0) atk[selecter[2]] += (int)(maxatk[selecter[2]]*0.5);
                            break;
                        case 1:
                            if (turnCnt2[0] == 0) atk[selecter[2]] += (int)(maxatk[selecter[2]]*0.5);
                            break;
                        case 2:
                            if (turnCnt3[0] == 0) atk[selecter[2]] += (int)(maxatk[selecter[2]]*0.5);
                            break;
                    }
                    char1Turn(selecter[2]+1,1,1,charitem3[item[2]][7]);
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　"+charname[selecter[2]]+"のアタックがあがった\n");
                }
                if (charitem3[item[2]][5] == 2){
                    if (enemyCnt[3] < charitem3[item[2]][7]) enemyCnt[3] = charitem3[item[2]][7];
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　"+charname[3]+"はまひした\n");
                }
                if (charitem3[item[2]][5] == 4){
                    if (enemyCnt[4] < charitem3[item[2]][7]) enemyCnt[4] = charitem3[item[2]][7];
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　"+charname[3]+"はどくをうけた\n");
                }
                if (charitem3[item[2]][5] == 3){
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　");
                    char1Turn(selecter[2],1,4,0);
                }
                if (charitem3[item[2]][5] == 5){
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　");
                    char1Turn(selecter[2]+1,1,5,0);
                }
                if (charitem3[item[2]][5] == 6){
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　");
                    if(hp[selecter[2]] <= 0){
                        if (charitem3[item[2]][7] >= maxhp[selecter[2]]){
                            hp[selecter[2]] = maxhp[selecter[2]];
                            viewhp[2][selecter[2]] = hp[selecter[2]];
                        }else {
                            hp[selecter[2]] = charitem3[item[2]][7];
                            viewhp[2][selecter[2]] = hp[selecter[2]];
                        }
                        log.append(charname[selecter[2]]+"はふっかつした\n");
                    }else{
                        log.append("がこうかはないようだ\n");
                    }
                }
                break;
        }
        CombatManagement.itemname[a][item[a]] = "";
    }

    public static void setHealitem(int a, int b){
        switch (a){
            case 0:
                if (charitem1[item[0]][5] == 1){
                    // 全キャラを回復
                    if (hp[0] > 0) {
                        if (hp[0] + charitem1[item[0]][0] < maxhp[0]) {
                            hp[0] += charitem1[item[0]][0];
                            viewhp[0][0] = hp[0];
                        } else {
                            hp[0] = maxhp[0];
                            viewhp[0][0] = hp[0];
                        }
                    }
                    if (hp[1] > 0) {
                        if (hp[1] + charitem1[item[0]][0] < maxhp[1]) {
                            hp[1] += charitem1[item[0]][0];
                            viewhp[0][1] = hp[1];
                        } else {
                            hp[1] = maxhp[1];
                            viewhp[0][1] = hp[1];
                        }
                    }
                    if (hp[2] > 0) {
                        if (hp[2] + charitem1[item[0]][0] < maxhp[2]) {
                            hp[2] += charitem1[item[0]][0];
                            viewhp[0][2] = hp[2];
                        } else {
                            hp[2] = maxhp[2];
                            viewhp[0][2] = hp[2];
                        }
                    }
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　エレナたちはＨＰをかいふくした\n");


                }else {
                    if (hp[b] > 0) {
                        if (hp[b] + charitem1[item[0]][0] < maxhp[b]) {
                            hp[b] += charitem1[item[0]][0];
                            viewhp[0][b] = hp[b];
                            data1 = charitem1[item[0]][0];
                            log.append(charname[a] + "は" + itemname[a][item[0]] + "をつかった　" + charname[selecter[0]] + "はＨＰを" + data1 + "かいふくした\n");
                        } else {
                            data1 = maxhp[b] - hp[b];
                            hp[b] = maxhp[b];
                            viewhp[0][b] = hp[b];
                            log.append(charname[a] + "は" + itemname[a][item[0]] + "をつかった　" + charname[selecter[0]] + "はＨＰを" + data1 + "かいふくした\n");
                        }
                    }else {
                        log.append(charname[a] + "は" + itemname[a][item[0]] + "をつかった　" + charname[selecter[0]] + "はたおれている\n");
                    }
                }
                break;
            case 1:
                if(charitem2[item[1]][5] == 1){
                    // 全キャラを回復
                    if (hp[0] > 0) {
                        if (hp[0] + charitem2[item[1]][0] < maxhp[0]) {
                            hp[0] += charitem2[item[1]][0];
                            viewhp[1][0] = hp[0];
                        } else {
                            hp[0] = maxhp[0];
                            viewhp[1][0] = hp[0];
                        }
                    }
                    if (hp[1] > 0) {
                        if (hp[1] + charitem2[item[1]][0] < maxhp[1]) {
                            hp[1] += charitem2[item[1]][0];
                            viewhp[1][1] = hp[1];
                        } else {
                            hp[1] = maxhp[1];
                            viewhp[1][1] = hp[1];
                        }
                    }
                    if (hp[2] > 0) {
                        if (hp[2] + charitem2[item[1]][0] < maxhp[2]) {
                            hp[2] += charitem2[item[1]][0];
                            viewhp[1][2] = hp[2];
                        } else {
                            hp[2] = maxhp[2];
                            viewhp[1][2] = hp[2];
                        }
                    }
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　エレナたちはＨＰをかいふくした\n");

                }else {
                    if (hp[b] > 0) {
                        if (hp[b] + charitem2[item[1]][0] < maxhp[b]) {
                            hp[b] += charitem2[item[1]][0];
                            viewhp[1][b] = hp[b];
                            data2 = charitem2[item[1]][0];
                            log.append(charname[a] + "は" + itemname[a][item[1]] + "をつかった　" + charname[selecter[1]] + "はＨＰを" + data2 + "かいふくした\n");
                        } else {
                            data2 = maxhp[1] - hp[1];
                            hp[1] = maxhp[1];
                            viewhp[1][b] = hp[b];
                            log.append(charname[a] + "は" + itemname[a][item[1]] + "をつかった　" + charname[selecter[1]] + "はＨＰを" + data2 + "かいふくした\n");
                        }
                    }else {
                        log.append(charname[a] + "は" + itemname[a][item[1]] + "をつかった　" + charname[selecter[1]] + "はたおれている\n");
                    }
                }
                break;
            case 2:
                if (charitem3[b][5] == 1){
                    // 全キャラを回復
                    if (hp[0] > 0) {
                        if (hp[0] + charitem3[item[2]][0] < maxhp[0]) {
                            hp[0] += charitem3[item[2]][0];
                            viewhp[2][0] = hp[0];
                        } else {
                            hp[0] = maxhp[0];
                            viewhp[2][0] = hp[0];
                        }
                    }
                    if (hp[1] > 0) {
                        if (hp[1] + charitem3[item[2]][0] < maxhp[1]) {
                            hp[1] += charitem3[item[2]][0];
                            viewhp[2][1] = hp[1];
                        } else {
                            hp[1] = maxhp[1];
                            viewhp[2][1] = hp[1];
                        }
                    }
                    if (hp[2] > 0) {
                        if (hp[2] + charitem3[item[2]][0] < maxhp[2]) {
                            hp[2] += charitem3[item[2]][0];
                            viewhp[2][2] = hp[2];
                        } else {
                            hp[2] = maxhp[2];
                            viewhp[2][2] = hp[2];
                        }
                    }
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　エレナたちはＨＰをかいふくした\n");

                }else {
                    if (hp[b] > 0) {
                        if (hp[b] + charitem3[item[2]][0] < maxhp[b]) {
                            hp[b] += charitem3[item[2]][0];
                            viewhp[2][b] = hp[b];
                            data3 = charitem3[item[2]][0];
                            log.append(charname[a] + "は" + itemname[a][item[2]] + "をつかった　" + charname[selecter[2]] + "はＨＰを" + data3 + "かいふくした\n");
                        } else {
                            data3 = maxhp[2] - hp[2];
                            hp[b] = maxhp[b];
                            viewhp[2][b] = hp[b];
                            log.append(charname[a] + "は" + itemname[a][item[2]] + "をつかった　" + charname[selecter[2]] + "はＨＰを" + data3 + "かいふくした\n");
                        }
                    }else {
                        log.append(charname[a] + "は" + itemname[a][item[2]] + "をつかった　" + charname[selecter[2]] + "はたおれている\n");
                    }
                }
                break;
        }
    }
    public static void setMpitem(int a, int b){
        switch (a){
            case 0:
                if (charitem1[item[0]][5] == 1){
                    // 全キャラを回復
                    if (mp[0] + charitem1[item[0]][1] < maxmp[0]) {
                        mp[0] += charitem1[item[0]][1];
                        viewmp[0][0] = mp[0];
                    } else {
                        mp[0] = maxmp[0];
                        viewmp[0][0] = mp[0];
                    }
                    if (mp[1] + charitem1[item[0]][1] < maxmp[1]) {
                        mp[1] += charitem1[item[0]][1];
                        viewmp[0][1] = mp[1];
                    } else {
                        mp[1] = maxmp[1];
                        viewmp[0][1] = mp[1];
                    }
                    if (mp[2] + charitem1[item[0]][1] < maxmp[2]) {
                        mp[2] += charitem1[item[0]][1];
                        viewmp[0][2] = mp[2];
                    } else {
                        mp[2] = maxmp[2];
                        viewmp[0][2] = mp[2];
                    }
                    log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　エレナたちはＭＰをかいふくした\n");

                }else {
                    if (mp[b] + charitem1[item[0]][1] < maxmp[b]) {
                        mp[b] += charitem1[item[0]][1];
                        viewmp[0][b] = mp[b];
                        data1 = charitem1[item[0]][1];
                        log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　"+charname[selecter[a]]+"はＭＰを"+data1+"かいふくした\n");
                    } else {
                        data1 = maxmp[b] - mp[b];
                        mp[b] = maxmp[b];
                        viewmp[0][b] = mp[b];
                        log.append(charname[a]+"は"+itemname[a][item[0]]+"をつかった　"+charname[selecter[a]]+"はＭＰを"+data1+"かいふくした\n");
                    }
                }
                break;
            case 1:
                if(charitem2[item[1]][5] == 1){
                    // 全キャラを回復
                    if (mp[0] + charitem2[item[1]][1] < maxmp[0]) {
                        mp[0] += charitem2[item[1]][1];
                        viewmp[1][0] = mp[0];
                    } else {
                        mp[0] = maxmp[0];
                        viewmp[1][0] = mp[0];
                    }
                    if (mp[1] + charitem2[item[1]][1] < maxmp[1]) {
                        mp[1] += charitem2[item[1]][1];
                        viewmp[1][1] = mp[1];
                    } else {
                        mp[1] = maxmp[1];
                        viewmp[1][1] = mp[1];
                    }
                    if (mp[2] + charitem2[item[1]][1] < maxmp[2]) {
                        mp[2] += charitem2[item[1]][1];
                        viewmp[1][2] = mp[2];
                    } else {
                        mp[2] = maxmp[2];
                        viewmp[1][2] = mp[2];
                    }
                    log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　エレナたちはＭＰをかいふくした\n");

                }else {
                    if (mp[b] + charitem2[item[1]][1] < maxmp[b]) {
                        mp[b] += charitem2[item[1]][1];
                        viewmp[1][b] = mp[b];
                        data2 = charitem2[item[1]][1];
                        log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　"+charname[selecter[a]]+"はＭＰを"+data2+"かいふくした\n");
                    } else {
                        data2 = maxmp[b] - mp[b];
                        mp[b] = maxmp[b];
                        viewmp[1][b] = mp[b];
                        log.append(charname[a]+"は"+itemname[a][item[1]]+"をつかった　"+charname[selecter[a]]+"はＭＰを"+data2+"かいふくした\n");
                    }
                }
                break;
            case 2:
                if (charitem3[item[2]][5] == 1){
                    // 全キャラを回復
                    if (mp[0] + charitem3[item[2]][1] < maxmp[0]) {
                        mp[0] += charitem3[item[2]][1];
                        viewmp[2][0] = mp[0];
                    } else {
                        mp[0] = maxmp[0];
                        viewmp[2][0] = mp[0];
                    }
                    if (mp[1] + charitem3[item[2]][1] < maxmp[1]) {
                        mp[1] += charitem3[item[2]][1];
                        viewmp[2][1] = mp[1];
                    } else {
                        mp[1] = maxmp[1];
                        viewmp[2][1] = mp[1];
                    }
                    if (mp[2] + charitem3[item[2]][1] < maxmp[2]) {
                        mp[2] += charitem3[item[2]][1];
                        viewmp[2][2] = mp[2];
                    } else {
                        mp[2] = maxmp[2];
                        viewmp[2][2] = mp[2];
                    }
                    log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　エレナたちはＭＰをかいふくした\n");

                }else {
                    if (mp[b] + charitem3[item[2]][1] < maxmp[b]) {
                        mp[b] += charitem3[item[2]][1];
                        viewmp[2][b] = mp[b];
                        data3 = charitem3[item[2]][1];
                        log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　"+charname[selecter[a]]+"はＭＰを"+data3+"かいふくした\n");
                    } else {
                        data3 = maxmp[b] - mp[b];
                        mp[b] = maxmp[b];
                        viewmp[2][b] = mp[b];
                        log.append(charname[a]+"は"+itemname[a][item[2]]+"をつかった　"+charname[selecter[a]]+"はＭＰを"+data3+"かいふくした\n");
                    }
                }
                break;
        }
    }
}