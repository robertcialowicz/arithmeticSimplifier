package org.antlr;

import lombok.val;
import org.Polynomial;
import org.PolynomialSum;

import java.util.ArrayList;

public class CalculatorVisitorImpl extends calculatorBaseVisitor<PolynomialSum> {

    @Override
    public PolynomialSum visitPlus(calculatorParser.PlusContext ctx) {
        return visit(ctx.multiplyingExpression()).plus(visit(ctx.expression()));
    }

    @Override
    public PolynomialSum visitMinus(calculatorParser.MinusContext ctx) {
        return visit(ctx.multiplyingExpression()).minus(visit(ctx.expression()));
    }

    @Override
    public PolynomialSum visitTimes(calculatorParser.TimesContext ctx) {
        return visit(ctx.powExpression()).multiply(visit(ctx.multiplyingExpression()));
    }

    @Override
    public PolynomialSum visitDiv(calculatorParser.DivContext ctx) {
        return visit(ctx.powExpression()).divide(visit(ctx.multiplyingExpression()));
    }

    @Override
    public PolynomialSum visitPow(calculatorParser.PowContext ctx) {
        // only integer exponents are supported at the moment
        val exponent = visit(ctx.signedAtom(1));
        // extracting the coefficient of the first polynomial to use as an exponent
        val firstExponentNumber = (int) new ArrayList<>(exponent.getPolynomials()).get(0).getCoefficient();

        return visit(ctx.signedAtom(0)).power(firstExponentNumber);
    }

    @Override
    public PolynomialSum visitPositiveAtom(calculatorParser.PositiveAtomContext ctx) {
        return visit(ctx.atom());
    }

    @Override
    public PolynomialSum visitNegativeAtom(calculatorParser.NegativeAtomContext ctx) {
        return visit(ctx.atom()).multiply(new Polynomial(-1));
    }

    @Override
    public PolynomialSum visitNumber(calculatorParser.NumberContext ctx) {
        return new PolynomialSum(new Polynomial(Double.parseDouble(ctx.FLOAT().getText())));
    }

    @Override
    public PolynomialSum visitVariable(calculatorParser.VariableContext ctx) {
        return new PolynomialSum(new Polynomial(1, ctx.VARIABLE().getText().charAt(0)));
    }

    @Override
    public PolynomialSum visitParens(calculatorParser.ParensContext ctx) {
        return visit(ctx.expression());
    }
}
