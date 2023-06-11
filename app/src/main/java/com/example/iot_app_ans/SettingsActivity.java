package com.example.iot_app_ans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {
    Button Statistic;
    Button Home;

    Button Ustawienia_urzadzenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Statistic = (Button)findViewById(R.id.statisticButton_urz);

        Statistic.setOnClickListener(view -> openStatistic());

        Home = (Button)findViewById(R.id.Home_urz);

        Home.setOnClickListener(view -> openHome());

        Ustawienia_urzadzenia = (Button)findViewById(R.id. ust_urz);

        Ustawienia_urzadzenia.setOnClickListener(view -> openUst_urz());


    }

    private void openUst_urz() {
        Intent intent = new Intent(this, SettingsActivity_ust_urz.class);
        startActivity(intent);
    }

    private void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openStatistic() {
        Intent intent = new Intent(this, StatisticActivity.class);
        startActivity(intent);
    }

}
