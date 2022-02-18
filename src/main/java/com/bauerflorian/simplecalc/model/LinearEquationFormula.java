package com.bauerflorian.simplecalc.model;

public class LinearEquationFormula extends AbstractFormula {
    private final double a;
    private final double b;

    public LinearEquationFormula(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateX(double y) {
        return (y-b)/a;
    }

    @Override
    public double calculateY(double x) {
        return a*x+b;
    }


}
