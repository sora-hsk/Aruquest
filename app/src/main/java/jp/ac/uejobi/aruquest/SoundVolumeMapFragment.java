package jp.ac.uejobi.aruquest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

/**
 * Created by uejobi on 2018/11/19.
 */

public class SoundVolumeMapFragment extends Fragment {
    static FragmentManager manager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soundvolume_map, container, false);
        manager = getFragmentManager();
        SeekBar bgm = (SeekBar)view.findViewById(R.id.BGM_bar);
        bgm.setProgress((int)(PlayerData.BGMVolume));
        bgm.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                        PlayerData.BGMVolume = progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        SeekBar se = (SeekBar)view.findViewById(R.id.SE_bar);
        se.setProgress((int)(PlayerData.SEVolume));
        se.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                        PlayerData.SEVolume = progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        return view;
    }

    public void callCommandFragment(){
        CommandFragment commandFragment = new CommandFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.commandFragment, commandFragment);
        transaction.commit();
    }
}
