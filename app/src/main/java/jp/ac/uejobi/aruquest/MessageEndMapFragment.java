package jp.ac.uejobi.aruquest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.IntentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;

/**
 * Created by uejobi on 2018/10/30.
 */

public class MessageEndMapFragment extends Fragment {
    static FragmentManager manager;
    static MessageEndMapFragment fragment;
    static LayoutInflater layoutInflater;
    static View viewGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_endmap, container, false);
        manager = getFragmentManager();
        fragment = this;
        layoutInflater = inflater;
        viewGroup = container;
        Bundle bundle = getArguments();
        DrawMessageEndMap.setMessage(bundle.getStringArray("msg"));
        DrawMessageEndMap.setName(bundle.getStringArray("name"));
        return view;
    }
    public void exitMessageFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }
}
