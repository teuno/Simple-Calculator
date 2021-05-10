package nl.teuno.simplecalculator.rest.mappers;

import nl.teuno.simplecalculator.models.Calculation;
import nl.teuno.simplecalculator.rest.dtos.CalculationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalculationMapper {
    CalculationMapper INSTANCE = Mappers.getMapper(CalculationMapper.class);

    Calculation toCalculation(CalculationDto source);
    CalculationDto toDto(Calculation destination);
}
