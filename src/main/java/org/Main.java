package org;

import lombok.val;

import java.io.IOException;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String inputFilePath = "./src/main/example/example.txt";
        Set<String> polynomials = InputParser.readFileLineByLine(inputFilePath);

        for(String polynomial : polynomials){
            val tokens = ShuntingYard.postfix(polynomial.split(" "));
            val sum = new Evaluator().evaluate(tokens);

            System.out.println("==================================");
            System.out.println(tokens);
            System.out.println(sum.toString());
            System.out.println(ResultParser.polynomialSumToString(sum));
            InputParser.saveLineToFile( InputParser.buildResultPath(inputFilePath),
                                    polynomial + "   ->   " +ResultParser.polynomialSumToString(sum));
            System.out.println("==================================");

        }
    }
}
