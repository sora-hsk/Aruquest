package jp.ac.uejobi.aruquest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by uejobi on 2018/11/06.
 */

public class ListFragment extends Fragment {
    static FragmentManager manager;
    HomeFragment homeFragment = new HomeFragment();
    SelectDungeonFragment selectDungeonFragment = new SelectDungeonFragment();
    StatusFragment statusFragment = new StatusFragment();
    SettingFragment settingFragment = new SettingFragment();
    GraphFragment graphFragment = new GraphFragment();
    EmptyFragment emptyFragment = new EmptyFragment();
    LayoutInflater inflater;
    Sound sound = new Sound();
    static ImageButton HButton;
    static ImageButton DButton;
    static ImageButton SButton;
    static ImageButton CButton;
    static ImageButton WButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        manager = getFragmentManager();
        this.inflater = inflater;
        HButton = (ImageButton) view.findViewById(R.id.H_button);
        DButton = (ImageButton) view.findViewById(R.id.D_button);
        SButton = (ImageButton) view.findViewById(R.id.S_button);
        CButton = (ImageButton) view.findViewById(R.id.C_button);
        WButton = (ImageButton) view.findViewById(R.id.W_button);
        HButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.createTouchMedia(getContext());
                Sound.touch.setLooping(false);
                Sound.touch.start();
                callHomeFragment();
            }
        });
        DButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.createTouchMedia(getContext());
                Sound.touch.setLooping(false);
                Sound.touch.start();
                callSelectDungeonFragment();
            }
        });
        SButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.createTouchMedia(getContext());
                Sound.touch.setLooping(false);
                Sound.touch.start();
                callStatusFragment();
            }
        });
        CButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.createTouchMedia(getContext());
                Sound.touch.setLooping(false);
                Sound.touch.start();
                callSettingFragment();
            }
        });
        WButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.createTouchMedia(getContext());
                Sound.touch.setLooping(false);
                Sound.touch.start();
                callGraphFragment();
            }
        });
        return view;
    }

    public void callHomeFragment() {
        resetButtonEnabled();
        HButton.setEnabled(false);
        resetSubFlagment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, homeFragment);
        transaction.commit();
    }

    public void callSelectDungeonFragment() {
        resetButtonEnabled();
        DButton.setEnabled(false);
        resetSubFlagment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, selectDungeonFragment);
        transaction.commit();
    }

    public void callStatusFragment() {
        resetButtonEnabled();
        SButton.setEnabled(false);
        resetSubFlagment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, statusFragment);
        transaction.commit();
    }

    public void callSettingFragment(){
        resetButtonEnabled();
        CButton.setEnabled(false);
        resetSubFlagment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, settingFragment);
        transaction.commit();
    }

    public void callGraphFragment(){
        resetButtonEnabled();
        WButton.setEnabled(false);
        resetSubFlagment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, graphFragment);
        transaction.commit();
    }

    public void resetButtonEnabled() {
        HButton.setEnabled(true);
        DButton.setEnabled(true);
        SButton.setEnabled(true);
        CButton.setEnabled(true);
        WButton.setEnabled(true);
    }

    static public void rockButton(){
        HButton.setEnabled(false);
        DButton.setEnabled(false);
        SButton.setEnabled(false);
        CButton.setEnabled(false);
        WButton.setEnabled(false);
    }

    static public void rockDButton(){
        DButton.setEnabled(false);
    }

    public void resetSubFlagment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.subFragment, emptyFragment);
        transaction.commit();
    }
}