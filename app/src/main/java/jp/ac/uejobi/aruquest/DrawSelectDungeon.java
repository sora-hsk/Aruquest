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
 * Created by uejobi on 2018/11/06.
 */

public class DrawSelectDungeon extends View {
    float width; // 画面横幅
    float height; // 画面縦幅
    float dungeonImgWidth;
    float dungeonImgHeight;
    float shopImgWidth;
    float shopImgHeight;
    static int dungeonIndex = 0;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    float secondTouchX; // タッチした位置のX座標
    float secondTouchY; // タッチした位置のY座標
    boolean slideFlg = true;
    final int[] imgID = {R.drawable.dungeon1, R.drawable.dungeon2, R.drawable.dungeon3,R.drawable.dungeon4, R.drawable.dungeon5, R.drawable.dungeon6, R.drawable.dungeon7, R.drawable.dungeon8, R.drawable.dungeon9, R.drawable.dungeon10, R.drawable.dungeon11, R.drawable.dungeon12, R.drawable.dungeon13, R.drawable.dungeon14, R.drawable.dungeon15, R.drawable.dungeon16, R.drawable.dungeon17, R.drawable.dungeon18};
    Bitmap[] dungeonImg;
    final int[] shopImgID = {R.drawable.alchemy1, R.drawable.alchemy2, R.drawable.alchemy3, R.drawable.alchemy4, R.drawable.alchemy5, R.drawable.alchemy6, R.drawable.alchemy7, R.drawable.alchemy8, R.drawable.alchemy9, R.drawable.alchemy10, R.drawable.alchemy11, R.drawable.alchemy12, R.drawable.alchemy13, R.drawable.alchemy14, R.drawable.alchemy15, R.drawable.alchemy16, R.drawable.alchemy17, R.drawable.alchemy18};
    Bitmap[] shopImg;
    Bitmap backgroundImg;

    SelectDungeonFragment selectDungeonFragment;
    Data data;
    Sound sound;

    public DrawSelectDungeon(Context context) {
        super(context);
    }

    public DrawSelectDungeon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawSelectDungeon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        dungeonImgWidth = (float)(w * 0.9);
        dungeonImgHeight = (float)(h * 0.45);
        shopImgWidth = (float)(w * 0.9);
        shopImgHeight = (float)(h * 0.25);
        backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
        backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int)width, (int)height, false);
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
                if(slideFlg) {
                    if (secondTouchX - firstTouchX < -100 && dungeonIndex < dungeonImg.length - 1) {
                        //if(dungeonIndex < PlayerData.rank) {
                            dungeonIndex++;
                        //}
                        slideFlg = false;
                    } else if (secondTouchX - firstTouchX > 100 && dungeonIndex > 0) {
                        dungeonIndex--;
                        slideFlg = false;
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                if(Math.abs(event.getX() - firstTouchX) < 100 && firstTouchX > width * 5 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 25 / 100 && firstTouchY < height * 70 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    selectDungeonFragment.callCheckFragment();
                }
                else if(Math.abs(event.getX() - firstTouchX) < 100 && firstTouchX > width * 5 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 75 / 100 && firstTouchY < height * 95 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    selectDungeonFragment.callAlchemyFragment();
                }
                slideFlg = true;
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

        canvas.drawBitmap(backgroundImg, 0, 0, p);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.danjonJouhouR(dungeonIndex)[0], null, width * 5 / 100, height * 5 / 100, width * 90 / 100, height * 12 / 100, 1, data.danjonJouhouR(dungeonIndex)[0].length(), font, mw, border);
        if(dungeonImg[dungeonIndex] == null) {
            dungeonImg[dungeonIndex] = BitmapFactory.decodeResource(getResources(), imgID[dungeonIndex]);
            dungeonImg[dungeonIndex] = Bitmap.createScaledBitmap(dungeonImg[dungeonIndex], (int) dungeonImgWidth, (int) dungeonImgHeight, false);
        }
        if(shopImg[dungeonIndex] == null){
            shopImg[dungeonIndex] = BitmapFactory.decodeResource(getResources(), shopImgID[dungeonIndex]);
            shopImg[dungeonIndex] = Bitmap.createScaledBitmap(shopImg[dungeonIndex], (int) shopImgWidth, (int) shopImgHeight, false);
        }
        canvas.drawBitmap(dungeonImg[dungeonIndex], (float)(width * 5 / 100), (float) (height * 21 / 100), p);
        canvas.drawBitmap(shopImg[dungeonIndex], (float)(width * 5 / 100), (float) (height * 70 / 100), p);

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
                dungeonImg = null;
                shopImg = null;
                selectDungeonFragment = null;
                data = null;
                sound = null;
                System.gc();
                break;
            // アクティブ状態
            case VISIBLE:
                dungeonImg = new Bitmap[imgID.length];
                shopImg = new Bitmap[shopImgID.length];
                selectDungeonFragment = new SelectDungeonFragment();
                data = new Data();
                sound = new Sound();
                break;
        }
    }
}
