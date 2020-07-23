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
 * Created by uejobi on 2018/12/20.
 */

public class DrawHelp extends View {
    float width;
    float height;
    float textWidth;
    float textHeight;
    float buttonWidth;
    float buttonHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    float secondTouchX; // タッチした位置のX座標
    float secondTouchY; // タッチした位置のY座標
    int textIndex = 0;
    boolean slideFlg = true;
    String[] msg = {"　　　　　　ほすうポイントについて\\　あなたがあるいたほすうが　ほすうポイントになります。\\　ほすうポイントはげーむのなかでつかうので　たくさんあるいてためましょう。", "　　　　　　エのなかのせかいについて\\　エのせんたくがめんでは２つのボタンがあります。\\　うえのボタンをおすと　エのなかにすすみます。\\　エのなかではあるくのに　ほすうポイントをつかいます。\\　なくなるとあるけなくなるのでちゅういしましょう。\\　したのボタンではぶきやぼうぐをれんきんできます。\\　れんきんにはほすうポイントをつかいます。\\　エによってれんきんできるものはかわります。", "　　　　　　ステータスがめんについて\\　ステータスがめんできゃらをたっぷすると　ぶき　ぼうぐ　わざ　どうぐ　をせっとできるがめんにかわります。\\　てにいれたらわすれずにせっとしましょう。"};
    Bitmap backgroundImg;

    SettingFragment settingFragment;
    Sound sound;


    public DrawHelp(Context context) {
        super(context);
    }

    public DrawHelp(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawHelp(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        textWidth = width * 90 / 100;
        textHeight = height * 78 / 100;
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
            case MotionEvent.ACTION_MOVE:
                secondTouchX = event.getX();
                secondTouchY = event.getY();
                if (slideFlg) {
                    if (secondTouchX - firstTouchX < -100) {
                        if(textIndex < msg.length - 1) {
                            textIndex++;
                        }
                        else if(textIndex == msg.length - 1){
                            textIndex = 0;
                        }
                        slideFlg = false;
                    }
                    else if (secondTouchX - firstTouchX > 100) {
                        if(textIndex > 0) {
                            textIndex--;
                        }
                        else if(textIndex == 0){
                            textIndex = msg.length - 1;
                        }
                        slideFlg = false;
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                slideFlg = true;
                if(event.getX() > width * 15 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 84 / 100 && event.getY() < height * 95 / 100 && firstTouchX > width * 15 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 84 / 100 && firstTouchY < height * 95 / 100){
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
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, msg[textIndex], null, width * 5 / 100, height * 5 / 100, textWidth, textHeight, 12, 23, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　　もどる", null, width * 15 / 100, height * 84 / 100, buttonWidth, buttonHeight, 1, 8, font, mw, border);

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
