package oldpractice;

import java.util.Arrays;

public class RotateMatrixBy90Deg {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }

        //Transpose matrix
        for(int i=0; i < matrix.length; i++) {
            for(int j=i; j < matrix[0].length; j++) {
                int tempVal = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tempVal;
            }
        }

        //Reverse matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int tempVal = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 -j];
                matrix[i][matrix.length - 1 -j] = tempVal;
            }
        }

        System.out.println("====================================OUTPUT=================================");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }
    }
}
