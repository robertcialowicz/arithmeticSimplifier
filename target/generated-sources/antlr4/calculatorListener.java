// Generated from calculator.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calculatorParser}.
 */
public interface calculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(calculatorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(calculatorParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(calculatorParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(calculatorParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(calculatorParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(calculatorParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterSignedAtom(calculatorParser.SignedAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitSignedAtom(calculatorParser.SignedAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(calculatorParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(calculatorParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculatorParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(calculatorParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculatorParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(calculatorParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculatorParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(calculatorParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculatorParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(calculatorParser.VariableContext ctx);
}