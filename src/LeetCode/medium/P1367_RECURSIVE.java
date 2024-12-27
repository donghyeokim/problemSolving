package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

class P1367_RECURSIVE {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        if (checkPath(head, root)) return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean checkPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null || head.val != root.val) return false;
        return checkPath(head.next, root.left) || checkPath(head.next, root.right);
    }
}

/*
- 링크드 리스트의 모든 원소가 트리의 아래방향으로 이어진 원소인지 확인
- 트리 노드 수 <= 2500
- 노드의 값 <= 100
*/