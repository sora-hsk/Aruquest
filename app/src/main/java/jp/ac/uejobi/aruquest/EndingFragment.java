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
 * Created by uejobi on 2019/01/29.
 */

public class EndingFragment extends Fragment {
    static FragmentManager manager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ending, container, false);
        manager = getFragmentManager();
        return view;
    }

    public void callMessageLeadFragment(String msg[][]){ // メッセージフラグメントを呼び出す
        MessageLeadFragment messageLeadFragment = new MessageLeadFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putStringArray("msg", msg[0]);
        bundle.putStringArray("name", msg[1]);
        messageLeadFragment.setArguments(bundle);
        transaction.replace(R.id.messageFragment, messageLeadFragment);
        transaction.commit();
    }
}
