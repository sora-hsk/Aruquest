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
 * Created by uejobi on 2018/11/14.
 */

public class DrawSkillSet extends View {
    int skillIndex = 0;
    int visibleIndex = 0;
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
    Bitmap upImg;
    Bitmap downImg;
    Bitmap backgroundImg;

    SkillFragment skillFragment;
    Data data;
    Sound sound;

    public DrawSkillSet(Context context) {
        super(context);
    }

    public DrawSkillSet(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawSkillSet(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
        decideImgWidth = (float)(w * 0.2);
        decideImgHeight = (float)(h * 0.125);
        backImgWidth = (float)(w * 0.2);
        backImgHeight = (float)(h * 0.125);
        charaImgWidth = (float)(w * 0.5);
        charaImgHeight = (float)(h * 0.65);
        skillWidth = (float)(w * 0.4);
        skillHeight = (float)(h * 0.1083);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                for(int i = 0; i < 5 && PlayerData.skill[DrawStatusAlone.charaID][i] != -1 && i < PlayerData.skill[DrawStatusAlone.charaID].length; i++){
                    if(firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 5 / 100 + i * skillHeight + skillHeight / 2 && firstTouchY < height * 5 / 100 + (i + 1) * skillHeight + skillHeight / 2){
                        sound.createTouchMedia(getContext());
                        Sound.touch.setLooping(false);
                        Sound.touch.start();
                        skillIndex = visibleIndex + i;
                    }
                }
                if(visibleIndex > 0  && firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 5 / 100 && firstTouchY < height * 5 / 100 + skillHeight / 2){
                    visibleIndex--;
                }
                else if(PlayerData.skill[DrawStatusAlone.charaID][visibleIndex + 5] != -1 && firstTouchX > width * 55 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 5 / 100 + skillHeight * 5 + skillHeight / 2 && firstTouchY < height * 5 / 100 + skillHeight * 6){
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
                    PlayerData.setSkillSetted(DrawStatusAlone.charaID, DrawSkill.skillIndex, PlayerData.skill[DrawStatusAlone.charaID][skillIndex]);
                    skillFragment.callSkillFragment();
                }
                // 戻る
                else if(event.getX() > width * 75 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 82.5 / 100 && event.getY() < height * 95 / 100 && firstTouchX > width * 75 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 82.5 / 100 && firstTouchY < height * 95 / 100){
                    sound.createCancelMedia(getContext());
                    Sound.cancel.setLooping(false);
                    Sound.cancel.start();
                    skillFragment.callSkillFragment();
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
        if(upImg == null) {
            upImg = BitmapFactory.decodeResource(getResources(), R.drawable.up);
            upImg = Bitmap.createScaledBitmap(upImg, (int) skillWidth, (int) skillHeight / 2, false);
        }
        if(downImg == null) {
            downImg = BitmapFactory.decodeResource(getResources(), R.drawable.down);
            downImg = Bitmap.createScaledBitmap(downImg, (int) skillWidth, (int) skillHeight / 2, false);
        }
        if(backgroundImg == null) {
            backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
            backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int) width, (int) height, false);
        }

        canvas.drawBitmap(backgroundImg, 0, 0, p);
        for(int i = 0; i < 5 && PlayerData.skill[DrawStatusAlone.charaID][i] != -1 && i < PlayerData.skill[DrawStatusAlone.charaID].length; i++) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.wazaR(PlayerData.skill[DrawStatusAlone.charaID][visibleIndex + i])[0] + "\\しょうひＭＰ：" + HarfToFull.changeNumHalfToFull(data.wazaR(PlayerData.skill[DrawStatusAlone.charaID][visibleIndex + i])[3]), null, width * 55 / 100, height * 5 / 100 + skillHeight / 2 + i * skillHeight, skillWidth, skillHeight, 2, 10, font, mw, border);
        }
        if(PlayerData.skill[DrawStatusAlone.charaID][skillIndex] != -1) {
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.wazaR(PlayerData.skill[DrawStatusAlone.charaID][skillIndex])[12], null, width * 5 / 100, height * 70 / 100, width * 70 / 100, height * 25 / 100, 4, 15, font, mw, border);
            if (skillIndex >= visibleIndex && skillIndex < visibleIndex + 5) {
                MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.wazaR(PlayerData.skill[DrawStatusAlone.charaID][skillIndex])[0] + "\\しょうひＭＰ：" + HarfToFull.changeNumHalfToFull(data.wazaR(PlayerData.skill[DrawStatusAlone.charaID][skillIndex])[3]), null, width * 55 / 100, height * 5 / 100 + skillHeight / 2 + (skillIndex - visibleIndex) * skillHeight, skillWidth, skillHeight, 2, 10, font, mw, borderRed);
            }
        }else{
            MultiLineText.drawMessageWindow(canvas, width * 5 / 100, height * 70 / 100, width * 70 / 100, height * 25 / 100, mw, border);
        }

        canvas.drawBitmap(charaImg[DrawStatusAlone.charaID], (float) (width * 5 / 100), (float) (height * 5 / 100), p);
        canvas.drawBitmap(upImg, width * 55 / 100, height * 5 / 100, p);
        canvas.drawBitmap(downImg, width * 55 / 100, height * 5 / 100 + skillHeight * 5 + skillHeight / 2, p);
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
                upImg = null;
                downImg = null;
                backgroundImg =null;
                skillFragment = null;
                data = null;
                sound = null;
                break;
            // アクティブ状態
            case VISIBLE:
                charaImg = new Bitmap[charaImgID.length];
                skillFragment = new SkillFragment();
                data = new Data();
                sound = new Sound();
                break;
        }
    }
}
