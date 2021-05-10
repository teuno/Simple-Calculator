package nl.teuno.simplecalculator.services;

import lombok.RequiredArgsConstructor;
import nl.teuno.simplecalculator.models.Calculation;
import nl.teuno.simplecalculator.repositories.CalculationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculationRepository calculationRepository;
    private final SimpleCalculator simpleCalculator;


    public Calculation executeCalculation(Calculation calculation) {
        double result = 0;
        if (calculation.getOperator().equals("+"))
            result = simpleCalculator.add(calculation.getFirstNumber(),calculation.getSecondNumber());
        else if(calculation.getOperator().equals("-"))
            result = simpleCalculator.subtract(calculation.getFirstNumber(),calculation.getSecondNumber());
        else if(calculation.getOperator().equals("*"))
            result = simpleCalculator.multiply(calculation.getFirstNumber(),calculation.getSecondNumber());
        else if(calculation.getOperator().equals("/"))
            result = simpleCalculator.divide(calculation.getFirstNumber(),calculation.getSecondNumber());

        calculation.setOutcome(result);
        calculationRepository.save(calculation);
        return calculation;
    }
}
