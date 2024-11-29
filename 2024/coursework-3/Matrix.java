/*
Coursework 3: Matrix Class
 */

public class Matrix {
    private final double[][] matrix;
    private final int rows;
    private final int cols;

    // Task 1: Constructor
    public Matrix(double[][] matrix) {

        this.matrix = matrix;
        validateMatrix();
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    // Validation helper
    private void validateMatrix() {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        for (double[] row : matrix) {
            if (row.length != matrix[0].length) {
                throw new IllegalArgumentException("Matrix rows must have the same number of columns");
            }
        }
    }

    // Task 3: Matrix Addition
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    // Task 4: Matrix Subtraction
    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    // Task 5: Matrix Multiplications
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Number of columns in first matrix must equal number of rows in second matrix");
        }
        double[][] result = new double[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    // Task 6: Matrix Transposition
    public Matrix transpose() {
        double[][] result = new double[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return new Matrix(result);
    }

    // Task 7: Matrix Determinant
    public double determinant() {
        // calculate the determinant for matrix no greater than 3x3
        if (rows > 3) {
            return Double.NaN;
        } else {
            return det();
        }
    }

    // general method to calculate determinant
    public double det() {
        if (!isSquare()) {
            throw new IllegalArgumentException("Matrix must be square to calculate determinant");
        }
        if (rows == 1) {
            return matrix[0][0];
        }
        if (rows == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int j = 0; j < cols; j++) {
            det += Math.pow(-1, j) * matrix[0][j] * subMatrix(0, j).det();
        }
        return det;
    }

    private Matrix subMatrix(int row, int col) {
        double[][] smaller = new double[rows - 1][cols - 1];
        int r = 0;
        for (int i = 0; i < rows; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < cols; j++) {
                if (j == col) continue;
                smaller[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return new Matrix(smaller);
    }

    // fun stuff
    // calculate the power of the matrix
    public Matrix power(int n) {
        if (!isSquare()) {
            throw new IllegalArgumentException("Matrix must be square for power operation");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Power must be non-negative");
        }
        if (n == 0) {
            return identity(rows);
        }
        if (n == 1) {
            return this;
        }

        Matrix result = this;
        for (int i = 1; i < n; i++) {
            result = result.multiply(this);
        }
        return result;
    }

    // calculate the trace of the matrix (sum of diagonal elements)
    public double trace() {
        if (!isSquare()) {
            throw new IllegalArgumentException("Matrix must be square to calculate trace");
        }
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    // calculate the inverse of the matrix
    public Matrix inverse() {
        if (!isSquare()) {
            throw new IllegalArgumentException("Matrix must be square to calculate inverse");
        }
        double det = det();
        if (Math.abs(det) < 1e-10) {
            throw new IllegalArgumentException("Matrix is not invertible");
        }

        if (rows == 2) {
            double[][] inv = new double[2][2];
            inv[0][0] = matrix[1][1] / det;
            inv[0][1] = -matrix[0][1] / det;
            inv[1][0] = -matrix[1][0] / det;
            inv[1][1] = matrix[0][0] / det;
            return new Matrix(inv);
        }
        // for larger matrices, use adjugate formula
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = Math.pow(-1, i + j) * subMatrix(i, j).det() / det;
            }
        }
        return new Matrix(result);
    }

    // check if matrix is identity (i.e., all elements are 0 except for diagonal elements which are 1)
    private static Matrix identity(int size) {
        double[][] id = new double[size][size];
        for (int i = 0; i < size; i++) {
            id[i][i] = 1.0;
        }
        return new Matrix(id);
    }

    // check if matrix is square
    public boolean isSquare() {
        return rows == cols;
    }

    // check if matrix is identity
    public boolean isIdentity() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    // check if matrix is symmetric
    public boolean isSymmetric() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Task 2: Accessor method
    public double[][] getData() {
        double[][] copy = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, cols);
        }
        return copy;
    }

    // Task 2 Bonus: Accessor methods for rows and columns
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    // toString method with matrix-like formatting
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append("│ ");
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%8.3f ", matrix[i][j]));
            }
            sb.append("│\n");
        }
        return sb.toString();
    }
}