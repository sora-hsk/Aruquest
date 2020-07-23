package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by uejobi on 2018/11/15.
 */

public class DrawCharSelect extends View {
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
    int Touchflg;

    CharSelectFragment charSelectFragment = new CharSelectFragment();
    ComandCtrl comandCtrl = new ComandCtrl();
    Sound sound = new Sound();

    public DrawCharSelect(Context context) {
        super(context);
    }

    public DrawCharSelect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCharSelect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int chara = ComandCtrl.getCharOrder();
        super.onTouchEvent(event);
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
                    charSelectFragment.backCharMove();
                }
                if(firstTouchX >= (width/100*7) && secondTouchX >= (width/100*7) && firstTouchX <= (width/100*33) && secondTouchX <= (width/100*33) && firstTouchY >= (height/100*81) && secondTouchY >= (height/100*81) && firstTouchY <= (height/100*93) && secondTouchY <= (height/100*93)){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    comandCtrl.setCharselect(chara,0);
                }
                if(firstTouchX >= (width/100*36) && secondTouchX >= (width/100*36) && firstTouchX <= (width/100*62) && secondTouchX <= (width/100*62) && firstTouchY >= (height/100*81) && secondTouchY >= (height/100*81) && firstTouchY <= (height/100*93) && secondTouchY <= (height/100*93)) {
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    comandCtrl.setCharselect(chara,1);
                }
                if(firstTouchX >= (width/100*65) && secondTouchX >= (width/100*65) && firstTouchX <= (width/100*91) && secondTouchX <= (width/100*91) && firstTouchY >= (height/100*81) && secondTouchY >= (height/100*81) && firstTouchY <= (height/100*93) && secondTouchY <= (height/100*93)) {
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    comandCtrl.setCharselect(chara,2);
                }
                }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
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

        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"　　だれにする？",null,0,height / 1000 * 740,width/100*45,height / 1000 * 60,1,10,pt,mw,border );
        MultiLineText.drawNewlineTextMessageWindow(canvas,"   ", null, 0, height / 10 * 8, width, height/10*2, 8, 20, pt, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenter(canvas,"　" + CombatManagement.charname[0],null,width / 100 * 7,height / 100 * 81,width / 100 * 26,height / 100 * 12,1,6,pt,mw,border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenter(canvas,"　" + CombatManagement.charname[1],null,width / 100 * 36,height / 100 * 81,width / 100 * 26,height / 100 * 12,1,6,pt,mw,border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenter(canvas,"　" + CombatManagement.charname[2],null,width / 100 * 65,height / 100 * 81,width / 100 * 26,height / 100 * 12,1,7,pt,mw,border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"　　　　　もどる",null,0,height / 100 * 94,width,height / 100 * 6,1,13,pt,mw,border);
    }
}
