package LeetCode.medium;

import java.util.Arrays;

public class P2391 {
    public String convertTypeToString(int i) {
        if (i == 0) return "M";
        if (i == 1) return "P";
        if (i == 2) return "G";
        return "";
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        // garbage를 뒤에서 순회하면서 각 타입의 마지막 노드 번호 계산
        int[] lastInd = new int[3];
        Arrays.fill(lastInd, -1);
        for (int i = garbage.length - 1; i >= 0; i--) {
            for (int t = 0; t < 3; t++) {
                if (lastInd[t] != -1) continue;
                if (garbage[i].contains(convertTypeToString(t)))
                    lastInd[t] = i;
            }
            if (lastInd[0] != -1 && lastInd[1] != -1 && lastInd[2] != -1)
                break;
        }

        // garbage를 앞에서 순회하면서 계산
        int result = 0;
        for (int i = 0; i < garbage.length; i++) {
            //현재 위치의 쓰레기 담기
            result += garbage[i].length();
            //다음 위치로 이동
            for (int t = 0; t < 3; t++) {
                if (i+1 <= lastInd[t])
                    result += travel[i];
            }
        }
        return result;
    }
}
