package com.example.jestina.mpandroidchart.presenter;

import com.example.jestina.mpandroidchart.contract.PieChartContract;
import com.example.jestina.mpandroidchart.model.BarChartModel;
import com.example.jestina.mpandroidchart.model.PieChartModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JESTINA on 2018-08-28.
 */

public class PieChartPresenter implements PieChartContract.Presenter {
    @Override
    public void initPresenter() {

    }

    @Override
    public List<PieChartModel> getChartData() {
        List<PieChartModel> pieChartModelList = new ArrayList<>();

        for(int i=0; i<6; i++) {
            pieChartModelList.add(
                    new PieChartModel.Builder()
                            .name("tester " + i)
                            .value(Math.random() * 200)
                            .build()
            );
        }

        return pieChartModelList;
    }
}
