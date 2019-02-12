package com.monast.taras.oop;

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
    private InStockBookAdapter inStockBookAdapter;
    private BookAdapter bookAdapter;
    private GivedBookAdapter givedBookAdapter;

    //Три списка
    public static ArrayList<Book> list;
    public static ArrayList<GivedBook> GivedList;
    public static ArrayList<InStockBook> InStockList;

    private ListView lvMain; // Це компонент який показує список візуально (той який прокручувати можна)

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Метод викликається при створенні "форми"
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillList(); // Тут заповнюється головний список

        InStockList = new ArrayList<>(); // Список 1, тут він заповнюється
        for (int i = 0; i < list.size(); ++i){
            if (list.get(i).getClass().equals(InStockBook.class)){
                InStockList.add((InStockBook)list.get(i));
            }
        }

        GivedList = new ArrayList<>(); // Список 2, тут він заповнюється
        for (int i = 0; i < list.size(); ++i){
            if (list.get(i).getClass().equals(GivedBook.class)){
                GivedList.add((GivedBook) list.get(i));
            }
        }

        inStockBookAdapter = new InStockBookAdapter(this, InStockList);
        givedBookAdapter = new GivedBookAdapter(this, GivedList);
        bookAdapter = new BookAdapter(this, list);
        lvMain = (ListView) findViewById(R.id.list);
        lvMain.setAdapter(bookAdapter);


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
                Toast.makeText(MainActivity.this, "Going for search by author !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_show_only_gived:
                Toast.makeText(MainActivity.this, "Showing only gived!", Toast.LENGTH_SHORT).show();
                lvMain.setAdapter(givedBookAdapter);
                return true;
            case R.id.item_show_only_in_stock:
                Toast.makeText(MainActivity.this, "Showing only in stock!", Toast.LENGTH_SHORT).show();
                lvMain.setAdapter(inStockBookAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() { //При поверненні на цю "форму"
        super.onResume();

        lvMain = (ListView) findViewById(R.id.list);//знаходимо ліст
        lvMain.setAdapter(bookAdapter);//заносимо дані із колекції

    }

    public void fillList(){ // Тут заповнення списку елементами
        list = new ArrayList<>();
        Book op = new InStockBook("adventures", "shevchenko", 720.0, 2001, "inStock", 7);
        list.add(op);

        op = new GivedBook("fruits", "franko", 22.0, 1995, "gived", "Tomorrow");
        list.add(op);

        op = new InStockBook("green", "kobzar", 1000.0, 1869, "inStock", 10);
        list.add(op);

        op = new InStockBook("flags", "new york", 452.5, 2004, "inStock", 100);
        list.add(op);

        op = new InStockBook("black bed", "bedroom", 1710.0, 1888, "inStock", 180);
        list.add(op);

        op = new GivedBook("fruits and sweets", "lviv", 224.0, 1930, "gived", "19.02.19");
        list.add(op);

        op = new GivedBook("laptops", "technologies", 777.0, 1999, "gived", "30.01.19");
        list.add(op);
    }
}
