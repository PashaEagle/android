package com.monast.taras.oop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InStockBookAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<InStockBook> objects;

    InStockBookAdapter(Context context, ArrayList<InStockBook> books) {
        ctx = context;
        objects = books;
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

        InStockBook p = getOrder(position);

        ((TextView) view.findViewById(R.id.tName)).setText(p.name);
        ((TextView) view.findViewById(R.id.tPrice)).setText(p.pages .toString());
        ((TextView) view.findViewById(R.id.tAddress)).setText(p.author);
        ((TextView) view.findViewById(R.id.tAmount)).setText(p.year.toString());
        ((TextView) view.findViewById(R.id.tDate)).setText(p.state);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, ((TextView) v.findViewById(R.id.tName)).getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    InStockBook getOrder(int position) {
        return ((InStockBook) getItem(position));
    }

}
