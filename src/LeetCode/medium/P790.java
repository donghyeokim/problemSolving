package LeetCode.medium;

public class P790 {

    class Solution {
        public int numTilings(int n) {
            int dp[] = new int[n+4];

            int mod = (int)(Math.pow(10,9)+7);
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 5;

            for(int i=4;i<=n;i++){
                dp[i] = ((2*dp[i-1])%mod)+dp[i-3];
                dp[i] %= mod;
            }

            return dp[n];
        }
    }

    // 이전 O(n^2) 풀이
//    class Solution {
//        public int numTilings(int n) {
//            int MOD = (int)1e9 + 7;
//            int[] dp = new int[n + 1];
//            dp[0] = 1;
//            for (int i = 1; i <= n; i++) {
//                long result = 0;
//                // dp[i-1]
//                result = (result + dp[i-1]) % MOD;
//                // dp[i-2]
//                if (i-2 >= 0) result = (result + dp[i-2]) % MOD;
//                // dp[i-3]
//                if (i-3 >= 0) result = (result + dp[i-3]*2) % MOD;
//                // dp[i-4], dp[i-6]....
//                int diff = 4;
//                while(i - diff >= 0) {
//                    result = (result + dp[i-diff]*2) % MOD;
//                    diff++;
//                }
//                dp[i] = result;
//            }
//            return dp[n];
//        }
//    }

/*
17:54
- 도미노 트로미노 타일링
- n이 주어질때 2*n 보드를 채우는 가지수를 구해라
- 10^9 + 7로 나눈 나머지를 구해라

- DP 문제
- DP[i] : i 크기의 보드를 채우는 가지수
- DP[i] = DP[i-1] + DP[i-2] + DP[i-3]*2 + DP[i-4]*2 + DP[i-5]*2 +.....
-> DP[i] - DP[i-1] = DP[i-1] + DP[i-3]
-> DP[i] = DP[i-1]*2 + DP[i-3]
*/
}
