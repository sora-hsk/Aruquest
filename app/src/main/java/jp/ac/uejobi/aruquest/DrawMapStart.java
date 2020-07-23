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

public class DrawMapStart extends View implements Runnable {
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
    int[] backImgID = {R.drawable.lead_black, R.drawable.lead_black, R.drawable.lead1, R.drawable.lead2, R.drawable.lead3, R.drawable.lead4, R.drawable.lead5, R.drawable.lead6, R.drawable.lead7, R.drawable.lead8};
    Bitmap[] backImg = new Bitmap[backImgID.length];
    Paint p = new Paint();
    Handler handler = new Handler();
    MapStartFragment mapStartFragment = new MapStartFragment();
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

    public DrawMapStart(Context context) {
        super(context);
    }

    public DrawMapStart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawMapStart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(DrawMessageLead.endFlg) {
                    DrawMessageLead.endFlg = false;
                    switch (backImgIndex) {
                        case 0:
                            String[][] msg = {{"このちにつたわっている　むかしばなしのなかに　こんなおはなしがあります。", "むかしむかし　あるところに　にんげんの　ゆたかなくにがありました。", "にんげんたちは　ひりきでしたが　かみがみからさずかった　せいなるオーブをみなもとに　はんえいしていました。", "しかし　そのへいわは　ながくはつづきませんでした。", "オーブのちからを　わがものにしようとしたあしきものが　ちのはてより　まものをよびよせたのです。", "ひとびとはけんめいにたたかいましたが　しだいにおいつめられ　ぜったいぜつめいとおもわれたそのとき", "どこからともなく　あかげのせいねんが　あらわれました。", "せいねんはオーブをけんにやどし　まものたちとたたかい　ついにあしきものを　ふういんしたのです。", "にんげんたちはこれをたたえようと　せいねんをさがしましたが　すがたをみたものは　いませんでした。", "オーブとともにさった　ゆうしゃのでんせつ", "せいねんがだれだったのか　このくにがどうなったのか　いまとなってはだれもしりません。"}, {null, null, null, null, null, null, null, null, null, null, null}};
                            mapStartFragment.callMessageLeadFragment(msg);
                            backImgIndex++;
                            break;
                        case 1:
                            AnimationSet anim = new AnimationSet(false);
                            anim.addAnimation(alpha2);
                            this.startAnimation(anim);
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
                                            mapStartFragment.callMessageLeadFragment(msg1);

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
                                            mapStartFragment.callMessageLeadFragment(msg2);
                                        }
                                    }, ANIMINTERVAL);
                                }
                            }, ANIMINTERVAL);
                            break;
                        case 3:
                            AnimationSet anim3 = new AnimationSet(false);
                            anim3.addAnimation(alpha2);
                            this.startAnimation(anim3);
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
                                            String[][] msg3 = {{"ここがラインハルトおうこくの　おしろかー", "；；；；；でかい！"}, {"マウ", "アルク"}};
                                            mapStartFragment.callMessageLeadFragment(msg3);
                                        }
                                    }, ANIMINTERVAL);
                                }
                            }, ANIMINTERVAL);
                            break;
                        case 4:
                            AnimationSet anim4 = new AnimationSet(false);
                            anim4.addAnimation(alpha2);
                            this.startAnimation(anim4);
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
                                            String[][] msg4 = {{"まにあってよかったわね！　こんどからねぼうしないでよアルク", "；；；；；"}, {"マウ", "アルク"}};
                                            mapStartFragment.callMessageLeadFragment(msg4);
                                        }
                                    }, ANIMINTERVAL);
                                }
                            }, ANIMINTERVAL);
                            break;
                        case 5:
                            AnimationSet anim5 = new AnimationSet(false);
                            anim5.addAnimation(alpha2);
                            this.startAnimation(anim5);
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
                                            String[][] msg5 = {{"アルクみて　おひめさまよ！　はなしかけてみよう！", "やめようよマウ　おこられるよ", "おひめサマーーーー！！！！", "；；；；；", "なに？　さわがしいわね", "おひめさま！　わたしマウっていいます！　こっちはアルク", "＊うるさいわねこいつ", "うん！　くるしゅうない　しもじものたみ！", "きぇえぇえええ　くるっくぅぅううううう", "プギぃいぃゃゃああ　かぁぁぁぁぁぁ", "なんと　モンスターが２ひきあらわれ　ひめにおそいかかった", "なによ！　やめさない　はやくえいへいをよんで！", "アルク！　おひめさまをまもるのよ！", "；；；；；！", "ひめはつれさられてしまった", "まって！", "マウはモンスターにつかみかかった", "まってマウ", "アルクはマウにつかまった"}, {"マウ", "アルク", "マウ", "アルク", "エレナ", "マウ", "エレナ" ,"エレナ", "かいちょう１", "かいちょう２", null, "エレナ", "マウ", "アルク", null, "マウ", null, "アルク", null}};
                                            mapStartFragment.callMessageLeadFragment(msg5);
                                        }
                                    }, ANIMINTERVAL);
                                }
                            }, ANIMINTERVAL);
                            break;
                        case 6:
                            AnimationSet anim6 = new AnimationSet(false);
                            anim6.addAnimation(alpha2);
                            this.startAnimation(anim6);
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
                                            String[][] msg6 = {{"たすけてぇぇぇぇぇー", "おちついてください　ひめさま。　わたしたちがついています。", "きっとたすけがきます。　しんじてまちま；；；うわぁぁぁぁぁぁー", "３にんは　こじょうにおとされた"}, {"エレナ", "マウ", "マウ", null}};
                                            mapStartFragment.callMessageLeadFragment(msg6);
                                        }
                                    }, ANIMINTERVAL);
                                }
                            }, ANIMINTERVAL);
                            break;
                        case 7:
                            AnimationSet anim7 = new AnimationSet(false);
                            anim7.addAnimation(alpha2);
                            this.startAnimation(anim7);
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
                                            String[][] msg6 = {{"おい　だいじょうぶか？　わかいの３にんしゅう。", "；；；だれ？", "わしか　わしはもりぃじゃ！　よろしくな。", "おまえさんたち　いきなりそらからふってきたが　どうしたんじゃ？", "マウはかいちょうにさらわれたことをはなした", "そうか　たいへんじゃったな。　ここでゆっくりしていくといい。", "すっかりひもくれたころ　もりいからはなしがあると３にんは　よびだされた", "じつは　きみたちにたのみたいことがあるんじゃ。", "どうしたの？　もりいさん。", "きみたち　ふういんされたまもののおうの　はなしはしっているじゃろう？", "このしろには　そのまもののおうが　ふういんされている　エがあるんじゃ。", "しかし　そのふういんがあとすこしで　とけてしまうのじゃ。", "わしがもういちどふういんできればいいのじゃが　みてのとおりこのとしじゃ。", "きみたちでこのまもののふっかつを　そししてくれないだろうか。", "そしって；；　どうしたらいいの？", "もりいは３にんを　とびらのまえにあんないした"}, {"？？？", "アルク", "？？？", "もりぃ", null, "もりぃ", null, "もりい", "マウ", "もりい", "もりい", "もりい", "もりい", "もりい", "エレナ", null}};
                                            mapStartFragment.callMessageLeadFragment(msg6);
                                        }
                                    }, ANIMINTERVAL);
                                }
                            }, ANIMINTERVAL);
                            break;
                        case 8:
                            AnimationSet anim8 = new AnimationSet(false);
                            anim8.addAnimation(alpha2);
                            this.startAnimation(anim8);
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
                                            String[][] msg6 = {{"なに；；これ？", "このへやには　エが１７まいある。　このエのなかにはくうかんがあり　ふういんのほうぎょくがかくされているのじゃ。", "エのなかにはいり　ほうぎょくをすべてさがしだしてきてはくれぬか。", "なんであたしたちが？", "もしまもののおうがふっかつしてしまえば　きみたちのくにもほろぼされてしまうのじゃ。", "これもなにかのえん。　どうかたのまれてはくれぬだろうか。", "ばかじゃないの？　まあいいけど。", "そうよ；；っていくの？　アルクもなにかいって！", "；；；；；", "さあいくわよ！　ふたりとも！"}, {"マウ", "もりい", "もりい", "マウ", "もりい", "もりい", "エレナ", "マウ", "アルク", "エレナ"}};
                                            mapStartFragment.callMessageLeadFragment(msg6);
                                        }
                                    }, ANIMINTERVAL);
                                }
                            }, ANIMINTERVAL);
                            break;
                        case 9:
                            AnimationSet anim9 = new AnimationSet(false);
                            anim9.addAnimation(alpha2);
                            this.startAnimation(anim9);
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(getContext(), jp.ac.uejobi.aruquest.HomeActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    getContext().startActivity(i);
                                }
                            }, ANIMINTERVAL - 500);
                            break;
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
        if(backImg[backImgIndex] == null) {
            backImg[backImgIndex] = BitmapFactory.decodeResource(getResources(), backImgID[backImgIndex]);
            backImg[backImgIndex] = Bitmap.createScaledBitmap(backImg[backImgIndex], (int)width, (int)(height * 75 / 100),false);
        }
        canvas.drawBitmap(backImg[backImgIndex], 0, 0, p);
        backImg[backImgIndex] = null;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        handler.postDelayed(this, 100);
    }
}
