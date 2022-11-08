package practice;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println("result = " + Arrays.toString(result));

    }

    public static int[] productExceptSelf(int[] nums) {
       int[] result = new int[nums.length];
       int[] prefix = new int[nums.length];
       int[] suffix = new int[nums.length];
       prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >=0 ; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;

    }

    public static void bruteForceApproach() {
        int[] nums = {1, 2, 3, 4};
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if(i == j) {
                    continue;
                } else {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        System.out.println("result = " + Arrays.toString(result));
    }
}
