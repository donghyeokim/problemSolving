package LeetCode.medium;
import java.util.*;
public class P2808 {
    class Solution {
        public int minimumSeconds(List<Integer> nums) {
            Map<Integer, List<Integer>> map = new HashMap<>();

            //각 숫자의 인덱스 배열 맵
            for (int i = 0; i < nums.size(); i++)
                map.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);

            // 최소 최대 거리
            int result = Integer.MAX_VALUE;
            for (List<Integer> arr : map.values()) {
                // 각 인덱스간 거리 계산
                int max = 0;
                for (int i = 1; i < arr.size(); i++)
                    max = Math.max(max, arr.get(i) - arr.get(i-1));
                max = Math.max(max, arr.get(0) - arr.get(arr.size() - 1) + nums.size());

                result = Math.min(result, max);
            }
            return result / 2;
        }
    }

/*
17:24
- nums, n개의 정수 배열
- 최소 작업을 통해 배열의 모든 수를 같게 만들어라
- 각 초마다 다음 작업 수행
    - nums[i]를 다음으로 바꿈
    - nums[i]
    - nums[(i-1+n)%n]
    - nums[(i+1)%n]
-> 각 배열의 앞, 뒤 원소를 뜻함
-> 각 숫자의 위치 배열을 두고 각 원소간 최대 거리 계산
-> 거리 / 2가 걸리는 시간임


- 1<= 배열 길이 <= 10만
*/
}
