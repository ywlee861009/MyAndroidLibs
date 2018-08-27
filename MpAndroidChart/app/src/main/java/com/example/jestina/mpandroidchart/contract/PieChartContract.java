package com.example.jestina.mpandroidchart.contract;

import com.example.jestina.mpandroidchart.model.BarChartModel;
import com.example.jestina.mpandroidchart.model.PieChartModel;
import com.example.jestina.mpandroidchart.presenter.BasePresenter;
import com.example.jestina.mpandroidchart.view.BaseView;

import java.util.List;

/**
 * Created by JESTINA on 2018-08-28.
 */

public interface PieChartContract {
    interface View extends BaseView {
        /**
         * Pie Chart 를 Activity View 에 그려줌
         *
         * @param pieChartModelList {@link PieChartModel} 리스트
         */
        void drawChart(List<PieChartModel> pieChartModelList);
    }

    interface Presenter extends BasePresenter {
        /**
         * Pie Chart 를 그리기 위한 데이터 get
         *
         * @return {@link PieChartModel} List
         */
        List<PieChartModel> getChartData();
    }
}
