package practice;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example:
 *
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 *              [-2,0,1]
 *              [-2,0,3]
 */

//Not sure on this soln
public class LC_259 {
    public static void main(String[] args) {
        int[] input = {-2, 0, 1, 3};
        int count = 0;
        Arrays.sort(input);
        int target = 2;
        for (int i = 0; i < input.length; i++) {
            int j = i + 1;
            int k = input.length - 1;
            while ( j < k) {
                int sum = input[i] + input [j] + input[k];
                if(sum == target) {
                    k--;
                } else if ( sum < target) {
                    count++;
                    k--;

                } else if( sum > target) {
                    j++;
                }
            }
        }
        System.out.println("count = " + count);
    }
}
