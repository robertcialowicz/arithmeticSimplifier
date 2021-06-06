package org;

import java.util.Set;

public class ResultParser {

    public static String polynomialSumToString(PolynomialSum polynomialSum){
        String output = "";
        output = polynomialSumToString(polynomialSum.getPolynomials());
        return output;
    }

    public static String polynomialSumToString(Set<Polynomial> polynomials){

        StringBuilder output = new StringBuilder();

        for (Polynomial polynomial : polynomials) {

            if (polynomial.getCoefficient() == 0 ) continue;
            if (polynomial.getCoefficient() != 1 ) output.append(polynomial.getCoefficient());
                                                         //.append("*");
            if (polynomial.getCoefficient() == 1 && polynomial.getIntermediates().size() == 0) output.append("1");

            for (Intermediate intermediate : polynomial.getIntermediates()){
                if (intermediate.getExponent() == 0) {
                    continue;
                } else if (intermediate.getExponent() == 1) {
                    output.append((intermediate.getSymbol()));
                } else if (intermediate.getExponent() < 0 ) {
                    output.append("(")
                              .append(intermediate.getSymbol())
                              .append("^")
                              .append("(")
                                  .append(intermediate.getExponent())
                              .append(")")
                          .append(")");
                } else {
                    output.append("(")
                              .append(intermediate.getSymbol())
                              .append("^")
                              .append(intermediate.getExponent())
                          .append(")");
                }
                //output.append("*");
            }
            //output.delete(output.length()-1, output.length());
            output.append("+");
        }
        output.delete(output.length()-1, output.length());
        return output.toString();
    }
}
