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

public class lab7 extends AppCompatActivity {

    EditText editText;
    Button btn_add;
    Button btn_sort;

    TextView textArray;
    TextView textSortedArray;

    private int amountOfElements;
    private int[] tempArray;
    private static int[]arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7);

        btn_add = (Button)findViewById(R.id.btn_add);
        btn_sort = (Button)findViewById(R.id.btn_sort);
        editText = (EditText)findViewById(R.id.editText2);
        textArray  = (TextView)findViewById(R.id.textArray);
        textSortedArray = (TextView)findViewById(R.id.textSortedArray);

        textArray.setText("Array:");
        textSortedArray.setText("Sorted:");
        btn_add.setText("add");
        btn_sort.setText("sort");
        amountOfElements = 0;
        tempArray = new int[100];

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4842f4")));
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
            Toast.makeText(lab7.this, "Enter number !", Toast.LENGTH_SHORT).show();
            editText.setHint("Here !");
        }

    }

    public void btnSortClick(View view){
        textSortedArray.setText("Sorted:");
        if (amountOfElements != 0)
        {
            arr = new int[amountOfElements];
            for (int i = 0; i < amountOfElements; ++i) arr[i] = tempArray[i];
            quickSort();
            for (int i = 0; i < amountOfElements; ++i) textSortedArray.append("  " + arr[i]);
        }
        else {
            Toast.makeText(lab7.this, "Enter at least one number !", Toast.LENGTH_SHORT).show();
            editText.setHint("Here !");
        }
    }

    //********************************QuickSort**********************************************

    public static void quickSort() {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        doSort(startIndex, endIndex);
    }

    private static void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }
}
