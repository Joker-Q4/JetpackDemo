package com.joker.ui.my;

import android.os.Bundle;

import com.joker.libnavannotation.FragmentDestination;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

@FragmentDestination(pageUrl = "main/tabs/my")
public class MyFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
