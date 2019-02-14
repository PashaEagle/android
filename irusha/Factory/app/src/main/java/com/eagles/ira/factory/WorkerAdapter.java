package com.eagles.ira.factory;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WorkerAdapter extends BaseAdapter { //Адаптери потрібні для відображення спику всіх книжок, їх три, так як списка тоже три

    View viewGL;
    AlertDialog.Builder ad;
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Worker> objects;

    WorkerAdapter(Context context, ArrayList<Worker> workers) {
        ctx = context;
        objects = workers;
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

        Worker p = getOrder(position);

        ((TextView) view.findViewById(R.id.tName)).setText(p.name);
        ((TextView) view.findViewById(R.id.tNumber)).setText(p.number.toString());
        ((TextView) view.findViewById(R.id.tPosition)).setText(p.position);
        ((TextView) view.findViewById(R.id.tDepartment)).setText("#" + p.department.toString());
        ((TextView) view.findViewById(R.id.tDate)).setText(p.date);
        //((TextView) view.findViewById(R.id.tDate)).setText(p.date);

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

    Worker getOrder(int position) {
        return ((Worker) getItem(position));
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
        for (int i = 0 ; i < MainActivity.AbsentList.size(); ++i){
            if (MainActivity.AbsentList.get(i).getName().equals(searchName)){
                //objects.remove(i);
                MainActivity.AbsentList.remove(i);
                Toast.makeText(ctx, ""+i,
                        Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
                break;
            }
        }
        for (int i = 0 ; i < MainActivity.PresentList.size(); ++i){
            if (MainActivity.PresentList.get(i).getName().equals(searchName)){
                //objects.remove(i);
                MainActivity.PresentList.remove(i);
                Toast.makeText(ctx, ""+i,
                        Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
                break;
            }
        }
    }


}
