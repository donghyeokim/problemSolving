package LeetCode.medium;
import java.util.*;
public class P2592 {
    class Solution {
        public int maximizeGreatness(int[] nums) {
            Arrays.sort(nums);
            int j = 0;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                while(j < nums.length && nums[i] == nums[j]) j++;
                if (j == nums.length) break;
                result++;
                j++;
            }
            return result;
        }
    }

/*
21:11
- nums의 순열 중에서 greatness가 가장 큰 값을 찾아라
- greatness란 특정 인덱스 i에 대해 perm[i] > nums[i] 인것 의 개수

1 1 1 2 3 3 5
*/
}
