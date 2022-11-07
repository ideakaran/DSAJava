package practice;

import java.util.*;

/**
 * Leetcode: 15
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class LC_ThreeSum {
    public static void main(String[] args) {


        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        List<List<Integer>> result2 = threeSumBruteForce(nums);
        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
    }

    //TIme Complexity: O(nlogn) for sort and O(n^2) for for loop and while
    public static List<List<Integer>>  threeSum(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();
        if(nums.length == 0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int  j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if(sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        return new ArrayList<>(res);

    }

//    Time Complexity O(n^3)
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k =  j + 1; k < nums.length; k++) {

                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> r = new ArrayList<>();
                        r.add(nums[i]);
                        r.add(nums[j]);
                        r.add(nums[k]);
                        result.add(r);
                    }

                }

            }
        }
        System.out.println("Arrays.toString(result) = " + result);
        return new ArrayList<>(result);
    }

}
