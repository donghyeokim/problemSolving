package LeetCode.medium;

public class P2226 {
    public int maximumCandies(int[] candies, long k) {
        long lo = 0;
        long hi = 10000001;
        while(lo + 1 < hi) {
            long mid = (lo + hi) / 2;

            //mid일 때 만족하는지 확인
            long cnt = 0;
            for (int cand : candies) {
                cnt += cand / mid;
                if (cnt >= k) break;
            }

            // k개 묶음을 만들 수 있는 경우
            if (cnt >= k) lo = mid;
            else hi = mid;
        }
        return (int) lo;
    }
}
