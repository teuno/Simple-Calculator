package nl.teuno.simplecalculator.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "calculation")
public class Calculation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_number", nullable = false)
    private Long firstNumber;

    @Column(name = "second_number", nullable = false)
    private Long secondNumber;

    @Column(name = "operator", nullable = false)
    private String operator;

    @Column(name = "outcome", precision=18, scale=2, nullable = false)
    private BigDecimal minValue;
}
