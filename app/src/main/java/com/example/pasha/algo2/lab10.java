package com.example.pasha.algo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class lab10 extends AppCompatActivity {

    Button btn_add;
    Button btn_remove;
    TextView textArray;
    EditText editText;
    ListView listView;

    final ArrayList<String> names = new ArrayList<>();
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab10);

        editText = (EditText)findViewById(R.id.editTextInput);
        listView = (ListView)findViewById(R.id.listView);
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_remove = (Button)findViewById(R.id.btn_remove);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, names);;

        listView.setAdapter(adapter);


    }

    public void btnAddClick(View view){
        names.add(0, editText.getText().toString());
        adapter.notifyDataSetChanged();
        editText.setText("");
    }

    public void btnRemoveClick(View view){
        if (names.size() > 0){
            names.remove(names.size() - 1);
            adapter.notifyDataSetChanged();
            editText.setText("");
            Toast.makeText(lab10.this, "Deleted !", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(lab10.this, "List is empty !", Toast.LENGTH_SHORT).show();
        }


    }

}
