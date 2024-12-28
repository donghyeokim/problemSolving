package LeetCode.medium;

public class P647 {
    public int countSubstrings(String str) {
        char[] arr = str.toCharArray();
        int N = arr.length;
        boolean[][] dp = new boolean[N][N];
        // diff 0~N-1

        int result = 0;
        for (int d = 0; d < N; d++) {
            for (int s = 0; s < N; s++) {
                int e = s + d;
                if (e >= N) break;  //배열 크기 넘어서면 중지
                if (arr[s] != arr[e]) continue; // 양 끝이 같지 않으면 넘김
                // 길이가 1 or 2
                if (e-1 < s+1) {
                    dp[s][e] = true;
                    result++;
                    continue;
                }
                // 길이가 3이상
                if (dp[s+1][e-1]) {
                    dp[s][e] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
