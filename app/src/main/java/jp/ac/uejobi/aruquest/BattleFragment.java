package jp.ac.uejobi.aruquest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by uejobi on 2018/11/13.
 */

public class BattleFragment extends Fragment {

    static FragmentManager manager;
    static BattleFragment battleFragment;
    Char1MoveFragment char1MoveFragment = new Char1MoveFragment();

    public BattleFragment(){}

    public static BattleFragment newInstance(String str) {
        BattleFragment fragment = new BattleFragment();
        Bundle barg = new Bundle();
        barg.putString("Message",str);
        fragment.setArguments(barg);
        return fragment;
    }

    public void setCharmove(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,char1MoveFragment);
        transaction.commit();
    }
    public void setResult(String[] msg){
        BattleMessageFragment fragment = new BattleMessageFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        String[] name = new String[msg.length];
        for(int i = 0; i < msg.length; i++){
            name[i] = null;
        }
        bundle.putStringArray("msg", msg);
        bundle.putStringArray("name", name);
        fragment.setArguments(bundle);
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle,container,false);
        manager = getFragmentManager();
        battleFragment = this;

        return view;
    }
}
