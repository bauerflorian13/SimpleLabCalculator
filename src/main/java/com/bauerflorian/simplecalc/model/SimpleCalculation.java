package com.bauerflorian.simplecalc.model;

public class SimpleCalculation {

    private final LinearEquationFormula formula;
    private double xValue;
    private double yValue;

    public SimpleCalculation(LinearEquationFormula formula) {
        this.formula = formula;
    }

    protected void setXandCalculateY(double xValue){
        this.xValue = xValue;
        yValue = formula.calculateY(xValue);
    }

    protected void setYandCalculateX(double yValue){
        this.yValue = yValue;
        xValue = formula.calculateX(yValue);
    }

    public LinearEquationFormula getFormula() {
        return formula;
    }

    public double getxValue() {
        return xValue;
    }

    public Integer getxValueRounded() {
        return Double.valueOf(Math.round(xValue)).intValue();
    }

    public double getyValue() {
        return yValue;
    }

    public Integer getyValueRounded() {
        return Double.valueOf(Math.round(yValue)).intValue();
    }
}
