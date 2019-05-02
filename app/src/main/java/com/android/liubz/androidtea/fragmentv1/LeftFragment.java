package com.android.liubz.androidtea.fragmentv1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.liubz.androidtea.R;

public class LeftFragment extends Fragment implements View.OnClickListener {

    private Button mBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        mBtn = view.findViewById(R.id.button);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mBtn) {
            ((LoginActivity) getActivity()).goToSecondStep();
        }
    }
}
