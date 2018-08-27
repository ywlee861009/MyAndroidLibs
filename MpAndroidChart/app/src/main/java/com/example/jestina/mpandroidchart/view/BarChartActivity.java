package com.example.jestina.mpandroidchart.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jestina.mpandroidchart.R;
import com.example.jestina.mpandroidchart.contract.BarChartContract;
import com.example.jestina.mpandroidchart.model.BarChartModel;
import com.example.jestina.mpandroidchart.presenter.BarChartPresenter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JESTINA on 2018-08-28.
 */
public class BarChartActivity extends AppCompatActivity implements BarChartContract.View {
    BarChartPresenter mPresenter;

    private BarChart mBarChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initPresenter();

        drawChart(mPresenter.getChartData());
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_bar_chart);

        mBarChart = (BarChart) findViewById(R.id.activity_bar_chart_chart);
    }

    @Override
    public void initPresenter() {
        mPresenter = new BarChartPresenter();
    }

    @Override
    public void drawChart(List<BarChartModel> barChartModelList) {
        List<BarEntry> entries = new ArrayList<>();

        for(int i=0; i<barChartModelList.size(); i++) {
            entries.add(new BarEntry(barChartModelList.get(i).getMonth(),
                    barChartModelList.get(i).getSellingAmount()));
        }

        BarDataSet barDataSet = new BarDataSet(entries, "판매량");

        BarData barData = new BarData(barDataSet);

        mBarChart.setData(barData);
        mBarChart.setNoDataText("결과가 없습니다.");
        mBarChart.setNoDataTextColor(Color.GRAY);
        mBarChart.setFitBars(true);
        mBarChart.animateXY(2000, 2000);
        mBarChart.invalidate();
    }
}
