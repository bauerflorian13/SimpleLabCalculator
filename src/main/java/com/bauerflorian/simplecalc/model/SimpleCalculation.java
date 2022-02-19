package com.bauerflorian.simplecalc.model;

public class SimpleCalculation {

    private final LinearEquationFormula formula;
    private Double xValue;
    private Double yValue;

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

    public Double getxValue() {
        return xValue;
    }

    public Integer getxValueRounded() {
        return xValue != null ? Double.valueOf(Math.round(xValue)).intValue() : null;
    }

    public Double getyValue() {
        return yValue;
    }

    public Integer getyValueRounded() {
        return yValue != null ? Double.valueOf(Math.round(yValue)).intValue() : null;
    }

    public void resetXandYValues(){
        yValue = null;
        xValue = null;
    }
}
