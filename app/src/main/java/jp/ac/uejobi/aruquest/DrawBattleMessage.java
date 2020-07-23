package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by uejobi on 2018/10/29.
 */

public class DrawBattleMessage extends View implements Runnable{
    final int INTERVAL = 30;
    int counter = 0;
    float width;
    float height;
    static String[] message = null;
    static String[] name = null;
    String moji = "";
    int lineIndex = 0;
    int index = 0;
    String dmg = "のダメージ";
    String heal = "かいふくした";
    int healreslut;
    String Revival = "ふっかつした";
    int Revivalreslut;
    String fixed = "なおった";
    int fixedreslut;
    String HP = "ＨＰ";
    int hpreslut;
    String MP = "ＭＰ";
    int mpreslut;
    String poison = "どくのダメージ";
    String alldmg = "エレナたちはダメージ";
    int alldmgresult;
    String allhp = "エレナたちはＨＰ";
    int allhpresult;
    String allmp = "エレナたちはＭＰ";
    int allmpresult;
    int poisonreslut;
    String[] dmgname = {CombatManagement.charname[0] + "に",CombatManagement.charname[1] + "に",CombatManagement.charname[2] + "に",CombatManagement.charname[3] + "に"};
    int result1;
    int result2;
    int result3;
    int[] dmgresult = new int[5];
    int[][] skillresult = new int[3][4];
    Paint mw = new Paint();
    Paint pt = new Paint();
    Paint border = new Paint();

    BattleMessageFragment mf;
    Handler handler = new Handler();
    Sound sound;

    public DrawBattleMessage(Context context) {
        super(context);
    }

    public DrawBattleMessage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBattleMessage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static void setMessage(String[] message) {
        DrawBattleMessage.message = message.clone();
    }

    public static void setName(String[] name){
        DrawBattleMessage.name = name.clone();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if(lineIndex < message.length && index >= message[lineIndex].length()) {
                    // キャラ名
                    result1 = moji.indexOf(CombatManagement.charname[0]);
                    result2 = moji.indexOf(CombatManagement.charname[1]);
                    result3 = moji.indexOf(CombatManagement.charname[2]);
                    allhpresult = moji.indexOf(allhp);
                    allmpresult = moji.indexOf(allmp);
                    alldmgresult = moji.indexOf(alldmg);
                    // ダメージを受けたキャラ
                    dmgresult[0] = moji.indexOf(dmgname[0]);
                    dmgresult[1] = moji.indexOf(dmgname[1]);
                    dmgresult[2] = moji.indexOf(dmgname[2]);
                    dmgresult[4] = moji.indexOf(dmgname[3]);
                    // のダメージ
                    dmgresult[3] = moji.indexOf(dmg);
                    // かいふくした
                    healreslut = moji.indexOf(heal);
                    // ふっかつした
                    Revivalreslut = moji.indexOf(Revival);
                    // なおった
                    fixedreslut = moji.indexOf(fixed);
                    // どくのダメージ
                    poisonreslut = moji.indexOf(poison);
                    // HP MP
                    hpreslut = moji.indexOf(HP);
                    mpreslut = moji.indexOf(MP);
                    //スキル名
                    for (int i = 0;i < 3;i++){
                        for (int y = 0;y < 4;y++){
                            if(CombatManagement.skillname[i][y] != null) {
                                skillresult[i][y] = moji.indexOf(CombatManagement.skillname[i][y]);
                            }
                        }
                    }
                    // スキルをつかったかどうか
                    for (int y = 0; y < 3;y++) {
                        for (int i = 0; i < 4; i++) {
                            if (skillresult[y][i] != -1) {
                                if (result1 == 0) {
                                    ComandCtrl.viewmp(0);
                                }
                                if (result2 == 0){
                                    ComandCtrl.viewmp(1);
                                }
                                if (result3 == 0){
                                    ComandCtrl.viewmp(2);
                                }
                            }
                        }
                    }
                    //ダメージを受けたかどうか
                    if (dmgresult[3] != -1 && dmgresult[4] == -1){
                        if (dmgresult[0] != -1){
                            ComandCtrl.viewhp(0);
                        }
                        if (dmgresult[1] != -1){
                            ComandCtrl.viewhp(1);
                        }
                        if (dmgresult[2] != -1){
                            ComandCtrl.viewhp(2);
                        }
                    }
                    // ダメージ音
                    if (dmgresult[3] != -1){
                        if (result1 == 0 || result2 == 0 || result3 == 0){
                            //みかたのこうげき
                            sound.createDamageAttackMedia(getContext());
                            Sound.damageAttack.start();
                        }else {
                            //てきのこうげき
                            sound.createDamageRecieveMedia(getContext());
                            Sound.damageRecieve.start();
                        }
                    }
                    // ふっかつしたかどうか
                    if (Revivalreslut != -1){
                        if(result1 == 0){
                            ComandCtrl.viewheal(0,1);
                        }
                        if (result2 == 0){
                            ComandCtrl.viewheal(1,1);
                        }
                        if (result3 == 0){
                            ComandCtrl.viewheal(2,1);
                        }
                    }
                    // かいふくしたかどうか
                    if (healreslut != -1){
                        if (hpreslut != -1){
                            if(result1 == 0){
                                if (allhpresult != -1){
                                    ComandCtrl.viewallheal(0);
                                }else {
                                    ComandCtrl.viewheal(0,1);
                                }
                            }
                            if (result2 == 0){
                                if (allhpresult != -1){
                                    ComandCtrl.viewallheal(1);
                                }else {
                                    ComandCtrl.viewheal(1,1);
                                }
                            }
                            if (result3 == 0){
                                if (allhpresult != -1){
                                    ComandCtrl.viewallheal(2);
                                }else {
                                    ComandCtrl.viewheal(2,1);
                                }
                            }
                        }
                        if (mpreslut != -1){
                            if(result1 == 0){
                                if (allmpresult != -1){
                                    ComandCtrl.viewallmp(0);
                                }else {
                                    ComandCtrl.viewheal(0,2);
                                }
                            }
                            if (result2 == 0){
                                if (allmpresult != -1){
                                    ComandCtrl.viewallmp(1);
                                }else {
                                    ComandCtrl.viewheal(1,2);
                                }
                            }
                            if (result3 == 0){
                                if (allmpresult != -1){
                                    ComandCtrl.viewallmp(2);
                                }else {
                                    ComandCtrl.viewheal(2,2);
                                }
                            }
                        }
                    }
                    // どくのダメージをうけたかどうか
                    if (poisonreslut != -1){
                        if(result1 == 0){
                            ComandCtrl.viewhppoison(0);
                        }
                        if (result2 == 0){
                            ComandCtrl.viewhppoison(1);
                        }
                        if (result3 == 0){
                            ComandCtrl.viewhppoison(2);
                        }
                    }
                    // 全体ダメージ
                    if (alldmgresult != -1){
                        ComandCtrl.viewhp(0);
                        ComandCtrl.viewhp(1);
                        ComandCtrl.viewhp(2);
                    }
                    moji = "";
                    index = 0;
                    lineIndex++;
                    if(lineIndex >= message.length) {
                        if(CombatManagement.returnMapFlg){
                            // 戦闘勝利
                            mf.returnMap();
                        }
                        else if(CombatManagement.returnHomeFlg){
                            // 戦闘敗北
                            mf.returnHome();
                        }
                        else {
                            mf.returnBattle();
                        }
                    }
                }
        }
        return true;
    }

    @Override
    public void run() {
        if( message != null && lineIndex < message.length) {
            if (counter >= 30 && index < message[lineIndex].length()) {
                moji = (moji + message[lineIndex].charAt(index));
                index++;
                counter = 0;
                invalidate();
            } else {
                counter += INTERVAL;
            }
        }
        handler.postDelayed(this, INTERVAL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);


        pt.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        pt.setColor(Color.WHITE);
        pt.setTextAlign(Paint.Align.LEFT);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        MultiLineText.drawNewlineTextMessageWindow(canvas, moji, null, 0, height / 100 * 80, width, height / 100 * 20, 3, 20, pt, mw, border);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        handler.postDelayed(this, INTERVAL);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        switch (visibility){
            // 非アクティブ状態
            case GONE:
            case INVISIBLE:
                mf = null;
                sound = null;
                break;
            // アクティブ状態
            case VISIBLE:
                mf = new BattleMessageFragment();
                sound = new Sound();
                break;
        }
    }
}
