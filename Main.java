import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String args[]) {
        System.out.print("What's the n value of your n by n matrix: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Format for entering values of matrix: 1 0 0 1 for matrix\n1 0\n0 1");
        System.out.print("Enter values of matrix: ");

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }

        System.out.println("Your matrix is:");

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }

        System.out.println(det(matrix));

    }

    public static double det(int[][] matrix) {
        if (matrix.length == 2) {
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        } else {
            int total = 0;
            for (int col = 0; col < matrix.length; col++) {
                //System.out.println(Math.pow(-1, (1 + col + 1)));
                //System.out.println(matrix[0][col]);
                //System.out.println(det(smallerMatrix(matrix, col)));
                total += Math.pow(-1, (1 + col + 1)) * matrix[0][col] * det(smallerMatrix(matrix, col));
            }
            return total;
        }

    }

    public static int[][] smallerMatrix(int[][] matrix, int currCol) {
        int[][] smaller = new int[matrix.length - 1][matrix.length - 1];
        for (int row = 1; row < matrix.length; row++) {
            int colWeNeedToSet = 0;
            for (int col = 0; col < matrix.length; col++) {
                if (col != currCol) {
                    smaller[row-1][colWeNeedToSet] = matrix[row][col];
                    colWeNeedToSet++;
                }

            }

        }
        /*for (int row = 0; row < smaller.length; row++) {
            for (int col = 0; col < smaller.length; col++) {
                System.out.print(smaller[row][col] + " ");
            }
            System.out.println("");
        }*/
        return smaller;

    }


}
