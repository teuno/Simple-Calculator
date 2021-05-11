package nl.teuno.simplecalculator.repositories;

import nl.teuno.simplecalculator.models.Calculation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CalculationRepositoryTest {

    @Autowired
    private CalculationRepository repository;

    @Test
    void whenAnValidCalculation_isSaved_theEntityGetsAnId() {
        Calculation calculation = new Calculation();
        calculation.setFirstNumber(1);
        calculation.setSecondNumber(1);
        calculation.setOperator("+");

        repository.save(calculation);
        assertThat(calculation.getId()).isNotNull();
    }

    @Test
    void whenFindAllOnEmptyRepository_thenGetEmptyList() {
        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    void whenFindAllOnRepositoryWithOneCalculation_thenGetListWithThatCalculation() {
        Calculation calculation = new Calculation();
        calculation.setFirstNumber(1);
        calculation.setSecondNumber(1);
        calculation.setOperator("+");
        calculation.setOutcome(2.);

        repository.save(calculation);
        List<Calculation> result = (List<Calculation>) repository.findAll();
        assertThat(result).hasSize(1);
        assertThat(result.get(0)
                .getId()).isNotNull();
        assertThat(result.get(0)
                .getFirstNumber()).isEqualTo(1);
        assertThat(result.get(0)
                .getSecondNumber()).isEqualTo(1);
        assertThat(result.get(0)
                .getOperator()).isEqualTo("+");
        assertThat(result.get(0)
                .getOutcome()).isEqualTo(2.);
    }
}
