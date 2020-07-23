package jp.ac.uejobi.aruquest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;

/**
 * Created by uejobi on 2018/12/14.
 */

public class StartBattleFragment extends Fragment {
    static FragmentManager manager;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_startbattle, container, false);
        manager = getFragmentManager();
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(1000);

        AnimationSet anim = new AnimationSet(false);
        anim.addAnimation(alpha);

        container.startAnimation(anim);
        return view;
    }

    public void callBattleFragment(){
        BattleFragment battleFragment = new BattleFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, battleFragment);
        transaction.commit();
    }
}
