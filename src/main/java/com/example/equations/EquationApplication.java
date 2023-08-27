package com.example.equations;

import java.io.IOException;

import com.example.equations.database.DatabaseInitializer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EquationApplication extends Application {
    public static void main(String[] args) {
        DatabaseInitializer.createTables();
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            EquationApplication.class.getResource("equation-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Equations helper :)");
        stage.setScene(scene);
        stage.show();
    }
}