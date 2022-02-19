package com.bauerflorian.simplecalc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    public interface Listener {
        void onChange(Model model);
    }

    private SimpleCalculation sGen;
    private SimpleCalculation rGen;
    private SimpleCalculation nGen;

    private final Map<SimpleCalculation, List<Listener>> listeners = new HashMap<>();

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
        notifyObserverForCalculation(sGen);
    }

    public void setYSGen(double yValue){
        sGen.setYandCalculateX(yValue);
        notifyObserverForCalculation(sGen);
    }

    public void setXRGen(double xValue){
        rGen.setXandCalculateY(xValue);
        notifyObserverForCalculation(rGen);
    }

    public void setYRGen(double yValue){
        rGen.setYandCalculateX(yValue);
        notifyObserverForCalculation(rGen);
    }

    public void setXNGen(double xValue){
        nGen.setXandCalculateY(xValue);
        notifyObserverForCalculation(nGen);
    }

    public void setYNGen(double yValue){
        nGen.setYandCalculateX(yValue);
        notifyObserverForCalculation(nGen);
    }

    public SimpleCalculation getsGen(){
        return sGen;
    }

    public SimpleCalculation getrGen() {
        return rGen;
    }

    public SimpleCalculation getnGen() {
        return nGen;
    }

    public void addListener(SimpleCalculation calculation, Listener listener){
        if(!listeners.containsKey(calculation)){
            listeners.put(calculation, new ArrayList<>());
        }
        listeners.get(calculation).add(listener);
    }

    private void notifyAllObservers(){
        listeners.values().forEach(l -> l.forEach(a -> a.onChange(this)));
    }

    private void notifyObserverForCalculation(SimpleCalculation simpleCalculation){
        listeners.get(simpleCalculation).forEach(l -> l.onChange(this));
    }




}
