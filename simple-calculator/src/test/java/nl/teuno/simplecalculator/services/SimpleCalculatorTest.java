package nl.teuno.simplecalculator.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class SimpleCalculatorTest {

    @ParameterizedTest
    @MethodSource("addTestingData")
    void given2Numbers_WhenAdding_ThenReturnSomAsDouble(int first, int second, double result) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThat(calculator.add(first, second)).isEqualTo(result);
    }

    private static Stream<Arguments> addTestingData() {
        return Stream.of(
                Arguments.of(1, 2, 3.),
                Arguments.of(-1, 2, 1.),
                Arguments.of(1, -2, -1.),
                Arguments.of(-1, -2, -3.)
                        );
    }

    @ParameterizedTest
    @MethodSource("minTestingData")
    void given2Numbers_WhenSubtracting_ThenReturnSomAsDouble(int first, int second, double result) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThat(calculator.subtract(first, second)).isEqualTo(result);
    }

    private static Stream<Arguments> minTestingData() {
        return Stream.of(
                Arguments.of(1, 2, -1.),
                Arguments.of(-1, 2, -3.),
                Arguments.of(1, -2, 3.),
                Arguments.of(-1, -2, 1.)
                        );
    }

    @ParameterizedTest
    @MethodSource("multiplyTestingData")
    void given2Numbers_WhenMultiplying_ThenReturnSomAsDouble(int first, int second, double result) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThat(calculator.multiply(first, second)).isEqualTo(result);
    }

    private static Stream<Arguments> multiplyTestingData() {
        return Stream.of(
                Arguments.of(1, 2, 2.),
                Arguments.of(-1, 2, -2.),
                Arguments.of(1, -2, -2.),
                Arguments.of(-1, -2, 2.)
                        );
    }

    @ParameterizedTest
    @MethodSource("divideTestingData")
    void given2Numbers_WhenDividing_ThenReturnSomAsDouble(int first, int second, double result) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThat(calculator.divide(first, second)).isEqualTo(result);
    }

    private static Stream<Arguments> divideTestingData() {
        return Stream.of(
                Arguments.of(1, 2, 0.5),
                Arguments.of(-1, 2, -0.5),
                Arguments.of(1, -2, -0.5),
                Arguments.of(-1, -2, 0.5)
                        );
    }

    @Test
    void given2Numbers_WhenDevidingByZero_ThenReturnsNotAllow() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    calculator.divide(3, 0);
                })
                .withMessage("not possible to devide by zero");
    }
}
