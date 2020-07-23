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

public class DrawItem extends View {
    static int itemIndex = 0;
    float width; // 画面横幅
    float height; // 画面縦幅
    float decideImgWidth;
    float decideImgHeight;
    float backImgWidth;
    float backImgHeight;
    float itemWidth;
    float itemHeight;
    float itemImgWidth;
    float itemImgHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    Bitmap decideImg;
    Bitmap backImg;
    Bitmap backgroundImg;

    StatusAloneFragment statusAloneFragment;
    ItemFragment itemFragment;
    Data data;
    Sound sound;
    BitmapData bitmapData;

    public DrawItem(Context context) {
        super(context);
    }

    public DrawItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        itemImgWidth = (float)(w * 0.5);
        itemImgHeight = (float)(h * 0.65);
        decideImgWidth = (float)(w * 0.2);
        decideImgHeight = (float)(h * 0.125);
        backImgWidth = (float)(w * 0.2);
        backImgHeight = (float)(h * 0.125);
        itemWidth = (float)(w * 0.4);
        itemHeight = (float)(h * 0.08);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                for(int i = 0; i < 4 && i < PlayerData.itemSetted[DrawStatusAlone.charaID].length; i++){
                    if(firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 22 / 100 + i * itemHeight && firstTouchY < height * 22 / 100 + (i + 1) * itemHeight){
                        sound.createTouchMedia(getContext());
                        Sound.touch.setLooping(false);
                        Sound.touch.start();
                        itemIndex = i;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                // はずす
                if(event.getX() > width * 55 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 22 / 100 + 4 * itemHeight && event.getY() < height * 22 / 100 + 6 * itemHeight && firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 22 / 100 + 4 * itemHeight && firstTouchY < height * 22 / 100 + 6 * itemHeight){
                    sound.createCancelMedia(getContext());
                    Sound.cancel.setLooping(false);
                    Sound.cancel.start();
                    PlayerData.releaseItemSetted(DrawStatusAlone.charaID, itemIndex);
                    invalidate();
                }
                // 決定
                if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 69 / 100 && event.getY() < height * 81.5 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 70 / 100 && firstTouchY < height * 82.5 / 100){
                    sound.createDecideMedia(getContext());
                    Sound.decide.setLooping(false);
                    Sound.decide.start();
                    itemFragment.callItemSetFragment();
                }
                // 戻る
                else if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 81.5 / 100 && event.getY() < height * 94 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 82.5 / 100 && firstTouchY < height * 95 / 100){
                    sound.createCancelMedia(getContext());
                    Sound.cancel.setLooping(false);
                    Sound.cancel.start();
                    statusAloneFragment.callStatusAloneFragment();
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
        Paint borderRed = new Paint();

        font.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        font.setColor(Color.WHITE);
        font.setTextAlign(Paint.Align.LEFT);

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        borderRed.setColor(Color.RED);
        borderRed.setStrokeWidth(5);
        borderRed.setStyle(Paint.Style.STROKE);

        if(decideImg == null) {
            decideImg = BitmapFactory.decodeResource(getResources(), R.drawable.icon_decide);
            decideImg = Bitmap.createScaledBitmap(decideImg, (int) decideImgWidth, (int) decideImgHeight, false);
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
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "どうぐはいちどつかうとなくなってしまうよ", null, width * 55 / 100, height * 5/ 100, itemWidth, height * 17 / 100, 2, 10, font, mw, border);
        for(int i = 0; i < PlayerData.itemSetted[DrawStatusAlone.charaID].length; i++) {
            if (PlayerData.itemSetted[DrawStatusAlone.charaID][i] != -1) {
                MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.douguR(PlayerData.itemSetted[DrawStatusAlone.charaID][i])[0], null, width * 55 / 100, height * 22 / 100 + i * itemHeight, itemWidth, itemHeight, 1, 8, font, mw, border);
            }else{
                MultiLineText.drawMessageWindow(canvas, width * 55 / 100, height * 22 / 100 + i * itemHeight, itemWidth, itemHeight, mw, border);
            }
        }
        if (PlayerData.itemSetted[DrawStatusAlone.charaID][itemIndex] != -1) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.douguR(PlayerData.itemSetted[DrawStatusAlone.charaID][itemIndex])[0], null, width * 55 / 100, height * 22 / 100 + itemIndex * itemHeight, itemWidth, itemHeight, 1, 8, font, mw, borderRed);
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.douguR(PlayerData.itemSetted[DrawStatusAlone.charaID][itemIndex])[9], null, width * 5 / 100, height * 70 / 100, width * 70 / 100, height * 25 / 100, 4, 15, font, mw, border);
        }else{
            MultiLineText.drawMessageWindow(canvas, width * 55 / 100, height * 22 / 100 + itemIndex * itemHeight, itemWidth, itemHeight, mw, borderRed);
            MultiLineText.drawMessageWindow(canvas, width * 5 / 100, height * 70 / 100, width * 70 / 100, height * 25 / 100, mw, border);
        }
        MultiLineText.drawNewlineTextMessageWindowVerticalCenter(canvas, "　　はずす", null, width * 55 / 100, height * 22 / 100 + 4 * itemHeight, itemWidth, itemHeight * 2, 1, 7, font, mw, border);
        if(PlayerData.itemSetted[DrawStatusAlone.charaID][itemIndex] != -1) {
            canvas.drawBitmap(bitmapData.getItemBitmap(PlayerData.itemSetted[DrawStatusAlone.charaID][itemIndex], getResources(), (int) itemImgWidth, (int) itemImgHeight), width * 5 / 100, height * 5 / 100, p);
        }
        canvas.drawBitmap(decideImg, width * 75 / 100, height * 70 / 100, p);
        canvas.drawBitmap(backImg, (float) width * 75 / 100, (float) (height * 82.5 / 100), p);

        p = null;
        font = null;
        mw = null;
        border = null;
        borderRed = null;
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        switch (visibility){
            // 非アクティブ状態
            case GONE:
            case INVISIBLE:
                decideImg = null;
                backImg = null;
                backgroundImg = null;
                statusAloneFragment = null;
                itemFragment = null;
                data = null;
                sound = null;
                bitmapData = null;
                break;
            // アクティブ状態
            case VISIBLE:
                statusAloneFragment = new StatusAloneFragment();
                itemFragment = new ItemFragment();
                data = new Data();
                sound = new Sound();
                bitmapData = new BitmapData();
                break;
        }
    }
}
