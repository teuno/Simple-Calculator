package nl.teuno.simplecalculator.rest.controllers;

import lombok.RequiredArgsConstructor;
import nl.teuno.simplecalculator.rest.dtos.CalculationDto;
import nl.teuno.simplecalculator.rest.mappers.CalculationMapper;
import nl.teuno.simplecalculator.services.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/calculations")
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @PostMapping
    public ResponseEntity<Void> executeCalculation(
            @Valid @RequestBody CalculationDto calculationDto, UriComponentsBuilder uriComponentsBuilder
                                                  ) {
        var calculation = CalculationMapper.INSTANCE.toCalculation(calculationDto);
        calculatorService.executeCalculation(calculation);

        var uriComponents = uriComponentsBuilder.path("/api/calculations/{id}")
                .buildAndExpand(calculation.getId());

        return ResponseEntity.created(uriComponents.toUri())
                .build();
    }
}
