package LeetCode.medium;
import java.util.*;
public class P731_preSum {
    class MyCalendarTwo {
        private TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendarTwo() {

        }

        public boolean book(int s, int e) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            map.put(e, map.getOrDefault(e, 0) - 1);
            if (isTripleBooking(s, e)) return false;
            return true;
        }

        private boolean isTripleBooking(int s, int e) {
            int cnt = 0;
            for (var entry : map.entrySet()) {
                cnt += entry.getValue();
                if (cnt > 2) {
                    map.put(s, map.get(s) - 1);
                    map.put(e, map.get(e) + 1);
                    return true;
                }
            }
            return false;
        }
    }
}
