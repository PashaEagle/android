package com.example.pasha.algo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class lab8 extends AppCompatActivity {

    EditText editText;
    EditText editTextFind;
    ImageView img;
    Button btn_add;
    Button btn_find;

    TextView textArray;

    private int amountOfElements;
    private int[] tempArray;
    private static int[]arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8);

        btn_add = (Button)findViewById(R.id.btn_add);
        btn_find = (Button)findViewById(R.id.btn_find);
        editText = (EditText)findViewById(R.id.editText3);
        editTextFind = (EditText)findViewById(R.id.editText4);
        textArray  = (TextView)findViewById(R.id.textArray);
        img = (ImageView)findViewById(R.id.imgResult);

        textArray.setText("Array:");
        amountOfElements = 0;
        tempArray = new int[100];
    }

    public void btnAddClick(View view){
        try{
            int num = Integer.parseInt(editText.getText().toString());
            if (amountOfElements != 0)
                textArray.append(", " + String.valueOf(num));
            else textArray.append(" " + String.valueOf(num));
            tempArray[amountOfElements] = num;
            ++amountOfElements;
            editText.setText("");
            editText.setHint("");
        }
        catch(Exception e){
            Toast.makeText(lab8.this, "Enter number !", Toast.LENGTH_SHORT).show();
            editText.setHint("Here !");
        }

    }

    public void btnFindClick(View view){

        try{
            if (amountOfElements != 0)
            {
                int toFind = Integer.parseInt(editTextFind.getText().toString());
                arr = new int[amountOfElements];
                for (int i = 0; i < amountOfElements; ++i) arr[i] = tempArray[i];
                Arrays.sort(arr);
                if (find(toFind) != -1){
                    img.setImageResource(R.drawable.gal);
                    Toast.makeText(lab8.this, "Success !  " + toFind + " exists", Toast.LENGTH_SHORT).show();

                }
                else{
                    img.setImageResource(R.drawable.cross);
                    Toast.makeText(lab8.this, toFind + " not found in array", Toast.LENGTH_SHORT).show();
                }

            }
            else {
                Toast.makeText(lab8.this, "Enter at least one number !", Toast.LENGTH_SHORT).show();
                editText.setHint("Here !");
            }
        }
        catch(Exception e){
            Toast.makeText(lab8.this, "Enter number to find!", Toast.LENGTH_SHORT).show();
            editTextFind.setHint("Here !");
        }
    }

    public int find(int x) {
        int i = -1;
        if (this.arr != null) {
            int low = 0, high = this.arr.length, mid;
            while (low < high) {
                mid = (low + high)/2; // Можно заменить на: (low + high) >>> 1, чтоб не возникло переполнение целого
                if (x == this.arr[mid]) {
                    i = mid;
                    break;
                } else {
                    if (x <= this.arr[mid]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return i;
    }

}
