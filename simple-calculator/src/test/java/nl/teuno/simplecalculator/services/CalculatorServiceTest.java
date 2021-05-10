package nl.teuno.simplecalculator.services;

import nl.teuno.simplecalculator.models.Calculation;
import nl.teuno.simplecalculator.repositories.CalculationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @Mock
    private CalculationRepository calculationRepository;

    @Mock
    private SimpleCalculator simpleCalculator;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    void givenCalculationForAdd_WhenExecuteCalculation_ThenAddIsCalled() {
        Calculation calculation = new Calculation();
        calculation.setOperator("+");

        calculatorService.executeCalculation(calculation);
        verify(simpleCalculator, times(1)).add(calculation.getFirstNumber(), calculation.getSecondNumber());
        verify(calculationRepository, times(1)).save(calculation);
    }

    @Test
    void givenCalculationForMin_WhenExecuteCalculation_ThenSubtractIsCalled() {
        Calculation calculation = new Calculation();
        calculation.setOperator("-");

        calculatorService.executeCalculation(calculation);
        verify(simpleCalculator, times(1)).subtract(calculation.getFirstNumber(), calculation.getSecondNumber());
        verify(calculationRepository, times(1)).save(calculation);
    }

    @Test
    void givenCalculationForMultiply_WhenExecuteCalculation_ThenMultiplyIsCalled() {
        Calculation calculation = new Calculation();
        calculation.setOperator("*");

        calculatorService.executeCalculation(calculation);
        verify(simpleCalculator, times(1)).multiply(calculation.getFirstNumber(), calculation.getSecondNumber());
        verify(calculationRepository, times(1)).save(calculation);
    }

    @Test
    void givenCalculationForDivide_WhenExecuteCalculation_ThenDivideIsCalled() {
        Calculation calculation = new Calculation();
        calculation.setOperator("/");

        calculatorService.executeCalculation(calculation);
        verify(simpleCalculator, times(1)).divide(calculation.getFirstNumber(), calculation.getSecondNumber());
        verify(calculationRepository, times(1)).save(calculation);
    }
}
