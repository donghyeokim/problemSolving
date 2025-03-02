package LeetCode.medium;
import java.util.*;
public class P659 {
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>(); // 각 숫자의 빈도
            Map<Integer, Integer> cont = new HashMap<>(); // key로 끝나는 길이 3이상 시퀀스

            // 각 숫자 빈도 계산
            for (int num : nums)
                freq.put(num, freq.getOrDefault(num, 0) + 1);

            // 각 숫자에 대해 가능 여부 판별
            for (int num : nums) {
                // 이미 모두 사용한 숫자라면
                if (freq.getOrDefault(num, 0) == 0) continue;

                // 1. 이을 수 있는 시퀀스가 있으면
                if (cont.getOrDefault(num, 0) > 0) {
                    cont.put(num, cont.getOrDefault(num, 0) - 1);
                    cont.put(num+1, cont.getOrDefault(num+1, 0) + 1);
                }
                // 2. 이을 수 있는 시퀀스가 없으면
                else if (freq.getOrDefault(num+1, 0) > 0 && freq.getOrDefault(num+2, 0) > 0) {
                    cont.put(num+3, cont.getOrDefault(num+3, 0) + 1);
                    freq.put(num+1, freq.getOrDefault(num+1, 0) - 1);
                    freq.put(num+2, freq.getOrDefault(num+2, 0) - 1);
                }
                // 3. 둘 다 불가능한 경우
                else return false;

                freq.put(num, freq.get(num) - 1);
            }
            return true;
        }
    }

/*
- 정렬된 배열 제공
- 다음 조건을 만족하는 부분 시퀀스로 변환할 수 있는지
    - 각 서브 시퀀스는 연속적으로 증가하는 시퀀스 (1씩 정확히 증가)
    - 각 서브 시퀀스는 3개 혹은 그 이상
- 나눌 수 있으면 true 리턴

- 그리디 알고리즘
1. 이을 수 있으면 잇는다
2. 이을 수 없다면 n, n+1, n+2를 새로 만든다
3. 그럴 수 없다면 false

- 1 1 2 1 1
- 1 1 2 2 2
- 1 1 1 2 1
*/
}
