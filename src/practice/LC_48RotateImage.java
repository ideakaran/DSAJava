package practice;

public class LC_48RotateImage {
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            //Transpose
            for (int j = i; j < matrix[0].length; j++) {
                int tempVal = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tempVal;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int tempVal = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length -1 -j];
                matrix[i][matrix.length -1 -j] = tempVal;
            }

        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
    }
}
