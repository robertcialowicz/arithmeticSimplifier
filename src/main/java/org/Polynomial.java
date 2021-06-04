package org;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

@Value
@RequiredArgsConstructor
public class Polynomial {

    double coefficient;
    Set<Intermediate> intermediates;

    public Polynomial(double coefficient, Intermediate intermediate) {
        this(coefficient, Set.of(intermediate));
    }

    public Polynomial(double coefficient, char symbol) {
        this(coefficient, Set.of(new Intermediate(symbol)));
    }

    public Polynomial(double coefficient) {
        this(coefficient, Collections.emptySet());
    }

    public Polynomial plus(Polynomial p) {
        if (!this.equals(p)) {
            throw new IllegalArgumentException("Polynomials to be added must consists of the same intermediates.");
        }

        return new Polynomial(coefficient + p.coefficient, intermediates);
    }

    public Polynomial minus(Polynomial p) {
        if (!this.equals(p)) {
            throw new IllegalArgumentException("Polynomials to be subtracted must consist of the same intermediates.");
        }

        return new Polynomial(coefficient - p.coefficient, intermediates);
    }

    public Polynomial multiply(Polynomial p) {
        return new Polynomial(coefficient * p.coefficient, multiplyIntermediates(intermediates, p.intermediates));
    }

    public Polynomial divide(Polynomial p) {
        return new Polynomial(coefficient / p.coefficient, divideIntermediates(intermediates, p.intermediates));
    }

    public Polynomial power(int exponent) {
        return new Polynomial(Math.pow(coefficient, exponent), intermediates.stream().map(i -> i.power(exponent)).collect(Collectors.toSet()));
    }

    // TODO refactor
    private Set<Intermediate> multiplyIntermediates(Set<Intermediate> i1, Set<Intermediate> i2) {
        val result = new HashMap<Character, Integer>();
        val duplicates = new HashSet<Intermediate>();

        for (Intermediate i : i1) {
            for (Intermediate j : i2) {
                if (i.getSymbol() == j.getSymbol()) {
                    duplicates.add(i.multiply(j));
                }
            }
        }

        for (Intermediate i : i1) {
            result.put(i.getSymbol(), i.getExponent());
        }

        for (Intermediate i : i2) {
            result.put(i.getSymbol(), i.getExponent());
        }

        for (Intermediate d : duplicates) {
            result.put(d.getSymbol(), d.getExponent());
        }

        return result.entrySet()
                .stream()
                .map(e -> new Intermediate(e.getKey(), e.getValue()))
                .collect(Collectors.toSet());
    }

    // TODO refactor
    private Set<Intermediate> divideIntermediates(Set<Intermediate> i1, Set<Intermediate> i2) {
        val result = new HashMap<Character, Integer>();
        val duplicates = new HashSet<Intermediate>();

        for (Intermediate i : i1) {
            for (Intermediate j : i2) {
                if (i.getSymbol() == j.getSymbol()) {
                    duplicates.add(i.divide(j));
                }
            }
        }

        for (Intermediate i : i1) {
            result.put(i.getSymbol(), i.getExponent());
        }

        for (Intermediate i : i2) {
            result.put(i.getSymbol(), i.getExponent() * -1);
        }

        for (Intermediate d : duplicates) {
            result.put(d.getSymbol(), d.getExponent());
        }

        return result.entrySet()
                .stream()
                .map(e -> new Intermediate(e.getKey(), e.getValue()))
                .filter(i -> i.getExponent() != 0)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        val that = (Polynomial) o;

        return Objects.equals(intermediates, that.intermediates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intermediates);
    }
}
