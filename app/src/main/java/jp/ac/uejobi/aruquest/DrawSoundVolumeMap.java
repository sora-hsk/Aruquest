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
 * Created by uejobi on 2018/11/19.
 */

public class DrawSoundVolumeMap extends View{
    float width;
    float height;
    float firstTouchX;
    float firstTouchY;
    Paint p = new Paint();
    Paint mw = new Paint();
    Paint pt = new Paint();
    Paint border = new Paint();

    SoundVolumeMapFragment soundVolumeMapFragment = new SoundVolumeMapFragment();
    Sound sound = new Sound();

    public DrawSoundVolumeMap(Context context) {
        super(context);
    }

    public DrawSoundVolumeMap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawSoundVolumeMap(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();
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
                // もどる
                if(event.getX() > width * 20 / 100 && event.getX() < width * 85 / 100 && event.getY() > height * 85 / 100 && event.getY() < height * 95 / 100 && firstTouchX > width * 20 / 100 && firstTouchX < width * 85 / 100 && firstTouchY > height * 85 / 100 && firstTouchY < height * 95 / 100){
                    sound.createCancelMedia(getContext());
                    Sound.cancel.setLooping(false);
                    Sound.cancel.start();
                    soundVolumeMapFragment.callCommandFragment();
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        pt.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/DragonQuestFC.ttf"));
        pt.setColor(Color.WHITE);
        pt.setTextAlign(Paint.Align.LEFT);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"ＢＧＭ",null,width/100*20,height/100*25,width/100*60,height/100*10,1,3,pt,mw,border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"こうかおん",null,width/100*20,height/100*55,width/100*60,height/100*10,1,5,pt,mw,border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"もどる",null,width/100*20,height/100*85,width/100*60,height/100*10,1,3,pt,mw,border);

    }
}
