package com.example.jestina.mpandroidchart.contract;

import com.example.jestina.mpandroidchart.model.BarChartModel;
import com.example.jestina.mpandroidchart.presenter.BasePresenter;
import com.example.jestina.mpandroidchart.view.BarChartActivity;
import com.example.jestina.mpandroidchart.view.BaseView;

import java.util.List;

/**
 * Created by JESTINA on 2018-08-28.
 */

public interface BarChartContract {
    interface View extends BaseView {
        /**
         * BarChart 를 Activity View 에 그려줌
         *
         * @param barChartModelList {@link BarChartModel} 리스트
         */
        void drawChart(List<BarChartModel> barChartModelList);
    }

    interface Presenter extends BasePresenter {
        /**
         * Bar Chart 를 그리기 위한 데이터 get
         *
         * @return {@link BarChartModel} List
         */
        List<BarChartModel> getChartData();
    }
}
