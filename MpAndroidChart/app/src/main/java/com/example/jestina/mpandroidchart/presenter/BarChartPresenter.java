package com.example.jestina.mpandroidchart.presenter;

import com.example.jestina.mpandroidchart.contract.BarChartContract;
import com.example.jestina.mpandroidchart.model.BarChartModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JESTINA on 2018-08-28.
 */

public class BarChartPresenter implements BarChartContract.Presenter {
    @Override
    public void initPresenter() {

    }


    /**
     * Bar Chart 를 위한 데이터 호출
     *
     * @return
     */
    @Override
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
