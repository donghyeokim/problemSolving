package LeetCode.medium;

public class P3121 {
    public int numberOfSpecialChars(String word) {
        // 소문자, 대문자 노출 여부 저장
        boolean[] lowerAppear = new boolean[26];
        boolean[] upperAppear = new boolean[26];

        // 소문자 노출 여부
        // 대문자 노출 여부
        // 대문자 노출되어 있을 때 소문자 노출 -> 소문자 노출 여부 false
        for (char cur : word.toCharArray()) {
            // 대문자 케이스
            if (cur < 'a') {
                int target = (int)(cur - 'A');
                upperAppear[target] = true;
            }
            // 소문자 케이스
            else {
                int target = (int)(cur - 'a');
                if (upperAppear[target]) lowerAppear[target] = false;
                else lowerAppear[target] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (lowerAppear[i] && upperAppear[i])
                result++;
        }
        return result;
    }
}
