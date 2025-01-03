package LeetCode.medium;

public class P1906_PREFIX_SUM {
    public int[] minDifference(int[] arr, int[][] qs) {
        int[][] preSum = new int[100001][101];
        for (int i = 0; i < arr.length; i++)
            for (int j = 1; j <= 100; j++)
                preSum[i+1][j] = preSum[i][j] + (arr[i] == j ? 1 : 0);

        int[] result = new int[qs.length];
        for (int i = 0; i < qs.length; i++) {
            int prev = 0, diff = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                if (preSum[qs[i][1] + 1][j] - preSum[qs[i][0]][j] > 0) {
                    diff = Math.min(diff, prev == 0 ? Integer.MAX_VALUE : j - prev);
                    prev = j;
                }
            }
            result[i] = (diff == Integer.MAX_VALUE ? -1 : diff);
        }
        return result;
    }
}
