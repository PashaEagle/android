package com.example.pasha.algo2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;

public class lab13 extends AppCompatActivity {

    EditText editTextP;
    EditText editTextQ;
    EditText editTextD;
    EditText editTextN;
    EditText editTextMessage;
    EditText editTextEncryptedMessage;
    EditText editTextDecryptedMessage;

    Button btn_encode;
    Button btn_decode;

    ArrayList<String> encryptedMessage;
    String decryptedMessage;

    char[] characters = new char[] { '#', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ',
            'Э', 'Ю', 'Я', 'І', ' ', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '0', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и',
            'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
            'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ',
            'э', 'ю', 'я', 'і', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', ',','.','!','?','/'    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab13);

        editTextP = (EditText)findViewById(R.id.editTextP);
        editTextQ = (EditText)findViewById(R.id.editTextQ);
        editTextD = (EditText)findViewById(R.id.editTextD);
        editTextN = (EditText)findViewById(R.id.editTextN);
        editTextMessage = (EditText)findViewById(R.id.editTextMessage);
        editTextEncryptedMessage = (EditText)findViewById(R.id.editTextEncryptedMessage);
        editTextDecryptedMessage = (EditText)findViewById(R.id.editTextDecryptedMessage);

        btn_encode = (Button)findViewById(R.id.btn_encode);
        btn_decode = (Button)findViewById(R.id.btn_decode);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4842f4")));
    }

    private boolean IsTheNumberSimple(long n)
    {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        for (long i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public void btnEncodeClick(View view){
        try{
            if (String.valueOf(editTextP.getText()) != "" && String.valueOf(editTextP.getText()) != ""){
                long p = Long.parseLong(String.valueOf(editTextP.getText()));
                long q = Long.parseLong(String.valueOf(editTextQ.getText()));

                if (IsTheNumberSimple(p) && IsTheNumberSimple(q))
                {
                    String s = String.valueOf(editTextMessage.getText());

                    long n = p * q;
                    long m = (p - 1) * (q - 1);
                    long d = Calculate_d(m);
                    long e_ = Calculate_e(d, m);

                    encryptedMessage = RSA_Encode(s, e_, n);

                    editTextEncryptedMessage.setText(String.valueOf(encryptedMessage));
                    editTextD.setText(String.valueOf(d));
                    editTextN.setText(String.valueOf(n));
                }
                else
                    Toast.makeText(lab13.this, "Public key numbers are not simple !", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(lab13.this, "Enter numbers of public key, p and q !", Toast.LENGTH_SHORT).show();

            }

        }catch(Exception e){
            Toast.makeText(lab13.this, "Enter numbers of public key, p and q !", Toast.LENGTH_SHORT).show();
        }
    }


    //зашифровать
    private ArrayList<String> RSA_Encode(String s, long e, long n)
    {
        char[] ss = s.toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        BigInteger bi;

        for (int i = 0; i < s.length(); i++)
        {
            int index = 0;
            for (int j = 0; j < characters.length; ++j){
                if (characters[j] == ss[i]){
                    index = j;
                    break;
                }
            }
            bi = BigInteger.valueOf(index);
            bi = bi.pow((int)e);
            BigInteger n_ = BigInteger.valueOf(n);
            bi = bi.mod(n_);
            result.add(String.valueOf(bi));
        }
        return result;
    }

    //расшифровать
    private String RSA_Decode(ArrayList<String> input, long d, long n)
    {
        String result = "";
        BigInteger bi, res;
        String item;
        for(int i = 0; i < input.size(); ++i)
        {
            item = input.get(i);
            bi = new BigInteger(item);
            bi = bi.pow((int)d);
            BigInteger n_ = BigInteger.valueOf(n);
            res = bi.mod(n_);
            int index = Integer.parseInt(String.valueOf(res));
            result += characters[index];
        }
        return result;
    }

    //вычисление параметра d. d должно быть взаимно простым с m
    private long Calculate_d(long m)
    {
        long d = m - 1;
        for (long i = 2; i <= m; i++)
            if ((m % i == 0) && (d % i == 0)) //если имеют общие делители
            {
                d--; i = 1;
            }
        return d;
    }

    //вычисление параметра e
    private long Calculate_e(long d, long m)
    {
        long e = 3;
        while (true)
        {
            if ((e * d) % m == 1)
                break;
            else e++;
        }
        return e;
    }

    public void btnDecodeClick(View view){
       // try{
            if (String.valueOf(editTextD.getText()) != "" && String.valueOf(editTextN.getText()) != "")
            {
                long d = Long.parseLong(String.valueOf(editTextD.getText()));
                long n = Long.parseLong(String.valueOf(editTextN.getText()));

                decryptedMessage = RSA_Decode(encryptedMessage, d, n);
                editTextDecryptedMessage.setText(decryptedMessage);
                Toast.makeText(lab13.this, "Successfully decrypted !", Toast.LENGTH_SHORT).show();

            }
            else
                Toast.makeText(lab13.this, "Please, enter private key !", Toast.LENGTH_SHORT).show();
        /*}catch(Exception e){
            Toast.makeText(lab13.this, "Enter numbers private key!", Toast.LENGTH_SHORT).show();
        }*/

    }


}
