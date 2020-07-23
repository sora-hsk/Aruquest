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
 * Created by uejobi on 2018/12/14.
 */

public class DrawStartBattle extends View implements Runnable{

    final int INTERVAL = 20;
    int counter = 0;
    float width;
    float height;
    String[] message = new String[1];
    String moji = "";
    int lineIndex = 0;
    int index = 0;
    Paint mw = new Paint();
    Paint pt = new Paint();
    Paint border = new Paint();

    Handler handler = new Handler();
    StartBattleFragment startBattleFragment = new StartBattleFragment();
    Data data = new Data();

    public DrawStartBattle(Context context) {
        super(context);
    }

    public DrawStartBattle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawStartBattle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        pt.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        pt.setColor(Color.WHITE);
        pt.setTextAlign(Paint.Align.LEFT);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        message[0] = data.tekiR(Dungeon.enemyID)[0] + "　があらわれた";
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if(lineIndex < message.length && index >= message[lineIndex].length()) {
                    moji = "";
                    index = 0;
                    lineIndex++;
                    if(lineIndex >= message.length) {
                        startBattleFragment.callBattleFragment();
                    }
                }
                else if(lineIndex < message.length){
                    moji = message[lineIndex];
                    index = message[lineIndex].length();
                    invalidate();
                }
        }
        return true;
    }

    @Override
    public void run() {
        if(lineIndex < message.length) {
            if (counter >= 40 && index < message[lineIndex].length()) {
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
        MultiLineText.drawNewlineTextMessageWindow(canvas, moji, null, 0, height / 100 * 80, width, height / 100 * 20, 3, 20, pt, mw, border);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        handler.postDelayed(this, INTERVAL);
    }
}
