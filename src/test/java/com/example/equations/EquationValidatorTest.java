package com.example.equations;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EquationValidatorTest {

    static Stream<String> validParenthesesProvider() {
        return Stream.of(
            "2*(x+5)",
            "(2*x+5)",
            "(2*5)+(x+5)",
            "2*(x+5)-5+(x+5)",
            "2*((x+5)-5)+(x+5)"
        );
    }

    static Stream<String> invalidParenthesesProvider() {
        return Stream.of(
            "2*(x+5",
            "(2*)x+5)",
            "2*(x+5))",
            "2*(((x+5))(x+2)",
            "(2*((x+5))",
            "2*(x+5))(x+2)"
        );
    }

    static Stream<String> validExpressionProvider() {
        return Stream.of(
            "2*x+5=10",
            "-1.3*5/x=1.2",
            "2*x=10",
            "2*x+5+x+5=10",
            "17=2*x+5"
        );
    }

    static Stream<String> invalidExpressionProvider() {
        return Stream.of(
            "2*x+*5=10",
            "2*x+=",
            "2*x+5+x+5=10+",
            "17=2*x+5/0",
            "2*x+5++x=10",
            "x*3-(2+5)=",
            "2*x+5-(x=10)"
        );
    }

    @ParameterizedTest
    @MethodSource("validParenthesesProvider")
    void testValidParentheses(String equation) {
        assertTrue(EquationValidator.isParenthesesValid(equation));
    }

    @ParameterizedTest
    @MethodSource("invalidParenthesesProvider")
    void testInvalidParentheses(String equation) {
        assertFalse(EquationValidator.isParenthesesValid(equation));
    }

    @ParameterizedTest
    @MethodSource("validExpressionProvider")
    void testValidExpression(String equation) {
        assertTrue(EquationValidator.isExpressionValid(equation));
    }

    @ParameterizedTest
    @MethodSource("invalidExpressionProvider")
    void testInvalidExpression(String equation) {
        assertFalse(EquationValidator.isExpressionValid(equation));
    }
}


