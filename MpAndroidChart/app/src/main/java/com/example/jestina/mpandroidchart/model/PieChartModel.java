package com.example.jestina.mpandroidchart.model;

/**
 * Created by JESTINA on 2018-08-28.
 */

public class PieChartModel {
    private String name;
    private double value;

    public PieChartModel() {}

    private PieChartModel(Builder builder) {
        this.name = builder.name;
        this.value = builder.value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }


    /**
     * Builder Pattern
     */
    public static class Builder {
        private String name;
        private double value;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder value(double value) {
            this.value = value;
            return this;
        }

        public PieChartModel build() {return new PieChartModel(this);}
    }
}
