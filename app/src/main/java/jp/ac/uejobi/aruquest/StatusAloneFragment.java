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
 * Created by uejobi on 2018/11/12.
 */

public class StatusAloneFragment extends Fragment {
    static FragmentManager manager;
    static StatusAloneFragment statusAloneFragment;
    WeaponFragment weaponFragment = new WeaponFragment();
    ArmorFragment armorFragment = new ArmorFragment();
    SkillFragment skillFragment = new SkillFragment();
    ItemFragment itemFragment = new ItemFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status_alone, container, false);
        manager = getFragmentManager();
        statusAloneFragment = this;
        Bundle bundle = getArguments();
        DrawStatusAlone.setCharaID(bundle.getInt("charaID"));
        return view;
    }

    public void callStatusFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, StatusFragment.statusFragment);
        transaction.commit();
    }

    public void callWeaponFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, weaponFragment);
        transaction.commit();
    }

    public void callArmorFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, armorFragment);
        transaction.commit();
    }

    public void callSkillFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, skillFragment);
        transaction.commit();
    }

    public void callItemFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, itemFragment);
        transaction.commit();
    }

    public void callStatusAloneFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment, statusAloneFragment);
        transaction.commit();
    }
}
