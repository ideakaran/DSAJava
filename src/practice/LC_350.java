package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 */
public class LC_350 {
    public static void main(String[] args) {
        approach();
    }
    public static int[] approach() {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            list2.add(nums2[i]);
        }
        list1.retainAll(list2);
        return list1.stream().mapToInt(Integer::intValue).toArray();
    }

}
