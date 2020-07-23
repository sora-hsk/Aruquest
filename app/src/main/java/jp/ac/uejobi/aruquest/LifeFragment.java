package jp.ac.uejobi.aruquest;

import android.graphics.Color;
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
import android.view.animation.ScaleAnimation;

/**
 * Created by uejobi on 2018/11/27.
 */

public class LifeFragment extends Fragment {

    static LifeFragment lifeFragment = new LifeFragment();
    static FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        manager = getFragmentManager();
        container.setBackgroundColor(Color.argb(200, 0, 0, 0));
        Bundle bundle = getArguments();
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(1000);
        RotateAnimation rotate = new RotateAnimation(0, 360, bundle.getFloat("width") / 2, bundle.getFloat("height") * 80 / 200);
        rotate.setDuration(1200);
        ScaleAnimation scale = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, bundle.getFloat("width") / 2, bundle.getFloat("height") * 80 / 200    );
        scale.setDuration(1200);
        AnimationSet anim = new AnimationSet(false);
        anim.addAnimation(alpha);
        anim.addAnimation(rotate);
        anim.addAnimation(scale);
        container.startAnimation(anim);
        return inflater.inflate(R.layout.fragment_life,container,false);
    }

    public void setlife(){
        //FragmentManager fragmentManager2 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction2 = manager.beginTransaction();
        fragmentTransaction2.replace(R.id.container2, LifeFragment.newInstance("Fragment"));
        fragmentTransaction2.commit();
    }

    public void setTest(){
        LifeFragment fragment = new LifeFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container2,fragment);
        transaction.commit();
    }

    public static LifeFragment newInstance(String str) {
        LifeFragment fragment = new LifeFragment();
        Bundle barg = new Bundle();
        barg.putString("Message",str);
        fragment.setArguments(barg);
        return fragment;
    }

    public void setBattle(){
        BattleFragment fragment = new BattleFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }
}
