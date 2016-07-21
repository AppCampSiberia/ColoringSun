package com.example.sonya.coloringsun;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle("О приложении");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // если кнопка - это кнопка назад
        if (item.getItemId() == android.R.id.home) {
            // взять редактор настроек приложения
            SharedPreferences.Editor editor = getSharedPreferences("my_preferences", MODE_PRIVATE).edit();
            // положить в настройки приложения строку
            //editor.putString("name", newEdittext.getText().toString());
            // сохранить настройки приложения
            editor.commit();
            // закрыть экран и вернуться на предыдущий
            finish(); // close this activity and return to previous activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


}
