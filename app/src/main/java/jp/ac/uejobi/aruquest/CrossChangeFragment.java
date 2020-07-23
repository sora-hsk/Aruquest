package jp.ac.uejobi.aruquest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by uejobi on 2018/12/13.
 */

public class CrossChangeFragment extends Fragment {
    static FragmentManager manager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crosskey, container, false);
        manager = getFragmentManager();
        return view;
    }

    public void callCommandFragment(){
        CommandFragment commandFragment = new CommandFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.commandFragment, commandFragment);
        transaction.commit();
    }
}
