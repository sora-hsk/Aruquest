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
 * Created by uejobi on 2018/12/13.
 */

public class DrawCrossChange extends View {
    float width;
    float height;
    float buttonWidth;
    float buttonHeight;
    float firstTouchX;
    float firstTouchY;
    Paint font = new Paint();
    Paint mw = new Paint();
    Paint border = new Paint();

    CrossChangeFragment crossChangeFragment = new CrossChangeFragment();
    Sound sound = new Sound();

    public DrawCrossChange(Context context) {
        super(context);
    }

    public DrawCrossChange(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCrossChange(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        buttonWidth = width * 60 / 100;
        buttonHeight = height * 8 / 100;

        font.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        font.setColor(Color.WHITE);
        font.setTextAlign(Paint.Align.LEFT);

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                // オン
                if(event.getX() > width * 20 / 100 && event.getX() < width * 80 / 100 && event.getY() > height * 20 / 100 && event.getY() < height * 28 / 100 && firstTouchX > width * 20 / 100 && firstTouchX < width * 80 / 100 && firstTouchY > height * 20 / 100 && firstTouchY < height *28 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    Dungeon.buttonFlg = true;
                }
                // オフ
                else if(event.getX() > width * 20 / 100 && event.getX() < width * 80 / 100 && event.getY() > height * 33 / 100 && event.getY() < height * 41 / 100 && firstTouchX > width * 20 / 100 && firstTouchX < width * 80 / 100 && firstTouchY > height * 33 / 100 && firstTouchY < height * 41 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    Dungeon.buttonFlg = false;
                }
                // もどる
                else if(event.getX() > width * 20 / 100 && event.getX() < width * 80 / 100 && event.getY() > height * 46 / 100 && event.getY() < height * 54 / 100 && firstTouchX > width * 20 / 100 && firstTouchX < width * 80 / 100 && firstTouchY > height * 46 / 100 && firstTouchY < height * 54 / 100){
                    sound.createCancelMedia(getContext());
                    Sound.cancel.setLooping(false);
                    Sound.cancel.start();
                    crossChangeFragment.callCommandFragment();
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　オン", null, width * 20 / 100, height * 20 / 100, buttonWidth, buttonHeight, 1, 5, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　オフ", null, width * 20 / 100, height * 33 / 100, buttonWidth, buttonHeight, 1, 5, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　もどる", null, width * 20 / 100, height * 46 / 100, buttonWidth, buttonHeight, 1, 5, font, mw, border);
    }
}
