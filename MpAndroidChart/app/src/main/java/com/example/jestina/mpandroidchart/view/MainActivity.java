package com.example.jestina.mpandroidchart.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jestina.mpandroidchart.R;
import com.example.jestina.mpandroidchart.contract.MainContract;
import com.example.jestina.mpandroidchart.model.BarChartModel;
import com.example.jestina.mpandroidchart.presenter.MainPresenter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    MainPresenter mainPresenter;

    private Button mBtnGoBarChart;
    private Button mBtnGoPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initPresenter();

    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

        mBtnGoBarChart = (Button) findViewById(R.id.activity_main_btn_go_bar_chart);
        mBtnGoBarChart.setOnClickListener(onClickListener);

        mBtnGoPieChart = (Button) findViewById(R.id.activity_main_btn_go_pie_chart);
        mBtnGoPieChart.setOnClickListener(onClickListener);
    }

    @Override
    public void initPresenter() {
        mainPresenter = new MainPresenter();
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.activity_main_btn_go_bar_chart:
                    goBarChartActivity();
                    break;

                case R.id.activity_main_btn_go_pie_chart:
                    goPieChartActivity();
                    break;
            }
        }
    };

    @Override
    public void goBarChartActivity() {
        startActivity(new Intent(MainActivity.this, BarChartActivity.class));
    }

    @Override
    public void goPieChartActivity() {
        startActivity(new Intent(MainActivity.this, PieChartActivity.class));
    }
}