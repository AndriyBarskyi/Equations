package com.example.equations;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EquationTest {

    @Test
    public void testValidParentheses() {
        assertTrue(EquationValidator.isParenthesesValid("2*(x+5)"));
        assertTrue(EquationValidator.isParenthesesValid("(2*x+5)"));
        assertTrue(EquationValidator.isParenthesesValid("(2*5)+(x+5)"));
        assertTrue(EquationValidator.isParenthesesValid("2*(x+5)-5+(x+5)"));
        assertTrue(EquationValidator.isParenthesesValid("2*((x+5)-5)+(x+5)"));

    }

    @Test
    public void testInvalidParentheses() {
        assertFalse(EquationValidator.isParenthesesValid("2*(x+5"));
        assertFalse(EquationValidator.isParenthesesValid("(2*)x+5)"));
        assertFalse(EquationValidator.isParenthesesValid("2*(x+5))"));
        assertFalse(EquationValidator.isParenthesesValid("2*(((x+5))(x+2)"));
        assertFalse(EquationValidator.isParenthesesValid("(2*((x+5))"));
        assertFalse(EquationValidator.isParenthesesValid("2*(x+5))(x+2)"));
    }

    @Test
    public void testValidExpression() {
        assertTrue(EquationValidator.isExpressionValid("2*x+5=10"));
        assertTrue(EquationValidator.isExpressionValid("-1.3*5/x=1.2"));
        assertTrue(EquationValidator.isExpressionValid("2*x=10"));
        assertTrue(EquationValidator.isExpressionValid("2*x+5+x+5=10"));
        assertTrue(EquationValidator.isExpressionValid("17=2*x+5"));
    }

    @Test
    public void testInvalidExpression() {
        assertFalse(EquationValidator.isExpressionValid("2*x+*5=10"));
        assertFalse(EquationValidator.isExpressionValid("2*x+="));
        assertFalse(EquationValidator.isExpressionValid("2*x+5+x+5=10+"));
        assertFalse(EquationValidator.isExpressionValid("17=2*x+5/0"));
        assertFalse(EquationValidator.isExpressionValid("2*x+5++x=10"));
        assertFalse(EquationValidator.isExpressionValid("x*3-(2+5)="));
        assertFalse(EquationValidator.isExpressionValid("2*x+5-(x=10)"));
    }
}


