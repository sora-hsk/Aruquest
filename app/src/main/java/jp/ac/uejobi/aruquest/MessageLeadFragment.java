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
 * Created by uejobi on 2018/12/18.
 */

public class MessageLeadFragment extends Fragment{
    static FragmentManager manager;
    static MessageLeadFragment fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messagestart, container, false);
        manager = getFragmentManager();
        fragment = this;
        Bundle bundle = getArguments();
        DrawMessageLead.setMessage(bundle.getStringArray("msg"));
        DrawMessageLead.setName(bundle.getStringArray("name"));
        return view;
    }
    public void exitMessageFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }
}
