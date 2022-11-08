package practice;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class LC_74Search2dMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        final int m = matrix.length;
        final int n = matrix[0].length;
        int l = 0;
        int r = m * n ;
        while (l < r) {
            final int mid = (l + r) / 2;
            final int i = mid / n;
            final int j = mid % n;
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int targer = 30;
        System.out.println(searchMatrix(matrix, targer));
    }
}
