package jp.ac.uejobi.aruquest;

import android.content.Intent;
import android.graphics.Color;
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
 * Created by uejobi on 2018/11/09.
 */

public class CheckFragment extends Fragment {
    static  LayoutInflater layoutInflater;
    static FragmentManager manager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selectdungeon_check, container, false);
        layoutInflater = inflater;
        manager = getFragmentManager();
        view.setBackgroundColor(Color.argb(200, 0, 0, 0));
        Bundle bundle = getArguments();
        DrawCheck.setText(bundle.getString("text"));
        DrawCheck.setCallMethodIndex(bundle.getInt("callMethodIndex"));
        return view;
    }

    public static void callDungeonActivity(){
        Intent i = new Intent(layoutInflater.getContext(), jp.ac.uejobi.aruquest.DungeonActivity.class);
        i.putExtra("dungeonID", DrawSelectDungeon.dungeonIndex);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        layoutInflater.getContext().startActivity(i);
    }

    public void callCommandFragment(){
        CommandFragment commandFragment = new CommandFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.commandFragment, commandFragment);
        transaction.commit();
    }

    public void callHomeActivity(){
        Intent i = new Intent(layoutInflater.getContext(), jp.ac.uejobi.aruquest.HomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        layoutInflater.getContext().startActivity(i);
    }

    public void callStartActivity(){
        Intent i = new Intent(layoutInflater.getContext(), StartActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        layoutInflater.getContext().startActivity(i);
    }
}

