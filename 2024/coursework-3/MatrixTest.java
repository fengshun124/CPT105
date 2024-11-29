public class MatrixTest {
    public static void test() {
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6}, {7, 8}};

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        Matrix sum = matrix1.add(matrix2);
        Matrix difference = matrix1.subtract(matrix2);
        Matrix product = matrix1.multiply(matrix2);
        Matrix transpose = matrix1.transpose();
        double determinant = matrix1.determinant();

        // Print results
        System.out.println("Sum:");
        printMatrix(sum.getData());
        System.out.println("Difference:");
        printMatrix(difference.getData());
        System.out.println("Product:");
        printMatrix(product.getData());
        System.out.println("Transpose:");
        printMatrix(transpose.getData());
        System.out.println("Determinant:");
        System.out.println(determinant);
    }

    public static void testValidOperations() {
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6}, {7, 8}};

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        // Test Addition
        Matrix sum = matrix1.add(matrix2);
        double[][] expectedSum = {{6, 8}, {10, 12}};
        if (areMatricesEqual(sum.getData(), expectedSum)) {
            System.out.println("Test Valid Addition: Passed");
        } else {
            System.out.println("Test Valid Addition: Failed");
        }

        // Test Subtraction
        Matrix difference = matrix1.subtract(matrix2);
        double[][] expectedDifference = {{-4, -4}, {-4, -4}};
        if (areMatricesEqual(difference.getData(), expectedDifference)) {
            System.out.println("Test Valid Subtraction: Passed");
        } else {
            System.out.println("Test Valid Subtraction: Failed");
        }

        // Test Multiplication
        Matrix product = matrix1.multiply(matrix2);
        double[][] expectedProduct = {{19, 22}, {43, 50}};
        if (areMatricesEqual(product.getData(), expectedProduct)) {
            System.out.println("Test Valid Multiplication: Passed");
        } else {
            System.out.println("Test Valid Multiplication: Failed");
        }

        // Test Transposition
        Matrix transpose = matrix1.transpose();
        double[][] expectedTranspose = {{1, 3}, {2, 4}};
        if (areMatricesEqual(transpose.getData(), expectedTranspose)) {
            System.out.println("Test Valid Transposition: Passed");
        } else {
            System.out.println("Test Valid Transposition: Failed");
        }

        // Test Determinant
        double determinant = matrix1.determinant();
        double expectedDeterminant = -2.0;
        if (determinant == expectedDeterminant) {
            System.out.println("Test Valid Determinant: Passed");
        } else {
            System.out.println("Test Valid Determinant: Failed");
        }
    }

    public static boolean areMatricesEqual(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void testInvalidConstructor() {
        try {
            double[][] invalidData = null;
            Matrix invalidMatrix = new Matrix(invalidData);
            System.out.println("Test Invalid Constructor (null data): Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Invalid Constructor (null data): Passed");
        }

        try {
            double[][] invalidData = {{1, 2}, {3}};
            Matrix invalidMatrix = new Matrix(invalidData);
            System.out.println("Test Invalid Constructor (jagged array): Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Invalid Constructor (jagged array): Passed");
        }
    }

    public static void testInvalidAddition() {
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6, 7}, {8, 9, 10}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        try {
            matrix1.add(matrix2);
            System.out.println("Test Invalid Addition (different sizes): Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Invalid Addition (different sizes): Passed");
        }
    }

    public static void testInvalidSubtraction() {
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6, 7}, {8, 9, 10}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        try {
            matrix1.subtract(matrix2);
            System.out.println("Test Invalid Subtraction (different sizes): Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Invalid Subtraction (different sizes): Passed");
        }
    }

    public static void testInvalidMultiplication() {
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        try {
            matrix1.multiply(matrix2);
            System.out.println("Test Invalid Multiplication (incompatible sizes): Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Invalid Multiplication (incompatible sizes): Passed");
        }
    }

    public static void testInvalidDeterminant() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        Matrix matrix = new Matrix(data);

        try {
            matrix.determinant();
            System.out.println("Test Invalid Determinant (non-square matrix): Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Invalid Determinant (non-square matrix): Passed");
        }
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void testAdditionalFeatures() {
        double[][] data1 = {
                {1, 0, 1, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 1}
        };
        Matrix matrix1 = new Matrix(data1);

        System.out.println(matrix1);
        System.out.println("N rows: " + matrix1.getRows() + "\nN cols: " + matrix1.getCols());
        System.out.println("Is square matrix? " + matrix1.isSquare());
        System.out.println("Is identity matrix? " + matrix1.isIdentity());
        System.out.println("Is symmetric matrix? " + matrix1.isSymmetric());

        System.out.println("trace\n" + matrix1.trace());
        System.out.println("power of three\n" + matrix1.power(3));
        System.out.println("inverse\n" + matrix1.inverse());
    }

    public static void main(String[] args) {
        test();
        testAdditionalFeatures();
        testValidOperations();
        testInvalidConstructor();
        testInvalidAddition();
        testInvalidSubtraction();
        testInvalidMultiplication();
        testInvalidDeterminant();
    }
}
