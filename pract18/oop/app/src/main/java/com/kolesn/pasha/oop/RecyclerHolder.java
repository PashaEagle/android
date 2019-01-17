package com.kolesn.pasha.oop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerHolder extends RecyclerView.ViewHolder {

    public TextView tName, tAddress, tPrice;
    public RecyclerHolder(View itemView) {
        super(itemView);
        tName = (TextView) itemView.findViewById(R.id.tName);
        tAddress =(TextView) itemView.findViewById(R.id.tAddress);
        tPrice =(TextView) itemView.findViewById(R.id.tPrice);
    }
}
