package jp.ac.uejobi.aruquest;

import android.support.v4.app.Fragment;

/**
 * Created by uejobi on 2018/11/14.
 */

public class ComandCtrl extends Fragment {

    static int charOrder;


    static Char1MoveFragment char1MoveFragment = new Char1MoveFragment();
    static BattleFragment battleFragment = new BattleFragment();
    CharSelectFragment charSelectFragment = new CharSelectFragment();
    // コマンド判断変数
    // こうげき　か　ぼうぎょ　か　わざ　か　どうぐ
    static int move[] = new int[3];
    // 技の対象
    static int selecter[] = new int[3];
    // 技判断変数
    static int skill[] = new int[3];
    // アイテム判断変数
    static int item[] = new int[3];

    //hpとmpを受け取る変数
    static int[] Hp = new int[3];
    static int[] Mp = new int[3];

    // データクラスから呼び出してくる予定
    //技能力値格納 0HP  1MP  2ATK  3DEF  4SPD  5属性 6対象 7アタック値up の順

    public void setcharskill(int a,int b){
        skill[a] = b;
    }

    public void skillselect(int a){
        move[a] = 3;
    }

    public void setComand(){
        charOrder = 0;

    }
    public void orderback(){
            charOrder--;
            char1MoveFragment.setCharmove();
    }

    public static void viewmp(int a){
       // Hp[0] = CombatManagement.getHp1();
       // Hp[1] = CombatManagement.getHp2();
       // Hp[2] = CombatManagement.getHp3();
        switch (a){
            case 0:
                if (move[0] == 3){
                    Mp[0] = CombatManagement.viewmp[0][0];
                }
                break;
            case 1:
                if (move[1] == 3){
                    Mp[1] = CombatManagement.viewmp[1][1];
                }
                break;
            case 2:
                if (move[2] == 3){
                    Mp[2] = CombatManagement.viewmp[2][2];
                }
        }

    }
    public void exit(int a){
        BattleFragment fragment = new BattleFragment();
        move[0] = 5;
        CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
        CombatManagement.damageCalc();
        String[] m = CombatManagement.getResult();
        String[] msg = new String[m.length];
        for (int i = 0; i<m.length;i++) {
            msg[i] = this.changeNumHalfToFull(m[i]);
        }
        fragment.setResult(msg);
        this.end();


    }

    public static void viewhp(int a){
        switch (a){
            case 0:
                Hp[0] = CombatManagement.viewhp[3][0];
                break;
            case 1:
                Hp[1] = CombatManagement.viewhp[3][1];
                break;
            case 2:
                Hp[2] = CombatManagement.viewhp[3][2];
                break;
        }
    }
    public static void viewhppoison(int a){
        switch (a){
            case 0:
                Hp[0] = CombatManagement.poisonhp[0];
                break;
            case 1:
                Hp[1] = CombatManagement.poisonhp[1];
                break;
            case 2:
                Hp[2] = CombatManagement.poisonhp[2];
                break;
        }
    }

    public static void viewheal(int a, int b){
        switch (a){
            case 0:
                if (b == 1){
                    switch (selecter[0]){
                        case 0:
                            Hp[0] = CombatManagement.viewhp[0][0];
                            break;
                        case 1:
                            Hp[1] = CombatManagement.viewhp[0][1];
                            break;
                        case 2:
                            Hp[2] = CombatManagement.viewhp[0][2];
                            break;
                    }
                }else {
                    switch (selecter[0]){
                        case 0:
                            Mp[0] = CombatManagement.viewmp[0][0];
                            break;
                        case 1:
                            Mp[1] = CombatManagement.viewmp[0][1];
                            break;
                        case 2:
                            Mp[2] = CombatManagement.viewmp[0][2];
                            break;
                    }
                }
                break;
            case 1:
                if (b == 1){
                    switch (selecter[1]){
                        case 0:
                            Hp[0] = CombatManagement.viewhp[1][0];
                            break;
                        case 1:
                            Hp[1] = CombatManagement.viewhp[1][1];
                            break;
                        case 2:
                            Hp[2] = CombatManagement.viewhp[1][2];
                            break;
                    }
                }else {
                    switch (selecter[1]){
                        case 0:
                            Mp[0] = CombatManagement.viewmp[1][0];
                            break;
                        case 1:
                            Mp[1] = CombatManagement.viewmp[1][1];
                            break;
                        case 2:
                            Mp[2] = CombatManagement.viewmp[1][2];
                            break;
                    }
                }
                break;
            case 2:
                if (b == 1){
                    switch (selecter[2]){
                        case 0:
                            Hp[0] = CombatManagement.viewhp[2][0];
                            break;
                        case 1:
                            Hp[1] = CombatManagement.viewhp[2][1];
                            break;
                        case 2:
                            Hp[2] = CombatManagement.viewhp[2][2];
                            break;
                    }
                }else {
                    switch (selecter[2]){
                        case 0:
                            Mp[0] = CombatManagement.viewmp[2][0];
                            break;
                        case 1:
                            Mp[1] = CombatManagement.viewmp[2][1];
                            break;
                        case 2:
                            Mp[2] = CombatManagement.viewmp[2][2];
                            break;
                    }
                }

                break;
        }
    }


    public static void viewallheal(int a){
        switch (a) {
            case 0:
                Hp[0] = CombatManagement.viewhp[0][0];
                Hp[1] = CombatManagement.viewhp[0][1];
                Hp[2] = CombatManagement.viewhp[0][2];
                break;
            case 1:
                Hp[0] = CombatManagement.viewhp[1][0];
                Hp[1] = CombatManagement.viewhp[1][1];
                Hp[2] = CombatManagement.viewhp[1][2];
                break;
            case 2:
                Hp[0] = CombatManagement.viewhp[2][0];
                Hp[1] = CombatManagement.viewhp[2][1];
                Hp[2] = CombatManagement.viewhp[2][2];
                break;

        }
        }
    public static void viewallmp(int a){
        switch (a) {
            case 0:
                Mp[0] = CombatManagement.viewmp[0][0];
                Mp[1] = CombatManagement.viewmp[0][1];
                Mp[2] = CombatManagement.viewhp[0][2];
                break;
            case 1:
                Mp[0] = CombatManagement.viewmp[1][0];
                Mp[1] = CombatManagement.viewmp[1][1];
                Mp[2] = CombatManagement.viewmp[1][2];
                break;
            case 2:
                Mp[0] = CombatManagement.viewmp[2][0];
                Mp[1] = CombatManagement.viewmp[2][1];
                Mp[2] = CombatManagement.viewmp[2][2];
                break;

        }
    }


    public static int getCharOrder() {
        return charOrder;
    }

    public void Desicionskill(int a, int b){
        BattleSkillFragment skillFragment = new BattleSkillFragment();
        skill[a] = b;
        switch (a){
            case 0:
                if(CombatManagement.charskill1[b][2] == 0 && (CombatManagement.charskill1[b][6] == 0 || CombatManagement.charskill1[b][6] == 6 || CombatManagement.charskill1[b][6] == 5 || CombatManagement.charskill1[b][6] == 3)){
                    skillFragment.setCharselect();
                } else {
                    charOrder++;
                    if (charOrder == 3){
                        charOrder = 0;
                        // 戦闘結果表示へ
                        CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
                        CombatManagement.damageCalc();
                        String[] m = CombatManagement.getResult();
                        String[] msg = new String[m.length];
                        for (int i = 0; i<m.length;i++) {
                            msg[i] = this.changeNumHalfToFull(m[i]);
                        }
                        skillFragment.setResult(msg);
                        this.end();
                    }else {
                        skillFragment.setCharmove();
                    }
                }
                break;
            case 1:
                if(CombatManagement.charskill2[b][2] == 0 && (CombatManagement.charskill2[b][6] == 0 || CombatManagement.charskill2[b][6] == 6 || CombatManagement.charskill2[b][6] == 5 || CombatManagement.charskill2[b][6] == 3)){
                    skillFragment.setCharselect();
                }else {
                    charOrder++;
                    if (charOrder == 3){
                        charOrder = 0;
                        // 戦闘結果表示へ
                        CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
                        CombatManagement.damageCalc();
                        String[] m = CombatManagement.getResult();
                        String[] msg = new String[m.length];
                        for (int i = 0; i<m.length;i++) {
                            msg[i] = this.changeNumHalfToFull(m[i]);
                        }
                        skillFragment.setResult(msg);
                        this.end();
                    }else {
                        skillFragment.setCharmove();
                    }
                }
                break;
            case 2:
                if(CombatManagement.charskill3[b][2] == 0 && (CombatManagement.charskill3[b][6] == 0 || CombatManagement.charskill3[b][6] == 6 || CombatManagement.charskill3[b][6] == 5 || CombatManagement.charskill3[b][6] == 3)){
                    skillFragment.setCharselect();
                }else {
                    charOrder++;
                    if (charOrder == 3){
                        charOrder = 0;
                        // 戦闘結果表示へ
                        CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
                        CombatManagement.damageCalc();
                        String[] m = CombatManagement.getResult();
                        String[] msg = new String[m.length];
                        for (int i = 0; i<m.length;i++) {
                            msg[i] = this.changeNumHalfToFull(m[i]);
                        }
                        skillFragment.setResult(msg);
                        this.end();
                    }else {
                        skillFragment.setCharmove();
                    }
                }
                break;
        }
    }

    public void Disicionitem (int a,int b){
        BattleItemFragment itemFragment = new BattleItemFragment();
        item[a] = b;
        switch (a){
            case 0:
                if(CombatManagement.charitem1[b][2] == 0 && (CombatManagement.charitem1[b][5] == 0 || CombatManagement.charitem1[b][5] == 3 || CombatManagement.charitem1[b][5] == 5 || CombatManagement.charitem1[b][5] == 6)){
                    itemFragment.setCharselect();
                }else {
                    charOrder++;
                    if (charOrder == 3){
                        charOrder = 0;
                        // 戦闘結果表示へ
                        CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
                        CombatManagement.damageCalc();
                        String[] m = CombatManagement.getResult();
                        String[] msg = new String[m.length];
                        for (int i = 0; i<m.length;i++) {
                            msg[i] = this.changeNumHalfToFull(m[i]);
                        }
                        itemFragment.setResult(msg);
                        this.end();
                    }else {
                        itemFragment.setCharmove();
                    }
                }
                break;
            case 1:
                if(CombatManagement.charitem2[b][2] == 0 && (CombatManagement.charitem2[b][5] == 0 || CombatManagement.charitem2[b][5] == 3 || CombatManagement.charitem2[b][5] == 5 || CombatManagement.charitem2[b][5] == 6)){
                    itemFragment.setCharselect();
                }else {
                    charOrder++;
                    if (charOrder == 3){
                        charOrder = 0;
                        // 戦闘結果表示へ
                        CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
                        CombatManagement.damageCalc();
                        String[] m = CombatManagement.getResult();
                        String[] msg = new String[m.length];
                        for (int i = 0; i<m.length;i++) {
                            msg[i] = this.changeNumHalfToFull(m[i]);
                        }
                        itemFragment.setResult(msg);
                        this.end();
                    }else {
                        itemFragment.setCharmove();
                    }
                }
                break;
            case 2:
                if(CombatManagement.charitem3[b][2] == 0 && (CombatManagement.charitem3[b][5] == 0 || CombatManagement.charitem3[b][5] == 3 || CombatManagement.charitem3[b][5] == 5 || CombatManagement.charitem3[b][5] == 6)){
                    itemFragment.setCharselect();
                }else {
                    charOrder++;
                    if (charOrder == 3){
                        charOrder = 0;
                        // 戦闘結果表示へ
                        CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
                        CombatManagement.damageCalc();
                        String[] m = CombatManagement.getResult();
                        String[] msg = new String[m.length];
                        for (int i = 0; i<m.length;i++) {
                            msg[i] = this.changeNumHalfToFull(m[i]);
                        }
                        itemFragment.setResult(msg);
                        this.end();
                    }else {
                        itemFragment.setCharmove();
                    }
                }
                break;
        }

    }

    public void setAtack(int a){
        // 戦闘クラスに行動を伝える
        move[a] = 1;
        charOrder++;
        if (charOrder == 3){
            charOrder = 0;
            //戦闘結果表示へ
            CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
            CombatManagement.damageCalc();
            String[] m = CombatManagement.getResult();
            String[] msg = new String[m.length];
            for (int i = 0; i<m.length;i++) {
                msg[i] = this.changeNumHalfToFull(m[i]);
            }
            char1MoveFragment.setResult(msg);
            this.end();
        }else {
            char1MoveFragment.setCharmove();
        }
    }

    public void setDefence(int a){
        // 戦闘クラスに行動を伝える
        move[a] = 2;
        charOrder++;
        if(charOrder == 3){
            charOrder = 0;
            // 戦闘結果表示へ
            CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
            CombatManagement.damageCalc();
            String[] m = CombatManagement.getResult();
            String[] msg = new String[m.length];
            for (int i = 0; i<m.length;i++) {
                msg[i] = this.changeNumHalfToFull(m[i]);
            }
                char1MoveFragment.setResult(msg);
            this.end();
        }else {
            char1MoveFragment.setCharmove();
        }
    }

    public static void resultview(String[] a){
        String[] msg = new String[a.length];
        for (int i = 0; i<a.length;i++) {
            msg[i] = changeNumHalfToFull(a[i]);
        }
        battleFragment.setResult(msg);

    }


    public void setItem(int a){
        move[a] = 4;
    }

    public void setCharselect(int a ,int b){
        // 誰が誰を選択したか戦闘クラスに伝える
        selecter[a] = b;
        charOrder++;
        if (charOrder == 3){
            charOrder = 0;
            // 戦闘結果表示へ
            CombatManagement.Comandresult(move[0],move[1],move[2],skill[0],skill[1],skill[2],selecter[0],selecter[1],selecter[2],item[0],item[1],item[2]);
            CombatManagement.damageCalc();
            String[] m = CombatManagement.getResult();
            String[] msg = new String[m.length];
            for (int i = 0; i<m.length;i++) {
                msg[i] = this.changeNumHalfToFull(m[i]);
            }
            charSelectFragment.setResult(msg);
            this.end();
        }else {
            charSelectFragment.setcharmove();
        }
    }

    public static String changeNumHalfToFull(String str) {
        String result = null;
        if(str != null) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < sb.length(); i++) {
                int c = (int) sb.charAt(i);
                if (c >= 0x30 && c <= 0x39) {
                    sb.setCharAt(i, (char) (c + 0xFEE0));
                }
            }
            result = sb.toString();
        }
        return result;
    }

    public void end(){
        if (CombatManagement.resultFlg == 1){
            // 全滅
            CombatManagement.returnHomeFlg = true;
        }else if(CombatManagement.resultFlg == 2){
            // 勝利
            CombatManagement.returnMapFlg = true;
        }
    }

}
