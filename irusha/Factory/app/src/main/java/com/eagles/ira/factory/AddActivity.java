package com.eagles.ira.factory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText eName, ePosition, eNumber, eDepartment, eDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //Петя, нижче то про шо я говорив
        eName = (EditText) findViewById(R.id.tName);
        ePosition = (EditText) findViewById(R.id.tPosition);
        eNumber = (EditText) findViewById(R.id.tNumber);
        eDepartment = (EditText) findViewById(R.id.tDepartment);
        eDate = (EditText) findViewById(R.id.tDate);


        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Worker worker = new PresentWorker(eName.getText().toString(),
                            ePosition.getText().toString(),
                            Double.parseDouble(eNumber.getText().toString()),
                            Integer.parseInt(eDepartment.getText().toString()), true,
                            eDate.getText().toString()
                    );
                    MainActivity.list.add(worker);//додаємо в статичну колекцію
                    MainActivity.PresentList.add((PresentWorker) worker);
                    finish();//закриваємо активність
                } catch(Exception e){
                    Toast.makeText(AddActivity.this, "Fill all the fileds!", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
