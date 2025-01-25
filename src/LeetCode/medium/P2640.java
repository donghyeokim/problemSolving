package LeetCode.medium;

public class P2640 {
    public long[] findPrefixScore(int[] nums) {
        int N = nums.length;
        long[] conv = new long[N];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nums[i]);
            conv[i] = nums[i] + max;
        }

        long[] res = new long[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += conv[i];
            res[i] = sum;
        }
        return res;
    }
}
