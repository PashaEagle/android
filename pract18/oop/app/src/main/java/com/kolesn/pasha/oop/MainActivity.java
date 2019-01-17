package com.kolesn.pasha.oop;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private OrderAdapter orderAdapter;
    private SavedOrderAdapter savedOrderAdapter;
    private PurchasedOrderAdapter purchasedOrderAdapter;
    public static ArrayList<Order> list;
    public static ArrayList<SavedOrder> SavedList;
    public static ArrayList<PurchasedOrder> PurchasedList;

    private ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        try {
//            FileInputStream fis = getApplicationContext().openFileInput("Serial.txt");
//            ObjectInputStream is = new ObjectInputStream(fis);
//            list = (ArrayList<Order>) is.readObject();
//            is.close();
//            fis.close();
//        }catch (Exception e){
//            Toast.makeText(MainActivity.this, "Exception in main", Toast.LENGTH_SHORT).show();
//        }

        fillList();

        PurchasedList = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i){
            if (list.get(i).getClass().equals(PurchasedOrder.class)){
                PurchasedList.add((PurchasedOrder)list.get(i));
            }
        }

        SavedList = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i){
            if (list.get(i).getClass().equals(SavedOrder.class)){
                SavedList.add((SavedOrder) list.get(i));
            }
        }

        orderAdapter = new OrderAdapter(this, list);
        purchasedOrderAdapter = new PurchasedOrderAdapter(this, PurchasedList);
        savedOrderAdapter = new SavedOrderAdapter(this, SavedList);
        lvMain = (ListView) findViewById(R.id.list);
        lvMain.setAdapter(orderAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // отримуємо ід вибраного пункту меню
        int id = item.getItemId();

        // В залежності від вибраного пункту виконуємо певну реалізацію
        switch (id) {
            case R.id.item_search:
                Toast.makeText(MainActivity.this, "Going for search by address !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_show_only_purchased:
                Toast.makeText(MainActivity.this, "Showing only purchased!", Toast.LENGTH_SHORT).show();
                lvMain.setAdapter(purchasedOrderAdapter);
                return true;
            case R.id.item_show_only_saved:
                Toast.makeText(MainActivity.this, "Showing only saved!", Toast.LENGTH_SHORT).show();
                lvMain.setAdapter(savedOrderAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvMain = (ListView) findViewById(R.id.list);//знаходимо ліст
        lvMain.setAdapter(orderAdapter);//заносимо дані із колекції

    }

    public void fillList(){
        list = new ArrayList<>();
        Order op = new PurchasedOrder("Cars", "Kyiv", 720.0, 2, "13.01.19", 70);
        list.add(op);

        op = new SavedOrder("Fruits", "Lviv", 22.0, 3, "15.01.19", "Tomorrow");
        list.add(op);

        op = new PurchasedOrder("Green Bed", "Kyiv", 1000.0, 1, "29.12.18", 10);
        list.add(op);

        op = new PurchasedOrder("Flags", "New York", 452.5, 4, "22.12.18", 100);
        list.add(op);

        op = new PurchasedOrder("Black Bed", "Kyiv", 1710.0, 1, "12.11.18", 180);
        list.add(op);

        op = new SavedOrder("Fruits and sweets", "Lviv", 224.0, 30, "15.01.19", "19.02.19");
        list.add(op);

        op = new SavedOrder("Laptop", "Lviv", 777.0, 1, "15.01.19", "30.01.19");
        list.add(op);
    }
}
