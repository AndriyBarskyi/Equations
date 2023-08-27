package com.example.equations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

public class EquationSolver {

    private EquationSolver() {

    }
    private static String convertEquation(String originalEquation) {
        String pattern = "([^=]+)=(.*)";
        Matcher matcher = Pattern.compile(pattern).matcher(originalEquation);

        if (matcher.find()) {
            String leftPart = matcher.group(1).trim();
            String rightPart = matcher.group(2).trim();

            return leftPart + "-1*(" + rightPart + ")";
        } else {
            throw new IllegalArgumentException("Некоректне рівняння: " + originalEquation);
        }
    }




    public static double calculateEquationValue(String equation, double xValue) {
        Argument argument = new Argument("x = " + xValue);
        Expression expression = new Expression(convertEquation(equation), argument);
        return expression.calculate();
    }

}
