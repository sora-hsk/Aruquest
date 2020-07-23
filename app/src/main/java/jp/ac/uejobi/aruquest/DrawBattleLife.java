package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by uejobi on 2018/11/27.
 */

public class DrawBattleLife extends View implements Runnable{
    final int INTERVAL = 300;
    int counter = 0;
    float width;
    float height;
    float wOut1;
    float wOut2;
    static String[] message = null;
    static String[] name = null;
    String moji = "";
    int lineIndex = 0;
    int index = 0;
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    float secondTouchX; // タッチした位置のX座標
    float secondTouchY; // タッチした位置のY座標
    Paint p = new Paint();
    Paint mw = new Paint();
    Paint pt = new Paint();
    Paint border = new Paint();
    Paint k = new Paint();
    Paint t = new Paint();

    // キャラのhp,mpを受け取る
    static int[] maxhp = {PlayerData.HP[0],PlayerData.HP[1],PlayerData.HP[2]};
    static int[] maxmp = {PlayerData.MP[0],PlayerData.MP[1],PlayerData.MP[2]};
     int[] hp = new int[3];
     int[] mp = new int[3];

     BitmapData bitmapData = new BitmapData();
    Handler handler = new Handler();

    public DrawBattleLife(Context context) {
        super(context);
    }

    public DrawBattleLife(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBattleLife(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        pt.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        pt.setColor(Color.WHITE);
        pt.setTextAlign(Paint.Align.LEFT);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        MultiLineText.drawMessageWindow(canvas, width * 5 / 100, height * 5 / 100, width * 90 / 100, height * 53 / 100, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"エ",null,0,height / 1000 * 630,width/100*10,height / 1000 * 80,1,1,pt,mw,border );
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"マ",null,width/100*50,height / 1000 * 630,width/100*10,height / 1000 * 80,1,1,pt,mw,border );
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas,"ア",null,width/100*50,height / 1000 * 720,width/100*10,height / 1000 * 80,1,1,pt,mw,border );
        canvas.drawBitmap(bitmapData.getEnemyBitmap(Dungeon.enemyID, getResources(), (int)(width * 88 / 100), (int)(height * 47 / 100)), width * 6 / 100, height * 8 / 100, p);

        hp[0] = ComandCtrl.Hp[0];
        if (hp[0] < 0)hp[0] = 0;
        if (hp[0] > maxhp[0]) hp[0] = maxhp[0];
        hp[1] = ComandCtrl.Hp[1];
        if (hp[1] < 0)hp[1] = 0;
        if (hp[1] > maxhp[1]) hp[1] = maxhp[1];
        hp[2] = ComandCtrl.Hp[2];
        if (hp[2] < 0)hp[2] = 0;
        if (hp[2] > maxhp[2]) hp[2] = maxhp[2];
        mp[0] = ComandCtrl.Mp[0];
        if (mp[0] < 0)mp[0] = 0;
        if (mp[0] > maxmp[0]) mp[0] = maxmp[0];
        mp[1] = ComandCtrl.Mp[1];
        if (mp[1] < 0)mp[1] = 0;
        if (mp[1] > maxmp[1]) mp[1] = maxmp[1];
        mp[2] = ComandCtrl.Mp[2];
        if (mp[2] < 0)mp[2] = 0;
        if (mp[2] > maxmp[2]) mp[2] = maxmp[2];

        // HP
        k.setColor(Color.rgb(0x0b,0x61,0x0b));
        k.setStrokeWidth(height/1000*36);
        if (hp[0] != 0)canvas.drawLine(width/100*11,height/100*65,(width/100*45)-((width/100*35)-(((width/100*35)*(float)hp[0])/(float) maxhp[0])),height/100*65,k);
        if (hp[1] != 0)canvas.drawLine(width/100*61,height/100*65,(width/100*95)-((width/100*35)-(((width/100*35)*(float) hp[1])/(float) maxhp[1])),height/100*65,k);
        if (hp[2] != 0)canvas.drawLine(width/100*61,height/100*74,(width/100*95)-((width/100*35)-(((width/100*35)*(float) hp[2])/(float) maxhp[2])),height/100*74,k);
        //mp
        k.setColor(Color.BLUE);
        if (mp[0] != 0)canvas.drawLine(width/100*11,height/100*69,(width/100*45)-((width/100*35)-(((width/100*35)*(float)mp[0])/(float) maxmp[0])),height/100*69,k);
        if (mp[1] != 0)canvas.drawLine(width/100*61,height/100*69,(width/100*95)-((width/100*35)-(((width/100*35)*(float) mp[1])/(float) maxmp[1])),height/100*69,k);
        if (mp[2] != 0)canvas.drawLine(width/100*61,height/100*78,(width/100*95)-((width/100*35)-(((width/100*35)*(float) mp[2])/(float) maxmp[2])),height/100*78,k);

        t.setColor(Color.WHITE);
        t.setStrokeWidth(5);
        t.setTypeface(Typeface.SANS_SERIF);
        t.setTextSize(height/1000*35);
        t.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(hp[0]+"/"+maxhp[0],width/100*11,height/100*66,t);
        canvas.drawText(hp[1]+"/"+maxhp[1],width/100*61,height/100*66,t);
        canvas.drawText(hp[2]+"/"+maxhp[2],width/100*61,height/100*75,t);
        canvas.drawText(mp[0]+"/"+maxmp[0],width/100*11,height/100*70,t);
        canvas.drawText(mp[1]+"/"+maxmp[1],width/100*61,height/100*70,t);
        canvas.drawText(mp[2]+"/"+maxmp[2],width/100*61,height/100*79,t);
    }

    @Override
    public void run() {
        invalidate();
        handler.postDelayed(this, INTERVAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        handler.postDelayed(this, 100);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}


