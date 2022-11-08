package practice;

/**
 * 304. Range Sum Query 2D - Immutable
 * */
public class RangeSumQuery {
    private int[][] prefixArray;

    public RangeSumQuery(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        //give row wise sum
        for (int i = 0; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                matrix[i][j] = matrix[i][j] +  matrix[i][j - 1];
            }
        }

        for(int i = 0; i < colLength; i++) {
            for (int j = 1; j < rowLength; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i-1][j];
            }
        }
        this.prefixArray = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = this.prefixArray[row2][col2];
        int commonSum = ((col1 > 0 && row1 > 0) ? this.prefixArray[row1 - 1][col1-1] : 0);
        int extraSum = (col1 != 0 ?this.prefixArray[row2][col1 - 1] : 0) + (row1 != 0 ? this.prefixArray[row1 - 1][col2] : 0) - commonSum;
        int actualSum = totalSum - extraSum;
        return actualSum;
    }

}
