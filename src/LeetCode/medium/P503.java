package LeetCode.medium;
import java.util.*;
public class P503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, Integer.MIN_VALUE);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        // 0 ~ n-1까지 한번 반복
        for (int i = 0; i < nums.length; i++) {
            //map을 순회하며 해당 값보다 클경우 제거 및 결과 기입
            Iterator<Map.Entry<Integer, List<Integer>>> iter = map.entrySet().iterator();
            while(iter.hasNext()) {
                Map.Entry<Integer, List<Integer>> entry = iter.next();
                if (entry.getKey() >= nums[i]) break;
                for (int val : entry.getValue())
                    result[val] = nums[i];
                iter.remove();
            }

            //현재값 map에 넣어줌
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // 0 ~ n-1까지 한번 더 반복
        for (int i = 0; i < nums.length; i++) {
            //map을 순회하며 해당 값보다 클경우 제거 및 결과 기입
            Iterator<Map.Entry<Integer, List<Integer>>> iter = map.entrySet().iterator();
            while(iter.hasNext()) {
                Map.Entry<Integer, List<Integer>> entry = iter.next();
                if (entry.getKey() >= nums[i]) break;
                for (int val : entry.getValue())
                    result[val] = nums[i];
                iter.remove();
            }

            if (result[i] == Integer.MIN_VALUE)
                result[i] = -1;
        }
        return result;
    }
}

/*
- 원형 배열 nums
- 다음으로 큰 숫자를 구해라 모든 nums에 대해
- 없으면 -1 리턴
- nums 길이 <= 1만
- 원소 -> integer 범위
- treeMap에 저장하고 앞에서부터 탐색
*/
