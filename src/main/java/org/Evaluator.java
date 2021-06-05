package org;

import lombok.val;

import java.util.*;

public class Evaluator {

    public PolynomialSum evaluate(List<String> tokens) {
        Deque<PolynomialSum> stack = new LinkedList<>();

        for (String token : tokens) {
            if (Operator.contains(token)) {
                val p1 = stack.pop();
                val p2 = stack.pop();

                stack.push(performOperation(p2, p1, Operator.getBySymbol(token)));
            } else {
                stack.push(parsePolynomial(token));
            }
        }

        return stack.pop();
    }

    private PolynomialSum performOperation(PolynomialSum p1, PolynomialSum p2, Operator op) {
        switch (op) {
            case ADD:
                return p1.plus(p2);
            case SUBTRACT:
                return p1.minus(p2);
            case MULTIPLY:
                return p1.multiply(p2);
            case DIVIDE:
                return p1.divide(p2);
            case POWER:
                return p1.power((int) new ArrayList<>(p2.getPolynomials()).get(0).getCoefficient());
        }

        throw new IllegalArgumentException("Not allowed operator: " + op);
    }

    private PolynomialSum parsePolynomial(String token) {
        if (token.matches("[0-9]+")) {
            return new PolynomialSum(new Polynomial(Double.parseDouble(token)));
        }

        return new PolynomialSum(new Polynomial(1, Set.of(new Intermediate(token.charAt(0), 1))));
    }
}
