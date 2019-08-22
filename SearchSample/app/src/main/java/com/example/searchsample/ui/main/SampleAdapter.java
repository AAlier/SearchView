package com.example.searchsample.ui.main;

import android.view.View;

import com.example.searchsample.R;
import com.example.searchsample.base.BaseRecyclerAdapter;

import java.util.List;

import androidx.annotation.NonNull;

public class SampleAdapter extends BaseRecyclerAdapter<SampleViewHolder, String> {
    private SampleListener listener;
    private String searchText;

    public SampleAdapter(List<String> generatedList, SampleListener listener) {
        super(generatedList);
        this.listener = listener;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_address;
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, int position) {
        holder.setSearchText(searchText);
        super.onBindViewHolder(holder, position);
    }

    @Override
    protected SampleViewHolder getViewHolder(View view) {
        return new SampleViewHolder(view, listener);
    }
}
