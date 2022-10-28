import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int result[] = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            int product = 1;
            for(int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        System.out.println(Arrays.toString(result));
    }
}
