package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by uejobi on 2018/11/06.
 */

public class DrawStart extends View {
    Bitmap titleImg;
    Paint p = new Paint();
    Sound sound = new Sound();

    public DrawStart(Context context) {
        super(context);
    }

    public DrawStart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawStart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        titleImg = BitmapFactory.decodeResource(getResources(), R.drawable.title);
        titleImg = Bitmap.createScaledBitmap(titleImg, (int)w, (int)h, false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                sound.createTouchMedia(getContext());
                Sound.touch.setLooping(false);
                Sound.touch.start();
                if(PlayerData.rank < 0){
                    Intent i = new Intent(getContext(), jp.ac.uejobi.aruquest.LeadActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    getContext().startActivity(i);
                }else {
                    Intent i = new Intent(getContext(), jp.ac.uejobi.aruquest.HomeActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    getContext().startActivity(i);
                }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(titleImg, 0, 0, p);
    }
}
