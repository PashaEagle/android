package com.example.converter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.converter_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // отримуємо ід вибраного пункту меню
        int id = item.getItemId();

        // В залежності від вибраного пункту виконуємо певну реалізацію
        switch (id) {
            case R.id.set_en:
                Toast.makeText(MainActivity.this, "Set english language!", Toast.LENGTH_LONG).show();
                setLocale("en");
                return true;
            case R.id.set_uk:
                Toast.makeText(MainActivity.this, "Встановлено українську мову!", Toast.LENGTH_LONG).show();
                setLocale("uk");
                return true;
        }
    }


    private Locale mNewLocale;

    void setLocale(String mLang) {// mLang – вхідний параметр функції
        mNewLocale = new Locale(mLang);//створюємо екземпляр класу Locale у відповідній до параметру мові
        Locale.setDefault(mNewLocale);//встановлюємо мову
        android.content.res.Configuration config = new android.content.res.Configuration();//достукуємося до конфігурації додатку
        config.locale = mNewLocale;//встановлюємо мову в конфігурації
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());//приймаємо зміни конфігурації

        setContentView(R.layout.activity_main);//пере підключаємо вигляд екрану додатку, тим самим перезавантажуючи його для того щоб компоненти підгрузили значення із ресурсів відповідно до завантаженої мови
    }


}
