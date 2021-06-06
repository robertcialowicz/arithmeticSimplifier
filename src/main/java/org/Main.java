package org;

import lombok.val;
import org.antlr.CalculatorVisitorImpl;
import org.antlr.calculatorLexer;
import org.antlr.calculatorParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String inputFilePath = "./src/main/example/example.txt";
        Set<String> polynomials = InputParser.readFileLineByLine(inputFilePath);

        for(String polynomial : polynomials){
            val stream = CharStreams.fromString(polynomial);
            val lexer = new calculatorLexer(stream);
            val tokens = new CommonTokenStream(lexer);
            val parser = new calculatorParser(tokens);
            val tree = parser.expression();

            val result = new CalculatorVisitorImpl().visit(tree);

            System.out.println("==================================");
            System.out.println(polynomial);
            System.out.println(result);
            System.out.println(ResultParser.polynomialSumToString(result));
            InputParser.saveLineToFile( InputParser.buildResultPath(inputFilePath),
                                    polynomial + "   ->   " +ResultParser.polynomialSumToString(result));
            System.out.println("==================================");

        }
    }
}
