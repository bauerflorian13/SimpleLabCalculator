package com.bauerflorian.simplecalc;

import com.bauerflorian.simplecalc.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;

import static com.bauerflorian.simplecalc.Application.APPLICATION_TITLE;
import static com.bauerflorian.simplecalc.Application.APPLICATION_VERSION;

public class Controller {
    public static final String N_GEN = "N-Gen";
    public static final String R_GEN = "RdRP-Gen";
    public static final String S_GEN = "S-Gen";
    public static final String FX_BACKGROUND_COLOR_DEFAULT = "-fx-background-color: white;";
    public static final String FX_BACKGROUND_COLOR_CHANGED = "-fx-background-color: #00ff91;";
    public static final String FX_BACKGROUND_COLOR_ERROR = "-fx-background-color: #e23b3b;";
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
    private boolean roundInputNumbers = false;
    private boolean roundOutputNumbers = true;

    public Controller(Model model) {
        this.model = model;
        setModelListenerCallbacks(model);
    }

    private void setModelListenerCallbacks(Model model) {
        // sgen
        model.addListener(model.getsGen(), this::redrawSgenXValueField);
        model.addListener(model.getsGen(), this::redrawSgenYValueField);
        // rgen
        model.addListener(model.getrGen(), this::redrawRgenXValueField);
        model.addListener(model.getrGen(), this::redrawRgenYValueField);
        // ngen
        model.addListener(model.getnGen(), this::redrawNgenXValueField);
        model.addListener(model.getnGen(), this::redrawNgenYValueField);
    }

    private void redrawSgenXValueField(Model m) {
        String value = roundOutputNumbers ? m.getsGen().getxValueRounded()+"" : m.getsGen().getxValue()+"";
        value = value.equals("null") ? "" : value;
        if(StringUtils.equals(sgenXValue.getText(), value)){
            sgenXValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        } else {
            sgenXValue.setText(value);
            sgenXValue.setStyle(FX_BACKGROUND_COLOR_CHANGED);
        }
    }

    private void redrawSgenYValueField(Model m) {
        String value = roundInputNumbers ? m.getsGen().getyValueRounded()+"" : m.getsGen().getyValue()+"";
        value = value.equals("null") ? "" : value;
        if(StringUtils.equals(sgenYValue.getText(), value)){
            sgenYValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        } else {
            sgenYValue.setText(value);
            sgenYValue.setStyle(FX_BACKGROUND_COLOR_CHANGED);
        }
    }

    private void redrawRgenXValueField(Model m) {
        String value = roundOutputNumbers ? m.getrGen().getxValueRounded()+"" : m.getrGen().getxValue()+"";
        value = value.equals("null") ? "" : value;
        if(StringUtils.equals(rgenXValue.getText(), value)){
            rgenXValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        } else {
            rgenXValue.setText(value);
            rgenXValue.setStyle(FX_BACKGROUND_COLOR_CHANGED);
        }
    }

    private void redrawRgenYValueField(Model m) {
        String value = roundInputNumbers ? m.getrGen().getyValueRounded()+"" : m.getrGen().getyValue()+"";
        value = value.equals("null") ? "" : value;
        if(StringUtils.equals(rgenYValue.getText(), value)){
            rgenYValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        } else {
            rgenYValue.setText(value);
            rgenYValue.setStyle(FX_BACKGROUND_COLOR_CHANGED);
        }
    }

    private void redrawNgenXValueField(Model m) {
        String value = roundOutputNumbers ? m.getnGen().getxValueRounded()+"" : m.getnGen().getxValue()+"";
        value = value.equals("null") ? "" : value;
        if(StringUtils.equals(ngenXValue.getText(), value)){
            ngenXValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        } else {
            ngenXValue.setText(value);
            ngenXValue.setStyle(FX_BACKGROUND_COLOR_CHANGED);
        }
    }

    private void redrawNgenYValueField(Model m) {
        String value = roundInputNumbers ? m.getnGen().getyValueRounded()+"" : m.getnGen().getyValue()+"";
        value = value.equals("null") ? "" : value;
        if(StringUtils.equals(ngenYValue.getText(), value)){
            ngenYValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        } else {
            ngenYValue.setText(value);
            ngenYValue.setStyle(FX_BACKGROUND_COLOR_CHANGED);
        }
    }

    public Controller() {
        model = null;
    }

    @FXML
    protected void onCalcBtnClick() {
        statusText.setText("Berechne...");
        long startTime = System.currentTimeMillis();
        setDefaultColorSchemeToTextfields();

        try {
            // do not overwhelm the user with to fast performance :P
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean allValid = validateInputTextField(sgenYValue, S_GEN) && validateInputTextField(rgenYValue, R_GEN) && validateInputTextField(ngenYValue, N_GEN);
        if(!allValid) return;


        double sgenValue = Double.parseDouble(sgenYValue.getText().replace(",","."));
        model.setYSGen(sgenValue);
        double rgenValue = Double.parseDouble(rgenYValue.getText().replace(",","."));
        model.setYRGen(rgenValue);
        double ngenValue = Double.parseDouble(ngenYValue.getText().replace(",","."));
        model.setYNGen(ngenValue);



        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        statusText.setText("Berechnung erfolgreich abgeschlossen in " + (duration * 1.0) / 1000 + "s");
    }

    private void setDefaultColorSchemeToTextfields() {
        sgenXValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        sgenYValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        rgenXValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        rgenYValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        ngenXValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
        ngenYValue.setStyle(FX_BACKGROUND_COLOR_DEFAULT);
    }

    private boolean validateInputTextField(TextField inputField, String valueName) {
        if(!isInCorrectNumberFormat(inputField.getText())){
            statusText.setText("Bitte valide Nummer eingeben für " + valueName + ".");
            inputField.setStyle(FX_BACKGROUND_COLOR_ERROR);
            return false;
        }
        return true;
    }

    public static boolean isInCorrectNumberFormat(String str) {
        // match a number with optional '-', up to two decimals before and two decimals after the comma
        return StringUtils.isNotBlank(str) && str.matches("-?\\d\\d?([\\.,]\\d\\d?)?");
    }

    public void setModel(Model model){
        this.model = model;
        setModelListenerCallbacks(model);
    }

    @FXML
    protected void onPreferencesClick() {
        statusText.setText("Nicht verfügbar :(");
    }

    @FXML
    protected void onAboutClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "This little Tool was developed by Florian Bauer :)", ButtonType.OK);
        alert.setTitle("About " + APPLICATION_TITLE);
        alert.setHeaderText(APPLICATION_TITLE + " " + APPLICATION_VERSION);
        alert.showAndWait();
    }

    @FXML
    protected void onRundenClick(){
        roundOutputNumbers = !roundOutputNumbers;
        redrawInputFields();
    }

    private void redrawInputFields() {
        redrawSgenXValueField(model);
        redrawSgenYValueField(model);
        redrawRgenXValueField(model);
        redrawRgenYValueField(model);
        redrawNgenXValueField(model);
        redrawNgenYValueField(model);
    }

    @FXML
    protected void onResetBtnClick(){
        statusText.setText("Zahlen zurückgesetzt.");
        setDefaultColorSchemeToTextfields();
        model.reset();
        redrawInputFields();
    }

}