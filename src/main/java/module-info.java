module com.bauerflorian.simplecalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bauerflorian.simplecalc to javafx.fxml;
    exports com.bauerflorian.simplecalc;
}