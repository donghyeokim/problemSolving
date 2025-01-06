package LeetCode.medium;
import java.util.*;
public class P1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = l[i];
            int right = r[i];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = left; j <= right; j++)
                pq.add(nums[j]);

            int before = pq.poll();
            int cur = pq.poll();
            int diff = before - cur;
            boolean tmpRes = true;
            while(!pq.isEmpty()) {
                int next = pq.poll();
                if (cur - next != diff) {
                    tmpRes = false;
                    break;
                }
                cur = next;
            }
            result.add(tmpRes);
        }
        return result;
    }
}
