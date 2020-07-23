package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by uejobi on 2018/11/19.
 */

public class DrawBattleItem extends View {
    final int INTERVAL = 20;
    int counter = 0;
    float width;
    float height;
    float wOut1;
    float wOut2;
    static String[] message = null;
    static String[] name = null;
    String moji = "";
    int lineIndex = 0;
    int index = 0;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    float secondTouchX; // タッチした位置のX座標
    float secondTouchY; // タッチした位置のY座標

    // 道具格納
    ComandCtrl comandCtrl = new ComandCtrl();
    BattleItemFragment itemFragment = new BattleItemFragment();
    Sound sound = new Sound();
    public DrawBattleItem(Context context) {
        super(context);
    }

    public DrawBattleItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBattleItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int chara = comandCtrl.getCharOrder();
        super.onDraw(canvas);

        Paint mw = new Paint();
        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        Paint pt = new Paint();
        pt.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        pt.setColor(Color.WHITE);
        pt.setTextAlign(Paint.Align.LEFT);

        Paint border = new Paint();
        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"　　"+CombatManagement.charname[chara],null,0,height / 1000 * 740,width/100*45,height / 1000 * 60,1,CombatManagement.charname[chara].length()+4,pt,mw,border );
        if(CombatManagement.itemname[chara][0] != null) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　" + CombatManagement.itemname[chara][0], null, 0, height / 100 * 80, width / 100 * 50, height / 100 * 7, 1, CombatManagement.itemname[chara][0].length() + 4, pt, mw, border);
        }else {
            MultiLineText.drawMessageWindow(canvas, 0, height / 100 * 80, width / 100 * 50, height / 100 * 7, mw, border);
        }
        if(CombatManagement.itemname[chara][1] != null) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　" + CombatManagement.itemname[chara][1], null, width / 100 * 50, height / 100 * 80, width / 100 * 50, height / 100 * 7, 1, CombatManagement.itemname[chara][1].length() + 4, pt, mw, border);
        }else {
            MultiLineText.drawMessageWindow(canvas, width / 100 * 50, height / 100 * 80, width / 100 * 50, height / 100 * 7, mw, border);
        }
        if(CombatManagement.itemname[chara][2] != null) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　" + CombatManagement.itemname[chara][2], null, 0, height / 100 * 87, width / 100 * 50, height / 100 * 7, 1, CombatManagement.itemname[chara][2].length() + 4, pt, mw, border);
        }else {
            MultiLineText.drawMessageWindow(canvas, 0, height / 100 * 87, width / 100 * 50, height / 100 * 7, mw, border);
        }
        if(CombatManagement.itemname[chara][3] != null) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　" + CombatManagement.itemname[chara][3], null, width / 100 * 50, height / 100 * 87, width / 100 * 50, height / 100 * 7, 1, CombatManagement.itemname[chara][3].length() + 4, pt, mw, border);
        }else {
            MultiLineText.drawMessageWindow(canvas, width / 100 * 50, height / 100 * 87, width / 100 * 50, height / 100 * 7, mw, border);
        }
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"　　　　　もどる",null,0,height / 100 * 94,width,height / 100 * 6,1,13,pt,mw,border);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        int chara = comandCtrl.getCharOrder();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                secondTouchX = event.getX();
                secondTouchY = event.getY();

                if (firstTouchX >= 0 && firstTouchX <= width && secondTouchX >= 0 && secondTouchX <= width && firstTouchY >= (height/100*94) && firstTouchY <= height && secondTouchY >= (height/100*94) && secondTouchY <= height){
                    sound.createCancelMedia(getContext());
                    Sound.cancel.setLooping(false);
                    Sound.cancel.start();
                    itemFragment.setCharmove();
                }
                if(firstTouchX >= 0 && secondTouchX >= 0 && firstTouchX <= width/100*50  && secondTouchX <= width/100*50 && firstTouchY >= (height/100*80) && secondTouchY >= (height/100*80) && firstTouchY <= (height/100*87) && secondTouchY <= (height/100*87) && PlayerData.itemSetted[chara][0] != -1){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    comandCtrl.Disicionitem(chara,0);
                }
                if (firstTouchX >= width/100*50 && secondTouchX >= width/100*50 && firstTouchX <= width && secondTouchX <= width && firstTouchY >= (height/100*80) && secondTouchY >= (height/100*80) && firstTouchY <= (height/100*87) && secondTouchY <= (height/100*87) && PlayerData.itemSetted[chara][1] != -1){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    comandCtrl.Disicionitem(chara,1);
                }
                if( firstTouchX >= 0 && secondTouchX >= 0 && firstTouchX <= width/100*50 && secondTouchX <= width/100*50 && firstTouchY >= (height/100*87) && secondTouchY >= (height/100*87) && firstTouchY <= (height/100*94) && secondTouchY <= (height/100*94) && PlayerData.itemSetted[chara][2] != -1){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    comandCtrl.Disicionitem(chara,2);
                }
                if (firstTouchX >= width/100*50 && secondTouchX >= width/100*50 && firstTouchX <= width && secondTouchX <= width && firstTouchY >= (height/100*87) && secondTouchY >= (height/100*87) && firstTouchY <= (height/100*94) && secondTouchY <= (height/100*94) && PlayerData.itemSetted[chara][3] != -1){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    comandCtrl.Disicionitem(chara,3);
                }
        }

        return true;
    }
}
