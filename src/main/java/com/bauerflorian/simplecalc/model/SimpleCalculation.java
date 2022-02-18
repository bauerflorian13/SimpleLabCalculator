package com.bauerflorian.simplecalc.model;

public class SimpleCalculation {

    private final LinearEquationFormula formula;
    private double xValue;
    private double yValue;

    public SimpleCalculation(LinearEquationFormula formula) {
        this.formula = formula;
    }

    public void setXandCalculateY(double xValue){
        this.xValue = xValue;
        yValue = formula.calculateY(xValue);
    }

    public void setYandCalculateX(double yValue){
        this.yValue = yValue;
        xValue = formula.calculateX(yValue);
    }

    public LinearEquationFormula getFormula() {
        return formula;
    }

    public double getxValue() {
        return xValue;
    }

    public double getyValue() {
        return yValue;
    }
}
