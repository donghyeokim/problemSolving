package LeetCode.medium;
import java.util.*;
public class P2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        boolean[] hDiv = new boolean[102];
        boolean[] vDiv = new boolean[102];
        int cur = hBars[0];
        int cnt = 2;
        hDiv[cnt] = true;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == cur + 1) {
                cur = hBars[i];
                hDiv[++cnt] = true;
            } else {
                cur = hBars[i];
                cnt = 2;
            }
        }

        cur = vBars[0];
        cnt = 2;
        vDiv[cnt] = true;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == cur + 1) {
                cur = vBars[i];
                vDiv[++cnt] = true;
            } else {
                cur = vBars[i];
                cnt = 2;
            }
        }

        for (int i = 101; i >= 2; i--) {
            if (hDiv[i] && vDiv[i])
                return i * i;
        }
        return 0;
    }
}
