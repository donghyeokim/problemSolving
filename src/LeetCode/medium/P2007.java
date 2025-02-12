package LeetCode.medium;
import java.util.*;
public class P2007 {
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            Arrays.sort(changed);
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : changed)
                map.put(num, map.getOrDefault(num, 0) + 1);

            int[] result = new int[changed.length / 2];
            int ind = 0;
            for (int num : changed) {
                int cnt1 = map.getOrDefault(num, 0);
                if (cnt1 <= 0) continue;
                map.put(num, cnt1 - 1);

                int cnt2 = map.getOrDefault(num * 2, 0);
                if (cnt2 <= 0) return new int[]{};
                map.put(num*2, cnt2 - 1);
                result[ind++] = num;
            }
            return result;
        }
    }

/*
original -> changed
각원소의 2배를 원래 배열에 추가해줌

불가능할 경우 빈 배열 리턴
아무순서로도 리턴해도 문제 없음
- map에 모두 넣어둠.
- 다시 순회하면서 2배가 되는 수가 있나 확인

-> 작은수부터 차례로 순회

1 2 3 4 6 8
2 1 4 3 6 8
*/
}
