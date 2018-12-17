package com.example.pasha.algo2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class lab9 extends AppCompatActivity {

    Button btn_add;
    Button btn_remove;
    TextView textArray;
    EditText editText;

    private int arr[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab9);

        btn_add = (Button)findViewById(R.id.btn_add);
        btn_remove = (Button)findViewById(R.id.btn_remove);
        editText = (EditText)findViewById(R.id.editText);
        textArray  = (TextView)findViewById(R.id.textArray);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4842f4")));

        textArray.setText("Array: ");
    }

    public void btnAddClick(View view){
        int num;
        try{
            num = Integer.parseInt(editText.getText().toString());
        }catch (Exception e){
            Toast.makeText(lab9.this, "Enter number !", Toast.LENGTH_SHORT).show();
            return;
        }

        if (arr == null){
            arr = new int[1];
            arr[0] = num;
        }else{
            int[] temp = new int[arr.length];
            for (int i = 0; i < arr.length; ++i) temp[i] = arr[i];
            arr = new int[arr.length + 1];
            for (int i = 0; i < arr.length - 1; ++i) arr[i] = temp[i];
            arr[arr.length - 1] = num;
        }
        textArray.append(String.valueOf(num) + "  ");
        editText.setText("");
    }


    public void btnRemoveClick(View view){
        if (arr == null){
            Toast.makeText(lab9.this, "Array is empty !", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (arr.length == 1){
            arr = null;
            Toast.makeText(lab9.this, "Deleted !", Toast.LENGTH_SHORT).show();
            textArray.setText("Array: ");
            return;
        }
        else{
            int[] temp = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; ++i) temp[i] = arr[i];
            arr = new int[arr.length - 1];
            for (int i = 0; i < arr.length; ++i) arr[i] = temp[i];
        }
        Toast.makeText(lab9.this, "Deleted !", Toast.LENGTH_SHORT).show();
        textArray.setText("Array: ");
        for (int i = 0; i < arr.length; ++i) textArray.append(String.valueOf(arr[i]) + "  ");
    }
}
