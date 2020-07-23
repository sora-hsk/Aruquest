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
 * Created by uejobi on 2018/11/12.
 */

public class DrawAlchemy extends View {
    float width; // 画面横幅
    float height; // 画面縦幅
    float imgWidth;
    float imgHeight;
    float backImgWidth;
    float backImgHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    static boolean touchFlg = true;
    Bitmap weaponImg;
    Bitmap armorImg;
    Bitmap backImg;
    Bitmap backgroundImg;

    static Animation alchemyAnimation;

    AlchemyFragment alchemyFragment;
    SelectDungeonFragment selectDungeonFragment;
    Data data;
    Sound sound;

    public DrawAlchemy(Context context) {
        super(context);
    }

    public DrawAlchemy(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawAlchemy(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
        imgWidth = (float)(w * 0.9);
        imgHeight = (float)(h * 0.3);
        backImgWidth = (float)(h * 0.12);
        backImgHeight = (float)(h * 0.12);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if(touchFlg) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    firstTouchX = event.getX();
                    firstTouchY = event.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    if (event.getX() > width * 5 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 17 / 100 && event.getY() < height * 56 / 100 && firstTouchX > width * 5 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 17 / 100 && firstTouchY < height * 56 / 100) {
                        sound.createTouchMedia(getContext());
                        Sound.touch.setLooping(false);
                        Sound.touch.start();
                        alchemyFragment.callCheckFragment("　ぶき", 2);
                    } else if (event.getX() > width * 5 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 56 / 100 && event.getY() < height * 95 / 100 && firstTouchX > width * 5 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 56 / 100 && firstTouchY < height * 95 / 100) {
                        sound.createTouchMedia(getContext());
                        Sound.touch.setLooping(false);
                        Sound.touch.start();
                        alchemyFragment.callCheckFragment("　ぼうぐ", 3);
                    } else if (event.getX() > width * 5 / 100 && event.getX() < width * 5 / 100 + backImgWidth && event.getY() > height * 5 / 100 && event.getY() < height * 5 + backImgHeight && firstTouchX > width * 5 / 100 && firstTouchX < width * 5 / 100 + backImgWidth && firstTouchY > height * 5 / 100 && firstTouchY < height * 5 + backImgHeight) {
                        sound.createCancelMedia(getContext());
                        Sound.cancel.setLooping(false);
                        Sound.cancel.start();
                        selectDungeonFragment.callSelectDungeonFragment();
                    }
                    break;
            }
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

        if(weaponImg == null) {
            weaponImg = BitmapFactory.decodeResource(getResources(), R.drawable.weapon_alchemy);
            weaponImg = Bitmap.createScaledBitmap(weaponImg, (int) imgWidth, (int) imgHeight, false);
        }
        if(armorImg == null) {
            armorImg = BitmapFactory.decodeResource(getResources(), R.drawable.armor_alchemy);
            armorImg = Bitmap.createScaledBitmap(armorImg, (int) imgWidth, (int) imgHeight, false);
        }
        if(backImg == null) {
            backImg = BitmapFactory.decodeResource(getResources(), R.drawable.icon_back);
            backImg = Bitmap.createScaledBitmap(backImg, (int) backImgWidth, (int) backImgHeight, false);
        }
        if(backgroundImg == null) {
            backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
            backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int) width, (int) height, false);
        }

        canvas.drawBitmap(backgroundImg, 0, 0, p);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.danjonJouhouR(DrawSelectDungeon.dungeonIndex)[0], null, width * 5 / 100 + backImgWidth, height * 5 / 100, width - width * 10 / 100 - backImgWidth, height * 12 / 100, 1, data.danjonJouhouR(DrawSelectDungeon.dungeonIndex)[0].length(), font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　ぶき　　" + HarfToFull.changeNumHalfToFull(String.valueOf(data.danjonJouhouR(DrawSelectDungeon.dungeonIndex)[1])) + "Ｐ ", null, width * 5 / 100, height * 17 / 100, width * 90 / 100, height * 9 / 100, 1, 12, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　ぼうぐ　" + HarfToFull.changeNumHalfToFull(String.valueOf(data.danjonJouhouR(DrawSelectDungeon.dungeonIndex)[1])) + "Ｐ ", null, width * 5 / 100, height * 56 / 100, width * 90 / 100, height * 9 / 100, 1, 12, font, mw, border);
        canvas.drawBitmap(weaponImg, (float)(width * 5 / 100), (float) (height * 25 / 100), p);
        canvas.drawBitmap(armorImg, (float)(width * 5 / 100), (float) (height * 65 / 100), p);
        canvas.drawBitmap(backImg, width * 5 / 100, height * 5 / 100, p);

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
                weaponImg = null;
                armorImg = null;
                backImg = null;
                backgroundImg = null;
                alchemyFragment = null;
                selectDungeonFragment = null;
                data = null;
                sound = null;
                break;
            // アクティブ状態
            case VISIBLE:
                alchemyFragment = new AlchemyFragment();
                selectDungeonFragment = new SelectDungeonFragment();
                data = new Data();
                sound = new Sound();
                break;
        }
    }
}
