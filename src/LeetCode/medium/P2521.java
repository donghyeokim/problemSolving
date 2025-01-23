package LeetCode.medium;
import java.util.*;
public class P2521 {
    boolean[] primeMap = new boolean[1001];
    List<Integer> prime = new ArrayList<>();

    public int distinctPrimeFactors(int[] nums) {
        // 소수 초기화 (에라토스테네스 체)
        for (int i = 2; i <= 1000; i++) {
            // 특정 소수의 배수가 아니면
            if (primeMap[i]) continue;
            prime.add(i);
            for (int j = 2; i * j <= 1000; j++)
                primeMap[i * j] = true;
        }

        Set<Integer> result = new HashSet<>();
        // 배열의 각 수에 대해 소인수 분해
        for (int target : nums) {
            while(target != 1) {
                for (Integer div : prime) {
                    //해당 소수로 나눠지면
                    if (target % div == 0) {
                        result.add(div);
                        target /= div;
                        break;
                    }
                }
            }
        }
        return result.size();
    }
}
