package com.example.jestina.mpandroidchart.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jestina.mpandroidchart.R;
import com.example.jestina.mpandroidchart.contract.PieChartContract;
import com.example.jestina.mpandroidchart.model.PieChartModel;
import com.example.jestina.mpandroidchart.presenter.PieChartPresenter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JESTINA on 2018-08-28.
 */

public class PieChartActivity extends AppCompatActivity implements PieChartContract.View {
    PieChartPresenter mPresenter;

    private PieChart mPieChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initPresenter();

        drawChart(mPresenter.getChartData());
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_pie_chart);

        mPieChart = (PieChart) findViewById(R.id.activity_pie_chart_chart);
    }

    @Override
    public void initPresenter() {
        mPresenter = new PieChartPresenter();
    }

    @Override
    public void drawChart(List<PieChartModel> pieChartModelList) {
        mPieChart.setUsePercentValues(true);
        mPieChart.getDescription().setEnabled(false);
        mPieChart.setExtraOffsets(5, 10, 5, 5);
        mPieChart.setDragDecelerationFrictionCoef(0.95f);
        mPieChart.setDrawHoleEnabled(false);
        mPieChart.setHoleColor(Color.WHITE);

        // Data input
        List<PieEntry> entries = new ArrayList<>();

        for(PieChartModel lists : pieChartModelList) {
            entries.add(new PieEntry((float) lists.getValue(), lists.getName()));
        }

        //  Description
        Description description = new Description();
        description.setText("원형 차트");
        description.setTextSize(15);
        mPieChart.setDescription(description);

        //  Animation
        mPieChart.animateY(1500, Easing.EasingOption.EaseInOutQuad);

        //  Data set
        PieDataSet dataSet = new PieDataSet(entries, "제목");
        dataSet.setSliceSpace(3f); // 각 데이터간 공백 영역
        dataSet.setSelectionShift(20f); // 해당 영역을 선택시 튀어나오는 거리
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS); // 여러색상

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        mPieChart.setData(data);
    }
}
