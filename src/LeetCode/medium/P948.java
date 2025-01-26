package LeetCode.medium;

import java.util.Arrays;

public class P948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int lo = 0;
        int hi = tokens.length - 1;

        int score = 0;
        int waste = 0;
        while(lo <= hi) {
            // 1. 점수 획득 시도
            if (tokens[lo] <= power) {
                power -= tokens[lo++];
                score++;
                waste = 0;
                continue;
            }

            // 2. 파워 획득 시도
            if (score >= 1) {
                power += tokens[hi--];
                score--;
                waste++;
                continue;
            }

            // 둘 다 할 수 없으면 멈춤
            break;
        }
        return score + waste;
    }
}
