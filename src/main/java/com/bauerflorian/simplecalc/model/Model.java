package com.bauerflorian.simplecalc.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public interface Listener {
        void onChange(Model model);
    }

    private SimpleCalculation sGen;
    private SimpleCalculation rGen;
    private SimpleCalculation nGen;

    private final List<Listener> listeners = new ArrayList<>();

    public Model() {
        initFormulas();
    }

    private void initFormulas() {
        LinearEquationFormula sGenFormula = new LinearEquationFormula(-3.765, 49.009);
        sGen = new SimpleCalculation(sGenFormula);
        LinearEquationFormula rGenFormula = new LinearEquationFormula(-3.3156, 47.348);
        rGen = new SimpleCalculation(rGenFormula);
        LinearEquationFormula nGenFormula = new LinearEquationFormula(-2.708, 46.246);
        nGen = new SimpleCalculation(nGenFormula);
    }

    public void setXSGen(double xValue){
        sGen.setXandCalculateY(xValue);
        notifyObservers();
    }

    public void setYSGen(double yValue){
        sGen.setYandCalculateX(yValue);
        notifyObservers();
    }

    public void setXRGen(double xValue){
        rGen.setXandCalculateY(xValue);
        notifyObservers();
    }

    public void setYRGen(double yValue){
        rGen.setYandCalculateX(yValue);
        notifyObservers();
    }

    public void setXNGen(double xValue){
        nGen.setXandCalculateY(xValue);
        notifyObservers();
    }

    public void setYNGen(double yValue){
        nGen.setYandCalculateX(yValue);
        notifyObservers();
    }

    public Double getXValueSGen(){
        return sGen.getxValue();
    }

    public Double getYValueSGen(){
        return sGen.getyValue();
    }

    public Double getXValueRGen(){
        return rGen.getxValue();
    }

    public Double getYValueRGen(){
        return rGen.getyValue();
    }

    public Double getXValueNGen(){
        return nGen.getxValue();
    }

    public Double getYValueNGen(){
        return nGen.getyValue();
    }
    public void addListener(Listener listener){
        listeners.add(listener);
    }

    private void notifyObservers(){
        listeners.forEach(l -> l.onChange(this));
    }




}
