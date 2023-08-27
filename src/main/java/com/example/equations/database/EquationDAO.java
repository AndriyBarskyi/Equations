package com.example.equations.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquationDAO {

    private EquationDAO() {
    }

    public static void insertEquationAndRoots(String equation, String roots)
        throws SQLException {
        String insertQuery =
            "INSERT INTO equations (equation, roots) VALUES (?, ?) ";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                insertQuery)) {
            preparedStatement.setString(1, equation);
            preparedStatement.setString(2, roots);
            preparedStatement.executeUpdate();
        }
    }

    public static List<String> findEquationsByRoot(double root, double DELTA) {
        List<String> equations = new ArrayList<>();
        String findQuery = "SELECT equation, roots FROM equations";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                findQuery);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String rootsString = resultSet.getString("roots");
                String[] rootsArray = rootsString.split(",\\s*");

                for (String rootItem : rootsArray) {
                    double storedRoot = Double.parseDouble(rootItem.trim());
                    if (Math.abs(storedRoot - root) < DELTA) {
                        String equation = resultSet.getString("equation");
                        equations.add(equation);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equations;
    }

    public static boolean equationExists(String equation) {
        String checkQuery = "SELECT COUNT(*) FROM equations WHERE equation = ?";
        try (Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                checkQuery)) {
            preparedStatement.setString(1, equation);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

}

