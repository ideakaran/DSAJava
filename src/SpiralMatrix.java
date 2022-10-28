import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> spiralOrder = spiralOrder(input);
        System.out.println("spiralOrder = " + Arrays.toString(new List[]{spiralOrder}));
        System.out.println("expected = [1,2,3,6,9,8,7,4,5]");
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowFirst = 0, colLast = matrix[0].length;
        int rowLast = matrix.length, colFirst = 0;

        List<Integer> result = new ArrayList<>();
        boolean topRowVisited = false, rightColVisited = true, bottomRowVisited = true, leftColVisited = true;
        int i=0, j =0;

        while(result.size() != (matrix.length * matrix[0].length)) {
            if(!topRowVisited) {
                result.add(matrix[i][j]);
                j++;
                if(j == colLast) {
                    topRowVisited = true;
                    rightColVisited = false;
                    i++;
                    j--;
                    colLast -= 1;
                }
            }

            if(!rightColVisited) {
                result.add(matrix[i][j]);
                i++;
                if(i == rowLast) {
                    rightColVisited = true;
                    bottomRowVisited = false;
                    j--;
                    i--;
                    rowLast -= 1;
                }

            }

            if(!bottomRowVisited) {
                result.add(matrix[i][j]);
                j--;
                if(j < colFirst) {
                    bottomRowVisited = true;
                    leftColVisited = false;
                    i--;
                    j++;
                    rowFirst += 1;
                }
            }

            if(!leftColVisited) {
                result.add(matrix[i][j]);
                i--;
                if(i < rowFirst) {
                    leftColVisited = true;
                    topRowVisited = false;
                    colFirst += 1;


                }
            }

        }
        return result;

    }
}

