package com.monast.taras.oop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class AddActivity extends AppCompatActivity {

    EditText eName, eAddress, ePrice, eAmount, eOrderDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        eName = (EditText) findViewById(R.id.tName);
        eAddress = (EditText) findViewById(R.id.tAddress);
        ePrice = (EditText) findViewById(R.id.tPrice);
        eAmount = (EditText) findViewById(R.id.tAmount);
        eOrderDay = (EditText) findViewById(R.id.tDate);

        Button btn = (Button)  findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new InStockBook(eName.getText().toString(),
                        eAddress.getText().toString(),
                        Double.parseDouble(ePrice.getText().toString()),
                        Integer.parseInt(eAmount.getText().toString()),
                        eOrderDay.getText().toString(), 1
                );
                MainActivity.list.add(book);//додаємо в статичну колекцію

                finish();//програмно закриваємо активність
            };
        });
    }
}
