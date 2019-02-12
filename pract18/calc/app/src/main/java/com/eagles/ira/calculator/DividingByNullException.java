package com.eagles.ira.calculator;

import android.content.Context;
import android.widget.Toast;

public class DividingByNullException extends Exception {

    DividingByNullException(){

    }

    DividingByNullException(Context context){
        Toast.makeText(context, "You can not divide by 0", Toast.LENGTH_LONG).show();
    }
}