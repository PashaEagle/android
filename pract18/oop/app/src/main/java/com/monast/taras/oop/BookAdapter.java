package com.monast.taras.oop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;


public class BookAdapter extends BaseAdapter { //Адаптери потрібні для відображення спику всіх книжок, їх три, так як списка тоже три

    View viewGL;
    AlertDialog.Builder ad;
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Book> objects;

    BookAdapter(Context context, ArrayList<Book> orders) {
        ctx = context;
        objects = orders;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        notifyDataSetChanged();
        ad = new AlertDialog.Builder(ctx);
        ad.setTitle("Deleting");  // заголовок
        ad.setMessage("Are you really want to delete this element?"); // сообщение
        ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                deleteAndRefresh(viewGL);
                Toast.makeText(ctx, "Deleted",
                        Toast.LENGTH_LONG).show();
            }
        });
        ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(ctx, "Not deleted", Toast.LENGTH_LONG).show();
            }
        });
        ad.setCancelable(true);
        ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
            }
        });
        notifyDataSetChanged();
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

        Book p = getOrder(position);

        ((TextView) view.findViewById(R.id.tName)).setText(p.name);
        ((TextView) view.findViewById(R.id.tPrice)).setText(p.pages.toString());
        ((TextView) view.findViewById(R.id.tAddress)).setText(p.author);
        ((TextView) view.findViewById(R.id.tAmount)).setText(p.year.toString());
        ((TextView) view.findViewById(R.id.tDate)).setText(p.state);
        //((TextView) view.findViewById(R.id.tDate)).setText(p.state);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewGL = v;
                ad.show();
                notifyDataSetChanged();
            }
        });

        return view;
    }

    Book getOrder(int position) {
        return ((Book) getItem(position));
    }

    public void deleteAndRefresh(View v){
        String searchName = ((TextView) v.findViewById(R.id.tName)).getText().toString();
        for (int i = 0 ; i < MainActivity.list.size(); ++i){
            if (MainActivity.list.get(i).getName().equals(searchName)){
                //objects.remove(i);
                MainActivity.list.remove(i);
                Toast.makeText(ctx, ""+i,
                        Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
                break;
            }
        }
        for (int i = 0 ; i < MainActivity.GivedList.size(); ++i){
            if (MainActivity.GivedList.get(i).getName().equals(searchName)){
                //objects.remove(i);
                MainActivity.GivedList.remove(i);
                Toast.makeText(ctx, ""+i,
                        Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
                break;
            }
        }
        for (int i = 0 ; i < MainActivity.InStockList.size(); ++i){
            if (MainActivity.InStockList.get(i).getName().equals(searchName)){
                //objects.remove(i);
                MainActivity.InStockList.remove(i);
                Toast.makeText(ctx, ""+i,
                        Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
                break;
            }
        }
    }
}
