package com.eagles.ira.calculator;

import android.content.Context;
import android.widget.Toast;

public class SqrtFromNegativeException extends Exception{

    SqrtFromNegativeException(){}

    SqrtFromNegativeException(Context context){
        Toast.makeText(context, "You can not work with negatives be this function ", Toast.LENGTH_LONG).show();
    }
}
