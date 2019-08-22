package com.example.searchsample.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerAdapter<V extends BaseViewHolder<T>, T> extends RecyclerView.Adapter<V> {
    private List<T> data = new ArrayList<>();

    public BaseRecyclerAdapter(List<T> list){
        this.data = list;
    }

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(getLayoutRes(), parent, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        holder.bind(getItemAt(position));
    }

    @Override
    public void onViewRecycled(@NonNull V holder) {
        super.onViewRecycled(holder);
        holder.unbind();
    }

    private T getItemAt(int position){
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract V getViewHolder(View view);

    public void updateList(List<T> newList){
        this.data = newList;
        notifyDataSetChanged();
    }
}
