package com.bauerflorian.simplecalc;

import com.bauerflorian.simplecalc.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label statusText;

    // s-gen
    @FXML
    private TextField sgenXValue;
    @FXML
    private TextField sgenYValue;

    // r-gen
    @FXML
    private TextField rgenXValue;
    @FXML
    private TextField rgenYValue;

    // n-gen
    @FXML
    private TextField ngenXValue;
    @FXML
    private TextField ngenYValue;

    private Model model;

    public Controller(Model model) {
        this.model = model;
        setModelListenerCallbacks(model);
    }

    private void setModelListenerCallbacks(Model model) {
        // sgen
        model.addListener(m -> sgenXValue.setText(m.getXValueSGen() + ""));
        model.addListener(m -> sgenYValue.setText(m.getYValueSGen() + ""));
        // rgen
        model.addListener(m -> rgenXValue.setText(m.getXValueRGen() + ""));
        model.addListener(m -> rgenYValue.setText(m.getYValueRGen() + ""));
        // ngen
        model.addListener(m -> ngenXValue.setText(m.getXValueNGen() + ""));
        model.addListener(m -> ngenYValue.setText(m.getYValueNGen() + ""));
    }

    public Controller() {
        model = null;
    }

    @FXML
    protected void onCalcBtnClick() {
        statusText.setText("Calculating...");
        try {
            // do not overwhelm the user with to fast performance :P
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(sgenXValue.getText() != null && !sgenXValue.getText().isBlank()){
            double xValue = Double.parseDouble(sgenXValue.getText());
            model.setXSGen(xValue);
        }

        statusText.setText("Calculation finished!");
    }

    public void setModel(Model model){
        this.model = model;
        setModelListenerCallbacks(model);
    }
}