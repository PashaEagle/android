package com.kolesn.pasha.oop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
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
                SavedOrder order = new SavedOrder(eName.getText().toString(),
                        eAddress.getText().toString(),
                        Double.parseDouble(ePrice.getText().toString()),
                        Integer.parseInt(eAmount.getText().toString()),
                        eOrderDay.getText().toString(), "123"
                );
                MainActivity.list.add(order);//додаємо в статичну колекцію

                FileOutputStream fos = null;
                try {
                    fos = getApplicationContext().openFileOutput("Serial.txt", Context.MODE_PRIVATE);
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(MainActivity.list);
                    os.close();
                    fos.close();
                } catch (Exception e) {
                    Toast.makeText(AddActivity.this, "Exception in add", Toast.LENGTH_SHORT).show();
                }

                finish();//програмно закриваємо активність
            };
        });
    }
}
