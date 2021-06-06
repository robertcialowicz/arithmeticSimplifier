package org;

import lombok.val;
import org.antlr.CalculatorVisitorImpl;
import org.antlr.calculatorLexer;
import org.antlr.calculatorParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    public static void main(String[] args) {
//        val polynomial = "( 2 * a ^ 2 + 3 * a * b ) * a * b + a * b - a * b";
//        val tokens = ShuntingYard.postfix(polynomial.split(" "));
//
//        System.out.println(tokens);
//
//        val sum = new Evaluator().evaluate(tokens);
//
//        System.out.println("==================================");
//        System.out.println(sum);

        val stream = CharStreams.fromString("(-2 * a) ^ 4");
        val lexer = new calculatorLexer(stream);
        val tokens = new CommonTokenStream(lexer);
        val parser = new calculatorParser(tokens);
        val tree = parser.expression();

        val result = new CalculatorVisitorImpl().visit(tree);

        System.out.println(tokens.getTokens());
        System.out.println(result);
    }
}
