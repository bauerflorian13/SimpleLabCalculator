module com.bauerflorian.simplecalc {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.lang3;


    opens com.bauerflorian.simplecalc to javafx.fxml;
    exports com.bauerflorian.simplecalc;
    exports com.bauerflorian.simplecalc.model;
    opens com.bauerflorian.simplecalc.model to javafx.fxml;
}