package com.example.equations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EquationSolverTest {

    @ParameterizedTest
    @MethodSource("equationValueProvider")
    void testCalculateEquationValue(String equation, double xValue) {
        double result = EquationSolver.calculateEquationValue(equation, xValue);

        assertEquals(0.0, result, 1e-9, "Result should match for equation: " + equation);
    }

    static Stream<Arguments> equationValueProvider() {
        return Stream.of(
            Arguments.of("2*x + 6 = 18", 6.0),
            Arguments.of("x*x - 5x + 6 = 0", 2.0),
            Arguments.of("x*x - 5x + 6 = 0", 3.0),
            Arguments.of("x - 5x + 6 = -2", 2.0),
            Arguments.of("6 + 6 = 2 * x", 6.0),
            Arguments.of("15.6 / 2.0 + 2.0 = 2.0 + x", 7.8),
            Arguments.of("16.4 / (2.0 + 2.0) = 2.0 + x", 2.1)
        );
    }
}

