package com.example.pasha.algo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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


    /**
     * Сортировка с помощью кучи.
     * Сначала формируется куча:
     * @see lab7#buildHeap(int[])
     * Теперь максимальный элемент массива находится в корне кучи. Его нужно
     * поменять местами с последним элементом и убрать из кучи (уменьшить
     * размер кучи на 1). Теперь в корне кучи находится элемент, который раньше
     * был последним в массиве. Нужно переупорядочить кучу так, чтобы
     * выполнялось основное условие кучи - a[parent]>=a[child]:
     * @see #heapify(int[], int)
     * После этого в корне окажется максимальный из оставшихся элементов.
     * Повторить до тех пор, пока в куче не останется 1 элемент
     *
     * @param a сортируемый массив
     */
    public static void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    /**
     * Построение кучи. Поскольку элементы с номерами начиная с a.length / 2 + 1
     * это листья, то нужно переупорядочить поддеревья с корнями в индексах
     * от 0 до a.length / 2 (метод heapify вызывать в порядке убывания индексов)
     *
     * @param a - массив, из которого формируется куча
     */
    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    /**
     * Переупорядочивает поддерево кучи начиная с узла i так, чтобы выполнялось
     * основное свойство кучи - a[parent] >= a[child].
     *
     * @param a - массив, из которого сформирована куча
     * @param i - корень поддерева, для которого происходит переупорядочивание
     */
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

    /**
     * Возвращает индекс правого потомка текущего узла
     *
     * @param i индекс текущего узла кучи
     * @return индекс правого потомка
     */
    private static int right(int i) {
        return 2 * i + 1;
    }

    /**
     * Возвращает индекс левого потомка текущего узла
     *
     * @param i индекс текущего узла кучи
     * @return индекс левого потомка
     */
    private static int left(int i) {
        return 2 * i + 2;
    }

    /**
     * Меняет местами два элемента в массиве
     *
     * @param a массив
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
