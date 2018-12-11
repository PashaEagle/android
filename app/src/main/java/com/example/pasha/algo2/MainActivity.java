package com.example.pasha.algo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_lab6;
    Button btn_lab7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lab6 = (Button)findViewById(R.id.btn_lab6);
        btn_lab7 = (Button)findViewById(R.id.btn_lab7);
        btn_lab6.setOnClickListener(this);
        btn_lab7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent intent;
        switch(view.getId()){
            case R.id.btn_lab6:
                intent = new Intent(this, lab6.class);
                startActivity(intent);
                break;
            case R.id.btn_lab7:
                intent = new Intent(this, lab7.class);
                startActivity(intent);
                break;
            default:
                break;
        }



    }
}
