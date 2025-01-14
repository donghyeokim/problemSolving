package LeetCode.medium.category;

public class P31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int N = nums.length;

        // 1. 배열 오른쪽부터 탐색해서 nums[i] < nums[i+1]인 첫 i를 찾음
        int i = N-1;
        while(--i >= 0) {
            if (nums[i] < nums[i+1])
                break;
        }

        // 2-1) 내림차순 정렬이면 오름차순 정렬후 마무리
        if (i == -1) {
            reverse(nums, 0);
            return;
        }

        // 2-2) 해당 인덱스부터 오른쪽으로 탐색해서 해당 값보다 크면서 가장 가까운 숫자와 인덱스 찾음
        int j = -1;
        int min = Integer.MAX_VALUE;
        for (int ind = N-1; ind > i; ind--) {
            if (nums[ind] > nums[i] && min > nums[ind]) {
                min = nums[ind];
                j = ind;
            }
        }

        // 3. 해당 숫자 교체해주고 해당 i+1부터 끝까지 오름차순 정렬
        swap(nums, i, j);
        reverse(nums, i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int s) {
        int i = s;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
