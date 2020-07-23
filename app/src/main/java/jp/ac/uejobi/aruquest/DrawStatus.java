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
 * Created by uejobi on 2018/11/07.
 */

public class DrawStatus extends View {
    float width; // 画面横幅
    float height; // 画面縦幅
    float imgWidth;
    float imgHeight;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    String[] status = new String[3];
    final int[] imgID = {R.drawable.princess_status, R.drawable.cat_status, R.drawable.sheep_status};
    Bitmap[] charImg;
    Bitmap backgroundImg;

    StatusFragment statusFragment;
    Data data;
    Sound sound;

    public DrawStatus(Context context) {
        super(context);
    }

    public DrawStatus(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawStatus(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        imgWidth = (float)(w * 0.3);
        imgHeight = (float)(h * 0.28);
        for (int i = 0; i < status.length; i++) {
            status[i] = "ＨＰ：" + HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.HP[i])) + "　ＭＰ：" + HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.MP[i])) + "\\ぶき　：　" + data.bukiR(PlayerData.weaponSetted[i])[0] + "\\ぼうぐ：　" + data.bouguR(PlayerData.armorSetted[i])[0];
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
            case MotionEvent.ACTION_UP:
                if(event.getX() > width * 5 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 10 / 100 && event.getY() < height * 35 / 100 && firstTouchX > width * 5 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 10 / 100 && firstTouchY < height * 35 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    statusFragment.callStatusAloneFragment(0);
                }
                else if(event.getX() > width * 5 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 40 / 100 && event.getY() < height * 65 / 100 && firstTouchX > width * 5 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 40 / 100 && firstTouchY < height * 65 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    statusFragment.callStatusAloneFragment(1);
                }
                else if(event.getX() > width * 5 / 100 && event.getX() < width * 95 / 100 && event.getY() > height * 70 / 100 && event.getY() < height * 95 / 100 && firstTouchX > width * 5 / 100 && firstTouchX < width * 95 / 100 && firstTouchY > height * 70 / 100 && firstTouchY < height * 95 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    statusFragment.callStatusAloneFragment(2);
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        Paint mw = new Paint();
        Paint pt = new Paint();
        Paint border = new Paint();

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        pt.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        pt.setColor(Color.WHITE);
        pt.setTextAlign(Paint.Align.LEFT);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        if(charImg != null && charImg[0] == null) {
            for (int i = 0; i < imgID.length; i++) {
                charImg[i] = BitmapFactory.decodeResource(getResources(), imgID[i]);
                charImg[i] = Bitmap.createScaledBitmap(charImg[i], (int) imgWidth, (int) imgHeight, false);
            }
        }
        if(backgroundImg == null) {
            backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
            backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int) width, (int) height, false);
        }

        canvas.drawBitmap(backgroundImg, 0, 0, p);
        for(int i = 0; i < charImg.length; i++) {
            canvas.drawBitmap(charImg[i], width * 10 / 100, height * 5 / 100 + height * i * 30 / 100, p);
            MultiLineText.drawNewlineTextMessageWindowVerticalCenter(canvas, status[i], null, width * 45 / 100, height * 5 / 100 + height * i * 30 / 100, width * 50 / 100, imgHeight, 3, 13, pt, mw, border);
        }

        p = null;
        mw = null;
        pt = null;
        border = null;
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        switch (visibility){
            // 非アクティブ状態
            case GONE:
            case INVISIBLE:
                charImg = null;
                backgroundImg = null;
                statusFragment = null;
                data = null;
                sound = null;
                break;
            // アクティブ状態
            case VISIBLE:
                charImg = new Bitmap[imgID.length];
                statusFragment = new StatusFragment();
                data = new Data();
                sound = new Sound();
                break;
        }
    }
}
