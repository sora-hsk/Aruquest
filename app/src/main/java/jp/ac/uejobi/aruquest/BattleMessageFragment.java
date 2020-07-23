package jp.ac.uejobi.aruquest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by uejobi on 2018/12/03.
 */

public class BattleMessageFragment extends Fragment {
    static FragmentManager manager;
    static BattleMessageFragment fragment;
    static LayoutInflater layoutInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle_message, container, false);
        manager = getFragmentManager();
        fragment = this;
        layoutInflater = inflater;
        Bundle bundle = getArguments();
        DrawBattleMessage.setMessage(bundle.getStringArray("msg"));
        DrawBattleMessage.setName(bundle.getStringArray("name"));
        return view;
    }

    public void exitMessageFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    public void returnBattle() {
        BattleFragment fragment = new BattleFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    public void returnMap(){
        if(Sound.battle != null && Sound.battle.isPlaying()) {
            Sound.battle.stop();
            Sound.battle = null;
        }
        if(Sound.bossBattle != null && Sound.bossBattle.isPlaying()) {
            Sound.bossBattle.stop();
            Sound.bossBattle = null;
        }
        if(Sound.lastBossBattle != null && Sound.lastBossBattle.isPlaying()) {
            Sound.lastBossBattle.stop();
            Sound.lastBossBattle = null;
        }
        if(Sound.secretBossBattle != null && Sound.secretBossBattle.isPlaying()) {
            Sound.secretBossBattle.stop();
            Sound.secretBossBattle = null;
        }
        Sound.dungeon.start();
        EmptyFragment fragment = new EmptyFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
        EmptyFragment fragment2 = new EmptyFragment();
        FragmentTransaction transaction2 = manager.beginTransaction();
        transaction2.replace(R.id.container2, fragment2);
        transaction2.commit();
    }

    public void returnHome(){
        if(Sound.battle != null && Sound.battle.isPlaying()) {
            Sound.battle.stop();
            Sound.battle = null;
        }
        if(Sound.bossBattle != null && Sound.bossBattle.isPlaying()) {
            Sound.bossBattle.stop();
            Sound.bossBattle = null;
        }
        if(Sound.lastBossBattle != null && Sound.lastBossBattle.isPlaying()) {
            Sound.lastBossBattle.stop();
            Sound.lastBossBattle = null;
        }
        if(Sound.secretBossBattle != null && Sound.secretBossBattle.isPlaying()) {
            Sound.secretBossBattle.stop();
            Sound.secretBossBattle = null;
        }
        Intent i = new Intent(layoutInflater.getContext(), jp.ac.uejobi.aruquest.HomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        layoutInflater.getContext().startActivity(i);
    }

}
