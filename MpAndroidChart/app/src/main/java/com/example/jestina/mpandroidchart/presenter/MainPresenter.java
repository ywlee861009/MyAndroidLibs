package com.example.jestina.mpandroidchart.presenter;

import com.example.jestina.mpandroidchart.contract.MainContract;
import com.example.jestina.mpandroidchart.model.BarChartModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JESTINA on 2018-08-27.
 */

public class MainPresenter implements MainContract.Presenter {
    @Override
    public void initPresenter() {

    }

    public List<BarChartModel> getChartData() {
        List<BarChartModel> barChartDataArr = new ArrayList<>();

        for(int i=0; i<12; i++) {
             barChartDataArr.add(
                     new BarChartModel.Builder()
                        .month(i)
                        .setSellingAmount((int) (Math.random() * 1000))
                        .build()
            );
        }

        return barChartDataArr;
    }
}
