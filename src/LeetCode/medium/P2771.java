package LeetCode.medium;

public class P2771 {
    public int solve(int[] n1, int[] n2, int[][] dp, int ind, int type) {
        if (ind == n1.length - 1) return dp[ind][type] = 1;
        if (dp[ind][type] != 0) return dp[ind][type];

        int result = 1;
        int cur = type == 0 ? n1[ind] : n2[ind];
        if (n1[ind + 1] >= cur) result = Math.max(result, 1 + solve(n1, n2, dp, ind+1, 0));
        if (n2[ind + 1] >= cur) result = Math.max(result, 1 + solve(n1, n2, dp, ind+1, 1));
        return dp[ind][type] = result;
    }

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            solve(nums1, nums2, dp, i, 0);
            solve(nums1, nums2, dp, i, 1);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (dp[i][j] > result)
                    result = dp[i][j];
            }
        }
        return result;
    }
}

/*
- 가장긴 증가하는 부분 배열
- 두 배열 길이 n으로 같음
- n1[i] or n2[i] -> n3[i]
- 감소하지 않는 부분배열의 최대 길이를 구해라
- 길이 <= 10만
- 숫자 <= 10억
- DP[i][2] : i번째 숫자를 특정 수로 골랐을 때 해당 인덱스부터 시작하는 최대 길이의 부분 수열
*/
