package LeetCode.medium;
import java.util.*;
public class P652 {

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

        public String recursive(List<TreeNode> res, Map<String, Integer> map, TreeNode cur) {
            if (cur == null) return "";
            String left = recursive(res, map, cur.left);
            String right = recursive(res, map, cur.right);

            String curStr = cur.val + "/" + left + "/" + right;
            if (map.getOrDefault(curStr, 0) == 1)
                res.add(cur);
            map.put(curStr, map.getOrDefault(curStr, 0) + 1);
            return curStr;
        }

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> result = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            recursive(result, map, root);
            return result;
        }
    }
}
