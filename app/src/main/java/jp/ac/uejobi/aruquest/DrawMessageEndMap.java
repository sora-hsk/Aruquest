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
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;

/**
 * Created by uejobi on 2018/10/29.
 */

public class DrawMessageEndMap extends View implements Runnable{
    final int INTERVAL = 20;
    int counter = 0;
    float width;
    float height;
    static String[] message = null;
    static String[] name = null;
    String moji = "";
    int lineIndex = 0;
    int index = 0;
    Paint mw = new Paint();
    Paint pt = new Paint();
    Paint border = new Paint();

    MessageEndMapFragment mf = new MessageEndMapFragment();
    MapFragment mapFragment = new MapFragment();
    Handler handler = new Handler();
    Sound sound = new Sound();


    public DrawMessageEndMap(Context context) {
        super(context);
    }

    public DrawMessageEndMap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawMessageEndMap(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static void setMessage(String[] message) {
        DrawMessageEndMap.message = message.clone();
    }

    public static void setName(String[] name){
        DrawMessageEndMap.name = name.clone();
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
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    if(lineIndex >= message.length) {
                        mapFragment.callHomeActivity();
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
            MultiLineText.drawNewlineTextMessageWindow(canvas, moji, name[lineIndex], width * 5 / 100, height * 70 / 100, width * 90 / 100, height * 25 / 100, 3, 20, pt, mw, border);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        handler.postDelayed(this, INTERVAL);
    }
}
