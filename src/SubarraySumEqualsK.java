import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int totalCount = 0;
        int nums[] ={1,2,1,2,1};
        int k = 3;
        Map<Integer, Integer> sumToIndexMap = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(!sumToIndexMap.containsKey(sum)) {
                sumToIndexMap.put(sum, i);
            }

            if(sum == k || nums[i] == k) {
                ++totalCount;
                continue;
            }

            if (i > 0 && sumToIndexMap.get(k - sum) != null) {
                ++totalCount;
            }
        }
        System.out.println("totalCount = " + totalCount);
    }
}
