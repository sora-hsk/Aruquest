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
 * Created by uejobi on 2018/11/13.
 */

public class DrawHome extends View{
    int charaIndex = 0;
    float width;
    float height;
    float nameWidth;
    float nameHeight;
    float iconWidth;
    float iconHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    float secondTouchX; // タッチした位置のX座標
    float secondTouchY; // タッチした位置のY座標
    boolean slideFlg = true;
    String[][] msg = new String[2][1];
    final int[] charaImgID = {R.drawable.princess_whole, R.drawable.cat_whole, R.drawable.sheep_whole};
    Bitmap[] charaImg;
    final int[] backImgID = {R.drawable.home_princess, R.drawable.home_cat, R.drawable.home_knight};
    Bitmap[] backImg;
    Bitmap walkImg;
    Bitmap pointImg;

    Data data = new Data();
    HomeFragment homeFragment = new HomeFragment();

    public DrawHome(Context context) {
        super(context);
    }

    public DrawHome(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawHome(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        nameWidth = width * 45 / 100;
        nameHeight = height * 14 / 100;
        iconWidth = width * 40 / 100;
        iconHeight = height * 7 / 100;
        walkImg = BitmapFactory.decodeResource(getResources(), R.drawable.icon_walk);
        walkImg = Bitmap.createScaledBitmap(walkImg, (int)iconWidth, (int)iconHeight, false);
        pointImg = BitmapFactory.decodeResource(getResources(), R.drawable.icon_point);
        pointImg = Bitmap.createScaledBitmap(pointImg, (int)iconWidth, (int)iconHeight, false);

        if(PlayerData.rank == -1){
            PlayerData playerData = new PlayerData();
            PlayerData.rank = 0;
            playerData.saveData(getContext());
            String[][] msg = {{"あるくときょうのほすうと　ほすうポイントがふえます。", "ほすうポイントはおもに　エのなかでしようします。", "グラフがめんでしゅうかんのほすうをしることができます。", "くわしくはせっていのヘルプをさんこうにしてください。"}, {null, null, null, null}};
            homeFragment.callMessageFragment(msg);
        }
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
                        if(charaIndex < backImg.length - 1) {
                            charaIndex++;
                        }
                        else if(charaIndex == backImg.length - 1){
                            charaIndex = 0;
                        }
                        slideFlg = false;
                    }
                    else if (secondTouchX - firstTouchX > 100) {
                        if(charaIndex > 0) {
                            charaIndex--;
                        }
                        else if(charaIndex == 0){
                            charaIndex = backImg.length - 1;
                        }
                        slideFlg = false;
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                if(event.getX() - firstTouchX > -100 && event.getX() - firstTouchX < 100){
                    msg[0][0] = data.homeTextR(charaIndex, PlayerData.rank);
                    msg[1][0] = data.mikataR(charaIndex)[0];
                    homeFragment.callMessageFragment(msg);
                }
                slideFlg = true;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        Paint font = new Paint();
        Paint fontBlack = new Paint();
        Paint mw = new Paint();
        Paint border = new Paint();

        font.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        font.setColor(Color.WHITE);
        font.setTextAlign(Paint.Align.LEFT);

        fontBlack.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        fontBlack.setColor(Color.BLACK);
        fontBlack.setTextAlign(Paint.Align.LEFT);

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        if(charaImg[charaIndex] == null){
            charaImg[charaIndex] = BitmapFactory.decodeResource(getResources(), charaImgID[charaIndex]);
            charaImg[charaIndex] = Bitmap.createScaledBitmap(charaImg[charaIndex], (int) width, (int) height, false);
        }
        if(backImg[charaIndex] == null){
            backImg[charaIndex] = BitmapFactory.decodeResource(getResources(), backImgID[charaIndex]);
            backImg[charaIndex] = Bitmap.createScaledBitmap(backImg[charaIndex], (int) width, (int) height, false);
        }
        canvas.drawBitmap(backImg[charaIndex], 0, 0, p);
        canvas.drawBitmap(charaImg[charaIndex], 0, 0, p);
        canvas.drawBitmap(walkImg, width * 55 / 100, height * 2 / 100, p);
        canvas.drawBitmap(pointImg, width * 55 / 100, height * 2 / 100 + iconHeight, p);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"　" + data.mikataR(charaIndex)[0], null,  width * 5 / 100, height * 2 / 100, nameWidth, nameHeight, 1, 5, font, mw, border);
        MultiLineText.drawNewlineTextVerticalCenterLessSpace(canvas,HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.stepWeek[6])), null,  width * 67 / 100, height * 2 / 100, width * 28 / 100, iconHeight, 1, 6, fontBlack);
        MultiLineText.drawNewlineTextVerticalCenterLessSpace(canvas,HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.stepPoint)), null,  width * 67 / 100, height * 2 / 100 + iconHeight, width * 28 / 100, iconHeight, 1, 6, fontBlack);

        p = null;
        font = null;
        fontBlack = null;
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
                charaImg = null;
                backImg = null;
                data = null;
                homeFragment = null;
                break;
            // アクティブ状態
            case VISIBLE:
                charaImg = new Bitmap[charaImgID.length];
                backImg = new Bitmap[backImgID.length];
                data = new Data();
                homeFragment = new HomeFragment();
                break;
        }
    }
}
