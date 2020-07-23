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

public class DrawSetting extends View {
    float width;
    float height;
    float titleWidth;
    float titleHeight;
    float buttonWidth;
    float buttonHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    Bitmap backgroundImg;

    SettingFragment settingFragment;
    Sound sound;

    public DrawSetting(Context context) {
        super(context);
    }

    public DrawSetting(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawSetting(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        titleWidth = width * 90 / 100;
        titleHeight = height * 16 / 100;
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
                // 音量
                if(event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 32 / 100 && event.getY() < height * 43 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 32 / 100 && firstTouchY < height * 43 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    settingFragment.callSoundVolumeFragment();
                }
                // ヘルプ
                else if(event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 49 / 100 && event.getY() < height * 60 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 49 / 100 && firstTouchY < height * 60 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    settingFragment.callHelpFragment();
                }
                // リセット
                else if(event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 66 / 100 && event.getY() < height * 77 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 66 / 100 && firstTouchY < height * 77 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    settingFragment.callResetFragment();
                }
                // タイトル
                else if(event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 83 / 100 && event.getY() < height * 94 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 83 / 100 && firstTouchY < height * 94 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    SettingFragment.callStartActivity();
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
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　せってい", null, width * 5 / 100, height * 5 / 100, titleWidth, titleHeight, 1, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　おんりょう", null, width * 15 / 100, height * 32 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　ヘルプ", null, width * 15 / 100, height * 49 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　りせっと", null, width * 15 / 100, height * 66 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　たいとる", null, width * 15 / 100, height * 83 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);

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
                settingFragment = null;
                sound = null;
                break;
            // アクティブ状態
            case VISIBLE:
                settingFragment = new SettingFragment();
                sound = new Sound();
                break;
        }
    }
}
