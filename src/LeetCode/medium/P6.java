package LeetCode.medium;
import java.util.*;
public class P6 {
    class Solution {
        public String convert(String s, int n) {
            if (n == 1) return s;
            List<Character>[] result = new List[n];
            for (int i = 0; i < n; i++)
                result[i] = new ArrayList<>();
            int ind = 0;
            boolean isDown = true;
            for (char cur : s.toCharArray()) {
                result[ind].add(cur);

                if (isDown) {
                    if (ind + 1 == n) {
                        isDown = false;
                        ind--;
                    } else
                        ind++;
                } else {
                    if (ind - 1 == -1) {
                        isDown = true;
                        ind++;
                    } else
                        ind--;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < result[i].size(); j++)
                    sb.append(result[i].get(j));
            }
            return sb.toString();
        }
    }

/*
12:28
- 길이 <= 1000개

*/
}
