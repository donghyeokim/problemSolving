package LeetCode;

public class P1053 {
    class Solution {

        public void swap(int[] arr, int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        public int[] prevPermOpt1(int[] arr) {
            // 뒤에서 앞으로 이동하며 가장 먼저 커지는 숫자를 찾아줌
            int pivot = -1;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    pivot = i;
                    break;
                }
            }
            // 가장 작은 순열이라면 그대로 리턴
            if (pivot == -1) return arr;

            // 1. pivot 수와 가장 작으면서 가장 가까운수 찾음
            int target = -1;
            for (int i = arr.length - 1; i > pivot; i--) {
                if (target == -1) {
                    if (arr[i] < arr[pivot]) target = i;
                    continue;
                }

                if (arr[i] < arr[target]) break;
                else target = i;
            }

            // 2. 두 수 교환
            swap(arr, pivot, target);

            return arr;
        }
    }

/*
순열로 놓고 봤을때 해당 순열보다 한단계 낮은 순열 구하기 (한번의 교환만 가능)
가장 작은 순열이라면 해당 순열 그대로 리턴

- before permutation
- 뒤부터 탐색했을 때, 가장먼저 커지는 위치를 pivot으로 둠.
- 뒤부터 탐색했을 때, pivot보다 작고 가장 가까운 위치의 수와 교환해줌
*/
}
