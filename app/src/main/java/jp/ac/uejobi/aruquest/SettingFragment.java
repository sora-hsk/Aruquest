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

/**
 * Created by uejobi on 2018/11/15.
 */

public class SettingFragment extends Fragment {
    static FragmentManager manager;
    static LayoutInflater layoutInflater;
    static SettingFragment settingFragment;
    ResetFragment resetFragment = new ResetFragment();
    SoundVolumeFragment soundVolumeFragment = new SoundVolumeFragment();
    HelpFragment helpFragment = new HelpFragment();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        manager = getFragmentManager();
        layoutInflater = inflater;
        settingFragment = this;
        return view;
    }

    public static void callStartActivity(){
        Intent i = new Intent(layoutInflater.getContext(), StartActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        layoutInflater.getContext().startActivity(i);
    }

    public void callSoundVolumeFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, soundVolumeFragment);
        transaction.commit();
    }

    public void callResetFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, resetFragment);
        transaction.commit();
    }

    public void callHelpFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, helpFragment);
        transaction.commit();
    }

    public void callSettingFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, settingFragment);
        transaction.commit();
    }
}
