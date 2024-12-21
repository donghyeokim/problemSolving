package LeetCode.medium;

class P1749 {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int maxSumMax = 0;
        int minSumMin = 0;
        for (int num : nums) {
            maxSum += num;
            if (maxSum < 0) maxSum = 0;
            maxSumMax = Math.max(maxSumMax, maxSum);

            minSum += num;
            if (minSum > 0) minSum = 0;
            minSumMin = Math.min(minSumMin, minSum);
        }
        return Math.max(maxSumMax, -minSumMin);
    }
}

/*
- num의 부분 배열에서 절대값의 합 중 최대값을 구해라
- 길이 <= 10만
- 카데인 알고리즘
*/
