package jp.ac.uejobi.aruquest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;

import java.io.IOException;

/**
 * Created by uejobi on 2018/10/24.
 */

public class DrawMap extends View implements Runnable{
    final int CHARSIGHTWIDTH = 5; // 横方向の表示マス数
    final int CHARSIGHTHEIGHT = 9; // 縦方向の表示マス数
    final int DRAWWIDTH = CHARSIGHTWIDTH + 4; // 横方向の描画マス数
    final int DRAWHEIGHT = CHARSIGHTHEIGHT + 4; // 縦方向の描画マス数
    final int INTERVAL = 20; // runの間隔
    final double moveDis = 0.05;
    static int[] charPos = new int[2]; // 0:y 1:x
    int[][] charArray = new int[DRAWHEIGHT][DRAWWIDTH]; //
    float width; // 画面横幅
    float height; // 画面縦幅
    int cellWidth; // 1マスの横幅
    int cellHeight; // 1マスの縦幅
    float pointWidth;
    float pointHeight;
    float commandWidth;
    float commandHeight;
    float buttonWidth;
    float buttonHeight;
    float widthFps = 0; // 滑らかに移動させるために使用
    float heightFps = 0; // 滑らかに移動させるために使用
    float firstTouchX; // タッチした位置のX座標
    float firstTouchY; // タッチした位置のY座標
    float secondTouchX; // タッチした位置のX座標
    float secondTouchY; // タッチした位置のY座標
    int stepCount = 0; // 何歩歩いたか、敵とのエンカウント判定に使用
    boolean upFlg = false;
    boolean downFlg = false;
    boolean rightFlg = false;
    boolean leftFlg = false;
    boolean touchFlg = false;
    boolean encounteFlg = false;
    boolean initialFlg = true;
    Bitmap pointImg;
    Bitmap currentButton;
    Bitmap button;
    Bitmap buttonUp;
    Bitmap buttonDown;
    Bitmap buttonLeft;
    Bitmap buttonRight;

    Paint p = new Paint();
    Paint font = new Paint();
    Paint fontBlack = new Paint();
    Paint mw = new Paint();
    Paint border = new Paint();

    //Dungeon dungeon = new Dungeon(DungeonActivity.dungeonID);
    MapFragment mapFragment;
    CombatManagement combatManagement;
    Object obj;
    Data data;
    DataBlock1 dataBlock1;
    DataBlock2 dataBlock2;
    DataBlock3 dataBlock3;
    DataBlock4 dataBlock4;
    DataBlock5 dataBlock5;
    DataBlock6 dataBlock6;
    BitmapData bitmapData;
    Animation backAnimation;
    Animation frontAnimation;
    Animation rightAnimation;
    Animation leftAnimation;
    Sound sound;
    Handler handler = new Handler();

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        cellWidth = w / (CHARSIGHTWIDTH + 1);
        cellHeight = h / (CHARSIGHTHEIGHT + 1);
        pointWidth = width * 40 / 100;
        pointHeight = height * 7 / 100;
        commandWidth = width * 30 / 100;
        commandHeight = height * 7 / 100;
        buttonWidth = height * 21 / 100;
        buttonHeight = height * 21 / 100;

        bitmapData.setBlockBitmap(getResources(), cellWidth, cellHeight);

        Dungeon.key = 0;
        Dungeon.floor = 0;
        if(DungeonActivity.dungeonID < 5) {
            Dungeon.mapArray = dataBlock1.blockidR(DungeonActivity.dungeonID, Dungeon.floor);
        }else if(DungeonActivity.dungeonID < 8){
            Dungeon.mapArray = dataBlock2.blockidR(DungeonActivity.dungeonID, Dungeon.floor);
        }else if(DungeonActivity.dungeonID < 11){
            Dungeon.mapArray = dataBlock3.blockidR(DungeonActivity.dungeonID, Dungeon.floor);
        }else if(DungeonActivity.dungeonID < 13){
            Dungeon.mapArray = dataBlock4.blockidR(DungeonActivity.dungeonID, Dungeon.floor);
        }else if(DungeonActivity.dungeonID < 15){
            Dungeon.mapArray = dataBlock5.blockidR(DungeonActivity.dungeonID, Dungeon.floor);
        }else if(DungeonActivity.dungeonID < 18){
            Dungeon.mapArray = dataBlock6.blockidR(DungeonActivity.dungeonID, Dungeon.floor);
        }
        charPos[0] = Integer.parseInt(data.danjonJouhouR(DungeonActivity.dungeonID)[3]);
        charPos[1] = Integer.parseInt(data.danjonJouhouR(DungeonActivity.dungeonID)[4]);

        p.setColor(Color.BLUE);
        p.setStrokeWidth(8);

        font.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        font.setColor(Color.WHITE);
        font.setTextAlign(Paint.Align.LEFT);

        fontBlack.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/DragonQuestFC.ttf"));
        fontBlack.setColor(Color.BLACK);
        fontBlack.setTextAlign(Paint.Align.LEFT);

        mw.setColor(Color.BLACK);
        mw.setStyle(Paint.Style.FILL_AND_STROKE);

        border.setColor(Color.WHITE);
        border.setStrokeWidth(5);
        border.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // アニメーションの準備
        super.onLayout(changed, left, top, right, bottom);
        final int[] imgBack = {R.drawable.princess_backward_1, R.drawable.princess_backward_2};
        backAnimation.setAnimation(MapFragment.layoutInflater, MapFragment.img);
        backAnimation.setDrImg(getResources(), imgBack, cellWidth, cellHeight);
        final int[] imgFront = {R.drawable.princess_frontward_1, R.drawable.princess_frontward_2};
        frontAnimation.setAnimation(MapFragment.layoutInflater, MapFragment.img);
        frontAnimation.setDrImg(getResources(), imgFront, cellWidth, cellHeight);
        final int[] imgRight = {R.drawable.princess_rightward_1, R.drawable.princess_rightward_2, R.drawable.princess_rightward_3, R.drawable.princess_rightward_2};
        rightAnimation.setAnimation(MapFragment.layoutInflater, MapFragment.img);
        rightAnimation.setDrImg(getResources(), imgRight, cellWidth, cellHeight);
        final int[] imgLeft = {R.drawable.princess_leftward_1, R.drawable.princess_leftward_2, R.drawable.princess_leftward_3, R.drawable.princess_leftward_2};
        leftAnimation.setAnimation(MapFragment.layoutInflater, MapFragment.img);
        leftAnimation.setDrImg(getResources(), imgLeft, cellWidth, cellHeight);

        sound.createDungeonMedia(getContext());
        Sound.dungeon.start();
    }

    public void setCharArray() {
        // マップから描画する部分を切り出す
        for(int i = 0; i < charArray.length; i++){
            for(int j = 0; j < charArray[i].length; j++){
                try {
                    if (charPos[0] - DRAWHEIGHT / 2 + i >= 0 && charPos[0] - DRAWHEIGHT / 2 + i < Dungeon.mapArray.length && charPos[1] - DRAWWIDTH / 2 + j >= 0 && charPos[1] - DRAWWIDTH / 2 + j < Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + i].length) {
                        charArray[i][j] = Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + i][charPos[1] - DRAWWIDTH / 2 + j];
                    } else {
                        charArray[i][j] = 0;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public DrawMap(Context context) {
        super(context);
    }

    public DrawMap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawMap(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void moveUp(){
        // 上アニメが再生されていなかったら実行
        if(!frontAnimation.anim.isRunning() && !upFlg && !downFlg && !rightFlg && !leftFlg) {
            resetAnimation();
            frontAnimation.createAnimation(350, false);
            frontAnimation.setAnimationPos(cellWidth * (CHARSIGHTWIDTH / 2 + 1) - cellWidth / 2, cellHeight * (CHARSIGHTHEIGHT / 2 + 1) - cellHeight / 2);
            frontAnimation.anim.start();
        }
        // 上に進めるか
        if (charPos[0] > 0 && !upFlg && !downFlg && !rightFlg && !leftFlg && collision(0, -1)) {
            if(PlayerData.stepPoint >= 5) {
                upFlg = true;
                stepCount++;
                PlayerData.decStepPoint(5);
            }else{
                String[][] msg = {{"しかし　あるくちからが　のこっていない！"},{null}};
                mapFragment.callMessageFragment(msg);
            }
        }
    }

    public void moveDown(){
        // 下アニメが再生されていなかったら実行
        if(!backAnimation.anim.isRunning() && !upFlg && !downFlg && !rightFlg && !leftFlg) {
            resetAnimation();
            backAnimation.createAnimation(350, false);
            backAnimation.setAnimationPos(cellWidth * (CHARSIGHTWIDTH / 2 + 1) - cellWidth / 2, cellHeight * (CHARSIGHTHEIGHT / 2 + 1) - cellHeight / 2);
            backAnimation.anim.start();
        }
        // 下に進めるか
        if(charPos[0] < Dungeon.mapArray.length && !upFlg && !downFlg && !rightFlg && !leftFlg && collision(0, 1)) {
            if(PlayerData.stepPoint >= 5) {
                downFlg = true;
                stepCount++;
                PlayerData.decStepPoint(5);
            }else{
                String[][] msg = {{"しかし　あるくちからが　のこっていない！"},{null}};
                mapFragment.callMessageFragment(msg);
            }
        }
    }

    public void moveRight(){
        // 右アニメが再生されていなかったら実行
        if(!rightAnimation.anim.isRunning() && !upFlg && !downFlg && !rightFlg && !leftFlg) {
            resetAnimation();
            rightAnimation.createAnimation(250, false);
            rightAnimation.setAnimationPos(cellWidth * (CHARSIGHTWIDTH / 2 + 1) - cellWidth / 2, cellHeight * (CHARSIGHTHEIGHT / 2 + 1) - cellHeight / 2);
            rightAnimation.anim.start();
        }
        // 右に進めるか
        if(charPos[1] < Dungeon.mapArray[0].length && !upFlg && !downFlg && !rightFlg && !leftFlg && collision(1, 0)) {
            if(PlayerData.stepPoint >= 5) {
                rightFlg = true;
                stepCount++;
                PlayerData.decStepPoint(5);
            }else{
                String[][] msg = {{"しかし　あるくちからが　のこっていない！"},{null}};
                mapFragment.callMessageFragment(msg);
            }
        }
    }
    public void moveLeft(){
        // 左アニメが再生されていなかったら実行
        if(!leftAnimation.anim.isRunning() && !upFlg && !downFlg && !rightFlg && !leftFlg) {
            resetAnimation();
            leftAnimation.createAnimation(250, false);
            leftAnimation.setAnimationPos(cellWidth * (CHARSIGHTWIDTH / 2 + 1) - cellWidth / 2, cellHeight * (CHARSIGHTHEIGHT / 2 + 1) - cellHeight / 2);
            leftAnimation.anim.start();
        }
        // 左に進めるか
        if(charPos[1] > 0 && !upFlg && !downFlg && !rightFlg && !leftFlg && collision(-1, 0)) {
            if(PlayerData.stepPoint >= 5) {
                leftFlg = true;
                stepCount++;
                PlayerData.decStepPoint(5);
            }else{
                String[][] msg = {{"しかし　あるくちからが　のこっていない！"},{null}};
                mapFragment.callMessageFragment(msg);
            }
        }
    }

    public void resetAnimation(){
        frontAnimation.anim.stop();
        backAnimation.anim.stop();
        rightAnimation.anim.stop();
        leftAnimation.anim.stop();
    }

    public boolean collision(int directionX, int directionY){
        if(charPos[0] + directionY < Dungeon.mapArray.length && charPos[0] + directionY >= 0 && charPos[1] + directionX < Dungeon.mapArray[0].length && charPos[1] + directionX >= 0) {
            if ((Dungeon.mapArray[charPos[0] + directionY][charPos[1] + directionX] > 80)) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    // 隣接オブジェクトタッチ判定
    public void isTouchObject(){
        for(int i = 0; i < charArray.length; i++){
            for(int j = 0; j < charArray[i].length; j++){
                if(charArray[i][j] > 1 && firstTouchX > (j - (DRAWWIDTH - CHARSIGHTWIDTH) / 2 + 1) * cellWidth - cellWidth / 2 && firstTouchX < (j - (DRAWWIDTH - CHARSIGHTWIDTH) / 2 + 1) * cellWidth + cellWidth / 2 && firstTouchY > (i - (DRAWHEIGHT - CHARSIGHTHEIGHT) / 2 + 1) * cellHeight - cellHeight / 2 && firstTouchY < (i - (DRAWHEIGHT - CHARSIGHTHEIGHT) / 2 + 1) * cellHeight + cellHeight / 2){
                    if((i == DRAWHEIGHT / 2 - 1 && j == DRAWWIDTH / 2 && frontAnimation.anim.isRunning()) || (i == DRAWHEIGHT / 2 + 1 && j == DRAWWIDTH / 2 && backAnimation.anim.isRunning()) || (i == DRAWHEIGHT / 2 && j == DRAWWIDTH / 2 - 1 && leftAnimation.anim.isRunning()) || (i == DRAWHEIGHT / 2 && j == DRAWWIDTH / 2 + 1 && rightAnimation.anim.isRunning())) {
                        touchFlg = false;
                        int direction = 0;
                        if(backAnimation.anim.isRunning()){
                            direction = 1;
                        }
                        else if(rightAnimation.anim.isRunning()){
                            direction = 2;
                        }
                        else if(leftAnimation.anim.isRunning()){
                            direction = 3;
                        }
                        sound.createTouchMedia(getContext());
                        Sound.touch.setLooping(false);
                        Sound.touch.start();
                        int judge = obj.objectTypeJudge(charArray[i][j], direction, this);
                        if(judge >= 0) {
                            Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + i][charPos[1] - DRAWWIDTH / 2 + j] = judge;
                        }
                        else if(judge < -1){
                            encountBoss(Math.abs(judge), i, j);
                        }
                    }
                }
            }
        }
    }

    // エンカウント判定
    public void isEncounte(){
        if(stepCount > 15 && (Math.random() * 10) > 7){
            encounteFlg = true;
            stepCount = 0;
            touchFlg = false;
            Dungeon.chooseEnemy();
            combatManagement.redyBattle();
            AlphaAnimation alpha = new AlphaAnimation(0.8f, 0.0f);
            alpha.setDuration(500);
            alpha.setRepeatCount(1);
            AnimationSet anim = new AnimationSet(false);
            anim.addAnimation(alpha);
            this.startAnimation(anim);
            try {
                Sound.dungeon.stop();
                Sound.dungeon.prepare();
            }catch (IllegalStateException | IOException e){
                e.printStackTrace();
            }
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    sound.createBattleMedia(getContext());
                    Sound.battle.start();
                    CombatManagement.escapeEnable = true;
                    mapFragment.callLifeFragment(width, height);
                    mapFragment.callStartBattleFragment();
                    encounteFlg = false;
                }
            }, 500);
        }
    }

    // ボス遭遇
    public void encountBoss(final int enemyID, final int posI, final int posJ){
        encounteFlg = true;
        stepCount = 0;
        touchFlg = false;
        Dungeon.setEmnemy(enemyID);
        combatManagement.redyBattle();
        AlphaAnimation alpha = new AlphaAnimation(0.8f, 0.0f);
        alpha.setDuration(500);
        alpha.setRepeatCount(1);
        AnimationSet anim = new AnimationSet(false);
        anim.addAnimation(alpha);
        this.startAnimation(anim);
        try {
            Sound.dungeon.stop();
            Sound.dungeon.prepare();
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mapFragment.callLifeFragment(width, height);
                mapFragment.callStartBattleFragment();
                if(enemyID == 69){
                    sound.createLastBossBattleMedia(getContext());
                    Sound.lastBossBattle.start();
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                }
                else if(enemyID == 70){
                    sound.createSecretBossBattleMedia(getContext());
                    Sound.secretBossBattle.start();
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 2][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 2][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 2][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 3][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 3][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 3][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 4][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 4][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 4][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                }else if(enemyID == 63 || enemyID == 64 || enemyID == 65 || enemyID == 66 || enemyID == 67 || enemyID == 68 || enemyID == 76){
                    sound.createBossBattleMedia(getContext());
                    Sound.bossBattle.start();
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ - 1] = 0;
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI - 1][charPos[1] - DRAWWIDTH / 2 + posJ + 1] = 0;
                }
                else{
                    sound.createBossBattleMedia(getContext());
                    Sound.bossBattle.start();
                    Dungeon.mapArray[charPos[0] - DRAWHEIGHT / 2 + posI][charPos[1] - DRAWWIDTH / 2 + posJ] = 0;
                }
                CombatManagement.escapeEnable = false;
                encounteFlg = false;
            }
        }, 1000);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(!encounteFlg) {
                    firstTouchX = event.getX();
                    firstTouchY = event.getY();
                    touchFlg = true;
                    // 接しているオブジェクトにタッチしたか
                    isTouchObject();
                    invalidate();
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
                // 設定
                if(event.getX() > width * 20 / 100 && event.getX() < width * 50 / 100 && event.getY() > height * 2 / 100 && event.getY() < height * 9 / 100 && firstTouchX > width * 20 / 100 && firstTouchX < width * 50 / 100 && firstTouchY > height * 2 / 100 && firstTouchY < height * 9 / 100){
                    sound.createTouchMedia(getContext());
                    Sound.touch.setLooping(false);
                    Sound.touch.start();
                    mapFragment.callCommandFragment();
                }
                break;
        }
        return true;
    }

    @Override
    public void run() {
        // 十字キー判定
        if(Dungeon.buttonFlg){
            if(touchFlg) {
                if(secondTouchX == 0 && secondTouchY == 0) {
                    if (firstTouchX > width * 10 / 100 + height * 7 / 100 && firstTouchX < width * 10 / 100 + height * 14 / 100 && firstTouchY > height * 74 / 100 && firstTouchY < height * 81 / 100) {
                        currentButton = buttonUp;
                        moveUp();
                    }
                    else if (firstTouchX > width * 10 / 100 + height * 7 / 100 && firstTouchX < width * 10 / 100 + height * 14 / 100 && firstTouchY > height * 88 / 100 && firstTouchY < height * 95 / 100) {
                        currentButton = buttonDown;
                        moveDown();
                    }
                    else if (firstTouchX > width * 10 / 100 && firstTouchX < width * 10 / 100 + height * 7 / 100 && firstTouchY > height * 81 / 100 && firstTouchY < height * 88 / 100) {
                        currentButton = buttonLeft;
                        moveLeft();
                    }
                    else if (firstTouchX > width * 10 / 100 + height * 14 / 100 && firstTouchX < width * 10 / 100 + height * 21 / 100 && firstTouchY > height * 81 / 100 && firstTouchY < height * 88 / 100) {
                        currentButton = buttonRight;
                        moveRight();
                    }
                    else {
                        currentButton = button;
                    }
                }else {
                    if (secondTouchX > width * 10 / 100 + height * 7 / 100 && secondTouchX < width * 10 / 100 + height * 14 / 100 && secondTouchY > height * 74 / 100 && secondTouchY < height * 81 / 100) {
                        currentButton = buttonUp;
                        moveUp();
                    }
                    else if (secondTouchX > width * 10 / 100 + height * 7 / 100 && secondTouchX < width * 10 / 100 + height * 14 / 100 && secondTouchY > height * 88 / 100 && secondTouchY < height * 95 / 100) {
                        currentButton = buttonDown;
                        moveDown();
                    }
                    else if (secondTouchX > width * 10 / 100 && secondTouchX < width * 10 / 100 + height * 7 / 100 && secondTouchY > height * 81 / 100 && secondTouchY < height * 88 / 100) {
                        currentButton = buttonLeft;
                        moveLeft();
                    }
                    else if (secondTouchX > width * 10 / 100 + height * 14 / 100 && secondTouchX < width * 10 / 100 + height * 21 / 100 && secondTouchY > height * 81 / 100 && secondTouchY < height * 88 / 100) {
                        currentButton = buttonRight;
                        moveRight();
                    }
                    else {
                        currentButton = button;
                    }
                }
            }else{
                currentButton = button;
            }

        }
        // スワイプ判定
        else if(touchFlg && secondTouchX != 0 && secondTouchY != 0) {
            if (Math.abs(secondTouchX - firstTouchX) > Math.abs(secondTouchY - firstTouchY) && Math.abs(secondTouchX - firstTouchX) > 50) {
                if (secondTouchX - firstTouchX > 0) {
                    moveRight();
                } else {
                    moveLeft();
                }
            } else if (Math.abs(secondTouchX - firstTouchX) < Math.abs(secondTouchY - firstTouchY) && Math.abs(secondTouchY - firstTouchY) > 50) {
                if (secondTouchY - firstTouchY > 0) {
                    moveDown();
                } else {
                    moveUp();
                }
            }
        }
        // キャラクターを滑らかに動かす
        if(upFlg) {
            heightFps += moveDis;
            //invalidate();
        }
        else if(downFlg){
            heightFps -= moveDis;
            //invalidate();
        }
        else if(rightFlg){
            widthFps -= moveDis;
            //invalidate();
        }
        else if(leftFlg){
            widthFps += moveDis;
            //invalidate();
        }
        // キャラクターの位置を動かす
        if(Math.abs(widthFps) >= 1 || Math.abs(heightFps) >= 1){
            if(upFlg){
                charPos[0]--;
                upFlg = false;
                obj.onObjectTypeJudege(Dungeon.mapArray[charPos[0]][charPos[1]]);
            }
            else if(downFlg){
                charPos[0]++;
                downFlg = false;
                obj.onObjectTypeJudege(Dungeon.mapArray[charPos[0]][charPos[1]]);
            }
            else if(rightFlg){
                charPos[1]++;
                rightFlg = false;
                obj.onObjectTypeJudege(Dungeon.mapArray[charPos[0]][charPos[1]]);
            }
            else if(leftFlg){
                charPos[1]--;
                leftFlg = false;
                obj.onObjectTypeJudege(Dungeon.mapArray[charPos[0]][charPos[1]]);
            }
            widthFps = 0;
            heightFps = 0;
            //invalidate();
            if(DungeonActivity.dungeonID != 16 && DungeonActivity.dungeonID != 17) {
                isEncounte();
            }
        }
        invalidate();
        handler.postDelayed(this, INTERVAL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(pointImg == null) {
            pointImg = BitmapFactory.decodeResource(getResources(), R.drawable.icon_point);
            pointImg = Bitmap.createScaledBitmap(pointImg, (int) pointWidth, (int) pointHeight, false);
        }
        if(button == null) {
            button = BitmapFactory.decodeResource(getResources(), R.drawable.button_normal);
            button = Bitmap.createScaledBitmap(button, (int) buttonWidth, (int) buttonHeight, false);
        }
        if(buttonUp == null) {
            buttonUp = BitmapFactory.decodeResource(getResources(), R.drawable.button_forward);
            buttonUp = Bitmap.createScaledBitmap(buttonUp, (int) buttonWidth, (int) buttonHeight, false);
        }
        if(buttonDown == null) {
            buttonDown = BitmapFactory.decodeResource(getResources(), R.drawable.button_back);
            buttonDown = Bitmap.createScaledBitmap(buttonDown, (int) buttonWidth, (int) buttonHeight, false);
        }
        if(buttonRight == null) {
            buttonRight = BitmapFactory.decodeResource(getResources(), R.drawable.button_right);
            buttonRight = Bitmap.createScaledBitmap(buttonRight, (int) buttonWidth, (int) buttonHeight, false);
        }
        if(buttonLeft == null) {
            buttonLeft = BitmapFactory.decodeResource(getResources(), R.drawable.button_left);
            buttonLeft = Bitmap.createScaledBitmap(buttonLeft, (int) buttonWidth, (int) buttonHeight, false);
        }
        if(currentButton == null){
            currentButton = button;
        }

        setCharArray();
        if(initialFlg){
            moveDown();
            initialFlg = false;
        }
        for(int i = 0; i < charArray.length; i++){
            for(int j = 0; j < charArray[i].length; j++) {
                canvas.drawBitmap(bitmapData.getBlockBitmap(Integer.parseInt(data.danjonJouhouR(DungeonActivity.dungeonID)[2])), cellWidth * (j - (DRAWWIDTH - CHARSIGHTWIDTH) / 2 + 1 + widthFps) - cellWidth / 2, cellHeight * (i - (DRAWHEIGHT - CHARSIGHTHEIGHT) / 2 + 1 + heightFps) - cellHeight / 2, p);
                if (charArray[i][j] > 0) {
                    try {
                        canvas.drawBitmap(bitmapData.getBlockBitmap(charArray[i][j]), cellWidth * (j - (DRAWWIDTH - CHARSIGHTWIDTH) / 2 + 1 + widthFps) - cellWidth / 2, cellHeight * (i - (DRAWHEIGHT - CHARSIGHTHEIGHT) / 2 + 1 + heightFps) - cellHeight / 2, p);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        if(Dungeon.buttonFlg) {
            canvas.drawBitmap(currentButton, width * 10 / 100, height * 74 / 100, p);
        }
        canvas.drawBitmap(pointImg, width * 55 / 100, height * 2 /100, p);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, HarfToFull.changeNumHalfToFull(String.valueOf(Dungeon.floor + 1)) + "Ｆ", null, width * 5 / 100, height * 2 / 100, width * 13 / 100, pointHeight, 1, 2, font, mw, border);
        MultiLineText.drawNewlineTextMessageWindowVerticalCenterLessSpace(canvas, "せってい", null, width * 20 / 100, height * 2 / 100, commandWidth, commandHeight, 1, 4, font, mw, border);
        MultiLineText.drawNewlineTextVerticalCenterLessSpace(canvas, HarfToFull.changeNumHalfToFull(String.valueOf(PlayerData.stepPoint)), null, width * 67 / 100, height * 2 / 100, width * 28 / 100, pointHeight, 1, 6, fontBlack);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        handler.postDelayed(this, 100);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        switch (visibility){
            // 非アクティブ状態
            case GONE:
            case INVISIBLE:
                pointImg = null;
                currentButton = null;
                button = null;
                buttonUp = null;
                buttonDown = null;
                buttonLeft = null;
                buttonRight = null;
                mapFragment = null;
                combatManagement = null;
                p = null;
                font = null;
                fontBlack = null;
                mw = null;
                border = null;
                obj = null;
                data = null;
                dataBlock1 = null;
                dataBlock2 = null;
                dataBlock3 = null;
                dataBlock4 = null;
                dataBlock5 = null;
                dataBlock6 = null;
                bitmapData = null;
                backAnimation = null;
                frontAnimation = null;
                rightAnimation = null;
                leftAnimation = null;
                sound = null;
                System.gc();
                break;
            // アクティブ状態
            case VISIBLE:
                mapFragment = new MapFragment();
                combatManagement = new CombatManagement();
                p = new Paint();
                font = new Paint();
                fontBlack = new Paint();
                mw = new Paint();
                border = new Paint();
                obj = new Object();
                data = new Data();
                dataBlock1 = new DataBlock1();
                dataBlock2 = new DataBlock2();
                dataBlock3 = new DataBlock3();
                dataBlock4 = new DataBlock4();
                dataBlock5 = new DataBlock5();
                dataBlock6 = new DataBlock6();
                bitmapData = new BitmapData();
                if(cellWidth > 0) {
                    bitmapData.setBlockBitmap(getResources(), cellWidth, cellHeight);
                }
                backAnimation = new Animation();
                frontAnimation = new Animation();
                rightAnimation = new Animation();
                leftAnimation = new Animation();
                sound = new Sound();
                break;
        }
    }
}