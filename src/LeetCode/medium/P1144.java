package LeetCode.medium;

public class P1144 {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int res1 = 0;
        int res2 = 0;

        for (int i = 0; i <= n / 2; i++) {
            int ind = i * 2 + 1;
            int target = Integer.MAX_VALUE;
            // 1. 짝수 인덱스를 큰 수로 만들기 위해 필요한 move 계산
            if (ind < nums.length) {
                if (ind - 1 >= 0) target = Math.min(target, nums[ind-1]);
                if (ind + 1 < nums.length) target = Math.min(target, nums[ind+1]);
                if (nums[ind] >= target) res1 += nums[ind] - target + 1;
            }
            // 2. 홀수 인덱스를 큰 수로 만들기 위해 필요한 move 계산
            ind = i * 2;
            target = Integer.MAX_VALUE;
            if (ind < nums.length) {
                if (ind - 1 >= 0) target = Math.min(target, nums[ind-1]);
                if (ind + 1 < nums.length) target = Math.min(target, nums[ind+1]);
                if (nums[ind] >= target) res2 += nums[ind] - target + 1;
            }
        }
        return Math.min(res1, res2);
    }
}
