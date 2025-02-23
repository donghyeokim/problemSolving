package LeetCode.medium;
import java.util.*;
public class P1382 {
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

    class Solution {

        public void inOrderSort(List<TreeNode> arr, TreeNode cur) {
            if (cur == null) return;
            inOrderSort(arr, cur.left);
            arr.add(cur);
            inOrderSort(arr, cur.right);
        }

        public TreeNode makeBalancedTree(List<TreeNode> arr, int s, int e) {
            if (s > e) return null;
            int mid = (s + e) / 2;
            TreeNode cur = arr.get(mid);
            cur.left = makeBalancedTree(arr, s, mid - 1);
            cur.right = makeBalancedTree(arr, mid + 1, e);
            return cur;
        }

        public TreeNode balanceBST(TreeNode root) {
            List<TreeNode> arr = new ArrayList<>();
            inOrderSort(arr, root);
            return makeBalancedTree(arr, 0, arr.size() - 1);
        }
    }

/*
- 이진 트리의 root가 주어짐
- 균형 이진 트리를 리턴해라
- 두 서브트리의 높이차가 1이하
*/
}
