package LeetCode.medium;

public class P2317 {
    public int maximumXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result |= num;
        }
        return result;
    }
}

/*
20:42
- 양의 정수 x 와 특정 인덱스 i에 대해
- num[i] = num[i] AND (num[i] XOR x)로 변환가능 (여러번 반복가능)
- 모든 원소를 XOR한 결과의 최대값을 구해라
- num[i] AND (num[i] XOR x) -> 이거는 있던 비트를 만들 순 없고 있던 비트를 없앨 수 있음
- 모든 비트 | 연산
*/