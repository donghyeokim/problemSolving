package LeetCode.medium;
import java.util.*;
public class P2096_BFS {
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
    public class Point {
        int n;
        String p;

        public Point(int n, String p) {
            this.n = n;
            this.p = p;
        }
    }

    int[] P, L, R;

    public void retrieve(int before, TreeNode cur) {
        P[cur.val] = before;
        if (cur.left != null) {
            L[cur.val] = cur.left.val;
            retrieve(cur.val, cur.left);
        }

        if (cur.right != null) {
            R[cur.val] = cur.right.val;
            retrieve(cur.val, cur.right);
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        P = new int[100001];
        L = new int[100001];
        R = new int[100001];
        retrieve(0, root);

        Queue<Point> q = new ArrayDeque<>();
        boolean[] chk = new boolean[100001];
        q.add(new Point(startValue, ""));
        chk[startValue] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.n == destValue)
                return cur.p;

            if (P[cur.n] != 0 && !chk[P[cur.n]]) {
                chk[P[cur.n]] = true;
                q.add(new Point(P[cur.n], cur.p + "U"));
            }
            if (L[cur.n] != 0 && !chk[L[cur.n]]) {
                chk[L[cur.n]] = true;
                q.add(new Point(L[cur.n], cur.p + "L"));
            }
            if (R[cur.n] != 0 && !chk[R[cur.n]]) {
                chk[R[cur.n]] = true;
                q.add(new Point(R[cur.n], cur.p + "R"));
            }
        }
        return "";
    }
}
