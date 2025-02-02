package LeetCode.medium;
import java.util.*;
public class P2442 {
    class Solution {

        public int reverseDigit(int n) {
            int rev = 0;
            while(n > 0) {
                rev = rev * 10 + (n % 10);
                n = n / 10;
            }
            return rev;
        }

        public int countDistinctIntegers(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
                set.add(reverseDigit(num));
            }
            return set.size();
        }
    }
}
