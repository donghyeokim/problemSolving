package LeetCode.medium;

public class P2348 {
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long cnt = 0;
            long result = 0;
            for (int num : nums) {
                if (num == 0) cnt++;
                else {
                    result += (1 + cnt) * cnt / 2;
                    cnt = 0;
                }
            }
            if (cnt != 0) result += (1 + cnt) * cnt / 2;
            return result;
        }
    }

/*
정수 배열이 주어졌을때 0으로 구성되는 부분 배열의 개수를 구해라
등차수열의 합 = (s + e) / 2
*/
}
