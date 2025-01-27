package Programmers;

import java.util.HashMap;
import java.util.Map;

public class 스타수열 {
    class Solution {
        public class Point {
            int count, ind;

            public Point(int count, int ind) {
                this.count = count;
                this.ind = ind;
            }
        }

        public int solution(int[] a) {
            Map<Integer, Point> map = new HashMap<>();

            int result = 0;
            for (int i = 0; i < a.length; i++) {
                Point cur = map.computeIfAbsent(a[i], k -> new Point(0, -1));

                // 좌측 수를 사용할 수 있는지 확인
                if ( i - 1 >= 0 && cur.ind < i - 1 && a[i - 1] != a[i]) {
                    cur.ind = i;
                    result = Math.max(result, ++cur.count);
                }
                // 우측 수를 사용할 수 있는지 확인
                else if ( i + 1 < a.length && a[i + 1] != a[i]) {
                    cur.ind = i + 1;
                    result = Math.max(result, ++cur.count);
                }
            }
            return result * 2;
        }
    }

/*
10:47
- 스타 수열 x
    - 길이가 2이상의 짝수(빈수열 X)
    - 2개씩 나눈 집합의 교집합 원소의 개수가 1이상
    - 각 집합의 두원소는 값이 같지 않음
- 정수 배열 a가 주어질 때 a의 모든 부분 수열 중에서 가장 길이가 긴 스타 수열의 길이를 return
- 1 <= a의 길이, 각원소 <= 50만
- 특정 숫자 기준으로 양옆에 값이 있어야함
- map에 각 숫자를 교집합으로 하는 스타 수열의 최대 개수와 사용한 최대 인덱스를 기록
*/
}
