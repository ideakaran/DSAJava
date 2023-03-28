package oldpractice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayHavingSumK {
    // function to find the length of longest
    // subarray having sum k
    static int lenOfLongSubarr(int[] arr, int n, int k)
    {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == k)
                maxLen = i + 1;

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(k - arr[i])) {
               maxLen = Math.max(maxLen, map.get(k - arr[i]) + 1 + 1);
            }

            if(map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }

        return maxLen;
    }

    // Driver code
    public static void main(String args[])
    {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int[] arr2 = {10, 5, 2, -3};
        int k2 = 12;
        int n = arr.length;
        int k = 15;
        System.out.println("Length = " +
                lenOfLongSubarr(arr, n, k));
    }
}
