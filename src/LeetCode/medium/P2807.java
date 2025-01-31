package LeetCode.medium;

public class P2807 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {

        public int calGcd(int a, int b) {
            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }
            return a;
        }

        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode cur = head;
            while(cur.next != null) {
                ListNode next = cur.next;
                ListNode gcd = new ListNode(calGcd(cur.val, next.val));

                cur.next = gcd;
                gcd.next = next;

                cur = next;
            }
            return head;
        }
    }
}
