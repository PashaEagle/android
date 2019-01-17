package com.kolesn.pasha.calculator;

import android.content.Context;
import android.widget.Toast;

public class Calculator {
    private Context context;

    public void setContext(Context context){
        this.context = context;
    }

    public static Double Add(Double x, Double y){
        return x + y;
    }

    public static Double Substract(Double x, Double y){
        return x - y;
    }

    public static Double Multiply(Double x, Double y){
        return x * y;
    }

    public static Double Divide(Double x, Double y)throws DividingByNullException{
        try{
            if (y == 0) throw new DividingByNullException();
            return x / y;
        }
        catch (DividingByNullException e){
            return 0.0;
        }
    }

    public static Double Equal(Double x, Double y, CalculatorOperation operation) throws DividingByNullException {
        switch (operation) {
            case ADD:
                return Add(x, y);
            case SUBSTRACT:
                return Substract(x, y);
            case MULTIPLY:
                return Multiply(x, y);
            case DIVIDE:
                return Divide(x, y);
            case POW:
                return Pow(x, y);
            default:
                return null;
        }
    }

    public static Double Pow(Double x, Double y){
        return Math.pow(x, y);
    }

    public static Double Sin(Double x){
        return Math.sin(x);
    }

    public static Double Cos(Double x){
        return Math.cos(x);
    }

    public static Double Tan(Double x){
        return Math.tan(x);
    }

    public static Double Cot(Double x){
        return (1.0 / Math.tan(x));
    }

    public static Double Log(Double x){
        return Math.log(x);
    }

    public static Double Sqrt(Double x){
        return Math.sqrt(x);
    }

    public static Double Percent(Double x){
        return x / 100.0;
    }
}
