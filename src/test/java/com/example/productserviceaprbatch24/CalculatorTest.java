package com.example.productserviceaprbatch24;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    // When Then
    // TEST_WHEN_ADD_TWO_NUMBER_RETURN_SUM
    @Test
    @DisplayName("Testing 1+2 = 3")
    void Test_WhenAddTwoNumber_ReturnSum() {
        //Arrange
        int a = 1;
        int b = 2;
        Calculator calculator = new Calculator();

        //Act
        int result = calculator.addition(a,b);

        //Assert
        assertEquals(3, result);

    }

    @Test
    void subtraction() {
    }

    @Test
    void multiplication() {
    }

    @Test
    void Test_DivideByZero_ThrowException() {
        //Arrange
        Calculator calculator = new Calculator();

        //Act & Assert
        assertThrows(ArithmeticException.class, () -> calculator.division(1,0));
    }
}