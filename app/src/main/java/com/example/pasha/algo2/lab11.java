package com.example.pasha.algo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class lab11 extends AppCompatActivity {

    EditText editText;
    Button btn_add;
    Button btn_sort;

    TextView textArray;
    TextView textSortedArray;

    private int amountOfElements;
    private int[] tempArray;
    private int[]arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11);


        btn_add = (Button)findViewById(R.id.btn_add);
        btn_sort = (Button)findViewById(R.id.btn_sort);
        editText = (EditText)findViewById(R.id.editText);
        textArray  = (TextView)findViewById(R.id.textArray);
        textSortedArray  = (TextView)findViewById(R.id.textSortedArray);

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
            Toast.makeText(lab11.this, "Enter number !", Toast.LENGTH_SHORT).show();
            editText.setHint("Here !");
        }

    }

    public void btnSortClick(View view){
        try{
            textSortedArray.setText("Sorted:");
            if (amountOfElements != 0)
            {
                arr = new int[amountOfElements];
                for (int i = 0; i < amountOfElements; ++i) arr[i] = tempArray[i];
                radixSort();
                for (int i = 0; i < amountOfElements; ++i) textSortedArray.append("  " + arr[i]);
            }
            else {
                Toast.makeText(lab11.this, "Enter at least one number !", Toast.LENGTH_SHORT).show();
                editText.setHint("Here !");
            }
        }catch(Exception e){
            Toast.makeText(lab11.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void radixSort(){
        int range = 10;
        int length = 1;
        for (int i = 0; i < arr.length; ++i)
        {
            int k = 1;
            int t = arr[i];
            while (Math.abs(t) > 9)
            {
                t /= 10;
                ++k;
            }
            if (k > length) length = k;
        }

        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> listsNegative = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < range; ++i) lists.add(new ArrayList<Integer>());
        for (int i = 0; i < range; ++i) listsNegative.add(new ArrayList<Integer>());


        for (int step = 0; step < length; ++step)
        {
            //Sorting to lists
            for (int i = 0; i < arr.length; ++i)
            {
                int temp = (Math.abs(arr[i]) % (int)Math.pow(range, step + 1)) /
                        (int)Math.pow(range, step);




                if (arr[i] >= 0)
                    lists.get(temp).add(arr[i]);
                else
                    listsNegative.get(temp).add(arr[i]);
            }


            //Building
            int k = 0;
            for (int i = range - 1; i >= 0; --i)
            {
                for (int j = 0; j < listsNegative.get(i).size(); ++j)
                {
                    arr[k++] = (int)listsNegative.get(i).get(j);
                }
            }
            for (int i = 0; i < range; ++i)
                listsNegative.get(i).clear();
            //Building2


            for (int i = 0; i < range; ++i)
            {
                for (int j = 0; j < lists.get(i).size(); ++j)
                {
                    arr[k++] = (int)lists.get(i).get(j);
                }
            }
            for (int i = 0; i < range; ++i)
                lists.get(i).clear();

        }
    }
}