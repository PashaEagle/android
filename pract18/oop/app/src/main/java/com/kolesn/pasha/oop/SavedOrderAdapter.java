package com.kolesn.pasha.oop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SavedOrderAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<SavedOrder> objects;

    SavedOrderAdapter(Context context, ArrayList<SavedOrder> orders) {
        ctx = context;
        objects = orders;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        SavedOrder p = getOrder(position);

        ((TextView) view.findViewById(R.id.tName)).setText(p.name);
        ((TextView) view.findViewById(R.id.tPrice)).setText(p.price + "грн.");
        ((TextView) view.findViewById(R.id.tAddress)).setText(p.address);
        ((TextView) view.findViewById(R.id.tAmount)).setText(p.amount.toString());
        ((TextView) view.findViewById(R.id.tDate)).setText(p.orderDate);
        //((TextView) view.findViewById(R.id.tDate)).setText(p.orderDate);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, ((TextView) v.findViewById(R.id.tPrice)).getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    SavedOrder getOrder(int position) {
        return ((SavedOrder) getItem(position));
    }

}