package practice;

import java.lang.reflect.Array;
import java.util.*;

/*
* Given two integer arrays nums1 and nums2, return an array of their intersection.
* Each element in the result must be unique and you may return the result in any order.
* */
public class LC_349 {
    public static void main(String[] args) {
        bruteForceApproach();
        int[] approach2 = otherApproach();
        System.out.println("approach2 = " + approach2);
    }

    public static int[] otherApproach() {
        int nums1[] = {4,9,5};
        int nums2[] = {9,4,9,8,4};

        HashSet<Integer> set1 = new HashSet<>();
        for(Integer n : nums1) {
            set1.add(n);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for(Integer n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }


    public static int[] bruteForceApproach() {
        int num1[] = {4,9,5};
        int num2[] = {9,4,9,8,4};
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                if(num1[i] == num2[j]) {
                    result.add(num1[i]);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
