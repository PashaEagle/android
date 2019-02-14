package com.eagles.ira.factory;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Три адаптера для списків
    private PresentWorkerAdapter presentWorkerAdapter;
    private WorkerAdapter workerAdapter;
    private AbsentWorkerAdapter absentWorkerAdapter;

    //Три списка
    public static ArrayList<Worker> list;
    public static ArrayList<AbsentWorker> AbsentList;
    public static ArrayList<PresentWorker> PresentList;

    private ListView lvMain; // Це компонент який показує список візуально (той який прокручувати можна)

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Метод викликається при створенні "форми"
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillList(); // Тут заповнюється головний список

        PresentList = new ArrayList<>(); // Список 1, тут він заповнюється
        for (int i = 0; i < list.size(); ++i){
            if (list.get(i).getClass().equals(PresentWorker.class)){
                PresentList.add((PresentWorker)list.get(i));
            }
        }

        AbsentList = new ArrayList<>(); // Список 2, тут він заповнюється
        for (int i = 0; i < list.size(); ++i){
            if (list.get(i).getClass().equals(AbsentWorker.class)){
                AbsentList.add((AbsentWorker) list.get(i));
            }
        }

        presentWorkerAdapter = new PresentWorkerAdapter(this, PresentList);
        absentWorkerAdapter = new AbsentWorkerAdapter(this, AbsentList);
        workerAdapter = new WorkerAdapter(this, list);
        lvMain = (ListView) findViewById(R.id.list);
        lvMain.setAdapter(workerAdapter);


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
                Toast.makeText(MainActivity.this, "Going for search by name !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_show_only_parked:
                Toast.makeText(MainActivity.this, "Showing only absent!", Toast.LENGTH_SHORT).show();
                lvMain.setAdapter(absentWorkerAdapter);
                return true;
            case R.id.item_show_only_out:
                Toast.makeText(MainActivity.this, "Showing only present!", Toast.LENGTH_SHORT).show();
                lvMain.setAdapter(presentWorkerAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() { //При поверненні на цю "форму"
        super.onResume();

        lvMain = (ListView) findViewById(R.id.list);//знаходимо ліст
        lvMain.setAdapter(workerAdapter);//заносимо дані із колекції

    }

    public void fillList(){ // Тут заповнення списку елементами
        list = new ArrayList<>();
        Worker op = new PresentWorker("Vasya", "Manager", 1.0, 7777, true,"19.01.18 20:50");
        list.add(op);

        op = new AbsentWorker("Kolya", "Cleaner", 2.0, 1910, false,"21.01.18 18:18");
        list.add(op);

        op = new PresentWorker("Petya", "Ex-Director", 3.0, 4452, true,"01.01.19 01:52");
        list.add(op);

        op = new PresentWorker("Ada", "Teacher", 452.0, 2040, true,"22.01.19 12:14");
        list.add(op);

        op = new PresentWorker("Zhora", "Assistant", 1710.0, 1888, true,"17.12.18 00:00");
        list.add(op);

        op = new AbsentWorker("Lilya", "Worker", 800.0, 8888, false,"12.12.19 12:19");
        list.add(op);

        op = new AbsentWorker("Zhenya", "Director", 777.0, 1999, false,"14.11.18 12:00");
        list.add(op);
    }
}
