package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class DrawReset extends View {
    float width;
    float height;
    float buttonWidth;
    float buttonHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    Bitmap backgroundImg;

    ResetFragment resetFragment;
    SettingFragment settingFragment;
    Sound sound;

    public DrawReset(Context context) {
        super(context);
    }

    public DrawReset(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawReset(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        buttonWidth = width * 70 / 100;
        buttonHeight = height * 11 / 100;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                if (event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 10 / 100 && event.getY() < height * 21 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 10 / 100 && firstTouchY < height * 21 / 100) {
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    resetFragment.callCheckFragment(4, "ほんとうに　きょうのほすうを\\りせっとしますか？");
                }
                else if (event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 32 / 100 && event.getY() < height * 43 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 32 / 100 && firstTouchY < height * 43 / 100) {
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    resetFragment.callCheckFragment(5, "ほんとうに　すべてのほすうを\\りせっとしますか？");
                }
                else if (event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 54 / 100 && event.getY() < height * 65 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 54 / 100 && firstTouchY < height * 65 / 100) {
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    resetFragment.callCheckFragment(6, "ほんとうに　げーむでーたを\\りせっとしますか？");
                }
                else if (event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 76 / 100 && event.getY() < height * 87 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 76 / 100 && firstTouchY < height * 87 / 100) {
                    sound.createCancelMedia(getContext());
                    Sound.cancel.setLooping(false);
                    Sound.cancel.start();
                    settingFragment.callSettingFragment();
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        Paint font = new Paint();
        Paint mw = new Paint();
        Paint border = new Paint();

        font.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        font.setColor(Color.WHITE);
        font.setTextAlign(Paint.Align.LEFT);

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        if(backgroundImg == null) {
            backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
            backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int) width, (int) height, false);
        }

        canvas.drawBitmap(backgroundImg, 0, 0, p);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　きょうのほすう", null, width * 15 / 100, height * 10 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　ほすうすべて", null, width * 15 / 100, height * 32 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　げーむでーた", null, width * 15 / 100, height * 54 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　もどる", null, width * 15 / 100, height * 76 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);

        p = null;
        font = null;
        mw = null;
        border = null;
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        switch (visibility){
            // 非アクティブ状態
            case GONE:
            case INVISIBLE:
                backgroundImg = null;
                resetFragment = null;
                settingFragment = null;
                sound = null;
                break;
            // アクティブ状態
            case VISIBLE:
                resetFragment = new ResetFragment();
                settingFragment = new SettingFragment();
                sound = new Sound();
                break;
        }
    }
}
