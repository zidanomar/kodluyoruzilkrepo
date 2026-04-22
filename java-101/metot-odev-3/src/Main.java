public class Main {
    static int[][] transpose(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[j][i] = matrix[i][j];
        return result;
    }

    static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) System.out.printf("%-5d", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 3, 4}, {5, 6, 4}};
        System.out.println("Matris:");
        printMatrix(matrix);
        System.out.println("Transpoze:");
        printMatrix(transpose(matrix));
    }
}
