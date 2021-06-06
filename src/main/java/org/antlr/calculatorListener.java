package org.antlr;// Generated from calculator.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calculatorParser}.
 */
public interface calculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlus(calculatorParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlus(calculatorParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(calculatorParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(calculatorParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toMultiplyingExpression}
	 * labeled alternative in {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterToMultiplyingExpression(calculatorParser.ToMultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toMultiplyingExpression}
	 * labeled alternative in {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitToMultiplyingExpression(calculatorParser.ToMultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Times}
	 * labeled alternative in {@link calculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterTimes(calculatorParser.TimesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Times}
	 * labeled alternative in {@link calculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitTimes(calculatorParser.TimesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link calculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterDiv(calculatorParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link calculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitDiv(calculatorParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toPowExpression}
	 * labeled alternative in {@link calculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterToPowExpression(calculatorParser.ToPowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toPowExpression}
	 * labeled alternative in {@link calculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitToPowExpression(calculatorParser.ToPowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link calculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPow(calculatorParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link calculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPow(calculatorParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toSignedAtom}
	 * labeled alternative in {@link calculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterToSignedAtom(calculatorParser.ToSignedAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toSignedAtom}
	 * labeled alternative in {@link calculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitToSignedAtom(calculatorParser.ToSignedAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PositiveAtom}
	 * labeled alternative in {@link calculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterPositiveAtom(calculatorParser.PositiveAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PositiveAtom}
	 * labeled alternative in {@link calculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitPositiveAtom(calculatorParser.PositiveAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegativeAtom}
	 * labeled alternative in {@link calculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterNegativeAtom(calculatorParser.NegativeAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegativeAtom}
	 * labeled alternative in {@link calculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitNegativeAtom(calculatorParser.NegativeAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumber(calculatorParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumber(calculatorParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVariable(calculatorParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVariable(calculatorParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParens(calculatorParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParens(calculatorParser.ParensContext ctx);
}
