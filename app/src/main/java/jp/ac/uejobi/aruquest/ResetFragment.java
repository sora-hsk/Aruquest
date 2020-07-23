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
 * Created by uejobi on 2018/11/15.
 */

public class ResetFragment extends Fragment {
    static FragmentManager manager;
    CheckFragment checkFragment = new CheckFragment();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset, container, false);
        manager = getFragmentManager();
        return view;
    }
    public void callCheckFragment(int index, String text){ // チェックフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        bundle.putInt("callMethodIndex", index);
        checkFragment.setArguments(bundle);
        transaction.replace(R.id.subFragment, checkFragment);
        transaction.commit();
    }
}
