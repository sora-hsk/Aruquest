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

public class DrawStatusAlone extends View {
    static int charaID = 0;
    float width; // 画面横幅
    float height; // 画面縦幅
    float backImgWidth;
    float backImgHeight;
    float charaImgWidth;
    float charaImgHeight;
    float iconImgWidth;
    float iconImgHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    Bitmap backImg;
    final int[] charaImgID = {R.drawable.princess_whole, R.drawable.cat_whole, R.drawable.sheep_whole};
    Bitmap[] charaImg = new Bitmap[charaImgID.length];
    final int[] iconImgID = {R.drawable.icon_weapon, R.drawable.icon_skill, R.drawable.icon_armor, R.drawable.icon_item};
    Bitmap[] iconImg = new Bitmap[iconImgID.length];
    Bitmap backgroundImg;

    StatusAloneFragment statusAloneFragment;
    Data data;
    Sound sound;

    public static void setCharaID(int charaID) {
        DrawStatusAlone.charaID = charaID;
    }

    public DrawStatusAlone(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawStatusAlone(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
        backImgWidth = (float)(w * 0.2);
        backImgHeight = (float)(h * 0.25);
        charaImgWidth = (float)(w * 0.5);
        charaImgHeight = (float)(h * 0.65);
        iconImgWidth = (float)(w * 0.2);
        iconImgHeight = (float)(h * 0.13);
        super.onSizeChanged(w, h, oldw, oldh);
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
                // 武器
                if(event.getX() > width * 55 / 100 && event.getX() < width * 75 / 100 && event.getY() > height * 44 / 100 && event.getY() < height * 57 / 100 && firstTouchX > width * 55 / 100 && firstTouchX < width * 75 / 100 && firstTouchY > height * 44 / 100 && firstTouchY < height * 57 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    statusAloneFragment.callWeaponFragment();
                }
                // 防具
                else if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 44 / 100 && event.getY() < height * 57 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 44 / 100 && firstTouchY < height * 57 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    statusAloneFragment.callArmorFragment();
                }
                // 技
                else if(event.getX() > width * 55 / 100 && event.getX() < width * 75 / 100 && event.getY() > height * 57 / 100 && event.getY() < height * 70 / 100 && firstTouchX > width * 55 / 100 && firstTouchX < width * 75 / 100 && firstTouchY > height * 57 / 100 && firstTouchY < height * 70 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    statusAloneFragment.callSkillFragment();
                }
                // 道具
                else if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 57 / 100 && event.getY() < height * 70 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 57 / 100 && firstTouchY < height * 70 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    statusAloneFragment.callItemFragment();
                }
                // 戻る
                else if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 70 / 100 && event.getY() < height * 95 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 70 / 100 && firstTouchY < height * 95 / 100){
                    sound.createCancelMedia(getContext());
                    Sound.cancel.setLooping(false);
                    Sound.cancel.start();
                    statusAloneFragment.callStatusFragment();
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
        Paint borderBlack = new Paint();

        font.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        font.setColor(Color.WHITE);
        font.setTextAlign(Paint.Align.LEFT);

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        borderBlack.setColor(Color.BLACK);
        borderBlack.setStrokeWidth(5);
        borderBlack.setStyle(Paint.Style.STROKE);

        if(charaImg[charaID] == null) {
            charaImg[charaID] = BitmapFactory.decodeResource(getResources(), charaImgID[charaID]);
            charaImg[charaID] = Bitmap.createScaledBitmap(charaImg[charaID], (int) charaImgWidth, (int) charaImgHeight, false);
        }
        if(iconImg != null && iconImg[0] == null) {
            for (int i = 0; i < iconImgID.length; i++) {
                iconImg[i] = BitmapFactory.decodeResource(getResources(), iconImgID[i]);
                iconImg[i] = Bitmap.createScaledBitmap(iconImg[i], (int) iconImgWidth, (int) iconImgHeight, false);
            }
        }
        if(backImg == null) {
            backImg = BitmapFactory.decodeResource(getResources(), R.drawable.back_wide);
            backImg = Bitmap.createScaledBitmap(backImg, (int) backImgWidth, (int) backImgHeight, false);
        }
        if(backgroundImg == null) {
            backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
            backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int) width, (int) height, false);
        }

        canvas.drawBitmap(backgroundImg, 0, 0, p);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "　" + data.mikataR(charaID)[0], null, width * 55 / 100, height * 5 / 100, width * 40 / 100, height * 7 / 100, 1, 5, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "ぶ：" + data.bukiR(PlayerData.weaponSetted[charaID])[0] + "\\ぼ：" + data.bouguR(PlayerData.armorSetted[charaID])[0], null, width * 55 / 100, height * 12 / 100, width * 40 / 100, height * 10 / 100, 2, 10, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "ＨＰ　　：" + HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.HP[charaID])) + "\\ＭＰ　　：" + HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.MP[charaID])) + "\\こうげき：" + HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.ATK[charaID])) + "\\ぼうぎょ：" + HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.DEF[charaID])) + "\\すばやさ：" + HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.SPD[charaID])), null, width * 55 / 100, height * 22 / 100, width * 40 / 100, height * 22 / 100, 5, 8, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.mikataR(charaID)[7], null, width * 5 / 100, height * 70 / 100, width * 70 / 100, height * 25 / 100, 4, 15, font, mw, border);
        canvas.drawBitmap(charaImg[charaID], (float)(width * 5 / 100), (float) (height * 5 / 100), p);
        canvas.drawBitmap(iconImg[0], (float)(width * 55 / 100), (float) (height * 44 / 100), p);
        canvas.drawBitmap(iconImg[1], (float)(width * 55 / 100), (float) (height * 57 / 100), p);
        canvas.drawBitmap(iconImg[2], (float)(width * 75 / 100), (float) (height * 44 / 100), p);
        canvas.drawBitmap(iconImg[3], (float)(width * 75 / 100), (float) (height * 57 / 100), p);
        canvas.drawBitmap(backImg, (float)width * 75 / 100, (float)(height * 70 / 100), p);

        p = null;
        font = null;
        mw = null;
        border = null;
        borderBlack = null;
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        switch (visibility){
            // 非アクティブ状態
            case GONE:
            case INVISIBLE:
                backImg = null;
                charaImg = null;
                iconImg = null;
                backgroundImg = null;
                statusAloneFragment = null;
                data = null;
                sound = null;
                break;
            // アクティブ状態
            case VISIBLE:
                charaImg = new Bitmap[charaImgID.length];
                iconImg = new Bitmap[iconImgID.length];
                statusAloneFragment = new StatusAloneFragment();
                data = new Data();
                sound = new Sound();
                break;
        }
    }
}
