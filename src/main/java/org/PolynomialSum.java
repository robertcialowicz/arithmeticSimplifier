package org;

import lombok.Value;
import lombok.val;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Value
public class PolynomialSum {

    Set<Polynomial> polynomials;

    private PolynomialSum(Set<Polynomial> polynomials) {
        this.polynomials = polynomials;
    }

    public PolynomialSum(Polynomial... polynomials) {
        this.polynomials = new HashSet<>(Arrays.asList(polynomials));
    }

    public PolynomialSum plus(Polynomial p) {
        return new PolynomialSum(performOperation(polynomials, p, Polynomial::plus));
    }

    // TODO refactor
    public PolynomialSum plus(PolynomialSum sum) {
        val newPolynomials = new HashMap<Polynomial, Double>();

        for (Polynomial p : polynomials) {
            newPolynomials.put(p, p.getCoefficient());
        }

        for (Polynomial p : sum.polynomials) {
            newPolynomials.compute(p, (pn, c) -> c == null ? p.getCoefficient() : p.getCoefficient() + c);
        }

        return new PolynomialSum(newPolynomials.entrySet()
                                         .stream()
                                         .map(e -> new Polynomial(e.getValue(), e.getKey().getIntermediates()))
                                         .collect(Collectors.toSet()));
    }

    public PolynomialSum minus(Polynomial p) {
        val newPolynomials = polynomials.stream()
                .map(pl -> {
                    if (pl.equals(p)) {
                        return pl.minus(p);
                    }

                    return pl;
                })
                .collect(Collectors.toSet());

        if (!newPolynomials.contains(p)) {
            newPolynomials.add(new Polynomial(-p.getCoefficient(), p.getIntermediates()));
        }

        return new PolynomialSum(newPolynomials);
    }

    // TODO refactor
    public PolynomialSum minus(PolynomialSum sum) {
        val newPolynomials = new HashMap<Polynomial, Double>();

        for (Polynomial p : polynomials) {
            newPolynomials.put(p, p.getCoefficient());
        }

        for (Polynomial pl : sum.polynomials) {
            newPolynomials.compute(pl, (pn, c) -> c == null ? -pl.getCoefficient() : c - pl.getCoefficient());
        }

        return new PolynomialSum(newPolynomials.entrySet()
                                         .stream()
                                         .map(e -> new Polynomial(e.getValue(), e.getKey().getIntermediates()))
                                         .collect(Collectors.toSet()));
    }

    public PolynomialSum multiply(Polynomial p) {
        return new PolynomialSum(performOperation2(p, Polynomial::multiply));
    }

    // TODO refactor
    public PolynomialSum multiply(PolynomialSum sum) {
        val newPolynomials = new HashMap<Polynomial, Double>();

        for (Polynomial i : polynomials) {
            for (Polynomial j : sum.polynomials) {
                newPolynomials.compute(i.multiply(j),
                                       (pn, c) -> c == null ? i.getCoefficient() * j.getCoefficient() :
                                               i.getCoefficient() * j
                                               .getCoefficient() + c);
            }
        }

        return new PolynomialSum(newPolynomials.entrySet()
                                         .stream()
                                         .map(e -> new Polynomial(e.getValue(), e.getKey().getIntermediates()))
                                         .collect(Collectors.toSet()));
    }

    public PolynomialSum divide(Polynomial p) {
        return new PolynomialSum(performOperation2(p, Polynomial::divide));
    }

    // TODO refactor
    public PolynomialSum divide(PolynomialSum sum) {
        val newPolynomials = new HashSet<Polynomial>();

        for (Polynomial i : polynomials) {
            for (Polynomial j : sum.polynomials) {
                newPolynomials.add(i.divide(j));
            }
        }

        return new PolynomialSum(newPolynomials);
    }

    public PolynomialSum power(int exponent) {
        var result = new PolynomialSum(polynomials);

        for (int i = 1; i < exponent; i++) {
            result = result.multiply(this);
        }

        return result;
    }

    private Set<Polynomial> performOperation(Set<Polynomial> polynomials,
                                             Polynomial p,
                                             BiFunction<Polynomial, Polynomial, Polynomial> performer) {
        val newPolynomials = polynomials.stream()
                .map(pl -> {
                    if (pl.equals(p)) {
                        return performer.apply(pl, p);
                    }

                    return pl;
                })
                .collect(Collectors.toSet());

        if (!newPolynomials.contains(p)) {
            newPolynomials.add(p);
        }

        return newPolynomials;
    }

    private Set<Polynomial> performOperation2(Polynomial p, BiFunction<Polynomial, Polynomial, Polynomial> performer) {
        return polynomials.stream()
                .map(pl -> performer.apply(pl, p))
                .collect(Collectors.toSet());
    }
}
