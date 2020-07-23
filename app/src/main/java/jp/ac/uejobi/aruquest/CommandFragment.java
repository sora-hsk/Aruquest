package jp.ac.uejobi.aruquest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by uejobi on 2018/11/02.
 */

public class CommandFragment extends Fragment{
    static FragmentManager manager;
    static CommandFragment fragment;
    static LayoutInflater layoutInflater;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_command, container, false);
        manager = getFragmentManager();
        fragment = this;
        layoutInflater = inflater;
        return view;
    }

    public void callCrossChangeFragment(){
        CrossChangeFragment crossChangeFragment = new CrossChangeFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.commandFragment, crossChangeFragment);
        transaction.commit();
    }

    public void callSoundVolumeMapFragment(){
        SoundVolumeMapFragment soundVolumeMapFragment = new SoundVolumeMapFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.commandFragment, soundVolumeMapFragment);
        transaction.commit();
    }

    public void exitCommandFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    public void callCheckFragment(int index, String text){ // チェックフラグメントを呼び出す
        CheckFragment checkFragment = new CheckFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        bundle.putInt("callMethodIndex", index);
        checkFragment.setArguments(bundle);
        transaction.replace(R.id.commandFragment, checkFragment);
        transaction.commit();
    }
}
