package LeetCode.medium;

public class P1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] n1 = new int[nums1.length + 1];
        int[] n2 = new int[nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) n1[i+1] = nums1[i];
        for (int i = 0; i < nums2.length; i++) n2[i+1] = nums2[i];

        int[][] dp = new int[n1.length][n2.length];

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n1.length; i++) {
            for (int j = 1; j < n2.length; j++) {
                if (n1[i] == n2[j]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
