package practice;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */
public class LC_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int closest = 0;
        for(int i = 0; i < size; i++ ) {
            int j = i + 1;
            int k = size - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target) {
                    return target;
                } else if(sum < target) {
                    j++;
                } else if(sum > target) {
                    k--;
                }

                int diff = Math.abs(target - sum);
                if(diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
            }

        }
        return closest;
    }

}
