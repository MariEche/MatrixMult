import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class MatrixMult {
    private static int[][] readMatrixFromFile(String filename) throws IOException {

        int i, j;
        FileReader reader1 = new FileReader(filename);
        BufferedReader br1 = new BufferedReader(reader1);
        String line1 = br1.readLine();
        String[] size1 = line1.split(" ");
        int rows1 = Integer.parseInt(size1[0]);
        int cols1 = Integer.parseInt(size1[1]);
        System.out.println("File %s has size: %d %d".formatted(filename, rows1, cols1));

        int[][] mat1 = new int[rows1][cols1];
        for (i = 0; i < rows1; i++) {
            line1 = br1.readLine();
            String[] row1 = line1.split(" ");
            for (j = 0; j < cols1; j++) {
                mat1[i][j] = Integer.parseInt(row1[j]);
            }
        }
        return mat1;
    }

    private static int[][] multiplyMatrix(int[][] matrixA, int[][] matrixB) {
        int numRowsA = matrixA.length;
        int numColsA = matrixA[0].length;
        int numColsB = matrixB[0].length;

        int[][] result = new int[numRowsA][numColsB];

        for (int i = 0; i < numRowsA; i++) {
            for (int j = 0; j < numColsB; j++) {
                int sum = 0;
                for (int k = 0; k < numColsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        String m1 = "";
        java.util.Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name of your first matrix:");
        m1 = scanner.nextLine();

        String m2 = "";
        java.util.Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the file name of your second matrix:");
        m2 = scanner1.nextLine();
        scanner.close();
        scanner1.close();

        int[][] matrix1 = readMatrixFromFile(m1);
        int[][] matrix2 = readMatrixFromFile(m2);

        System.out.println("Here is your first matrix:");
        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }

        System.out.println("Here is your second matrix:");
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }

        System.out.println("Here is your result matrix:");
        int[][] result = multiplyMatrix(matrix1, matrix2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        FileWriter writer = new FileWriter("matrix3.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i < result.length; i++) {
            buffer.write(Arrays.toString(result[i]));
            buffer.newLine();
        }
        buffer.close();
    }
}
