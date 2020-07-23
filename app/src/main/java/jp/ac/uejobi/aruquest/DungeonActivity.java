package jp.ac.uejobi.aruquest;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class  DungeonActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager manager;
    private Sensor stepCntSensor;
    static int dungeonID;
    MediaPlayer mp;
    PlayerData playerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSystemUI();
        playerData = new PlayerData();
        //センサーマネージャを取得
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //センサマネージャから TYPE_STEP_COUNTER についての情報を取得する
        stepCntSensor = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Intent intent = getIntent();
        dungeonID = intent.getIntExtra("dungeonID", -1);
        setContentView(R.layout.activity_dungeon);
        /*mp = MediaPlayer.create(this, R.raw.test2);
        mp.setVolume((float)PlayerData.BGMVolume / 10, (float)PlayerData.BGMVolume / 10);
        mp.start();
        mp.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mp.start();
                    }
                }
        );*/
    }

    public void onSensorChanged (SensorEvent event){
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            PlayerData.addStepPoint(1);
            PlayerData.addStepWeek(1);
            PlayerData.addStepSum(1);
            if(PlayerData.stepSum % 100 == 0){
                PlayerData.changeZokusei();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // accuracy に変更があった時の処理
    }

    @Override
    protected void onResume() {
        super.onResume();
        // リスナー設定
        manager.registerListener (this, stepCntSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // リスナー解除
        manager.unregisterListener(this,stepCntSensor);
        System.gc();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // セーブ
        playerData.saveData(this);
        Sound.dungeon.stop();
        System.gc();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                    }
                });
    }
}
