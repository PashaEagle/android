package com.eagles.ira.factory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PresentWorkerAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<PresentWorker> objects;

    PresentWorkerAdapter(Context context, ArrayList<PresentWorker> avtos) {
        ctx = context;
        objects = avtos;
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

        PresentWorker p = getOrder(position);

        ((TextView) view.findViewById(R.id.tName)).setText(p.name);
        ((TextView) view.findViewById(R.id.tNumber)).setText(p.number.toString());
        ((TextView) view.findViewById(R.id.tPosition)).setText(p.position);
        ((TextView) view.findViewById(R.id.tDepartment)).setText("BX " + p.department.toString());
        ((TextView) view.findViewById(R.id.tDate)).setText(p.date);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, ((TextView) v.findViewById(R.id.tName)).getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    PresentWorker getOrder(int position) {
        return ((PresentWorker) getItem(position));
    }

}
