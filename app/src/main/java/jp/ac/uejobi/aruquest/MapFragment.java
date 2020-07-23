package jp.ac.uejobi.aruquest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by uejobi on 2018/10/30.
 */

public class MapFragment extends Fragment {
    static FragmentManager manager;
    static ImageView img; // アニメーション描画ImageView
    static ImageView img2;
    static ImageView img3;
    static LayoutInflater layoutInflater; // アニメーションの画像の定義に使用
    static View view;
    MessageFragment messageFragment = new MessageFragment();
    MessageEndMapFragment messageEndMapFragment = new MessageEndMapFragment();
    CommandFragment commandFragment = new CommandFragment();
    LifeFragment lifeFragment = new LifeFragment();
    BattleFragment battleFragment = new BattleFragment();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        layoutInflater = inflater;
        img = (ImageView)view.findViewById(R.id.img);
        img2 = (ImageView)view.findViewById(R.id.img2);
        img3 = (ImageView)view.findViewById(R.id.img3);
        manager = getFragmentManager();
        this.view = view;
        return view;
    }

    public void callMessageFragment(String msg[][]){ // メッセージフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putStringArray("msg", msg[0]);
        bundle.putStringArray("name", msg[1]);
        messageFragment.setArguments(bundle);
        transaction.replace(R.id.messageFragment, messageFragment);
        transaction.commit();
    }

    public void callMessageMapEndFragment(String msg[][]){ // メッセージフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putStringArray("msg", msg[0]);
        bundle.putStringArray("name", msg[1]);
        messageEndMapFragment.setArguments(bundle);
        transaction.replace(R.id.messageFragment, messageEndMapFragment);
        transaction.commit();
    }

    public void callCommandFragment(){ // コマンドフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.commandFragment, commandFragment);
        transaction.commit();
    }

    public void callLifeFragment(float width, float height){
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putFloat("width", width);
        bundle.putFloat("height", height);
        lifeFragment.setArguments(bundle);
        transaction.replace(R.id.container2, lifeFragment);
        transaction.commit();
    }

    public void callHomeActivity(){
        AlphaAnimation alpha = new AlphaAnimation(1.0f, -0.5f);
        alpha.setDuration(3000);
        alpha.setRepeatCount(0);
        AnimationSet anim = new AnimationSet(false);
        anim.addAnimation(alpha);
        view.startAnimation(anim);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(layoutInflater.getContext(), jp.ac.uejobi.aruquest.HomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                layoutInflater.getContext().startActivity(i);
            }
        }, 2500);
    }

    public void callBattleFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, battleFragment);
        transaction.commit();
    }

    public void callStartBattleFragment(){
        StartBattleFragment startBattleFragment = new StartBattleFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, startBattleFragment);
        transaction.commit();
    }


}
