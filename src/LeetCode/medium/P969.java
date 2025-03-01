package LeetCode.medium;
import java.util.*;
public class P969 {
    class Solution {
        public void reverse(int[] arr, int e) {
            int s = 0;
            while (s < e) {
                int tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++; e--;
            }
        }

        public List<Integer> pancakeSort(int[] arr) {

            List<Integer> result = new ArrayList<>();
            int target = arr.length;
            int fixInd = arr.length;

            while(fixInd > 0) {
                int maxInd = -1;
                // 1. 가장 큰 숫자의 인덱스 찾기
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == target) {
                        maxInd = i;
                        break;
                    }
                }

                // 2. 해당 숫자까지 뒤집기
                reverse(arr, maxInd);

                // 3. 고정 부분 이전까지 뒤집기
                reverse(arr, fixInd-1);
                fixInd--;
                target--;
                result.add(maxInd+1);
                result.add(fixInd+1);
            }
            return result;
        }
    }

/*
15:28
- arr가 주어질 때, 팬케익 플립을 수행해라?
    - 인덱스 k를 고르고
    - arr[0...k-1]를 뒤집어라
- arr를 정렬하기 위한 k값의 배열을 리턴  ((10*arr.length)내에 정렬이 가능한 아무거나)
- 정렬할 수 없으면 빈배열

- 배열 길이 <= 100
- 배열의 모든 원소는 1~length까지의 순열 중 하나임

-> 가장 큰 원소를 찾고 해당 원소까지 뒤집음
-> 고정 영역 이전까지 전체를 뒤집음 (반복)

- 3 2 4 1
- 4 2 3 1
- 1 3 2 4
- 3 1 2 4
- 2 1 3 4
-
*/
}
