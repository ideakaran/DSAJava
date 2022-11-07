import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        if(nums.length < 1) {
            return ;
        }
        int length = nums.length - 1;
        for(int i = length; i > 0; i--) {

            int prevVal = nums[i - 1];
            int currVal = nums[i];
            if(prevVal < currVal) {
                int idx = findHigherVal(i, nums);
                if(idx > -1) {
                    int temp = nums[idx];
                    nums[i - 1] = temp;
                    nums[idx] = prevVal;
                    nums = reverse(i, nums);
                    flag = true;
                    break;
                }
            }
        }

        if(!flag) {
            reverse(0, nums);
        }
        System.out.println(Arrays.toString(nums));
    }

    private int findHigherVal(int index, int[] nums) {
        int prevVal = nums[index - 1];
        int exchangeIdx = index;
        int maxVal = nums[index];
        for(int i = index; i < nums.length; i++) {
            if(prevVal < nums[i] && nums[i] < maxVal) {
                exchangeIdx = i;
                maxVal = nums[i];
            }
        }
        return exchangeIdx;
    }

    private int[] reverse(int index, int[] nums) {
        int counter = nums.length - 1;
        for(int i = index; i < counter; ++i) {
            int temp = nums[counter];
            if(temp < nums[i]) {
                nums[counter] = nums[i];
                nums[i] = temp;
            }
            counter--;
        }
        return nums;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
//        int[] inp = {1, 5, 8,4, 7, 6, 5, 3, 1}; // 1, 5, 8, 5, 1, 3, 4, 6, 7
        int[] inp = {3,4,1,4,3,3}; // 1, 5, 8, 5, 1, 3, 4, 6, 7
//        int[] inp = {1,2, 3}; // 1, 5, 8, 5, 1, 3, 4, 6, 7
        np. nextPermutation(inp);
    }
}
