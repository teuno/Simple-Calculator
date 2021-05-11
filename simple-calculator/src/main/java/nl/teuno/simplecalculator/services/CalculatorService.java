package nl.teuno.simplecalculator.services;

import lombok.RequiredArgsConstructor;
import nl.teuno.simplecalculator.models.Calculation;
import nl.teuno.simplecalculator.repositories.CalculationRepository;
import nl.teuno.simplecalculator.services.exceptions.ShouldNotBePossibleException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculationRepository calculationRepository;
    private final SimpleCalculator simpleCalculator;


    public Calculation executeCalculation(Calculation calculation) {
        double result;
        switch (calculation.getOperator()) {
            case "+":
                result = simpleCalculator.add(calculation.getFirstNumber(), calculation.getSecondNumber());
                break;
            case "-":
                result = simpleCalculator.subtract(calculation.getFirstNumber(), calculation.getSecondNumber());
                break;
            case "*":
                result = simpleCalculator.multiply(calculation.getFirstNumber(), calculation.getSecondNumber());
                break;
            case "/":
                result = simpleCalculator.divide(calculation.getFirstNumber(), calculation.getSecondNumber());
                break;
            default:
                throw new ShouldNotBePossibleException("If we get here the input validation is broken");
        }

        calculation.setOutcome(result);
        calculationRepository.save(calculation);
        return calculation;
    }

    public List<Calculation> getCalculations() {
        return (List<Calculation>) calculationRepository.findAll();
    }
}
