package nl.teuno.simplecalculator.rest.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CalculationDto {

    @NotNull(message = "firstNumber may not be empty")
    private Integer firstNumber;
    @NotNull(message = "secondNumber may not be empty")
    private Integer secondNumber;
    @NotNull
    @NotEmpty
    private String operator;
}
