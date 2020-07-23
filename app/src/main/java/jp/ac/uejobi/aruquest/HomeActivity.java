package jp.ac.uejobi.aruquest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

/**
 * Created by uejobi on 2018/11/06.
 */

public class HomeActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager manager;
    private Sensor stepCntSensor;
    PlayerData playerData = new PlayerData();
    static ImageView img;
    MediaPlayer mp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSystemUI();
        //センサーマネージャを取得
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //センサマネージャから TYPE_STEP_COUNTER についての情報を取得する
        stepCntSensor = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        setContentView(R.layout.activity_home);
        mp = MediaPlayer.create(this, R.raw.home);
        mp.setVolume((float)PlayerData.BGMVolume / 10, (float)PlayerData.BGMVolume / 10);
        mp.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mp.start();
                    }
                }
        );
        mp.start();
        img = findViewById(R.id.imgAlchemy);
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFragment, homeFragment);
        transaction.commit();
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

    // セーブ
    @Override
    protected void onPause() {
        super.onPause();
        playerData.saveData(this);
        try {
            mp.stop();
            mp.prepare();
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
        }
        System.gc();
    }
}
