package LeetCode.medium;

import java.util.*;
public class P3137 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length() / k; i++) {
            int ind = i * k;
            String target = word.substring(ind, ind + k);
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        int max = 0;
        for (String key : map.keySet())
            max = Math.max(max, map.get(key));
        return word.length() / k - max;
    }
}
