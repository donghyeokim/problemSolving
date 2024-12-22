package LeetCode.medium;

import java.util.*;
public class P2910 {
    public int minGroupsForValidAssignment(int[] balls) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ball : balls)
            map.put(ball, map.getOrDefault(ball, 0) + 1);

        int min = Integer.MAX_VALUE;
        for (int num : map.values())
            min = Math.min(min, num);
        min++;
        // min : 가장 작은 집합 개수
        // 각 사이즈 별로 사이즈 -1 까지는 용인
        for (int size = min; size > 1; size--) {
            boolean flag = true;
            int result = 0;

            for (int num : map.values()) {
                int div = num / size;
                int mod = num % size;

                // 딱 떨어질 경우
                if (mod == 0) result += div;
                // 그룹에서 하나씩 받아서 size - 1을 맞출 수 있는 경우
                else if(div >= size - mod - 1) result += div + 1;
                // 불가능
                else {
                    flag = false;
                    break;
                }
            }
            if (flag) return result;
        }

        return -1;
    }
}


/*
- 같은 박스에 있는 공들은 같은 값을 가져야함, 같은 값이 여러개라면 다른 박스에 나눠 담을 수 있음
- 가장 많은 박스는 가장 작은 박스보다 1개 많아야함
- 가장 적은 박스 개수 구해라

- 총 10만개 나눠야함
- 맵에 모두 넣기
- 최소 개수 + 1 부터 크기 줄여 나가면서 나눠질 수 있는지 확인
*/
