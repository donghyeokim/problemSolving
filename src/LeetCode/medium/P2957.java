package LeetCode.medium;

public class P2957 {
    class Solution {

        public boolean isEqual(char a, char b) {
            if (a == b || Math.abs(a - b) == 1) return true;
            return false;
        }

        public int removeAlmostEqualCharacters(String word) {
            char[] arr = word.toCharArray();
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                // 왼쪽과 같지 않은 경우 넘어감
                if (i == 0 || !isEqual(arr[i-1], arr[i])) continue;
                if (isEqual(arr[i-1] ,arr[i])) {
                    arr[i] = 'X';
                    result++;
                }
            }
            return result;
        }
    }

/*
19:16
- 한번의 연산으로 하나의 인덱스 문자를 원하는 소문자로 바꿀수 있음
- 모든 인접 거의 같은 문자 없애기
- 거의 같은 문자 : a == b or a, b 인접 문자

- 왼쪽 문자와 같지 않은 경우 (왼쪽 문자 없는 경우) -> 넘어감
- 왼쪽 문자와 같은 경우 -> X로 바꿈
*/
}
