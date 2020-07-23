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

public class DrawSkill extends View {
    static int skillIndex = 0;
    float width; // 画面横幅
    float height; // 画面縦幅
    float charaImgWidth;
    float charaImgHeight;
    float decideImgWidth;
    float decideImgHeight;
    float backImgWidth;
    float backImgHeight;
    float skillWidth;
    float skillHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    final int[] charaImgID = {R.drawable.princess_whole, R.drawable.cat_whole, R.drawable.sheep_whole};
    Bitmap[] charaImg;
    Bitmap decideImg;
    Bitmap backImg;
    Bitmap backgroundImg;

    StatusAloneFragment statusAloneFragment;
    SkillFragment skillFragment;
    Data data;
    Sound sound;

    public DrawSkill(Context context) {
        super(context);
    }

    public DrawSkill(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawSkill(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        charaImgWidth = (float)(w * 0.5);
        charaImgHeight = (float)(h * 0.65);
        decideImgWidth = (float)(w * 0.2);
        decideImgHeight = (float)(h * 0.125);
        backImgWidth = (float)(w * 0.2);
        backImgHeight = (float)(h * 0.125);
        skillWidth = (float)(w * 0.4);
        skillHeight = (float)(h * 0.16125);
        for(int i = 0; i < charaImgID.length; i++) {
            charaImg[i] = BitmapFactory.decodeResource(getResources(), charaImgID[i]);
            charaImg[i] = Bitmap.createScaledBitmap(charaImg[i], (int) charaImgWidth, (int) charaImgHeight, false);
        }
        decideImg = BitmapFactory.decodeResource(getResources(), R.drawable.icon_decide);
        decideImg = Bitmap.createScaledBitmap(decideImg, (int)decideImgWidth, (int)decideImgHeight, false);
        backImg = BitmapFactory.decodeResource(getResources(), R.drawable.icon_back);
        backImg = Bitmap.createScaledBitmap(backImg, (int)backImgWidth, (int)backImgHeight, false);
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
                for(int i = 0; i < PlayerData.skillSetted[DrawStatusAlone.charaID].length; i++){
                    if(firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 5 / 100 + i * skillHeight && firstTouchY < height * 5 / 100 + (i + 1) * skillHeight){
                        sound.createTouchMedia(getContext());
                        Sound.touch.setLooping(false);
                        Sound.touch.start();
                        skillIndex = i;
                    }
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                // 決定
                if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 69 / 100 && event.getY() < height * 81.5 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 70 / 100 && firstTouchY < height * 82.5 / 100){
                    sound.createDecideMedia(getContext());
                    Sound.decide.setLooping(false);
                    Sound.decide.start();
                    skillFragment.callSkillSetFragment();
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

        if(charaImg[DrawStatusAlone.charaID] == null) {
            charaImg[DrawStatusAlone.charaID] = BitmapFactory.decodeResource(getResources(), charaImgID[DrawStatusAlone.charaID]);
            charaImg[DrawStatusAlone.charaID] = Bitmap.createScaledBitmap(charaImg[DrawStatusAlone.charaID], (int) charaImgWidth, (int) charaImgHeight, false);
        }
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
        for(int i = 0; i < PlayerData.skillSetted[DrawStatusAlone.charaID].length; i++) {
            if(PlayerData.skillSetted[DrawStatusAlone.charaID][i] != -1) {
                MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.wazaR(PlayerData.skillSetted[DrawStatusAlone.charaID][i])[0] + "\\しょうひＭＰ：" + HarfToFull.changeNumHalfToFull(data.wazaR(PlayerData.skillSetted[DrawStatusAlone.charaID][i])[3]), null, width * 55 / 100, height * 5 / 100 + i * skillHeight, skillWidth, skillHeight, 2, 10, font, mw, border);
            }else{
                MultiLineText.drawMessageWindow(canvas,width * 55 / 100, height * 5 / 100 + i * skillHeight, skillWidth, skillHeight, mw, border);
            }
        }
        if(PlayerData.skillSetted[DrawStatusAlone.charaID][skillIndex] != -1) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.wazaR(PlayerData.skillSetted[DrawStatusAlone.charaID][skillIndex])[0] + "\\しょうひＭＰ：" + HarfToFull.changeNumHalfToFull(data.wazaR(PlayerData.skillSetted[DrawStatusAlone.charaID][skillIndex])[3]), null, width * 55 / 100, height * 5 / 100 + skillIndex * skillHeight, skillWidth, skillHeight, 2, 10, font, mw, borderRed);
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.wazaR(PlayerData.skillSetted[DrawStatusAlone.charaID][skillIndex])[12], null, width * 5 / 100, height * 70 / 100, width * 70 / 100, height * 25 / 100, 4, 15, font, mw, border);
        }else{
            MultiLineText.drawMessageWindow(canvas,width * 55 / 100, height * 5 / 100 + skillIndex * skillHeight, skillWidth, skillHeight, mw, borderRed);
            MultiLineText.drawMessageWindow(canvas, width * 5 / 100, height * 70 / 100, width * 70 / 100, height * 25 / 100, mw, border);
        }
        canvas.drawBitmap(charaImg[DrawStatusAlone.charaID], width * 5 / 100, height * 5 / 100, p);
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
                charaImg = null;
                decideImg = null;
                backImg = null;
                backgroundImg = null;
                statusAloneFragment = null;
                skillFragment = null;
                data = null;
                sound = null;
                break;
            // アクティブ状態
            case VISIBLE:
                charaImg = new Bitmap[charaImgID.length];
                statusAloneFragment = new StatusAloneFragment();
                skillFragment = new SkillFragment();
                data = new Data();
                sound = new Sound();
                break;
        }
    }
}
