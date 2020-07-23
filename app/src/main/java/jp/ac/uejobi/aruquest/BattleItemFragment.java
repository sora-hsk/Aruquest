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
 * Created by uejobi on 2018/11/19.
 */

public class BattleItemFragment extends Fragment {

    static FragmentManager manager;
    static BattleItemFragment itemFragment;

    public BattleItemFragment(){}

    public void setCharmove(){
        Char1MoveFragment Fragment = new Char1MoveFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,Fragment);
        transaction.commit();
    }
    public void setCharselect(){
        CharSelectFragment fragment = new CharSelectFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,fragment);
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
        manager = getFragmentManager();
        itemFragment = this;

        return inflater.inflate(R.layout.fragment_battle_item,container,false);
    }
}
