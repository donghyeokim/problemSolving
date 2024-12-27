package LeetCode.medium;

import java.util.*;
class P1367_DFS {
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
    public boolean result = false;

    public void dfs(TreeNode cur, List<Integer> target, List<Integer> tmp) {
        if (result) return;
        // 리프 노드
        if (cur.left == null && cur.right == null) {
            // 결과 계산
            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.size() - i < target.size()) break;
                if (tmp.get(i) == target.get(0)) {
                    boolean flag = true;
                    for (int j = 0; j < target.size(); j++) {
                        if (target.get(j) != tmp.get(i + j)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result = true;
                        return;
                    }
                }
            }

        }

        if (cur.left != null) {
            tmp.add(cur.left.val);
            dfs(cur.left, target, tmp);
            tmp.remove(tmp.size() - 1);
        }

        if (cur.right != null) {
            tmp.add(cur.right.val);
            dfs(cur.right, target, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> target = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            target.add(cur.val);
            cur = cur.next;
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        dfs(root, target, tmp);
        return result;
    }
}

/*
- 링크드 리스트의 모든 원소가 트리의 아래방향으로 이어진 원소인지 확인
- 트리 노드 수 <= 2500
- 노드의 값 <= 100
*/