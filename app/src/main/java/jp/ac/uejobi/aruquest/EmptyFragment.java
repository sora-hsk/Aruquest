package jp.ac.uejobi.aruquest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by uejobi on 2018/11/12.
 */

public class EmptyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_empty, container, false);
        container.setBackgroundColor(Color.argb(0, 0, 0, 0));
        return view;
    }
}
