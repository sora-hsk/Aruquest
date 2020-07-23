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
 * Created by uejobi on 2018/11/08.
 */

public class DrawBattle extends View {
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

    BattleFragment battleFragment = new BattleFragment();
    ComandCtrl comandCtrl = new ComandCtrl();
    Sound sound = new Sound();

    public DrawBattle(Context context) {
        super(context);
    }

    public DrawBattle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBattle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"　　どうする？",null,0,height / 1000 * 740,width/100*40,height / 1000 * 60,1,9,pt,mw,border );
        MultiLineText.drawNewlineTextMessageWindow(canvas,"   ", null, 0, height / 10 * 8, width, height/10*2, 8, 20, pt, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"\\　　たたかう",null,width / 100 * 1,height / 100 * 81,width - width / 100 * 52,height / 100 * 18,3,8,pt,mw,border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"\\　　　にげる",null,width / 100 * 51,height / 100 * 81,width - width / 100 * 52,height / 100 * 18,3,9,pt,mw,border);

        comandCtrl.setComand();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int chara = comandCtrl.getCharOrder();
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                secondTouchX = event.getX();
                secondTouchY = event.getY();
                    if (firstTouchX >= (width/100*1) &&firstTouchX <= (width/100*48) && secondTouchX >= (width/100*1) && secondTouchX <= (width/100*48) && firstTouchY >= (height/100*81) && secondTouchY >= (height / 100 * 81) && firstTouchY <= (height/100*99) && secondTouchY <= (height/100*99)) {
                        sound.createTouchMedia(getContext());
                        Sound.touch.setLooping(false);
                        Sound.touch.start();
                        battleFragment.setCharmove();
                    }
                if (firstTouchX >= (width/100*51) &&firstTouchX <= width && secondTouchX >= (width/100*51) && secondTouchX <= width && firstTouchY >= (height/100*81) && secondTouchY >= (height / 100 * 81) && firstTouchY <= (height/100*99) && secondTouchY <= (height/100*99)) {
                        // にげる
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    comandCtrl.exit(chara);

                    }
                    break;
        }


        return true;


    }
}
