package com.example.searchsample.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {
    // фрагментом хочет общаться с Activity
    private SampleListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener.onClickItem("sajhakhjzhdjzhd");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (SampleListener) context;
    }

    public void setSearchQuery(String aksjdklajs) {

    }
}
