package oldpractice;

public class LC304RangeSumQuery {
    private int[][] prefixArray;

    LC304RangeSumQuery(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        
        //gives row wise sum
        for (int i = 0; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
            }
        }
        
        //gives col wise sum
        for (int i = 1; i < rowLength ; i++) {
            for (int j = 0; j < colLength; j++) {
                matrix[i][j] =matrix[i][j] + matrix[i - 1] [j];
            }
        }

        this.prefixArray = matrix;
    }

    public int getSum(int row1, int col1, int row2, int col2) {
        int totalSum = this.prefixArray[row2][col2];
        int commonSum = ((col1 > 0 && row1 > 0) ? this.prefixArray[row1 - 1][col1 - 1] : 0);

        int extraSum = (col1 != 0 ? this.prefixArray[row2][col1 - 1 ] :  0) + (row1 != 0 ? this.prefixArray[row1 - 1][col2] : 0) - commonSum;
        int actualSum = totalSum - extraSum;
        return actualSum;
    }



    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        LC304RangeSumQuery lc = new LC304RangeSumQuery(matrix);
        int totalSum = lc.getSum(2,1,4,3);
        System.out.println(lc.getSum(1,1,2,2));
        System.out.println("totalSum = " + totalSum);
        System.out.println(lc.getSum(1,2,2,4));

    }
}
