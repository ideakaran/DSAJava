package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Leetcode: 1
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
* */
public class LC_TwoSum {
    //Brute force approach
    /**
    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int target = 9;
        int[] result = new int[2];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if(i == j)
                    continue;
                int val1 = input[j];
                int val2 = input[i];
                if(val1 + val2 == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        System.out.println("result = " + Arrays.toString(result));
    }
     */

    //HashMap Approach
    //If the array was sorted use two pointer approach
    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int target = 9;
        Map<Integer, Integer> intToIndexMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < input.length; i++) {
            int value = input[i];
            int diff = target - value;
            if(intToIndexMap.get(diff) != null) {
                result[0] = i;
                result[1] = intToIndexMap.get(diff);
                break;
            } else {
                intToIndexMap.put(input[i], i);
            }
        }
        System.out.println("result = " + Arrays.toString(result));
    }
}
