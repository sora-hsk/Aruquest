package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;

/**
 * Created by uejobi on 2018/11/09.
 */

public class DrawCheck extends View {
    static String text;
    static int callMethodIndex;
    boolean alchemyFlg = false;
    float width;
    float height;
    float yesPosX;
    float yesPosY;
    float noPosX;
    float noPosY;
    float checkWidth;
    float checkHeight;
    float downX;
    float downY;
    float upX;
    float upY;
    int weaponID = -1;
    int armorID = -1;
    boolean touchFlg = true;
    Bitmap alchemyImg;
    Paint p = new Paint();
    Paint font = new Paint();
    Paint mw = new Paint();
    Paint border = new Paint();
    View view;

    ListFragment listFragment = new ListFragment();
    CheckFragment checkFragment = new CheckFragment();
    Handler handler = new Handler();
    Data data = new Data();
    Sound sound = new Sound();
    BitmapData bitmapData = new BitmapData();
    PlayerData playerData = new PlayerData();

    public static void setText(String text) {
        DrawCheck.text = text;
    }

    public static void setCallMethodIndex(int callMethodIndex) {
        DrawCheck.callMethodIndex = callMethodIndex;
    }

    public DrawCheck(Context context) {
        super(context);
    }

    public DrawCheck(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCheck(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        checkWidth = w * 2 / 10;
        checkHeight = h / 10;
        noPosX = w * 2 / 10;
        noPosY = h / 2 - checkHeight / 2;
        yesPosX = w * 6 / 10;
        yesPosY = h / 2 - checkHeight / 2;

        font.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        font.setColor(Color.WHITE);
        font.setTextAlign(Paint.Align.LEFT);

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);

        alchemyImg = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.alchemy_result), (int)width, (int)height,false);
        view = this;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                if(alchemyFlg){
                    alchemyFlg = false;
                }
                if(touchFlg && downX > yesPosX && downX < yesPosX + checkWidth && downY > yesPosY && downY < yesPosY + checkHeight && event.getX() > yesPosX && event.getX() < yesPosX + checkWidth && event.getY() > yesPosY && event.getY() < yesPosY + checkHeight){
                    switch (callMethodIndex){
                        case 1:
                            sound.createDecideMedia(getContext());
                            Sound.decide.start();
                            CheckFragment.callDungeonActivity();
                            break;
                        case 2:
                            if(PlayerData.stepPoint < Integer.parseInt(data.danjonJouhouR(DrawSelectDungeon.dungeonIndex)[1])){
                                sound.createBanMedia(getContext());
                                Sound.ban.start();
                                break;
                            }
                            sound.createDecideMedia(getContext());
                            Sound.decide.setLooping(false);
                            Sound.decide.start();
                            if(touchFlg) {
                                touchFlg = false;
                                int[] imgBack = {R.drawable.alchemy_anim1, R.drawable.alchemy_anim2, R.drawable.alchemy_anim3, R.drawable.alchemy_anim4, R.drawable.alchemy_anim5, R.drawable.alchemy_anim6, R.drawable.alchemy_anim7, R.drawable.alchemy_anim8, R.drawable.alchemy_anim9, R.drawable.alchemy_anim10, R.drawable.alchemy_anim11, R.drawable.alchemy_anim12, R.drawable.alchemy_anim13, R.drawable.alchemy_anim14, R.drawable.alchemy_anim15, R.drawable.alchemy_anim16, R.drawable.alchemy_anim17, R.drawable.alchemy_anim18};
                                if(DrawAlchemy.alchemyAnimation == null) {
                                    DrawAlchemy.alchemyAnimation = new Animation();
                                    DrawAlchemy.alchemyAnimation.setAnimation(AlchemyFragment.layoutInflater, HomeActivity.img);
                                    DrawAlchemy.alchemyAnimation.setDrImg(getResources(), imgBack, (int) width, (int) (height * 10 / 9));
                                }
                                PlayerData.decStepPoint(Integer.parseInt(data.danjonJouhouR(DrawSelectDungeon.dungeonIndex)[1]));
                                weaponID = getWeapon();
                                armorID = -1;
                                ListFragment.rockButton();
                                DrawAlchemy.touchFlg = false;
                                DrawAlchemy.alchemyAnimation.createAnimation(200, true);
                                DrawAlchemy.alchemyAnimation.setAnimationPos(0, 0);
                                DrawAlchemy.alchemyAnimation.anim.start();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        alchemyFlg = true;
                                        invalidate();
                                        DrawAlchemy.alchemyAnimation.anim.stop();
                                        HomeActivity.img.setBackgroundDrawable(null);
                                    }
                                }, 200 * 21);
                            }
                            break;
                        case 3:
                            if(PlayerData.stepPoint < Integer.parseInt(data.danjonJouhouR(DrawSelectDungeon.dungeonIndex)[1])){
                                sound.createBanMedia(getContext());
                                Sound.ban.start();
                                break;
                            }
                            sound.createDecideMedia(getContext());
                            Sound.decide.start();
                            if(touchFlg) {
                                touchFlg = false;
                                int[] imgBack = {R.drawable.alchemy_anim1, R.drawable.alchemy_anim2, R.drawable.alchemy_anim3, R.drawable.alchemy_anim4, R.drawable.alchemy_anim5, R.drawable.alchemy_anim6, R.drawable.alchemy_anim7, R.drawable.alchemy_anim8, R.drawable.alchemy_anim9, R.drawable.alchemy_anim10, R.drawable.alchemy_anim11, R.drawable.alchemy_anim12, R.drawable.alchemy_anim13, R.drawable.alchemy_anim14, R.drawable.alchemy_anim15, R.drawable.alchemy_anim16, R.drawable.alchemy_anim17, R.drawable.alchemy_anim18};
                                if(DrawAlchemy.alchemyAnimation == null) {
                                    DrawAlchemy.alchemyAnimation = new Animation();
                                    DrawAlchemy.alchemyAnimation.setAnimation(AlchemyFragment.layoutInflater, HomeActivity.img);
                                    DrawAlchemy.alchemyAnimation.setDrImg(getResources(), imgBack, (int) width, (int) (height * 10 / 9));
                                }
                                PlayerData.decStepPoint(Integer.parseInt(data.danjonJouhouR(DrawSelectDungeon.dungeonIndex)[1]));
                                armorID = getArmor();
                                weaponID = -1;
                                ListFragment.rockButton();
                                DrawAlchemy.touchFlg = false;
                                DrawAlchemy.alchemyAnimation.createAnimation(200, true);
                                DrawAlchemy.alchemyAnimation.setAnimationPos(0, 0);
                                DrawAlchemy.alchemyAnimation.anim.start();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        alchemyFlg = true;
                                        invalidate();
                                        DrawAlchemy.alchemyAnimation.anim.stop();
                                        HomeActivity.img.setBackgroundDrawable(null);
                                    }
                                }, 200 * 21);
                            }
                            break;
                        case 4: // 今日の歩数リセット
                            sound.createDecideMedia(getContext());
                            Sound.decide.start();
                            PlayerData.stepWeek[6] = 0;
                            listFragment.resetSubFlagment();
                            break;
                        case 5: // 歩数全てリセット
                            sound.createDecideMedia(getContext());
                            Sound.decide.start();
                            PlayerData.stepSum = 0;
                            for(int i = 0; i < PlayerData.stepWeek.length; i++){
                                PlayerData.stepWeek[i] = 0;
                            }
                            listFragment.resetSubFlagment();
                            break;
                        case 6: // ゲームデータリセット
                            sound.createDecideMedia(getContext());
                            Sound.decide.start();
                            playerData.resetData(getContext());
                            checkFragment.callStartActivity();
                            break;
                        case 7: // ダンジョンから出るか
                            sound.createDecideMedia(getContext());
                            Sound.decide.start();
                            checkFragment.callHomeActivity();
                            break;
                    }
                }
                else if(touchFlg && downX > noPosX && downX < noPosX + checkWidth && downY > noPosY && downY < noPosY + checkHeight && event.getX() > noPosX && event.getX() < noPosX + checkWidth && event.getY() > noPosY && event.getY() < noPosY + checkHeight){
                    sound.createCancelMedia(getContext());
                    Sound.cancel.start();
                    if(callMethodIndex == 7){
                        checkFragment.callCommandFragment();
                    }else {
                        listFragment.resetSubFlagment();
                    }
                }

                if(HomeActivity.img != null && DrawAlchemy.alchemyAnimation != null && !DrawAlchemy.alchemyAnimation.anim.isRunning()){
                    listFragment.resetSubFlagment();
                    HomeActivity.img.setBackgroundDrawable(null);
                    listFragment.resetButtonEnabled();
                    ListFragment.rockDButton();
                    DrawAlchemy.alchemyAnimation = null;
                    DrawAlchemy.touchFlg = true;
                    touchFlg = true;
                }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (alchemyFlg) {
            canvas.drawBitmap(alchemyImg, 0, 0, p);
            if(weaponID != -1) {
                canvas.drawBitmap(bitmapData.getWeaponBitmap(weaponID, getResources(), (int) width / 2, (int) (height / 2)), width * 25 / 100, height * 10 / 100, p);
                MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.bukiR(weaponID)[0] + "　をてにいれた", null, width * 5 / 100, height * 84 / 100, width * 90 / 100, height * 11 / 100, 1, 15, font, mw, border);
            }else if(armorID != -1){
                canvas.drawBitmap(bitmapData.getArmorBitmap(armorID, getResources(), (int) width / 2, (int) (height / 2)), width * 25 / 100, height * 10 / 100, p);
                MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, data.bouguR(armorID)[0] + "　をてにいれた", null, width * 5 / 100, height * 84 / 100, width * 90 / 100, height * 11 / 100, 1, 15, font, mw, border);
            }
        } else {
            int count = 1;
            int index = 0;

            for (int i = 0; i < text.length(); i++) {
                if (String.valueOf(text.charAt(i)).equals("\\")) {
                    count++;
                }
                if (count == 1) {
                    index++;
                }
            }
            if (count == 1) {
                index = text.length();
            }

            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, text, null, width / 10, height * 2 / 10, width * 8 / 10, checkHeight, count, index, font, mw, border);
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "いいえ", null, noPosX, noPosY, checkWidth, checkHeight, 1, 3, font, mw, border);
            MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "はい", null, yesPosX, yesPosY, checkWidth, checkHeight, 1, 2, font, mw, border);
        }
    }

    public int getWeapon(){
        int[] weapon = new int[10];
        int index = 0;
        for(int i = 0; i < data.bukiarray.length; i++) {
            if(Integer.parseInt(data.bukiR(i)[2]) == DrawSelectDungeon.dungeonIndex + 1){
                weapon[index] = i;
                index++;
            }
        }
        int weaponID = (int)(Math.random() * index);
        PlayerData.getWeapon(weapon[weaponID]);
        return weapon[weaponID];
    }

    public int getArmor(){
        int[] armor = new int[10];
        int index = 0;
        for(int i = 0; i < data.bouguarray.length; i++) {
            if(Integer.parseInt(data.bouguR(i)[2]) == DrawSelectDungeon.dungeonIndex + 1){
                armor[index] = i;
                index++;
            }
        }
        int armorID = (int)(Math.random() * index);
        PlayerData.getArmor(armor[armorID]);
        return armor[armorID];
    }
}
