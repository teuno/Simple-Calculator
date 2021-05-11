package nl.teuno.simplecalculator.rest.controllers;

import lombok.RequiredArgsConstructor;
import nl.teuno.simplecalculator.rest.dtos.CalculationDto;
import nl.teuno.simplecalculator.rest.mappers.CalculationMapper;
import nl.teuno.simplecalculator.services.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculations")
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @PostMapping
    public ResponseEntity<CalculationDto> executeCalculation(
            @Valid @RequestBody CalculationDto calculationDto) {
        var calculation = calculatorService.executeCalculation(
                CalculationMapper.INSTANCE.toCalculation(calculationDto));

        var body = CalculationMapper.INSTANCE.toDto(calculation);

        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}
