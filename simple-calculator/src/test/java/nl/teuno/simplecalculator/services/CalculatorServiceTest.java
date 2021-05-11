package nl.teuno.simplecalculator.services;

import nl.teuno.simplecalculator.models.Calculation;
import nl.teuno.simplecalculator.repositories.CalculationRepository;
import nl.teuno.simplecalculator.services.exceptions.ShouldNotBePossibleException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

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

    @Test
    void givenAnNotValidOperator_WhenExecuteCalculation_ThenThrowsShouldNotBePossibleException() {
        Calculation calculation = new Calculation();
        calculation.setOperator("g");

        assertThatExceptionOfType(ShouldNotBePossibleException.class)
                .isThrownBy(() -> {
                    calculatorService.executeCalculation(calculation);
                });
    }


    @Test
    void whenGetCalcutionsOfEmptyDatabase_thenReceiveListOfCalculations(){
        when(calculationRepository.findAll()).thenReturn(Lists.emptyList());

        var result = calculatorService.getCalculations();
        verify(calculationRepository, times(1)).findAll();
        assertThat(result).isEqualTo(Lists.emptyList());
    }

    @Test
    void whenGetCalcutionsFilledDatabase_thenReceiveListOfCalculations(){
        Calculation calculation = new Calculation();
        calculation.setFirstNumber(1);
        calculation.setSecondNumber(1);
        calculation.setOperator("+");
        calculation.setOutcome(2.);
        var testdata = List.of(calculation);

        when(calculationRepository.findAll()).thenReturn(testdata);

        var result = calculatorService.getCalculations();
        verify(calculationRepository, times(1)).findAll();
        assertThat(result).isEqualTo(testdata);
    }
}
