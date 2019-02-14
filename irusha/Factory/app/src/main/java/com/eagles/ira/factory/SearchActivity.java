package com.eagles.ira.factory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private WorkerAdapter workerAdapter;
    public static ArrayList<Worker> Searchlist;

    private EditText search_text;
    private ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_text = (EditText)findViewById(R.id.search_text);

        Searchlist = new ArrayList<>();
        for (int i = 0; i < MainActivity.list.size(); ++i){

            Searchlist.add(MainActivity.list.get(i));

        }

        workerAdapter = new WorkerAdapter(this, Searchlist);
        lvMain = (ListView) findViewById(R.id.list_search);
        lvMain.setAdapter(workerAdapter);


    }

    public void onSearchButton(View view){
        Searchlist.clear();
        String par = search_text.getText().toString();
        Searchlist = new ArrayList<>();

        //Тут сама логіка пошуку, я провіряю чи шукомий текст збігається з частиною якогось номеру
        for (int i = 0; i < MainActivity.list.size(); ++i){
            if (MainActivity.list.get(i).getName().equals(par) || MainActivity.list.get(i).getName().contains(par)){
                Searchlist.add(MainActivity.list.get(i));
            }
        }
        if (Searchlist.size() > 0){ //Якщо шось знайшов
            Toast.makeText(SearchActivity.this, "Found " + Searchlist.size() + " workers", Toast.LENGTH_SHORT).show();
        }
        else{ // Якшо ніче не найшов
            Toast.makeText(SearchActivity.this, "Nothing found..", Toast.LENGTH_SHORT).show();
        }

        //Це для перезагрузки списка на екрані
        lvMain = (ListView) findViewById(R.id.list_search);
        workerAdapter = new WorkerAdapter(this, Searchlist);
        lvMain.setAdapter(workerAdapter);
    }
}
