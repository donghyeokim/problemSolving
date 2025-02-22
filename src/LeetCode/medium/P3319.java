package LeetCode.medium;
import java.util.*;

public class P3319 {
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
        public int kthLargestPerfectSubtree(TreeNode root, int k) {
            solve(root);
            Collections.sort(results, (a, b) -> b - a);
            return results.size() < k ? -1 : results.get(k-1);
        }

        private List<Integer> results = new ArrayList<>();

        // 완전 이진트리라면 현재 트리의 depth 출력
        // 완전 이진트리가 아니라면 -1 출력
        private int solve(TreeNode cur) {
            // 리프 노드인 경우
            if (cur.left == null && cur.right == null) {
                results.add(1);
                return 1;
            }

            int lResult = -1;
            int rResult = -1;
            if (cur.left != null) lResult = solve(cur.left);
            if (cur.right != null) rResult = solve(cur.right);

            if (lResult != rResult || lResult == -1) return -1;
            // 완전 이진 트리인 경우
            results.add(convertToSize(lResult + 1));
            return lResult + 1;
        }

        private int convertToSize(int depth) {
            int result = 0;
            for (int i = 0; i < depth; i++)
                result += Math.pow(2, i);
            return result;
        }
    }

/*
09:04
- k번째로 큰 사이즈의 완전이진트리 사이즈 리턴
- 완전이진트리를 어떻게 판별?
-> left, right가 완전이진트리이고 depth가 같다면?
*/
}
