package org;

import lombok.val;

public class Main {

    public static void main(String[] args) {
        val polynomial = "( 2 * a ^ 2 + 3 * a * b ) * a * b + a * b - a * b";
        val tokens = ShuntingYard.postfix(polynomial.split(" "));

        System.out.println(tokens);

        val sum = new Evaluator().evaluate(tokens);

        System.out.println("==================================");
        System.out.println(sum);
    }
}
