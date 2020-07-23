package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;

/**
 * Created by uejobi on 2018/12/18.
 */

public class DrawEnding extends View implements Runnable {
    final int INTERVAL = 20; // runの間隔
    final int ANIMINTERVAL = 2000;
    float width; // 画面横幅
    float height; // 画面縦幅
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    float secondTouchX; // タッチした位置のX座標
    float secondTouchY; // タッチした位置のY座標
    boolean touchFlg = false;
    int backImgIndex = 0;
    int staffImgIndex = 0;
    final int[] backImgID = {R.drawable.lead_black, R.drawable.ending1, R.drawable.ending2, R.drawable.ending3};
    final int[] staffImgID = {R.drawable.ending4, R.drawable.ending5, R.drawable.ending6, R.drawable.ending7, R.drawable.ending8, R.drawable.ending9};
    Bitmap[] backImg = new Bitmap[backImgID.length];
    Bitmap[] staffImg = new Bitmap[staffImgID.length];
    Paint p = new Paint();
    Handler handler = new Handler();
    EndingFragment endingFragment = new EndingFragment();
    View view = this;

    AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
    AlphaAnimation alpha2 = new AlphaAnimation(1.0f, 0.0f);

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        DrawMessageLead.endFlg = true;
        alpha.setDuration(ANIMINTERVAL);
        alpha2.setDuration(ANIMINTERVAL);
    }

    public DrawEnding(Context context) {
        super(context);
    }

    public DrawEnding(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawEnding(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(DrawMessageLead.endFlg) {
                    DrawMessageLead.endFlg = false;
                    if (backImgIndex < 3) {
                        switch (backImgIndex) {
                            case 0:
                                AnimationSet anim0 = new AnimationSet(false);
                                anim0.addAnimation(alpha2);
                                this.startAnimation(anim0);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        backImgIndex++;
                                        invalidate();
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                String[][] msg0 = {{"；ルク！；アルク！おきなさい！", "；；；；；！", "きょうはマウちゃんと　おしろにいくよていでしょ！", "；；；；；"}, {"はは", "アルク", "はは", "アルク"}};
                                                endingFragment.callMessageLeadFragment(msg0);

                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                            case 1:
                                AnimationSet anim1 = new AnimationSet(false);
                                anim1.addAnimation(alpha2);
                                this.startAnimation(anim1);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        backImgIndex++;
                                        invalidate();
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                String[][] msg1 = {{"；ルク！；アルク！おきなさい！", "；；；；；！", "きょうはマウちゃんと　おしろにいくよていでしょ！", "；；；；；"}, {"はは", "アルク", "はは", "アルク"}};
                                                endingFragment.callMessageLeadFragment(msg1);

                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                            case 2:
                                AnimationSet anim2 = new AnimationSet(false);
                                anim2.addAnimation(alpha2);
                                this.startAnimation(anim2);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        backImgIndex++;
                                        invalidate();
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                String[][] msg2 = {{"おそいわよ　アルクったらもう！", "；；；；；！", "きょうはむらのけんじょうひんを　おしろにとどけるって　やくそくしたでしょ？！　いくわよ！", "；；；；；！"}, {"マウ", "アルク", "マウ", "アルク"}};
                                                endingFragment.callMessageLeadFragment(msg2);
                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                        }
                    }else{
                        switch (staffImgIndex) {
                            case 0:
                                AnimationSet anim3 = new AnimationSet(false);
                                anim3.addAnimation(alpha2);
                                this.startAnimation(anim3);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        backImgIndex++;
                                        invalidate();
                                        staffImgIndex++;
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                DrawMessageLead.endFlg = true;
                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                            case 1:
                                AnimationSet anim4 = new AnimationSet(false);
                                anim4.addAnimation(alpha2);
                                this.startAnimation(anim4);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        invalidate();
                                        staffImgIndex++;
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                DrawMessageLead.endFlg = true;
                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                            case 2:
                                AnimationSet anim5 = new AnimationSet(false);
                                anim5.addAnimation(alpha2);
                                this.startAnimation(anim5);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        invalidate();
                                        staffImgIndex++;
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                DrawMessageLead.endFlg = true;
                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                            case 3:
                                AnimationSet anim6 = new AnimationSet(false);
                                anim6.addAnimation(alpha2);
                                this.startAnimation(anim6);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        invalidate();
                                        staffImgIndex++;
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                DrawMessageLead.endFlg = true;
                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                            case 4:
                                AnimationSet anim7 = new AnimationSet(false);
                                anim7.addAnimation(alpha2);
                                this.startAnimation(anim7);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        invalidate();
                                        staffImgIndex++;
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                DrawMessageLead.endFlg = true;
                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                            case 5:
                                AnimationSet anim8 = new AnimationSet(false);
                                anim8.addAnimation(alpha2);
                                this.startAnimation(anim8);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        invalidate();
                                        staffImgIndex++;
                                        AnimationSet anim = new AnimationSet(false);
                                        anim.addAnimation(alpha);
                                        view.startAnimation(anim);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                DrawMessageLead.endFlg = true;
                                            }
                                        }, ANIMINTERVAL);
                                    }
                                }, ANIMINTERVAL);
                                break;
                            case 6:
                                AnimationSet anim9 = new AnimationSet(false);
                                anim9.addAnimation(alpha2);
                                this.startAnimation(anim9);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent i = new Intent(getContext(), StartActivity.class);
                                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        getContext().startActivity(i);
                                    }
                                }, ANIMINTERVAL - 500);
                                break;
                            }
                        }
                    }
                break;
            case MotionEvent.ACTION_MOVE:
                secondTouchX = event.getX();
                secondTouchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                touchFlg = false;
                secondTouchX = 0;
                secondTouchY = 0;
                break;
        }
        return true;
    }

    @Override
    public void run() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(backImgIndex < 4 && backImg[backImgIndex] == null) {
            backImg[backImgIndex] = BitmapFactory.decodeResource(getResources(), backImgID[backImgIndex]);
            backImg[backImgIndex] = Bitmap.createScaledBitmap(backImg[backImgIndex], (int)width, (int)(height * 75 / 100),false);
        }
        else if(staffImgIndex < staffImg.length && staffImg[staffImgIndex] == null) {
            staffImg[staffImgIndex] = BitmapFactory.decodeResource(getResources(), staffImgID[staffImgIndex]);
            staffImg[staffImgIndex] = Bitmap.createScaledBitmap(staffImg[staffImgIndex], (int)width, (int)height,false);
        }
        if(backImgIndex < 4) {
            canvas.drawBitmap(backImg[backImgIndex], 0, 0, p);
            backImg[backImgIndex] = null;
        }
        else if(staffImgIndex < staffImg.length){
            canvas.drawBitmap(staffImg[staffImgIndex], 0, 0, p);
            staffImg[staffImgIndex] = null;
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        handler.postDelayed(this, 100);
    }
}
