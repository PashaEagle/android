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

import java.util.Stack;

public class lab12 extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;

    Button btn_interpret;
    Button btn_calculate;
    Button btn_clear;

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab12);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        btn_interpret = (Button)findViewById(R.id.btn_interpret);
        btn_calculate = (Button)findViewById(R.id.btn_calculate);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);

        textView3.setText("");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4842f4")));
    }



    //**************************here*******************************

    public int getPriority(String x)
    {
        if (x == "+" || x == "-") return 2;
        if (x == "*" || x == "/") return 3;
        else return 1;
    }




    public void btnInterpretClick(View view){
        String t = String.valueOf(editText1.getText());
        String ans = "";
        int priority = 0;
        Stack<String> stack = new Stack<String>();
        char [] tex = t.toCharArray();
        String tt;
        for (int i = 0; i < t.length(); ++i)
        {
            tt = String.valueOf(tex[i]);
            if (tt.equals("(")) { stack.push(tt); continue; }
            else if (tt.equals("+")) priority = 2;
            else if (tt.equals("-")) priority = 2;
            else if (tt.equals("*")) priority = 3;
            else if (tt.equals("/")) priority = 3;
            else if (tt.equals(")"))
            {
                while (!stack.peek().equals("("))
                {
                    ans += stack.pop();
                }
                stack.pop();
                continue;
            }
            else

            {
                ans += tt;
                continue;
            }

            if (stack.size() == 0 || priority > getPriority(stack.peek())) { stack.push(tt); }
            else
            {
                while (stack.size() != 0 && priority <= getPriority(stack.peek()))                    {
                    ans += stack.pop();
                }
                stack.push(tt);
            }

        }
        while (stack.size() > 0)
        {
            ans += stack.pop();
        }

        editText2.setText(ans);

    }
    
    
    public void btnCalculateClick(View view){
        if (String.valueOf(editText2.getText()) == "") {     
            Toast.makeText(lab12.this, "Enter number !", Toast.LENGTH_SHORT).show();
            return;
        }
        String s1 = String.valueOf(editText2.getText());
        char [] str = s1.toCharArray();
        String tt;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s1.length(); ++i)
        {
            tt = String.valueOf(str[i]);
            if (tt.equals("+"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            }
            else if (tt.equals("-"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if (tt.equals("*"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            }
            else if (tt.equals("/"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
            else
            {
                try
                {
                    int a = Integer.parseInt(String.valueOf(tt));
                    stack.push(a);
                }
                catch (Exception e)
                {
                    int a = Character.getNumericValue(str[i]) - 9;
                    stack.push(a);
                }

            }
        }
        textView3.setText(String.valueOf(stack.pop()));
    }


    public void btnClearClick(View view){
        editText1.setText("");
        editText2.setText("");
        textView3.setText("");
    }




}
