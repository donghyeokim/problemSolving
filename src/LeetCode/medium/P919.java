package LeetCode.medium;

import java.util.*;
class P919 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class CBTInserter {

        TreeNode[] nodes = new TreeNode[10001];
        int ind = 1;

        public CBTInserter(TreeNode root) {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                nodes[ind++] = cur;

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }

        public int insert(int val) {
            TreeNode newTreeNode = new TreeNode(val);
            int parent = ind / 2;
            int mod = ind % 2;
            if (mod == 0) nodes[parent].left = newTreeNode;
            else nodes[parent].right = newTreeNode;
            nodes[ind++] = newTreeNode;
            return nodes[parent].val;
        }

        public TreeNode get_root() {
            return nodes[1];
        }
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */


/*
- 12:55
- 리프노드를 제외하고는 모두 완전 이진 트리가 되어야함
- insert : 노드 넣고 부모 노드 번호 출력
- get_root : 트리 루트 노드 출력

-      1
-   2.   3
-  4 5. 6. 7
*/
