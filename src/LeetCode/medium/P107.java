package LeetCode.medium;
import java.util.*;
public class P107 {
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

    public List<List<Integer>> tmpList = new ArrayList<>();

    public void dfs(TreeNode node, int depth) {
        // 리스트 크기 늘려주기
        if (depth == tmpList.size())
            tmpList.add(new ArrayList<>());
        tmpList.get(depth).add(node.val);

        if (node.left != null)
            dfs(node.left, depth + 1);

        if (node.right != null)
            dfs(node.right, depth + 1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root != null)
            dfs(root, 0);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = tmpList.size() -1; i >= 0; i--)
            result.add(tmpList.get(i));
        return result;
    }
}
