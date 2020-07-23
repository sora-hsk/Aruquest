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
 * Created by uejobi on 2018/11/07.
 */

public class StatusFragment extends Fragment {
    static FragmentManager manager;
    static StatusFragment statusFragment;
    StatusAloneFragment statusAloneFragment = new StatusAloneFragment();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        manager = getFragmentManager();
        statusFragment = this;
        return view;
    }

    public void callStatusAloneFragment(int charaID){
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt("charaID", charaID);
        statusAloneFragment.setArguments(bundle);
        transaction.replace(R.id.mainFragment, statusAloneFragment);
        transaction.commit();
    }
}
