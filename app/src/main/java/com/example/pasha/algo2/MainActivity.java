package com.example.pasha.algo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_lab6;
    Button btn_lab7;
    Button btn_lab8;
    Button btn_lab9;
    Button btn_lab10;
    Button btn_lab11;
    Button btn_lab12;
    Button btn_lab13;
    Button btn_lab14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lab6 = (Button)findViewById(R.id.btn_lab6);
        btn_lab7 = (Button)findViewById(R.id.btn_lab7);
        btn_lab8 = (Button)findViewById(R.id.btn_lab8);
        btn_lab9 = (Button)findViewById(R.id.btn_lab9);
        btn_lab10 = (Button)findViewById(R.id.btn_lab10);
        btn_lab11 = (Button)findViewById(R.id.btn_lab11);
        btn_lab12 = (Button)findViewById(R.id.btn_lab12);
        btn_lab13 = (Button)findViewById(R.id.btn_lab13);
        btn_lab14 = (Button)findViewById(R.id.btn_lab14);
        btn_lab6.setOnClickListener(this);
        btn_lab7.setOnClickListener(this);
        btn_lab8.setOnClickListener(this);
        btn_lab9.setOnClickListener(this);
        btn_lab10.setOnClickListener(this);
        btn_lab11.setOnClickListener(this);
        btn_lab12.setOnClickListener(this);
        btn_lab13.setOnClickListener(this);
        btn_lab14.setOnClickListener(this);
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
            case R.id.btn_lab8:
                intent = new Intent(this, lab8.class);
                startActivity(intent);
                break;
            case R.id.btn_lab9:
                intent = new Intent(this, lab9.class);
                startActivity(intent);
                break;
            case R.id.btn_lab10:
                intent = new Intent(this, lab10.class);
                startActivity(intent);
                break;
            case R.id.btn_lab11:
                intent = new Intent(this, lab11.class);
                startActivity(intent);
                break;
            case R.id.btn_lab12:
                intent = new Intent(this, lab12.class);
                startActivity(intent);
                break;
            case R.id.btn_lab13:
                intent = new Intent(this, lab13.class);
                startActivity(intent);
                break;
            case R.id.btn_lab14:
                intent = new Intent(this, lab14.class);
                startActivity(intent);
                break;
            default:
                break;
        }



    }
}

