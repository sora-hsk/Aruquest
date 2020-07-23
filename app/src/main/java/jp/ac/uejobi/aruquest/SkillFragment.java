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

public class SkillFragment extends Fragment {
    static FragmentManager manager;
    static SkillFragment skillFragment;
    SkillSetFragment skillSetFragment = new SkillSetFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill, container, false);
        manager = getFragmentManager();
        skillFragment = this;
        return view;
    }

    public void callSkillSetFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, skillSetFragment);
        transaction.commit();
    }

    public void callSkillFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, SkillFragment.skillFragment);
        transaction.commit();
    }
}
