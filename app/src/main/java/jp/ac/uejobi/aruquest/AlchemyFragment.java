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
 * Created by uejobi on 2018/11/12.
 */

public class AlchemyFragment extends Fragment {
    static  FragmentManager manager;
    static LayoutInflater layoutInflater;
    CheckFragment checkFragment = new CheckFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alchemy, container, false);
        manager = getFragmentManager();
        layoutInflater = inflater;
        return view;
    }

    public void callCheckFragment(String equip, int methodIndex){ // チェックフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("text", equip + "　をれんきんしますか？　");
        bundle.putInt("callMethodIndex", methodIndex);
        checkFragment.setArguments(bundle);
        transaction.replace(R.id.subFragment, checkFragment);
        transaction.commit();
    }
}
