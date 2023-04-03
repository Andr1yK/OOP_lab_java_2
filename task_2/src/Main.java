import java.util.Random;

public class Main {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        int rows = 8;
        int cols = 5;
        int[][] matrix = new int[rows][cols];
        create(matrix);
        print(matrix);
        System.out.println("---------------------------");
        sort(matrix);
        print(matrix);
        System.out.println("---------------------------");
        calculateSumAndCount(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void create(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rnd.nextInt(50) - 26;
            }
        }
    }

    private static void sort(int[][] matrix) {
        for (int i0 = 0; i0 < matrix.length - 1; i0++) {
            for (int i1 = 0; i1 < matrix.length - i0 - 1; i1++) {
                if ((matrix[i1][0] > matrix[i1 + 1][0]) ||
                        (matrix[i1][0] == matrix[i1 + 1][0] && matrix[i1][1] < matrix[i1 + 1][1]) ||
                        (matrix[i1][0] == matrix[i1 + 1][0] && matrix[i1][1] == matrix[i1 + 1][1] &&
                                matrix[i1][2] > matrix[i1 + 1][2])) {
                    change(matrix, i1, i1 + 1, matrix[0].length);
                }
            }
        }
    }

    private static void change(int[][] matrix, int row1, int row2, int colCount) {
        int tmp;
        for (int j = 0; j < colCount; j++) {
            tmp = matrix[row1][j];
            matrix[row1][j] = matrix[row2][j];
            matrix[row2][j] = tmp;
        }
    }

    private static void calculateSumAndCount(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] > 0 && ints[j] % 2 == 0) {
                    continue;
                }
                count++;
                sum += ints[j];
            }
        }
        System.out.println("Count elements: " + count);
        System.out.println("Sum elements: " + sum);
    }
}
