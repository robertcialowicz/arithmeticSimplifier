package org;

import lombok.val;

public class Main {

    public static void main(String[] args) {
        val polynomial = "( 2 * a ^ 2 + 3 * a * b ) * a * b + a * b - a * b";
        //val polynomial = "( a + b ) / ( ( a + b ) ^ 2 )";
        //val polynomial = "( a * b ) / ( a ^ 3 )";
        //val polynomial = "a + b + a b + 7 + a ^ 3 + b ^ 2 + 1 + 0";
        //val polynomial = "( a + b ) ^ 2";
        //val polynomial = "a * ( b ^ ( 2 ) )";

        val tokens = ShuntingYard.postfix(polynomial.split(" "));
        val sum = new Evaluator().evaluate(tokens);

        System.out.println("==================================");
        System.out.println(tokens);
        System.out.println("==================================");
        System.out.println(sum.toString());
        System.out.println("==================================");
        System.out.println(ResultParser.polynomialSumToString(sum));
        System.out.println("==================================");

    }
}
