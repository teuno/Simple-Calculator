package nl.teuno.simplecalculator.services;

import org.springframework.stereotype.Service;

@Service
public class SimpleCalculator {
    public double add(int first, int second) {
        return (double) first + second;
    }

    public double subtract(int first, int second) {
        return (double) first - second;
    }

    public double multiply(int first, int second) {
        return (double) first * second;
    }

    public double divide(int first, int second) {
        if(second == 0)
            throw new ArithmeticException("not possible to devide by zero");
        return (double) first / second;
    }
}
