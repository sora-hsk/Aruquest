package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/**
 * Created by uejobi on 2018/11/30.
 */
import android.support.annotation.Nullable;

public class DrawGraph extends View {

    final double MARGIN_TOP = 0.07;
    final double MARGIN_BOTTOM = 0.15;
    final double NOT_BOTTOM = 1 - MARGIN_TOP - MARGIN_BOTTOM;
    final float DAY_SPACE = (float) 20.5;
    final float DAY_SPACE_PLUS = (float)11.3;
    final float DAY_SPACE_RECT = (float)10.5;
    float hundred = 100;
    Bitmap backgroundImg;
    Paint p = new Paint();
    Paint p2 = new Paint();
    Paint p3 = new Paint();
    Paint p4 = new Paint();
    Paint p5 = new Paint();
    Paint p6 = new Paint();
    Paint p7 = new Paint();
    Paint p8 = new Paint();
    Paint p9 = new Paint();

    public DrawGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //スマホの横幅変数
    double wh;
    //スマホの縦幅変数
    double hh;

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //スマホの横の割合を取る
        wh = getWidth();
        //スマホの縦の割合を取る
        hh = getHeight();
        backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background_home);
        backgroundImg = Bitmap.createScaledBitmap(backgroundImg, (int)wh, (int)hh, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(backgroundImg, 0, 0, p);
        //描画の色
        p.setColor(Color.RED);
        p2.setColor(Color.GREEN);
        p3.setColor(Color.BLACK);
        p4.setColor(Color.BLACK);
        p5.setColor(Color.BLACK);
        p6.setColor(Color.BLACK);
        p7.setColor(Color.RED);
        p8.setColor(Color.RED);

        //描画の太さ設定
        p.setStrokeWidth(5);
        p2.setStrokeWidth(15);
        p3.setStrokeWidth(15);
        p4.setStrokeWidth(3);
        p5.setStrokeWidth(30);
        p5.setTextSize(30);
        p6.setTextSize(20);
        p7.setTextSize(35);
        p8.setTextSize(25);
        p9.setTextSize(25);

        //描画のスタイル設定
        p.setStrokeCap(Paint.Cap.BUTT);
        p.setStyle(Paint.Style.FILL_AND_STROKE);

        float hh090 = (float) (hh * 0.90);
        float wh095 = (float) (wh * 0.95);
        float wh20 = (float) (wh * 0.20);
        float heightLine = (float) 10.7;
        float heightspace = (float) 30.7;
        float stickspace = (float) 24;
        float hh005 = (float) hh / 100 * 7;
        float text_space = 24;
        float start_point = 20;
        float rect_space = 29;
        float bottom_line = 85;
        float hh001 = (float)(hh * 0.01);


        int max = PlayerData.stepWeek[0];
        for(int i = 1; i < PlayerData.stepWeek.length; i++){
            if(max < PlayerData.stepWeek[i]){
                max = PlayerData.stepWeek[i];
            }
        }

        int count = 1;
        while (max > 100){
            max /= 10;
            count *= 10;
        }

        max = (max+1) * count;
        //横軸数字
        int maxI2 = (max / 4) * 3;
        int maxI3 = (max / 4) * 2;
        int maxI4 = (max / 4);
        float wh001 = (float) ((float) wh * 0.01);
        canvas.drawText("" + max, (float)(wh / hundred * 5), (float) (hh * (MARGIN_TOP + NOT_BOTTOM * (hundred - 98) / hundred)), p5);
        canvas.drawText("" + maxI2,  (float)(wh / hundred * 5), (float) (hh * (MARGIN_TOP + NOT_BOTTOM * (hundred - 74) / hundred)), p5);
        canvas.drawText("" + maxI3,   (float)(wh / hundred * 5), (float) (hh * (MARGIN_TOP + NOT_BOTTOM * (hundred - 49) / hundred)), p5);
        canvas.drawText("" + maxI4,  (float)(wh / hundred * 5), (float) (hh * (MARGIN_TOP + NOT_BOTTOM * (hundred - 24) / hundred)), p5);
        canvas.drawText("0", (float)(wh / hundred * 5), (float) (hh * (1 - 0.15)), p5);

        canvas.drawText("6日前", (float) (wh / hundred * DAY_SPACE), hh090, p9);
        for(int i=2; i<7; i++) {
            canvas.drawText((7 - i)+"日前", ((float) wh / hundred * (DAY_SPACE + DAY_SPACE_PLUS * (i - 1))), hh090, p9);
        }
        canvas.drawText("今日", ((float) wh / hundred * (DAY_SPACE + DAY_SPACE_PLUS * 6)), hh090, p9);

        //横線
        canvas.drawLine(wh20, (float) (hh * (MARGIN_TOP + NOT_BOTTOM * (hundred - hundred) / hundred)),wh095, (float) (hh * (MARGIN_TOP + NOT_BOTTOM * (hundred - hundred) / hundred)), p4);
        for(int i=1; i<4; i++){
            int k = i*25;
            canvas.drawLine(wh20,(float)(hh*(MARGIN_TOP+NOT_BOTTOM*(hundred - k) / hundred)),wh095,(float)(hh*(MARGIN_TOP+NOT_BOTTOM*(hundred - k) / hundred)),p4);
        }

        //縦線
        canvas.drawLine((float) (wh * 0.307),  hh005, (float) (wh * 0.307), (float) (hh / hundred * bottom_line), p4);//1
        canvas.drawLine((float) wh / hundred * (heightspace + heightLine), hh005, (float) wh / hundred * (heightspace + heightLine), (float) (hh / hundred * bottom_line), p4);
        for(int i=2; i<7; i++){
            canvas.drawLine((float) wh / hundred * (heightspace + heightLine * i), hh005, (float) wh / hundred * (heightspace + heightLine * i), (float) (hh / hundred * bottom_line), p4);
        }

        canvas.drawRect((float) wh / hundred * stickspace, (float) ((hh * MARGIN_TOP) + (hh * NOT_BOTTOM * (max - PlayerData.stepWeek[0]) / max)), (float) wh / hundred * rect_space, (float) hh / hundred * 85, p2);//1
        canvas.drawRect((float) wh / hundred * (stickspace + DAY_SPACE_RECT), (float) ((hh * MARGIN_TOP) + (hh * NOT_BOTTOM * (max - PlayerData.stepWeek[1]) / max)), (float) wh / hundred * (rect_space + DAY_SPACE_RECT), (float) hh / hundred * bottom_line, p2);
        for(int i=2; i < PlayerData.stepWeek.length; i++){
            canvas.drawRect((float) wh / hundred * (stickspace + DAY_SPACE_RECT * i), (float) ((hh * MARGIN_TOP) + (hh * NOT_BOTTOM * (max - PlayerData.stepWeek[i]) / max)), (float) wh / hundred * (rect_space + DAY_SPACE_RECT * i), (float) hh / hundred * bottom_line, p2);
        }

        canvas.drawText("" + PlayerData.stepWeek[0], (float) wh / hundred * text_space, (float) ((hh * MARGIN_TOP) + (hh * NOT_BOTTOM * (max - PlayerData.stepWeek[0]) / max) - hh001), p8);
        canvas.drawText("" + PlayerData.stepWeek[1], (float) wh / hundred * (text_space + DAY_SPACE_RECT),(float) ((hh * MARGIN_TOP) + (hh * NOT_BOTTOM * (max - PlayerData.stepWeek[1]) / max) - hh001), p8);
        for(int i=2; i < PlayerData.stepWeek.length; i++){
            canvas.drawText("" + PlayerData.stepWeek[i], (float) wh / hundred * (text_space + DAY_SPACE_RECT * i), (float)((hh * MARGIN_TOP) + (hh * NOT_BOTTOM * (max - PlayerData.stepWeek[i]) / max) - hh001), p8);
        }

        canvas.drawText("累計" + PlayerData.stepSum + "歩", (float) (wh * 0.45), (float) (hh * 0.95), p7);

        canvas.drawLine((float) wh / hundred * start_point, (float) hh / hundred * bottom_line,
                (float) wh / hundred * 95, (float) hh / hundred * bottom_line, p3);//X軸

        canvas.drawLine((float) wh / hundred * start_point, (float) hh / hundred * 7,
                (float) wh / hundred * start_point, (float) hh / hundred * bottom_line, p3);//Y軸
    }
}