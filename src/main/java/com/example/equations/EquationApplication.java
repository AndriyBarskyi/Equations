package com.example.equations;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.equations.database.DatabaseInitializer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EquationApplication extends Application {
    public static void main(String[] args) {
        try {
            DatabaseInitializer.createTables();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseInitializer.class.getName()).log(Level.SEVERE, null, e);
        }
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