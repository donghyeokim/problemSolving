package LeetCode.medium;

public class P1314 {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int N = mat.length;
            int M = mat[0].length;
            // 1. 구간합 구하기
            int[][] preSum = new int[N][M];
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += mat[i][j];
                    preSum[i][j] = sum;
                }
            }

            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += preSum[i][j];
                    preSum[i][j] = sum;
                }
            }

            int[][] result = new int[N][M];
            // 2. 각 원소에 결과 구하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int tmpRes = 0;

                    // 필요한 4개의 꼭지점 구하기
                    int loX = i - k < 0 ? 0 : i - k;
                    int loY = j - k < 0 ? 0 : j - k;
                    loX--; loY--;
                    int hiX = i + k >= N ? N-1 : i+k;
                    int hiY = j + k >= M ? M-1 : j+k;

                    tmpRes += preSum[hiX][hiY];
                    if (loX >= 0) tmpRes -= preSum[loX][hiY];
                    if (loY >= 0) tmpRes -= preSum[hiX][loY];
                    if (loX >= 0 && loY >= 0) tmpRes += preSum[loX][loY];

                    result[i][j] = tmpRes;
                }
            }
            return result;
        }
    }

}
