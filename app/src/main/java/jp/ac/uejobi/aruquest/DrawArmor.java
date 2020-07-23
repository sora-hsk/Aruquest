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

public class DrawArmor extends View {
    int armorIndex = 0;
    int visibleIndex = 0;
    float width; // 画面横幅
    float height; // 画面縦幅
    float decideImgWidth;
    float decideImgHeight;
    float backImgWidth;
    float backImgHeight;
    float armorImgWidth;
    float armorImgHeight;
    float armorWidth;
    float armorHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    Bitmap decideImg;
    Bitmap backImg;
    Bitmap upImg;
    Bitmap downImg;
    Bitmap backgroundImg;

    StatusAloneFragment statusAloneFragment;
    Data data;
    Sound sound;
    BitmapData bitmapData;

    public DrawArmor(Context context) {
        super(context);
    }

    public DrawArmor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArmor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        decideImgWidth = (float)(w * 0.2);
        decideImgHeight = (float)(h * 0.125);
        backImgWidth = (float)(w * 0.2);
        backImgHeight = (float)(h * 0.125);
        armorImgWidth = (float)(w * 0.5);
        armorImgHeight = (float)(h * 0.55);
        armorWidth = (float)(w * 0.4);
        armorHeight = (float)(h * 0.1083);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                for(int i = 0; i < 5 && PlayerData.armor[DrawStatusAlone.charaID][i] != -1 && i < PlayerData.armor[DrawStatusAlone.charaID].length; i++){
                    if(firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 5 / 100 + i * armorHeight + armorHeight / 2 && firstTouchY < height * 5 / 100 + (i + 1) * armorHeight + armorHeight / 2){
                        sound.createTouchMedia(getContext());
                        Sound.touch.setLooping(false);
                        Sound.touch.start();
                        armorIndex = visibleIndex + i;
                    }
                }
                if(visibleIndex > 0  && firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 5 / 100 && firstTouchY < height * 5 / 100 + armorHeight / 2){
                    visibleIndex--;
                }
                else if(PlayerData.armor[DrawStatusAlone.charaID][visibleIndex + 5] != -1 && visibleIndex < PlayerData.armor[DrawStatusAlone.charaID].length - 5 && firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 5 / 100 + armorHeight * 5 + armorHeight / 2 && firstTouchY < height * 5 / 100 + armorHeight * 6){
                    visibleIndex++;
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                // 決定
                if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 70 / 100 && event.getY() < height * 82.5 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 70 / 100 && firstTouchY < height * 82.5 / 100){
                    sound.createDecideMedia(getContext());
                    Sound.decide.setLooping(false);
                    Sound.decide.start();
                    PlayerData.setArmorSetted(DrawStatusAlone.charaID, PlayerData.armor[DrawStatusAlone.charaID][armorIndex]);
                    statusAloneFragment.callStatusAloneFragment();
                }
                // 戻る
                else if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 82.5 / 100 && event.getY() < height * 95 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 82.5 / 100 && firstTouchY < height * 95 / 100){
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
        if(upImg == null) {
            upImg = BitmapFactory.decodeResource(getResources(), R.drawable.up);
            upImg = Bitmap.createScaledBitmap(upImg, (int) armorWidth, (int) armorHeight / 2, false);
        }
        if(downImg == null) {
            downImg = BitmapFactory.decodeResource(getResources(), R.drawable.down);
            downImg = Bitmap.createScaledBitmap(downImg, (int) armorWidth, (int) armorHeight / 2, false);
        }
        if(backgroundImg == null) {
            backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
            backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int) width, (int) height, false);
        }

        canvas.drawBitmap(backgroundImg, 0, 0, p);
        for(int i = 0; PlayerData.armor[DrawStatusAlone.charaID][i] != -1 && i < PlayerData.armor[DrawStatusAlone.charaID].length && i < 5; i++) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.bouguR(PlayerData.armor[DrawStatusAlone.charaID][visibleIndex + i])[0] + "\\ぼうぎょ：" + HarfToFull.changeNumHalfToFull(data.bouguR(PlayerData.armor[DrawStatusAlone.charaID][visibleIndex + i])[6]), null, width * 55 / 100, height * 5 / 100 + armorHeight / 2 + i * armorHeight, armorWidth, armorHeight, 2, 8, font, mw, border);
        }
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.bouguR(PlayerData.armor[DrawStatusAlone.charaID][armorIndex])[0], null, width * 5 / 100, height * 5 / 100, width * 50 / 100, height * 10 / 100, 1, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.bouguR(PlayerData.armor[DrawStatusAlone.charaID][armorIndex])[9], null, width * 5 / 100, height * 70 / 100, width * 70 / 100, height * 25 / 100, 4, 15, font, mw, border);
        if(armorIndex >= visibleIndex && armorIndex < visibleIndex + 5) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.bouguR(PlayerData.armor[DrawStatusAlone.charaID][armorIndex])[0] + "\\ぼうぎょ：" + HarfToFull.changeNumHalfToFull(data.bouguR(PlayerData.armor[DrawStatusAlone.charaID][armorIndex])[6]), null, width * 55 / 100, height * 5 / 100 + armorHeight / 2 + (armorIndex - visibleIndex) * armorHeight, armorWidth, armorHeight, 2, 8, font, mw, borderRed);
        }
        canvas.drawBitmap(bitmapData.getArmorBitmap(PlayerData.armor[DrawStatusAlone.charaID][armorIndex], getResources(), (int)armorImgWidth, (int)armorImgHeight), (float) (width * 5 / 100), (float) (height * 15 / 100), p);
        canvas.drawBitmap(upImg, width * 55 / 100, height * 5 / 100, p);
        canvas.drawBitmap(downImg, width * 55 / 100, height * 5 / 100 + armorHeight * 5 + armorHeight / 2, p);
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
                upImg = null;
                downImg = null;
                backgroundImg = null;
                statusAloneFragment = null;
                data = null;
                sound = null;
                bitmapData = null;
                break;
            // アクティブ状態
            case VISIBLE:
                statusAloneFragment = new StatusAloneFragment();
                data = new Data();
                sound = new Sound();
                bitmapData = new BitmapData();
                break;
        }
    }
}
