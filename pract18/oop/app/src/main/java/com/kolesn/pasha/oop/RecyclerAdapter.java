package com.kolesn.pasha.oop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        holder.tName.setText(MainActivity.list.get(position).getName());
        holder.tAddress.setText(MainActivity.list.get(position).getAddress());
        holder.tPrice.setText(String.valueOf(MainActivity.list.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return MainActivity.list.size();
    }
}
