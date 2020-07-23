package jp.ac.uejobi.aruquest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by uejobi on 2018/12/18.
 */

public class MapStartFragment extends Fragment {
    MessageLeadFragment messageLeadFragment = new MessageLeadFragment();
    static FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapstart, container, false);
        manager = getFragmentManager();
        return view;
    }

    public void callMessageLeadFragment(String msg[][]){ // メッセージフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putStringArray("msg", msg[0]);
        bundle.putStringArray("name", msg[1]);
        messageLeadFragment.setArguments(bundle);
        transaction.replace(R.id.messageFragment, messageLeadFragment);
        transaction.commit();
    }
}
