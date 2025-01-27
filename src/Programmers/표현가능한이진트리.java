package Programmers;

public class 표현가능한이진트리 {
    class Solution {
        public boolean result;

        public void dfs(boolean[] arr, int s, int e, boolean isEnd) {
            int mid = (s + e) / 2;
            boolean cur = arr[mid];

            // 중간에 0이 나왔는데 1이라면
            if (isEnd && cur) {
                result = false;
                return;
            }

            if (s != e) {
                dfs(arr, s, mid - 1, !cur);
                dfs(arr, mid+1, e, !cur);
            }
        }

        public int[] solution(long[] numbers) {
            int[] res = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                long target = numbers[i];
                // 해당 이진수의 길이 계산
                int len = (int)Math.floor(Math.log(target) / Math.log(2)) + 1;
                // 해당 이진수의 포화 이진트리 높이 계산
                int height = (int)Math.floor(Math.log(len) / Math.log(2)) + 1;
                // 해당 이진트리의 길이 계산
                int treeLen = (int)Math.pow(2, height) - 1;
                // 이진트리 배열 계산
                boolean[] arr = new boolean[treeLen];
                int ind = arr.length - 1;
                while(target != 0) {
                    arr[ind--] = target % 2 == 1 ? true : false;
                    target /= 2;
                }

                // 결과 계산
                result = true;
                dfs(arr, 0, arr.length - 1, false);
                if (result) res[i] = 1;
            }
            return res;
        }
    }

/*
- 11:54
- 이진수의 길이를 고려하여 포화 이진 트리의 높이를 구함
- 해당 크기만큼 배열 길이를 정의
- 뒤 부터 이진수 값을 넣고 앞에는 0으로 패딩
*/
}
