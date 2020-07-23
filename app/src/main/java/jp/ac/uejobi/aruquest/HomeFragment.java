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
 * Created by uejobi on 2018/11/13.
 */

public class HomeFragment extends Fragment {
    static FragmentManager manager;
    MessageFragment messageFragment = new MessageFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        manager = getFragmentManager();
        return view;
    }

    public void callMessageFragment(String msg[][]){ // メッセージフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putStringArray("msg", msg[0]);
        bundle.putStringArray("name", msg[1]);
        messageFragment.setArguments(bundle);
        transaction.replace(R.id.subFragment, messageFragment);
        transaction.commit();
    }
}
