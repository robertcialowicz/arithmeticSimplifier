import java.util.Arrays;

public class Matrix {
   public Double[][] matrix;
   public int rowSize;
   public int colSize;

    public Matrix(Double[][] matrix) {
        this.matrix = matrix;
        this.rowSize = matrix.length;
        this.colSize = matrix[0].length;
    }

    public Double[][] getMatrix() {
        return matrix;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return colSize;
    }

    public boolean hasSingleElement() {
        return this.colSize == 1 && this.rowSize ==1;
    }

    public void printMatrix() {
        if(this.hasSingleElement()) {
            System.out.println(matrix[0][0]);
        } else {
            System.out.println(Arrays.deepToString(matrix));
        }
    }
}
