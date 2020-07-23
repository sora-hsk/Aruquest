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
 * Created by uejobi on 2018/11/06.
 */

public class SelectDungeonFragment extends Fragment {
    static FragmentManager manager;
    CheckFragment checkFragment = new CheckFragment();
    AlchemyFragment alchemyFragment = new AlchemyFragment();
    static SelectDungeonFragment selectDungeonFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selectdungeon, container, false);
        manager = getFragmentManager();
        selectDungeonFragment = this;
        return view;
    }

    public void callCheckFragment(){ // チェックフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("text", "　このさきへ　すすみますか？　");
        bundle.putInt("callMethodIndex", 1);
        checkFragment.setArguments(bundle);
        transaction.replace(R.id.subFragment, checkFragment);
        transaction.commit();
    }

    public void callAlchemyFragment(){ // アルケミフラグメントを呼び出す
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, alchemyFragment);
        transaction.commit();
    }

    public void callSelectDungeonFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, selectDungeonFragment);
        transaction.commit();
    }
}
