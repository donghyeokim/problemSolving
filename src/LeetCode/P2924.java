package LeetCode;

public class P2924 {
    public int findChampion(int n, int[][] edges) {
        boolean[] chk = new boolean[n];
        for (int[] e : edges)
            chk[e[1]] = true;

        int result = -1;
        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                if (result != -1) return -1;
                result = i;
            }
        }
        return result;
    }
}

/*
21:08
- n : 노드 개수 (0~n-1)
- edges : [u, v] (u -> v) 노드 집합 u가 v보다 강하다
- 유일한 챔피언이 존재하면 챔피언 번호 리턴 아니면 -1

- 자신을 이기는 노드가 없으면 챔피온 후보
*/
