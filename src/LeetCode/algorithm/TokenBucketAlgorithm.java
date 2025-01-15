package LeetCode.algorithm;

public class TokenBucketAlgorithm {

    public static class TokenBucket {
        private final long capacity;        // 버킷 용량
        private final double refillRate;    // 초당 리필 수
        private double tokens;              // 남은 토큰 수
        private long lastRefillTimeStamp;   // 마지막 리필 시간

        public TokenBucket(long capacity, double refillRate) {
            this.capacity = capacity;
            this.refillRate = refillRate;
            this.tokens = capacity;
            this.lastRefillTimeStamp = System.nanoTime();
        }

        public synchronized boolean tryConsume(double tokens) {
            refill();

            if (this.tokens < tokens) return false;

            this.tokens -= tokens;
            return true;
        }

        private void refill() {
            long now = System.nanoTime();
            double elapsedTimeStamp = (now - lastRefillTimeStamp) / 1e9;

            double tokensToAdd = elapsedTimeStamp * refillRate;

            tokens = Math.min(capacity, tokens + tokensToAdd);

            lastRefillTimeStamp = now;
        }

        public synchronized  double getAvailableTokens() {
            refill();
            return this.tokens;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 최대 10개의 토큰을 저장할 수 있고, 초당 1개의 토큰이 리필되는 버킷 생성
        TokenBucket bucket = new TokenBucket(10, 1);

        // 토큰 소비 테스트
        // 3초마다 한번씩 성공할 예정
        for (int i = 0; i < 15; i++) {
            boolean consumed = bucket.tryConsume(3.0);
            System.out.printf("Request %d: %s (Available tokens: %.2f)%n",
                    i + 1,
                    consumed ? "Accepted" : "Rejected",
                    bucket.getAvailableTokens());

            Thread.sleep(1000); // 300ms 대기
        }
    }
}
