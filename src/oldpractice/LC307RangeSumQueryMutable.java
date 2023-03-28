package oldpractice;

public class LC307RangeSumQueryMutable {
    int[] sum;
    public LC307RangeSumQueryMutable(int[] nums) {
        calculateSum(nums);
        sum = nums;
    }

    public int[] calculateSum(int[] nums) {
        for(int i = 1; i< nums.length ; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    public void update(int index, int val) {
        int oldVal = sum[index];
        int newSumAtIndex = 0;

        if(index == 0) {
            newSumAtIndex = val;
            oldVal = 0;
            sum[index] =newSumAtIndex;
        } else {
            newSumAtIndex = val + sum[index - 1];
            sum[index] = val + sum[index - 1];
        }
        for(int i = index + 1; i < sum.length; i++) {
            if(i >= 1) {
                oldVal = sum[index];
            }
            sum[i] = sum[i] - oldVal + newSumAtIndex;
        }

    }

    public int sumRange(int left, int right) {
        if(left == 0) {
            return sum[right];
        } else {
            return sum[right] - sum[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, -8};
        LC307RangeSumQueryMutable obj = new LC307RangeSumQueryMutable(nums);
        obj.update(0,3);
        System.out.println(obj.sumRange(0,1));
    }
}
