package com.example.iot_app_ans;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.graphics.Color;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.ArrayList;
import java.util.List;
import android.view.MotionEvent;
import android.widget.Button;
public class StatisticActivity2 extends AppCompatActivity {
    float x1, x2, y1, y2;
    private LineChart chart;
    Button Settings;
    Button Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statystyki2);
        chart = findViewById(R.id.chart);
        createTemperatureChart();

        Settings = (Button) findViewById(R.id.settings5);

        Settings.setOnClickListener(view -> openSettigns());

        Home = (Button) findViewById(R.id.home5);
        Home.setOnClickListener(view -> openHome());

    }

    private void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openSettigns() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void createTemperatureChart() {
        String[] daysOfWeek = {"Pon", "Wto", "Śro", "Czw", "Pią", "Sob", "Nie"};
        float[] temperatureValues = {35f, 29f, 33f, 32f, 39f, 33f, 36f};

        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < daysOfWeek.length; i++) {
            entries.add(new Entry(i, temperatureValues[i]));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Wilgotność (%)");
        dataSet.setColor(Color.parseColor("#62AFCD"));
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(13f); // Zwiększenie rozmiaru czcionki dla wartości

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        Description description = new Description();
        description.setText("Wilgotność w stosunku do dni tygodnia");
        description.setTextSize(12f); // Zwiększenie rozmiaru czcionki dla opisu
        chart.setDescription(description);

        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                int index = (int) value;
                if (index >= 0 && index < daysOfWeek.length) {
                    return daysOfWeek[index];
                }
                return "";
            }
        });
        xAxis.setTextSize(11f); // Zwiększenie rozmiaru czcionki dla etykiet osi X

        YAxis yAxis = chart.getAxisLeft();
        yAxis.setTextSize(12f); // Zwiększenie rozmiaru czcionki dla etykiet osi Y

        chart.invalidate();
    }

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if (x1 > x2) {
                    Intent i = new Intent(this, StatisticActivity3.class);
                    startActivity(i);
                }
                else if(x1 < x2){
                    Intent i = new Intent(this, StatisticActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}