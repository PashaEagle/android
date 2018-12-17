package com.example.pasha.algo2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class lab6 extends AppCompatActivity {

    EditText editText;
    TextView textArray;
    TextView textSortedArray;
    TextView array;

    private static int heapSize;
    private static int amountOfElements;
    private int[] tempArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);

        editText = (EditText)findViewById(R.id.editText);
        textArray  = (TextView)findViewById(R.id.array);
        textSortedArray = (TextView)findViewById(R.id.sorted);
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
            Toast.makeText(lab6.this, "Enter number !", Toast.LENGTH_SHORT).show();
            editText.setHint("Here !");
        }

    }

    public void btnSortClick(View view){
        textSortedArray.setText("Sorted:");
        if (amountOfElements != 0)
        {
            int[] arr = new int[amountOfElements];
            for (int i = 0; i < amountOfElements; ++i) arr[i] = tempArray[i];
            sort(arr);
            for (int i = 0; i < amountOfElements; ++i) textSortedArray.append("  " + arr[i]);
        }
        else {
            Toast.makeText(lab6.this, "Enter at least one number !", Toast.LENGTH_SHORT).show();
            editText.setHint("Here !");
        }
    }



    public static void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }


    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }


    private static void heapify(int[] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && a[i] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 1;
    }

    private static int left(int i) {
        return 2 * i + 2;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
