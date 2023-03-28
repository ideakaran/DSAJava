package oldpractice;

public class LC303RangeSumQueryImmutable {
    int[] sum;
    public LC303RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1] ;
        }
    }

    public int sumRange(int left, int right) {
        if(left != 0)
            return sum[right] - sum[left - 1] ;
        else
            return sum[right];
    }

    public static void main(String[] args) {
        int[] input = {-2,0,3,-5,2,-1};
        LC303RangeSumQueryImmutable lc = new LC303RangeSumQueryImmutable(input);
        System.out.println(lc.sumRange(0,2));
        System.out.println(lc.sumRange(2,5));
        System.out.println(lc.sumRange(0,5));
    }
}
