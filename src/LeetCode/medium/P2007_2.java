package LeetCode.medium;
import java.util.*;
public class P2007_2 {
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            int[] result = new int[changed.length / 2];
            Queue<Integer> q = new ArrayDeque<>();
            Arrays.sort(changed);
            int ind = 0;

            for (int num : changed) {
                if (!q.isEmpty() && q.peek() == num)
                    result[ind++] = q.poll() / 2;
                else q.add(num * 2);
            }
            return q.size() > 0 ? new int[]{} : result;
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
