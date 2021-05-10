package nl.teuno.simplecalculator.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class CalculationRepositoryTest {

    @Autowired
    private CalculationRepository repository;

    @Test
    public void calculationRepositoryIsCreated(){
        assertThat(repository.findAll()).hasSize(0);

    }
}
