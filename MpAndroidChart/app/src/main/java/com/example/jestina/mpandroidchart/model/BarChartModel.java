package com.example.jestina.mpandroidchart.model;

/**
 * Created by JESTINA on 2018-08-27.
 */
public class BarChartModel {
    private int month; // 판매 월
    private int sellingAmount; // 판매량

    public BarChartModel(){}

    private BarChartModel(Builder builder) {
        this.month = builder.bmonth;
        this.sellingAmount = builder.bsellingAmount;
    }

    public int getMonth() {
        return month;
    }

    public int getSellingAmount() {
        return sellingAmount;
    }

    /**
     * Bar Chart Model Builder Pattern
     */
    public static class Builder {
        private int bmonth;
        private int bsellingAmount;

        public Builder month(int month) {
            this.bmonth = month;
            return this;
        }

        public Builder setSellingAmount(int sellingAmount) {
            this.bsellingAmount = sellingAmount;
            return this;
        }

        public BarChartModel build() {
            return new BarChartModel(this);
        }
    }
}
