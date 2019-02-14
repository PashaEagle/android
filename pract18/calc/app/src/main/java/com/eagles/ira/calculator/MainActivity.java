package com.eagles.ira.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CalculatorOperation currentOperation;

    private TextView txt_result;
    private String secretSecondArg;

    private Double firstArg;
    private Double secondArg;
    private Boolean firstArgLastDot;
    private Boolean firstArgHasDot;
    private Boolean secondArgHasDot;
    private Boolean secondArgLastDot;
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_plus;
    private Button btn_substract;
    private Button btn_multiply;
    private Button btn_divide;
    private Button btn_dot;
    private Button btn_equal;
    private Button btn_clear;
    private Button btn_sin;
    private Button btn_cos;
    private Button btn_tan;
    private Button btn_cot;
    private Button btn_log;
    private Button btn_pow;
    private Button btn_sqrt;
    private Button btn_percent;
    private Button btn_backspace;

    private LinearLayout engineer_layout;

    //When the form is ruuning
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstArg = null;
        secondArg = null;
        firstArgLastDot = false;
        secondArgLastDot = false;
        firstArgHasDot = false;
        secondArgHasDot = false;
        currentOperation = CalculatorOperation.NULL;

        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_substract = (Button)findViewById(R.id.btn_substract);
        btn_multiply = (Button)findViewById(R.id.btn_multiply);
        btn_divide = (Button)findViewById(R.id.btn_divide);
        btn_dot = (Button)findViewById(R.id.btn_dot);
        btn_equal = (Button)findViewById(R.id.btn_equal);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        btn_sin = (Button)findViewById(R.id.btn_sin);
        btn_cos = (Button)findViewById(R.id.btn_cos);
        btn_tan = (Button)findViewById(R.id.btn_tan);
        btn_cot = (Button)findViewById(R.id.btn_cot);
        btn_log = (Button)findViewById(R.id.btn_log);
        btn_pow = (Button)findViewById(R.id.btn_pow);
        btn_sqrt = (Button)findViewById(R.id.btn_sqrt);
        btn_backspace = (Button)findViewById(R.id.btn_backspace);
        txt_result = (TextView)findViewById(R.id.txt_result);
        btn_percent = (Button)findViewById(R.id.btn_percent);
        engineer_layout = (LinearLayout)findViewById(R.id.linearLayout2);

        engineer_layout.setVisibility(View.INVISIBLE);

        //Check the button
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){

                    case R.id.btn_0:
                        digitButtonHandler("0");
                        break;

                    case R.id.btn_1:
                        digitButtonHandler("1");
                        break;

                    case R.id.btn_2:
                        digitButtonHandler("2");
                        break;

                    case R.id.btn_3:
                        digitButtonHandler("3");
                        break;

                    case R.id.btn_4:
                        digitButtonHandler("4");
                        break;

                    case R.id.btn_5:
                        digitButtonHandler("5");
                        break;

                    case R.id.btn_6:
                        digitButtonHandler("6");
                        break;

                    case R.id.btn_7:
                        digitButtonHandler("7");
                        break;

                    case R.id.btn_8:
                        digitButtonHandler("8");
                        break;

                    case R.id.btn_9:
                        digitButtonHandler("9");
                        break;

                    case R.id.btn_plus:
                        operationButtonHandler(CalculatorOperation.ADD);
                        break;

                    case R.id.btn_substract:
                        operationButtonHandler(CalculatorOperation.SUBSTRACT);
                        break;

                    case R.id.btn_multiply:
                        operationButtonHandler(CalculatorOperation.MULTIPLY);
                        break;

                    case R.id.btn_divide:
                        operationButtonHandler(CalculatorOperation.DIVIDE);
                        break;

                    case R.id.btn_equal:
                        try {
                            equalButtonHandler();
                        } catch (DividingByNullException e) {
                            Toast.makeText(MainActivity.this, "111You can not divide by 0", Toast.LENGTH_LONG).show();
                        }
                         //catch(SqrtFromNegativeException e){
                             //Toast.makeText(MainActivity.this, "111You can not work with negatives", Toast.LENGTH_LONG).show();
                         //}
                        break;

                    case R.id.btn_clear:
                        clearButtonHandler();
                        break;

                    case R.id.btn_dot:
                        dotButtonHandler();
                        break;

                    case R.id.btn_pow:
                        operationButtonHandler(CalculatorOperation.POW);
                        break;

                    case R.id.btn_sin:
                        funcButtonHandler(CalculatorOperation.SIN);
                        break;

                    case R.id.btn_cos:
                        funcButtonHandler(CalculatorOperation.COS);
                        break;

                    case R.id.btn_tan:
                        funcButtonHandler(CalculatorOperation.TAN);
                        break;

                    case R.id.btn_cot:
                        funcButtonHandler(CalculatorOperation.COT);
                        break;

                    case R.id.btn_log:
                        funcButtonHandler(CalculatorOperation.LOG);
                        break;

                    case R.id.btn_sqrt:
                        funcButtonHandler(CalculatorOperation.SQRT);
                        break;

                    case R.id.btn_percent:
                        funcButtonHandler(CalculatorOperation.PERCENT);
                        break;

                    case R.id.btn_backspace:
                        backspaceButtonHandler();
                        break;
                }
            }
        };


        btn_0.setOnClickListener(onClickListener);
        btn_1.setOnClickListener(onClickListener);
        btn_2.setOnClickListener(onClickListener);
        btn_3.setOnClickListener(onClickListener);
        btn_4.setOnClickListener(onClickListener);
        btn_5.setOnClickListener(onClickListener);
        btn_6.setOnClickListener(onClickListener);
        btn_7.setOnClickListener(onClickListener);
        btn_8.setOnClickListener(onClickListener);
        btn_9.setOnClickListener(onClickListener);
        btn_plus.setOnClickListener(onClickListener);
        btn_substract.setOnClickListener(onClickListener);
        btn_multiply.setOnClickListener(onClickListener);
        btn_divide.setOnClickListener(onClickListener);
        btn_dot.setOnClickListener(onClickListener);
        btn_equal.setOnClickListener(onClickListener);
        btn_clear.setOnClickListener(onClickListener);
        btn_sin.setOnClickListener(onClickListener);
        btn_cos.setOnClickListener(onClickListener);
        btn_tan.setOnClickListener(onClickListener);
        btn_cot.setOnClickListener(onClickListener);
        btn_log.setOnClickListener(onClickListener);
        btn_pow.setOnClickListener(onClickListener);
        btn_sqrt.setOnClickListener(onClickListener);
        btn_percent.setOnClickListener(onClickListener);
        btn_backspace.setOnClickListener(onClickListener);

    }


    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //Checking mode
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.engineerMode:
                engineer_layout.setVisibility(View.VISIBLE);
                return true;
            case R.id.simpleMode:
                engineer_layout.setVisibility(View.INVISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Digit Button
    public void digitButtonHandler(String text){
        if (txt_result.getText().toString().equals("0")) txt_result.setText("");
        if (currentOperation.equals(CalculatorOperation.NULL)){
            txt_result.append(text);
            firstArg = Double.parseDouble(txt_result.getText().toString());
            if (firstArgLastDot) firstArgLastDot = false;
        }
        else if(!currentOperation.equals(CalculatorOperation.NULL)){
            if (secondArg == null){
                secretSecondArg = "";
            }
            txt_result.append(text);
            if (secondArgLastDot){
                secretSecondArg += ".";
                secondArgLastDot = false;
            }
            secretSecondArg += text;
            secondArg = Double.parseDouble(secretSecondArg);

        }
    }

    //Button operations (+ - / * ^)
    public void operationButtonHandler(CalculatorOperation calculatorOperation) {
        if (firstArgLastDot || secondArgLastDot) {
            Toast.makeText(MainActivity.this, "Type digit after point firstly", Toast.LENGTH_SHORT).show();
            return;
        }
        if (currentOperation.equals(CalculatorOperation.POW) && firstArg < 0 && secondArgHasDot){
            Toast.makeText(MainActivity.this, "Cannot find root of negative", Toast.LENGTH_SHORT).show();
            return;
        }

        if (firstArg == null) return;
        if (firstArg != null && secondArg == null){
            secondArg = null;
            secondArgHasDot = false;
            secondArgLastDot = false;
            if (!currentOperation.equals(CalculatorOperation.NULL)){
                txt_result.setText(firstArg.toString());
            }
            currentOperation = calculatorOperation;
            String textToAdd = "null";
            switch(calculatorOperation){
                case ADD:
                    textToAdd = getResources().getString(R.string.btn_plus);
                    break;
                case SUBSTRACT:
                    textToAdd = getResources().getString(R.string.btn_substract);
                    break;
                case MULTIPLY:
                    textToAdd = getResources().getString(R.string.btn_multiply);
                    break;
                case DIVIDE:
                    textToAdd = getResources().getString(R.string.btn_divide);
                    break;
                case POW:
                    textToAdd = getResources().getString(R.string.btn_pow);
                    break;
            }
            txt_result.append(textToAdd);
        }
        else if (secondArg != null){
            if (currentOperation.equals(CalculatorOperation.DIVIDE) && secondArg == 0){
                Toast.makeText(MainActivity.this, "Dividing by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            Double res;
            try{
                 res = Calculator.Equal(firstArg, secondArg, currentOperation);
            } catch(Exception ex){
                return;
            }

            String[] splitter = String.valueOf(res).split("\\.");
            if (splitter[1].length() > 8){
                txt_result.setText(String.format("%.8f", res).replace(',','.'));
            }
            else if (splitter[1].equals("0")){
                double res_d = res.doubleValue();
                int res_i = (int)res_d;
                Integer res_I = Integer.valueOf(res_i);
                txt_result.setText(res_I.toString());
            }
            else{
                txt_result.setText(res.toString());
            }

            firstArg = Double.parseDouble(txt_result.getText().toString());
            secondArg = null;
            currentOperation = CalculatorOperation.NULL;



            currentOperation = calculatorOperation;
            String textToAdd = "null";
            switch(calculatorOperation){
                case ADD:
                    textToAdd = getResources().getString(R.string.btn_plus);
                    break;
                case SUBSTRACT:
                    textToAdd = getResources().getString(R.string.btn_substract);
                    break;
                case MULTIPLY:
                    textToAdd = getResources().getString(R.string.btn_multiply);
                    break;
                case DIVIDE:
                    textToAdd = getResources().getString(R.string.btn_divide);
                    break;
                case POW:
                    textToAdd = getResources().getString(R.string.btn_pow);
                    break;
            }
            txt_result.append(textToAdd);

        }

    }

    //Button equal
    public void equalButtonHandler() throws DividingByNullException {
        if (firstArg == null || secondArg == null || currentOperation.equals(CalculatorOperation.NULL) || firstArgLastDot || secondArgLastDot)
            return;
        if (currentOperation.equals(CalculatorOperation.DIVIDE) && secondArg == 0){
            Toast.makeText(MainActivity.this, "Dividing by zero", Toast.LENGTH_SHORT).show();
            return;
        }
        if (currentOperation.equals(CalculatorOperation.POW) && firstArg < 0 && secondArgHasDot){
            Toast.makeText(MainActivity.this, "Cannot find root of negative", Toast.LENGTH_SHORT).show();
            return;
        }
        Double res = Calculator.Equal(firstArg, secondArg, currentOperation);
        String[] splitter = String.valueOf(res).split("\\.");
        if (splitter[1].length() > 8){
            txt_result.setText(String.format("%.8f", res).replace(',','.'));
        }
        else if (splitter[1].equals("0")){
            double res_d = res.doubleValue();
            int res_i = (int)res_d;
            Integer res_I = Integer.valueOf(res_i);
            txt_result.setText(res_I.toString());
        }
        else{
            txt_result.setText(res.toString());
        }

        firstArg = Double.parseDouble(txt_result.getText().toString());
        secondArg = null;
        currentOperation = CalculatorOperation.NULL;
    }

    //Delete button
    public void backspaceButtonHandler(){
        if (txt_result.getText().toString().equals("0") || firstArg == null) return;
        if (txt_result.getText().toString().length() == 1){
            txt_result.setText("0");
            firstArg = null; secondArg = null; firstArgHasDot = false; secondArgHasDot = false;
            currentOperation = CalculatorOperation.NULL;
            return;
        }
        int len = txt_result.getText().toString().length();
        char lastChar = txt_result.getText().toString().charAt(len-1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == '*' || lastChar == '^'){
            currentOperation = CalculatorOperation.NULL;
            secondArg = null;
        } else if (lastChar == '.'){
            if (firstArgLastDot) {
                firstArgLastDot = false;
                firstArgHasDot = false;
            }
            else if (secondArgLastDot){
                secondArgHasDot = false;
                secondArgLastDot = false;
                String stash = secretSecondArg;
                secretSecondArg = "";
                for (int i = 0; i < stash.length() - 1; ++i) secretSecondArg += stash.charAt(i);
            }
        }
        else if (secondArg != null){
            String stash = secretSecondArg;
            secretSecondArg = "";

            if (stash.length() == 1){
                secondArg = null;
            } else {
                for (int i = 0; i < stash.length() - 1; ++i) secretSecondArg += stash.charAt(i);
            }
            if (secretSecondArg.length() > 1 && secretSecondArg.charAt(secretSecondArg.length() - 1) == '.'){
                secondArgLastDot = true;
                secondArgHasDot = true;
            }
        } else if (firstArg != null){
            String stash = firstArg.toString();
            if (stash.length() == 1) firstArg = null;
            else {
                String stashFirst = "";
                for (int i = 0; i < stash.length() - 1; ++i) stashFirst += stash.charAt(i);
                if (stashFirst.charAt(stashFirst.length() - 1) == '.'){
                    firstArgLastDot = true;
                    firstArgHasDot = true;
                    String stashFirstWithoutDot = "";
                    for (int i = 0; i < stashFirst.length() - 1; ++i) stashFirstWithoutDot += stash.charAt(i);
                    firstArg = Double.parseDouble(stashFirstWithoutDot);
                } else
                    try {
                        firstArg = Double.parseDouble(stashFirst);
                    } catch(Exception e){
                        Toast.makeText(MainActivity.this, "Error occured, please clear all", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

        }

        String newTxtResult = "";
        for (int i = 0; i < len - 1; ++i) newTxtResult += txt_result.getText().toString().charAt(i);
        txt_result.setText(newTxtResult);

    }

    //clear
    public void clearButtonHandler(){
        txt_result.setText("0");
        firstArg = null;
        secondArg = null;
        secretSecondArg = "null";
        currentOperation = CalculatorOperation.NULL;
        firstArgLastDot = false;
        secondArgLastDot = false;
        firstArgHasDot = false;
        secondArgHasDot = false;
    }

    //Dot
    public void dotButtonHandler(){
        if (currentOperation.equals(CalculatorOperation.NULL)){
            if (firstArg == null) return;
            if (firstArgHasDot) return;
            txt_result.append(".");
            firstArgLastDot = true;
            firstArgHasDot = true;
        }
        else{
            if (secondArg == null) return;
            if (secondArgHasDot) return;
            txt_result.append(".");
            secondArgLastDot = true;
            secondArgHasDot = true;
        }
    }

    // (sin, cos..)
    public void funcButtonHandler(CalculatorOperation calculatorOperation) {
        if (firstArg != null && !firstArgLastDot && secondArg == null && currentOperation.equals(CalculatorOperation.NULL)){
            Double res = 0.0;
            switch(calculatorOperation){
                case SIN:
                    res = Calculator.Sin(Double.parseDouble(txt_result.getText().toString()));
                    break;

                case COS:
                    res = Calculator.Cos(Double.parseDouble(txt_result.getText().toString()));
                    break;

                case TAN:
                    res = Calculator.Tan(Double.parseDouble(txt_result.getText().toString()));
                    break;

                case COT:
                    if (Math.tan(Double.parseDouble(txt_result.getText().toString())) == 0){
                        Toast.makeText(MainActivity.this, "Cotangens of this number doesn`t exists", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    res = Calculator.Cot(Double.parseDouble(txt_result.getText().toString()));
                    break;

                case LOG:
                    if (Double.parseDouble(txt_result.getText().toString()) <= 0){
                        Toast.makeText(MainActivity.this, "Cannot find logariphm of negative number", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    res = Calculator.Log(Double.parseDouble(txt_result.getText().toString()));
                    break;

                case SQRT:
                    if (Double.parseDouble(txt_result.getText().toString()) < 0){
                        Toast.makeText(MainActivity.this, "Cannot find sqrt of negative number", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    res = Calculator.Sqrt(Double.parseDouble(txt_result.getText().toString()));
                    break;

                case PERCENT:
                    res = Calculator.Percent(Double.parseDouble(txt_result.getText().toString()));
                    break;
            }
            String[] splitter = String.valueOf(res).split("\\.");
            if (splitter[1].length() > 8){
                txt_result.setText(String.format("%.8f", res).replace(',','.'));
            }
            else if (splitter[1].equals("0")){
                double res_d = res.doubleValue();
                int res_i = (int)res_d;
                Integer res_I = Integer.valueOf(res_i);
                txt_result.setText(res_I.toString());
            }
            else{
                txt_result.setText(res.toString());
            }

            firstArg = Double.parseDouble(txt_result.getText().toString());
            secondArg = null;
            currentOperation = CalculatorOperation.NULL;
        }
        else{
            Toast.makeText(MainActivity.this, "This function works only with 1 argument, please check input", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}