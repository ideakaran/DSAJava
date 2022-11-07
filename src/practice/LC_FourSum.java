package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Leetcode: 18
* Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
* */
public class LC_FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int k = j + 1;
                int l = size - 1;
                while(k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);

                        int leftValue = nums[k];
                        while(k < size && nums[k] == leftValue) {
                            ++k;
                        }
                        int rightValue = nums[l];
                        while(l > k && nums[l] == rightValue) {
                            --l;
                        }


                    } else if(sum < target) {
                        k++;
                    } else if(sum > target) {
                        l--;
                    }
                }
                while(j + 1 < size && nums[j + 1] == nums[j]) {
                    ++j;
                }
            }
            while(i + 1 < size && nums[i + 1] == nums[i]) {
                ++i;
            }

        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println("result = " + result);
    }
}
