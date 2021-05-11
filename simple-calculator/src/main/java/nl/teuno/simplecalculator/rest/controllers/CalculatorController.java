package nl.teuno.simplecalculator.rest.controllers;

import lombok.RequiredArgsConstructor;
import nl.teuno.simplecalculator.rest.dtos.CalculationDto;
import nl.teuno.simplecalculator.rest.mappers.CalculationMapper;
import nl.teuno.simplecalculator.services.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<CalculationDto>> getCalculations() {
        var body = calculatorService.getCalculations()
                .stream()
                .map(CalculationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(body);
    }
}
