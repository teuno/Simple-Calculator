package nl.teuno.simplecalculator.repositories;

import nl.teuno.simplecalculator.models.Calculation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends CrudRepository<Calculation, Long> {
}
