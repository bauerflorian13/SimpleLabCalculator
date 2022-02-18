package com.bauerflorian.simplecalc;

import com.bauerflorian.simplecalc.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    public static final String APPLICATION_TITLE = "Simple Calc";

    @Override
    public void start(Stage stage) throws IOException {
        Model model = new Model();
        // TODO add own controller before loading
//        Controller controller = new Controller(model);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
//        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load());
        Controller controller = fxmlLoader.getController();
        controller.setModel(model);
        stage.setTitle(APPLICATION_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}