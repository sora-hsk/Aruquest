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
import android.widget.SeekBar;

/**
 * Created by uejobi on 2018/11/19.
 */

public class DrawSoundVolume extends View{
    float width;
    float height;
    Bitmap backgroundImg;

    public DrawSoundVolume(Context context) {
        super(context);
    }

    public DrawSoundVolume(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawSoundVolume(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();
        backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
        backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int)width, (int)height, false);
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

        pt.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/DragonQuestFC.ttf"));
        pt.setColor(Color.WHITE);
        pt.setTextAlign(Paint.Align.LEFT);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        if(backgroundImg == null) {
            backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
            backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int) width, (int) height, false);
        }

        canvas.drawBitmap(backgroundImg, 0, 0, p);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"ＢＧＭ",null,width/100*20,height/100*25,width/100*60,height/100*10,1,3,pt,mw,border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"こうかおん",null,width/100*20,height/100*55,width/100*60,height/100*10,1,5,pt,mw,border);

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
                backgroundImg = null;
                break;
            // アクティブ状態
            case VISIBLE:
                break;
        }
    }
}
