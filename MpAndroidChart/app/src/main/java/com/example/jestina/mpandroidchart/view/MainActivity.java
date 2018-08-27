package com.example.jestina.mpandroidchart.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jestina.mpandroidchart.R;
import com.example.jestina.mpandroidchart.contract.MainContract;
import com.example.jestina.mpandroidchart.presenter.MainPresenter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    MainPresenter mainPresenter;

    private BarChart mBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initPresenter();

        drawChart();
    }


    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

        mBarChart = (BarChart) findViewById(R.id.activity_main_chart);
    }

    @Override
    public void initPresenter() {
        mainPresenter = new MainPresenter();
    }

    private void drawChart() {
        List<BarEntry> entries = new ArrayList<BarEntry>();

        int sum = 0;
        for(int i=0; i<20; i++) {
            sum += i;
            entries.add(new BarEntry((float) i, sum));
        }

        BarDataSet barDataSet = new BarDataSet(entries, "test");

        BarData barData = new BarData(barDataSet);

        mBarChart.setData(barData);
        mBarChart.setFitBars(false);
        mBarChart.animateXY(1000, 1000);
        mBarChart.invalidate();
    }
}
