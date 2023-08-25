package com.example.equations;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EquationController {

    @FXML
    private TextField equationTextField;

    @FXML
    private TextField rootsTextField;

    @FXML
    private Button checkButton;

    @FXML
    public void onCheckButtonClick() {
        String equation = equationTextField.getText();
        String roots = rootsTextField.getText();

        if (!EquationValidator.isParenthesesValid(equation)) {
            showErrorAlert("Некоректне розміщення дужок у рівнянні.");
            return;
        }

        if (!EquationValidator.isExpressionValid(equation)) {
            showErrorAlert("Некоректний вираз у рівнянні.");
            return;
        }

        showInfoAlert("Успіх", "Вираз валідний.");

    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Помилка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
