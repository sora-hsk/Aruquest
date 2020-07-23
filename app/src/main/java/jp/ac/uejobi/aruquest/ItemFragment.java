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

public class ItemFragment extends Fragment {
    static FragmentManager manager;
    static  ItemFragment itemFragment;
    ItemSetFragment itemSetFragment = new ItemSetFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        manager = getFragmentManager();
        itemFragment = this;
        return view;
    }

    public void callItemSetFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, itemSetFragment);
        transaction.commit();
    }

    public void callItemFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, ItemFragment.itemFragment);
        transaction.commit();
    }
}
