package LeetCode;

class P1695 {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] chk = new boolean[10001];
        int l = 0;
        int r = 0;
        int sum = nums[0];
        chk[nums[0]] = true;
        int result = sum;
        // 배열 끝에 도달하지 않을 때까지 반복
        while(r != nums.length - 1) {
            // 1. 다음 수가 이미 체크된 수 인경우
            if (chk[nums[r+1]]) {
                // l을 체크된 수를 만나기 다음까지 당김
                while(true) {
                    if (nums[l] == nums[r+1]) {
                        sum -= nums[l++];
                        break;
                    }
                    chk[nums[l]] = false;
                    sum -= nums[l++];
                }
                chk[nums[r+1]] = true;

            }
            // 2. 다음 수가 체크된 수가 아닌 경우
            chk[nums[++r]] = true;
            sum += nums[r];
            result = Math.max(result, sum);
        }
        return result;
    }
}

/*
- 유니크 원소들로 이뤄진 부분 배열 지우기 원함
- 점수는 지운 부분배열 원소합
- 정확히 하나 지울 때 최대 점수
*/
