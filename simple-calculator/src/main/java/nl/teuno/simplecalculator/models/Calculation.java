package nl.teuno.simplecalculator.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "calculation")
public class Calculation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_number", nullable = false)
    private int firstNumber;

    @Column(name = "second_number", nullable = false)
    private int secondNumber;

    @Column(name = "operator", nullable = false)
    private String operator;

    @Column(name = "outcome", nullable = false)
    private double outcome;
}
