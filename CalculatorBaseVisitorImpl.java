import java.util.HashMap;

public class CalculatorBaseVisitorImpl extends CalculatorBaseVisitor<Double> {
    private HashMap<String, Double> variables = new HashMap<String, Double>();

    @Override
    public Double visitPlus(CalculatorParser.PlusContext ctx) {
        return visit(ctx.plusOrMinus()) + visit(ctx.multOrDiv());
    }
    
    @Override
    public Double visitMinus(CalculatorParser.MinusContext ctx) {
        return visit(ctx.plusOrMinus()) - visit(ctx.multOrDiv());
    }

    @Override
    public Double visitMultiplication(CalculatorParser.MultiplicationContext ctx) {
        return visit(ctx.multOrDiv()) * visit(ctx.pow());
    }

    @Override
    public Double visitDivision(CalculatorParser.DivisionContext ctx) {
        return visit(ctx.multOrDiv()) / visit(ctx.pow());
    }

    @Override
    public Double visitSetVariable(CalculatorParser.SetVariableContext ctx) {
        Double value = visit(ctx.plusOrMinus());
        variables.put(ctx.ID().getText(), value);
        return value;
    }

    @Override
    public Double visitPower(CalculatorParser.PowerContext ctx) {
        if (ctx.pow() != null)
            return Math.pow(visit(ctx.unaryMinus()), visit(ctx.pow()));
        return visit(ctx.unaryMinus());
    }

    @Override
    public Double visitChangeSign(CalculatorParser.ChangeSignContext ctx) {
        return -1*visit(ctx.unaryMinus());
    }

    @Override
    public Double visitBraces(CalculatorParser.BracesContext ctx) {
        return visit(ctx.plusOrMinus());
    }

    @Override
    public Double visitConstantPI(CalculatorParser.ConstantPIContext ctx) {
        return Math.PI;
    }

    @Override
    public Double visitConstantE(CalculatorParser.ConstantEContext ctx) {
        return Math.E;
    }

    @Override
    public Double visitInt(CalculatorParser.IntContext ctx) {
        return Double.parseDouble(ctx.INT().getText());
    }

    @Override
    public Double visitVariable(CalculatorParser.VariableContext ctx) {
        return variables.get(ctx.ID().getText());
    }

    @Override
    public Double visitDouble(CalculatorParser.DoubleContext ctx) {
        return Double.parseDouble(ctx.DOUBLE().getText());
    }

    @Override
    public Double visitMatrix(CalculatorParser.MatrixContext ctx) {
        String str = ctx.matrixdef().getText().substring(1, ctx.matrixdef().getText().length() - 1);
        String[] parts = str.split(";");
        Double[][] matrix = new Double[parts.length][parts[0].length()];
        for (int i = 0; i < parts.length; i++) {
            String[] numbers = parts[i].split(",");
            for (int j = 0; j < numbers.length; j++){
                matrix[i][j] = Double.parseDouble(numbers[j]);
            }
        }
        Matrix m = new Matrix(matrix);
        m.printMatrix();
        System.out.println(m.getColSize());
        System.out.println(m.getRowSize());

        return null;
    }

    @Override
    public Double visitCalculate(CalculatorParser.CalculateContext ctx) {
        return visit(ctx.plusOrMinus());
    }
}
