package LeetCode.medium;
import java.util.*;
public class P1034 {
    public class Point {
        int x, y;
        int sc, tc;

        public Point(int x, int y, int sc, int tc) {
            this.x = x;
            this.y = y;
            this.sc = sc;
            this.tc = tc;
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] chk = new int[N][M];
        int[][] result = new int[N][M];

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};


        //초기화
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                result[i][j] = grid[i][j];

        //BFS시작
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(row, col, grid[row][col], color));
        chk[row][col] = 1;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            boolean flag = false;
            for (int d = 0; d < 4; d++) {
                int X = cur.x + dx[d];
                int Y = cur.y + dy[d];

                // 경계라서 더이상 진행 불가
                if (X < 0 || Y < 0 || X >= N || Y >= M || grid[X][Y] != cur.sc) {
                    flag = true;
                    continue;
                }
                // 이미 방문해서 더이상 진행 불가
                if (chk[X][Y] == 1) continue;

                chk[X][Y] = 1;
                q.add(new Point(X, Y, cur.sc, cur.tc));
            }

            // 경계라면 색을 칠해줌
            if (flag) result[cur.x][cur.y] = cur.tc;
        }
        return result;
    }
}
